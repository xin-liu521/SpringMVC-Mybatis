package com.velvol.hr.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.xml.bind.v2.model.core.ID;
import com.velvol.hr.dao.IKaoqinbbDao;
import com.velvol.hr.dao.IKaoqinbjDao;
import com.velvol.hr.dao.IKaoqindateDao;
import com.velvol.hr.dao.IKaoqinwhDao;
import com.velvol.hr.dao.IKaoqinxianDao;
import com.velvol.hr.dao.IMaterialinitDao;
import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.dao.IStationDao;
import com.velvol.hr.dao.IStatkaoqinDao;
import com.velvol.hr.dao.IWorkerDao;
import com.velvol.hr.domain.Kaoqinbb;
import com.velvol.hr.domain.Kaoqinbj;
import com.velvol.hr.domain.Kaoqindate;
import com.velvol.hr.domain.Kaoqinwh;
import com.velvol.hr.domain.Kaoqinxian;
import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.Statkaoqin;
import com.velvol.hr.domain.User;
import com.velvol.hr.domain.Worker;
import com.velvol.hr.service.IWorkerService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;

@Service      
@Transactional
public class WorkerServiceImpl  implements IWorkerService{

	@Autowired
	private IWorkerDao workerDao;
	@Autowired
	private IRegionDao regionDao;
	@Autowired
	private IStationDao stationDao;
	@Autowired
	private IMaterialinitDao MaterialinitDao;
	
	@Autowired
	private IKaoqindateDao kaoqindateDao;
	@Autowired
	private IKaoqinxianDao kaoqinxianDao;
	@Autowired
	private IKaoqinbjDao kaoqinbjDao;
	@Autowired
	private IKaoqinwhDao kaoqinwhDao;
	@Autowired
	private IKaoqinbbDao kaoqinbbDao;
	@Autowired
	private	IStatkaoqinDao statkaoqinDao;
	public void pageQuery(PageBean pageBean, int state) {		
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",state));
		
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		 String roleCode = user.getRoleCode();
		 
		 if("renshirole".equals(roleCode)){
			 Long regionid= user.getRegionid();
			 Region region = regionDao.findById(regionid);
			 detachedCriteria.add(Restrictions.eq("region",region));	
		  }
		  else if("zhanzhangrole".equals(roleCode)){
			  Long stationid= user.getStationid();
			  Station station = stationDao.findById(stationid);
			  detachedCriteria.add(Restrictions.eq("station",station));		
		  }
				
		detachedCriteria.addOrder(Order.asc("indate"));
		
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		workerDao.pageQuery(pageBean);		
		
	}

	@Override
	public List<Materialinit> findMListById(String id) {
		return MaterialinitDao.findAllByWorkerid(id);
	}

