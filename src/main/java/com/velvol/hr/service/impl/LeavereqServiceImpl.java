package com.velvol.hr.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.dao.ILeavereqDao;
import com.velvol.hr.dao.IMaterialinitDao;
import com.velvol.hr.dao.IPreworkerDao;
import com.velvol.hr.dao.IWorkerDao;
import com.velvol.hr.domain.Leavereq;
import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.User;
import com.velvol.hr.domain.Worker;
import com.velvol.hr.service.ILeavereqService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;

@Service      
@Transactional
public class LeavereqServiceImpl implements ILeavereqService{

	@Autowired
	private ILeavereqDao leavereqDao;
	@Autowired
	private IPreworkerDao preworkerDao;
	@Autowired
	private IWorkerDao workerDao;
	@Autowired
	private IMaterialinitDao materialinitDao;
	
	//添加离职信息
	public void save(Leavereq model) {
		//获取用户
		User user = SessionUtils.getLoginUser();
		String workerid = user.getWorkerid();
		//测试用，此处要改
		Worker worker = workerDao.findById(user.getWorkerid());
		
		Date leavedate = new Date();
		if(StringUtils.isNotBlank(model.getSleavedate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				leavedate = sdf.parse(model.getSleavedate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		Leavereq leavereq =new Leavereq(worker.getId(), worker.getName(), model.getReason(),
				new Date(),leavedate, worker.getRegion().getId(), worker.getStation().getId(), 
				0, 1, 0);
		
		leavereqDao.save(leavereq);
		
	}

	@Override
	public List<Leavereq> findListByWorkerId(String preworkerid) {
		
		return leavereqDao.findListByWorkerId(preworkerid);
	}

	//编辑离职申请
	public void edit(Leavereq model) {
		Leavereq leavereq = leavereqDao.findById(model.getId());
		Date leavedate = new Date();
		if(StringUtils.isNotBlank(model.getSleavedate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				leavedate = sdf.parse(model.getSleavedate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		leavereq.setLeavedate(leavedate);
		leavereq.setReason(model.getReason());
		leavereqDao.update(leavereq);
	}

	@Override
	public void delete(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereqDao.delete(leavereq);		
	}

    //提交离职申请
	public void doSubmit(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereq.setState(1);
		leavereqDao.update(leavereq);
		
	}

	//站长代发离职申请
	public void zsave(Leavereq model,String workerid) {
		//获取用户
		User user = SessionUtils.getLoginUser();
		Long stationid = user.getStationid();
		//测试用，此处要改
		Worker worker = workerDao.findById(workerid);
		
		Date leavedate = new Date();
		if(StringUtils.isNotBlank(model.getSleavedate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				leavedate = sdf.parse(model.getSleavedate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		Leavereq leavereq =new Leavereq(workerid, worker.getName(), model.getReason(),
				new Date(),leavedate, worker.getRegion().getId(), worker.getStation().getId(), 
				0, model.getReqtype(), 1);
		
		leavereqDao.save(leavereq);				
	}

	//根据站点ID获取离职申请
	public List<Leavereq> findListByStationId(Long stationid,int state) {
		List<Leavereq> list = leavereqDao.findListByStationId(stationid,state);
		List<Leavereq> list0 = new ArrayList<Leavereq>();
		for (Leavereq leavereq : list) {
			System.out.println("leavereq.getPreworkerid()"+leavereq.getPreworkerid());
			Worker worker = workerDao.findById(leavereq.getPreworkerid());
		    System.out.println("worker"+worker);
			leavereq.setMeituanid(worker.getMeituanid());
			leavereq.setStationname(worker.getStation().getName());
			leavereq.setTelephone(worker.getTelephone());
			
			list0.add(leavereq);
			}
		return list0;
	}

	@Override
	public void zedit(Leavereq model) {
		Leavereq leavereq = leavereqDao.findById(model.getId());
		Date leavedate = new Date();
		if(StringUtils.isNotBlank(model.getSleavedate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				leavedate = sdf.parse(model.getSleavedate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		leavereq.setReqtype(model.getReqtype());
		leavereq.setLeavedate(leavedate);
		leavereq.setReason(model.getReason());
		leavereqDao.update(leavereq);
	}

	//站长驳回
	public void doRedo(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereq.setState(-1);
		leavereqDao.update(leavereq);		
	}

	//站长审批通过
	public void zShipi(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereq.setState(2);
		leavereqDao.update(leavereq);			
	}

	//人事审批通过完成离职手续
	public void rShipi(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereq.setState(3);
		//同时，更新实际离职日期为当前时间
		Date date = new Date();
		leavereq.setLeavedate(date);
		leavereqDao.update(leavereq);	
	}

	//人事审批离职列表
	public List<Leavereq> findListByRegionId(Long regionid, int state) {
		
		List<Leavereq> list = leavereqDao.findListByRegionId(regionid,state);
		List<Leavereq> list0 = new ArrayList<Leavereq>();
		for (Leavereq leavereq : list) {
			Worker worker = workerDao.findById(leavereq.getPreworkerid());
		
			leavereq.setMeituanid(worker.getMeituanid());
			leavereq.setStationname(worker.getStation().getName());
			leavereq.setTelephone(worker.getTelephone());
			leavereq.setRegionname(worker.getRegion().getName());
			list0.add(leavereq);
			}
		return list0;
	}

	//离职完成列表pageQuery
	public void pageQuery(PageBean pageBean, Long regionid, int state) {
		
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",new Integer(state)));
		
		//设置骑手是否领取物料的状态
		detachedCriteria.add(Restrictions.eq("regionid",regionid));
						
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		leavereqDao.pageQuery(pageBean);	
		
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 
				
		List<Leavereq> list0 = new ArrayList<Leavereq>(); 
		List<Leavereq> list = pageBean.getRows();
		for (Leavereq leavereq : list) 
		{
			//处理日期格式问题
			Date reqdate = leavereq.getReqdate();
			if(reqdate!=null){
			   String strreqdate = sdf.format(reqdate);			
			   leavereq.setSreqdate(strreqdate);
			}
			Date leavedate = leavereq.getLeavedate();
			if(leavedate!=null){
			   String sleavedate = sdf.format(leavedate);			
			   leavereq.setSleavedate(sleavedate);
			}
			
			//获取骑手其他信息
			Worker worker = workerDao.findById(leavereq.getPreworkerid());
			
			leavereq.setMeituanid(worker.getMeituanid());
			leavereq.setStationname(worker.getStation().getName());
			leavereq.setTelephone(worker.getTelephone());
			
			list0.add(leavereq);
		}
	 pageBean.setRows(list0);

	}

	@Override
	public Leavereq getById(Long id) {
		
		return leavereqDao.findById(id);
	}
	
	public void backMaterial(Materialinit materialinit) {
		Materialinit entity = materialinitDao.findById(materialinit.getId());
	
		Date date = new Date();
		if(StringUtils.isNotBlank(materialinit.getSbackdate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				date = sdf.parse(materialinit.getSbackdate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		entity.setBackdate(date);
		entity.setBackremark(materialinit.getBackremark());
		entity.setBacktype(materialinit.getBacktype());
		entity.setPcjin(materialinit.getPcjin());
		entity.setIsback(1);
		materialinitDao.update(entity);
		
	}

	@Override
	public void backFee(Materialinit materialinit) {
		Materialinit entity = materialinitDao.findById(materialinit.getId());
		
		Date date = new Date();
		if(StringUtils.isNotBlank(materialinit.getSbackdate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				date = sdf.parse(materialinit.getSbackdate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		entity.setBackdate(date);
		entity.setBackremark(materialinit.getBackremark());
		entity.setPcjin(materialinit.getPcjin());
		entity.setIsback(1);
		materialinitDao.update(entity);
		
		
	}

	@Override
	public List<Leavereq> findListByStationId(Long stationid) {
		List<Leavereq> list = leavereqDao.findListByStationId(stationid);
		List<Leavereq> list0 = new ArrayList<Leavereq>();
		for (Leavereq leavereq : list) {
			Worker worker = workerDao.findById(leavereq.getPreworkerid());
		
			leavereq.setMeituanid(worker.getMeituanid());
			leavereq.setStationname(worker.getStation().getName());
			leavereq.setTelephone(worker.getTelephone());
			
			list0.add(leavereq);
			}
		return list0;
	}

	//外卖箱扣款
	public void wmxkoukuan(Materialinit materialinit) {
		Materialinit entity = materialinitDao.findById(materialinit.getId());
		entity.setPcjin(materialinit.getPcjin());
		entity.setIsback(1);
		materialinitDao.update(entity);
	}

	@Override
	public void htmatback(Materialinit materialinit) {
Materialinit entity = materialinitDao.findById(materialinit.getId());
		
		Date date = new Date();
		if(StringUtils.isNotBlank(materialinit.getSbackdate())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				date = sdf.parse(materialinit.getSbackdate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		entity.setBackdate(date);
		entity.setBackremark(materialinit.getBackremark());		
		entity.setIsback(1);
		materialinitDao.update(entity);
		
	}

	
	public void rkoufei(Long id) {
		Leavereq leavereq = leavereqDao.findById(id);
		leavereq.setState(4);
		//同时，更新实际离职日期为当前时间
		Date date = new Date();
		leavereq.setLeavedate(date);
		leavereqDao.update(leavereq);	
		
		//更新preworker表和worker表的状态为4
		String preworkid = leavereq.getPreworkerid();
		Preworker preworker = preworkerDao.findById(preworkid);
		preworker.setState(4);
		preworkerDao.update(preworker);
		
		Worker worker = workerDao.findById(preworkid);
		if(worker !=null){
			worker.setState(4);
			workerDao.update(worker);
		}
	}
}