	//考勤分页查询
	public void pageQuerykq(PageBean pageBean, int i) {
		//获取登录用户的站点ID
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		
		//当前日期
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	
		String dateNowStr = sdf.format(now); 
		try {
			now = sdf.parse(dateNowStr);
										
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//如果不是站长角色，则直接返回
		if(!"zhanzhangrole".equals(roleCode)){
			return;
		}
		else{//先判断今天是否加入考勤了。
			boolean b = workerDao.isInsert(stationid);
			if(!b){//如果没插入，则先插入
				Kaoqindate kaoqindate = new Kaoqindate();
				kaoqindate.setRegionid(regionid);
				kaoqindate.setStationid(stationid);
				
				
				kaoqindate.setKqdate(now);				
				kaoqindateDao.save(kaoqindate);;
				
				//插入到考勤表
				Station station = stationDao.findById(stationid);
				List<Worker>  list = workerDao.findListByStation(station);
				for (Worker worker : list) {
					if(1==regionid){						
						Kaoqinxian kq = new Kaoqinxian();
						kq.setKqdate(now);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());						
						kaoqinxianDao.save(kq);
					}
					else if(2==regionid){						
						Kaoqinbj kq = new Kaoqinbj();
						kq.setKqdate(now);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());						
						kaoqinbjDao.save(kq);
					}
					else if(3==regionid){						
						Kaoqinwh kq = new Kaoqinwh();
						kq.setKqdate(now);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());						
						kaoqinwhDao.save(kq);
					}
					else if(4==regionid){						
						Kaoqinbb kq = new Kaoqinbb();
						kq.setKqdate(now);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());						
						kaoqinbbDao.save(kq);
					}
				}				
			}
			
			//判断是哪个区域，调用哪个考勤表
			if(1==regionid){
				DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				kaoqinxianDao.pageQuery(pageBean);
			}
			else if(2==regionid){					
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				kaoqinbjDao.pageQuery(pageBean);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				kaoqinwhDao.pageQuery(pageBean);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				kaoqinbbDao.pageQuery(pageBean);
			}
			
		}
	}

	@Override
	public List movePageQuerykq(PageBean pageBean, int i) {
		//获取登录用户的站点ID
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		List lis = new ArrayList();
		//当前日期
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(now);
		try {
			now = sdf.parse(dateNowStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		//如果不是站长角色，则直接返回
		if("zhanzhangrole".equals(roleCode)){
			//先判断今天是否加入考勤了。
			boolean b = workerDao.isInsert(stationid);
			if(!b){//如果没插入，则先插入
				Kaoqindate kaoqindate = new Kaoqindate();
				kaoqindate.setRegionid(regionid);
				kaoqindate.setStationid(stationid);


				kaoqindate.setKqdate(now);
				kaoqindateDao.save(kaoqindate);;

				//插入到考勤表
				Station station = stationDao.findById(stationid);
				List<Worker>  list = workerDao.findListByStation(station);
				for (Worker worker : list) {
					if(1==regionid){
						Kaoqinxian kq = new Kaoqinxian();
						kq.setKqdate(now);
						kq.setState(0);
						kq.setZcstate(0);
						kq.setBtstate(0);
						kq.setYxstate(0);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());
						kaoqinxianDao.save(kq);
					}
					else if(2==regionid){
						Kaoqinbj kq = new Kaoqinbj();
						kq.setKqdate(now);
						kq.setState(0);
						kq.setZcstate(0);
						kq.setBtstate(0);
						kq.setYxstate(0);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());
						kaoqinbjDao.save(kq);
					}
					else if(3==regionid){
						Kaoqinwh kq = new Kaoqinwh();
						kq.setKqdate(now);
						kq.setState(0);
						kq.setZcstate(0);
						kq.setBtstate(0);
						kq.setYxstate(0);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());
						kaoqinwhDao.save(kq);
					}
					else if(4==regionid){
						Kaoqinbb kq = new Kaoqinbb();
						kq.setKqdate(now);
						kq.setState(0);
						kq.setZcstate(0);
						kq.setBtstate(0);
						kq.setYxstate(0);
						kq.setMeituanid(worker.getMeituanid());
						kq.setName(worker.getName());
						kq.setStationid(stationid);
						kq.setStationname(station.getName());
						kq.setTelephone(worker.getTelephone());
						kq.setWorkerid(worker.getId());
						kaoqinbbDao.save(kq);
					}
				}
			}

			//判断是哪个区域，调用哪个考勤表
			if(1==regionid){
				DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinxianDao.xianpageQuery(pageBean);
			}
			else if(2==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinbjDao.xianpageQuery(pageBean);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinwhDao.xianpageQuery(pageBean);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinbbDao.xianpageQuery(pageBean);
			}

		}
		//如果是人事角色，才查询
		else if("renshirole".equals(roleCode)){
				//判断是哪个区域，调用哪个考勤表
			if(1==regionid){
				DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinxianDao.xianpageQuery(pageBean);
			}
			else if(2==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinbjDao.xianpageQuery(pageBean);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinwhDao.xianpageQuery(pageBean);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				pageBean.setDetachedCriteria(detachedCriteria);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				lis = kaoqinbbDao.xianpageQuery(pageBean);
			}
		}
		return lis;
	}

	//单个提交考勤：提交完考勤信息要更新统计信息
	public void submit(Kaoqinxian model) {
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		
		  Statkaoqin statkaoqin = new Statkaoqin();
		  statkaoqin.setRegionid(regionid);
		  statkaoqin.setRegionname(user.getRegionName());
		  statkaoqin.setStationid(user.getStationid());
		  statkaoqin.setStationname(user.getStationName());
		  
		if(1==regionid){
		  Kaoqinxian kaoqinxian = kaoqinxianDao.findById(model.getId());
		  kaoqinxian.setIssubmit(1);
		  kaoqinxian.setState(model.getState());
		  kaoqinxian.setRemark(model.getRemark());
		  kaoqinxianDao.update(kaoqinxian);
		  statkaoqin.setKqdate(kaoqinxian.getKqdate());
		  //获取统计信息
		  kaoqinxianDao.statkaoqin(statkaoqin);
		}
		else if(2==regionid){
		  Kaoqinbj kaoqin = kaoqinbjDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
		  kaoqin.setState(model.getState());
		  kaoqin.setRemark(model.getRemark());
		  kaoqinbjDao.update(kaoqin);
		  kaoqinbjDao.statkaoqin(statkaoqin);
		}
		else if(3==regionid){
		  Kaoqinwh kaoqin = kaoqinwhDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
		  kaoqin.setState(model.getState());
		  kaoqin.setRemark(model.getRemark());
		  kaoqinwhDao.update(kaoqin);
		  
		  kaoqinwhDao.statkaoqin(statkaoqin);
		}
		else if(4==regionid){
		  Kaoqinbb kaoqin = kaoqinbbDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
		  kaoqin.setState(model.getState());
		  kaoqin.setRemark(model.getRemark());
		  kaoqinbbDao.update(kaoqin);
		  kaoqinbbDao.statkaoqin(statkaoqin);
		}	
		
		//更新统计信息
		statkaoqinDao.updatetj(statkaoqin);
	}

	//批量考勤：先批量提交完，再更新考勤信息
	public void submits(List list, int state, Integer flag) {
		Kaoqinxian kaoqinxian = null;
		for (int i=0; i<list.size(); i++) {
			kaoqinxian = new Kaoqinxian();
			kaoqinxian.setId(Long.parseLong(list.get(i).toString()));
			kaoqinxian.setRemark("");

			//没有提交的考勤，并且已经设置了考勤的才处理
			if( 0!=state){
				submit0(kaoqinxian, state, flag);
			}
		}
//		for (Kaoqinxian kaoqinxian : list) {
//			try {
//				kaoqinxian.setRemark(URLDecoder.decode(kaoqinxian.getRemark(), "UTF-8"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//没有提交的考勤，并且已经设置了考勤的才处理
//			if(0==kaoqinxian.getIssubmit()&& 0!=kaoqinxian.getState()){
//				submit0(kaoqinxian);
//			}
//		}
		
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	
		String dateNowStr = sdf.format(now); 
		try {
			now = sdf.parse(dateNowStr);
										
		} catch (ParseException e) {
			e.printStackTrace();
		}
	  Statkaoqin statkaoqin = new Statkaoqin();
	  statkaoqin.setRegionid(regionid);
	  statkaoqin.setRegionname(user.getRegionName());
	  statkaoqin.setStationid(user.getStationid());
	  statkaoqin.setStationname(user.getStationName());
	  statkaoqin.setKqdate(now);
	  
	  if(1==regionid)
	     kaoqinxianDao.statkaoqin(statkaoqin);
	  else if(2==regionid)
	     kaoqinbjDao.statkaoqin(statkaoqin);
	  else if(3==regionid)
		     kaoqinwhDao.statkaoqin(statkaoqin);
	  else if(4==regionid)
		     kaoqinbbDao.statkaoqin(statkaoqin);
	  
	  statkaoqinDao.updatetj(statkaoqin);
	}
	
	private void submit0(Kaoqinxian model, int state, Integer flag) {
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		
		  Statkaoqin statkaoqin = new Statkaoqin();
		  statkaoqin.setRegionid(regionid);
		  statkaoqin.setRegionname(user.getRegionName());
		  statkaoqin.setStationid(user.getStationid());
		  statkaoqin.setStationname(user.getStationName());
		  
		if(1==regionid){
		  Kaoqinxian kaoqinxian = kaoqinxianDao.findById(model.getId());
		  kaoqinxian.setIssubmit(1);
			if (flag != null) {
				if (flag == 1) {
					kaoqinxian.setZcstate(state);
				}else if (flag == 2) {
					kaoqinxian.setBtstate(state);
				}else if (flag == 3) {
					kaoqinxian.setYxstate(state);
				}
			}
		  kaoqinxian.setRemark(model.getRemark());	
		  kaoqinxianDao.update(kaoqinxian);
		}
		else if(2==regionid){
		  Kaoqinbj kaoqin = kaoqinbjDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
			if (flag != null) {
				if (flag == 1) {
					kaoqin.setZcstate(state);
				}else if (flag == 2) {
					kaoqin.setBtstate(state);
				}else if (flag == 3) {
					kaoqin.setYxstate(state);
				}
			}
		  kaoqin.setRemark(model.getRemark());	
		  kaoqinbjDao.update(kaoqin);
		}
		else if(3==regionid){
		  Kaoqinwh kaoqin = kaoqinwhDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
			if (flag != null) {
				if (flag == 1) {
					kaoqin.setZcstate(state);
				}else if (flag == 2) {
					kaoqin.setBtstate(state);
				}else if (flag == 3) {
					kaoqin.setYxstate(state);
				}
			}
		  kaoqin.setRemark(model.getRemark());	
		  kaoqinwhDao.update(kaoqin);
		}
		else if(4==regionid){
		  Kaoqinbb kaoqin = kaoqinbbDao.findById(model.getId());
		  kaoqin.setIssubmit(1);
			if (flag != null) {
				if (flag == 1) {
					kaoqin.setZcstate(state);
				}else if (flag == 2) {
					kaoqin.setBtstate(state);
				}else if (flag == 3) {
					kaoqin.setYxstate(state);
				}
			}
		  kaoqin.setRemark(model.getRemark());	
		  kaoqinbbDao.update(kaoqin);
		}		
	}

	//考勤详情分页查询
	public void pageQueryDetail(PageBean pageBean, Kaoqinxian model) {
		//转换日期字符串
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 			 
		try {
			date = sdf.parse(model.getSkqdate());										
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获取站点和区域ID
		Long stationid = model.getStationid();
		Station station = stationDao.findById(stationid);
		Long regionid = station.getRegionid();
		if(1==regionid){
			DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			detachedCriteria.add(Restrictions.eq("kqdate",date));
			kaoqinxianDao.pageQuery(pageBean);
		}
		else if(2==regionid){					
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
			pageBean.setDetachedCriteria(detachedCriteria);
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			detachedCriteria.add(Restrictions.eq("kqdate",date));
			kaoqinbjDao.pageQuery(pageBean);
		}
		else if(3==regionid){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
			pageBean.setDetachedCriteria(detachedCriteria);
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			detachedCriteria.add(Restrictions.eq("kqdate",date));
			kaoqinwhDao.pageQuery(pageBean);
		}
		else if(4==regionid){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
			pageBean.setDetachedCriteria(detachedCriteria);
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			detachedCriteria.add(Restrictions.eq("kqdate",date));
			kaoqinbbDao.pageQuery(pageBean);
		}
		
	}

	//人事查询今日考勤
	public void pageQuerykqrs(PageBean pageBean) {
		//获取登录用户的站点ID
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		
		//当前日期
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	
		String dateNowStr = sdf.format(now); 
		try {
			now = sdf.parse(dateNowStr);
										
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//如果是人事角色，才查询
		if("renshirole".equals(roleCode)){
			//判断是哪个区域，调用哪个考勤表
			if(1==regionid){
				DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();				
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				detachedCriteria.addOrder(Order.desc("stationname"));				
				kaoqinxianDao.pageQuery(pageBean);			
			}
			else if(2==regionid){					
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				pageBean.setDetachedCriteria(detachedCriteria);				
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				detachedCriteria.addOrder(Order.desc("stationname"));				
				kaoqinbjDao.pageQuery(pageBean);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				pageBean.setDetachedCriteria(detachedCriteria);				
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				detachedCriteria.addOrder(Order.desc("stationname"));				
				kaoqinwhDao.pageQuery(pageBean);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				pageBean.setDetachedCriteria(detachedCriteria);				
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				detachedCriteria.addOrder(Order.desc("stationname"));				
				kaoqinbbDao.pageQuery(pageBean);
			}
		}
		
	}

	//获取站长的员工列表
	public void lpageQuery(PageBean pageBean, int state) {
		//设置查询的状态为预注册的骑手
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",state));
		
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		Long stationid= user.getStationid();
		Station station = stationDao.findById(stationid);
		detachedCriteria.add(Restrictions.eq("station",station));
		
		//detachedCriteria.addOrder(Order.asc("reqtime"));
		
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		workerDao.pageQuery(pageBean);		
	}

	@Override
	public Worker selectWorker() {
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		String workerid = user.getWorkerid();
		Worker worker = null;
		if (workerid != null && !"".equals(workerid)) {
			worker = workerDao.findById(workerid);
		}
		return worker;
	}

}
