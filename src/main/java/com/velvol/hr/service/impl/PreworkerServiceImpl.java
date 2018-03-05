package com.velvol.hr.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.velvol.hr.dao.*;
import com.velvol.hr.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;

@Service      
@Transactional
public class PreworkerServiceImpl implements IPreworkerService{

	@Autowired
	private IPreworkerDao preworkerDao;
	@Autowired
	private IWorkerDao workerDao;
	@Autowired
	private IRegionDao regionDao;
	@Autowired
	private IStationDao stationDao;
	@Autowired
	private IMaterialinitDao MaterialinitDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ILeavereqDao leavereqDao;
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
	
	//扫码添加:返回提示信息
	public Tipinfo scansave(Preworker model, Long regionid, Long stationid) {
		//设置申请类型为扫码
		model.setType(0);
		//设置申请时间为当前时间
		model.setReqtime(new Timestamp(System.currentTimeMillis()));
		
		//获取区域，并设置区域对象
		Region region = regionDao.findById(regionid);
		model.setRegion(region);

		//获取站点，并设置站点对象
		Station station = stationDao.findById(stationid);
		model.setStation(station);

		//处理预计入职日期
		String spredate = model.getSpredate();		
		if(StringUtils.isNotBlank(spredate)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 			
			try {
				Date date = sdf.parse(spredate);
				//System.out.println(date.getDate());				
				model.setPredate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}						
		}
		
		//保存数据
		preworkerDao.save(model);
		System.out.println(model.getId());
		initMaterial(model.getId());

		Tipinfo tipinfo=null;
		if(stationid == -1) {
			//获取区域提示信息
			tipinfo = regionDao.getTipinfoByRegion(regionid);
		}else {
			tipinfo = regionDao.getTipinfo(station.getName());
		}
		return tipinfo;
	}
	
	//人事添加
	public void save(Preworker model,Long regionid) {
		//设置申请类型为人事
		model.setType(1);
		//设置申请时间为当前时间
		model.setReqtime(new Timestamp(System.currentTimeMillis()));
		
		//从session的登录用户里提取区域ID
		//User user = SessionUtils.getLoginUser();
		//Long regionid= user.getRegionid();
		
		//**********测试用先指定区域ID
		//Long regionid = 1L;
		Region region = regionDao.findById(regionid);
		model.setRegion(region);
		preworkerDao.save(model);
		System.out.println(model.getId());
		initMaterial(model.getId());
	}
	
	//站长添加
	public void zsave(Preworker model,Long regionid) {
		//设置申请类型为站长
		model.setType(2);
		//设置申请时间为当前时间
		model.setReqtime(new Timestamp(System.currentTimeMillis()));
		
		//从session的登录用户里提取站点ID
		User user = SessionUtils.getLoginUser();
		Long stationid= user.getStationid();
		Station station =  stationDao.findById(stationid);
		model.setStation(station);
		
		//**********测试用先指定区域ID		
		Region region = regionDao.findById(user.getRegionid());
		model.setRegion(region);
		preworkerDao.save(model);
		System.out.println(model.getId());
		initMaterial(model.getId());
	}
	
	//初始化物料数据
	private void initMaterial(String preworkerid){
		Materialinit materialinit0 = new Materialinit(preworkerid, "头盔", 0);
		MaterialinitDao.save(materialinit0);
		Materialinit materialinit1 = new Materialinit(preworkerid, "上衣", 1);
		MaterialinitDao.save(materialinit1);
		Materialinit materialinit2 = new Materialinit(preworkerid, "外卖箱", 2);
		MaterialinitDao.save(materialinit2);
		Materialinit materialinit3 = new Materialinit(preworkerid, "工牌", 3);
		MaterialinitDao.save(materialinit3);
		Materialinit materialinit4 = new Materialinit(preworkerid, "健康证", 4);
		MaterialinitDao.save(materialinit4);
		Materialinit materialinit5 = new Materialinit(preworkerid, "电动车", 5);
		MaterialinitDao.save(materialinit5);
		Materialinit materialinit6 = new Materialinit(preworkerid, "培训费", 6);
		MaterialinitDao.save(materialinit6);
		Materialinit materialinit7 = new Materialinit(preworkerid, "保险", 7);
		MaterialinitDao.save(materialinit7);
		Materialinit materialinit8 = new Materialinit(preworkerid, "劳动合同", 8);
		MaterialinitDao.save(materialinit8);
	}
	
	public void pageQuery(PageBean pageBean,int state) {
		
		//设置查询的状态为预注册的骑手
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
				
		detachedCriteria.addOrder(Order.asc("reqtime"));
		
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		preworkerDao.pageQuery(pageBean);		
	}

	@Override
	public List movePageQuery(PageBean pageBean, int state) {
		//设置查询的状态为预注册的骑手
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

		detachedCriteria.addOrder(Order.asc("reqtime"));

		pageBean.setDetachedCriteria(detachedCriteria);

		List list= preworkerDao.movePageQuery(pageBean);
		return list;
	}

	@Override
	public List<Preworker> movePageQueryCount() {
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		List<Preworker> list = new ArrayList<>();
		if("renshirole".equals(roleCode)){
			Long regionid= user.getRegionid();
			Region region = regionDao.findById(regionid);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Preworker.class);
			detachedCriteria.add(Restrictions.eq("region",region));
			list = preworkerDao.findByCriteria(detachedCriteria);
		}
		else if("zhanzhangrole".equals(roleCode)){
			Long stationid= user.getStationid();
			Station station = stationDao.findById(stationid);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Preworker.class);
			detachedCriteria.add(Restrictions.eq("station",station));
			list = preworkerDao.findByCriteria(detachedCriteria);
		}
		return list;
	}

	@Override
	public List selectWorkerCount() {
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		List list = new ArrayList();
		if("renshirole".equals(roleCode)){
			Long regionid= user.getRegionid();
			Region region = regionDao.findById(regionid);
//			detachedCriteria.add(Restrictions.eq("region",region));
			list = workerDao.selectRegionWorkerCount(region);
		}
		else if("zhanzhangrole".equals(roleCode)){
			Long stationid= user.getStationid();
			Station station = stationDao.findById(stationid);
//			detachedCriteria.add(Restrictions.eq("station",station));
			list = workerDao.findListByStation(station);
		}

		return list;
	}

	@Override
	public List selectCqWorkerCount() {
		//获取登录用户的站点ID
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		List list = new ArrayList();
		//当前日期
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(now);
		try {
			now = sdf.parse(dateNowStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if("renshirole".equals(roleCode)){
			if(1==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinxian.class);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinxianDao.findByCriteria(detachedCriteria);
			}
			else if(2==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinbjDao.findByCriteria(detachedCriteria);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinwhDao.findByCriteria(detachedCriteria);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinbbDao.findByCriteria(detachedCriteria);
			}
		}else if("zhanzhangrole".equals(roleCode)){
//			//判断是哪个区域，调用哪个考勤表
			if(1==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinxian.class);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinxianDao.findByCriteria(detachedCriteria);
			}
			else if(2==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbj.class);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinbjDao.findByCriteria(detachedCriteria);
			}
			else if(3==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinwh.class);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinwhDao.findByCriteria(detachedCriteria);
			}
			else if(4==regionid){
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kaoqinbb.class);
				detachedCriteria.add(Restrictions.eq("stationid",stationid));
				detachedCriteria.add(Restrictions.eq("kqdate",now));
				list = kaoqinbbDao.findByCriteria(detachedCriteria);
			}
		}
		return list;
	}

	@Override
	public List selectLeaverWorkerCount() {
		//获取登录用户的站点ID
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		List list = new ArrayList();
		if("renshirole".equals(roleCode)){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leavereq.class);
			detachedCriteria.add(Restrictions.eq("regionid",regionid));
			list = leavereqDao.findByCriteria(detachedCriteria);
		}else if("zhanzhangrole".equals(roleCode)){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leavereq.class);
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			list = leavereqDao.findByCriteria(detachedCriteria);

		}
		return list;
	}

	//批量删除：其实是作废
	public void deleteBatch(String ids) {//1,2,3,4
		if(StringUtils.isNotBlank(ids)){
			String[] preworkerIds = ids.split(",");
			for (String id : preworkerIds) {
				preworkerDao.executeUpdate("preworker.delete", id);
				
				//批量删除物料的初始数据
				MaterialinitDao.executeUpdate("materialinit.delete", id);;
			}
		}
	}
	
	public Preworker findById(String id) {
		return preworkerDao.findById(id);
	}
	
	public void update(Preworker preworker) {
		preworkerDao.update(preworker);
	}

	//获取区域列表
	public List<Region> findRegionList() {
		
		return regionDao.findAll();
	}

	//删除
	public void delete(String id) {
		preworkerDao.executeUpdate("preworker.delete", id);
		
	}

	//审核通过
	public void auditok(String id,int state) {
		Preworker preworker = preworkerDao.findById(id);
		preworker.setState(state);
	
		preworkerDao.update(preworker);	
	}

	
	//加入黑名单
	public void auditno(String id, String faildesc) {
		Preworker preworker = preworkerDao.findById(id);
		preworker.setState(-1);
		preworker.setFaildesc(faildesc);
		preworkerDao.update(preworker);
	}

	@Override
	public void pageQueryM(PageBean pageBean, int getstate) {
		//设置查询的状态为审核通过的骑手
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",new Integer(1)));
		
		//设置骑手是否领取物料的状态
		detachedCriteria.add(Restrictions.eq("getstate",getstate));
		
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		Long regionid= user.getRegionid();
		Region region = regionDao.findById(regionid);
		detachedCriteria.add(Restrictions.eq("region",region));
		
		
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		preworkerDao.pageQuery(pageBean);		
		
	}

	//获取站点列表
	public List<Station> findStations() {
		//获取登录者的区域编号
		User user = SessionUtils.getLoginUser();
		Long regionid= user.getRegionid();
		
		List<Station> list= stationDao.findAllByRegionid(regionid);
		return list;
	}

	//微信注册获取站点列表
	@Override
	public List<Station> moveFindStations(Long regionid) {
		List<Station> list= stationDao.findAllByRegionid(regionid);
		return list;
	}

	//分配站点
	public void assignStation(String id, Long stationid) {
		Preworker preworker = preworkerDao.findById(id);
		Station station = stationDao.findById(stationid);
		preworker.setStation(station);
		preworkerDao.update(preworker);
	}

	@Override
	public List<Materialinit> findMListById(String preworkerid) {
		
		return MaterialinitDao.findAllByWorkerid(preworkerid);
	}

	@Override
	public void putMaterial(Materialmodel materialmodel) {
		
		String preworkerid = materialmodel.getId();
		int type = materialmodel.getType();
		Materialinit materialinit = MaterialinitDao.findByType(preworkerid,type);
		if(0==type){//头盔		
			materialinit.setSort(materialmodel.getTksort());			
			materialinit.setNewold(materialmodel.getTknewold());
			materialinit.setRemark(materialmodel.getTkremark());
			materialinit.setPutdate(materialmodel.getTkputdate());
			materialinit.setPutstate(1);
		}
		else if(1==type){//衣服			
			materialinit.setSort(materialmodel.getSysort());			
			materialinit.setNewold(materialmodel.getSynewold());
			materialinit.setRemark(materialmodel.getSyremark());
			materialinit.setPutdate(materialmodel.getSyputdate());
			materialinit.setPutstate(1);
		}
		else if(2==type){//外卖箱			
			materialinit.setSort(materialmodel.getWmxsort());			
			materialinit.setNewold(materialmodel.getWmxnewold());
			materialinit.setRemark(materialmodel.getWmxremark());
			materialinit.setPutdate(materialmodel.getWmxputdate());
			materialinit.setPutstate(1);
		}
		else if(3==type){//工牌									
			materialinit.setRemark(materialmodel.getGpremark());
			materialinit.setPutdate(materialmodel.getGpputdate());			
			materialinit.setPutstate(materialmodel.getGpputstate());			
		}
		else if(4==type){//健康证									
			materialinit.setRemark(materialmodel.getJkzremark());
			materialinit.setPutdate(materialmodel.getJkzputdate());			
			materialinit.setPutstate(materialmodel.getJkzputstate());			
		}
		else if(5==type){//电动车			
			materialinit.setSort(materialmodel.getDdcsort());			
			materialinit.setNewold(materialmodel.getDdcnewold());
			materialinit.setRemark(materialmodel.getDdcremark());
			materialinit.setPutdate(materialmodel.getDdcputdate());
			if("公司提供".equals(materialmodel.getDdcsort()))
			    materialinit.setPutstate(1);
			else
				materialinit.setPutstate(0);
		}
		else if(6==type){//培训费										
			materialinit.setRemark(materialmodel.getPxremark());
			materialinit.setPutdate(materialmodel.getPxputdate());
			materialinit.setPutstate(materialmodel.getPxputstate());
			
		}
		else if(7==type){//保险										
			materialinit.setRemark(materialmodel.getBxremark());
			materialinit.setPutdate(materialmodel.getBxputdate());
			materialinit.setPutstate(materialmodel.getBxputstate());			
		}	
		else if(8==type){//劳动合同										
			materialinit.setRemark(materialmodel.getHtremark());
			materialinit.setPutdate(materialmodel.getHtputdate());
			materialinit.setPutstate(materialmodel.getHtputstate());			
		}		
	}

	@Override
	public void updatejkz(Materialmodel model, String newFilename) {		
		//保存健康证
		Preworker preworker = preworkerDao.findById(model.getId());
		preworker.setPicpath(newFilename);
		preworkerDao.update(preworker);
		
		//设置健康证状态为已上传
		Materialinit materialinit = MaterialinitDao.findByType(model.getId(),4);
		materialinit.setPutstate(1);
	}

	//试用期劝退
	public void quantui(String id, String faildesc) {
		Preworker preworker = preworkerDao.findById(id);
		preworker.setTestresult(-1);//设置使用期劝退状态		
		preworker.setFaildesc(faildesc);//设置劝退原因
		preworkerDao.update(preworker);		
		
		//生成试用期不合格离职申请
	}

	//试用期合格
	public void hege(String id) {
		Preworker preworker = preworkerDao.findById(id);
		preworker.setTestresult(1);
		preworker.setState(3);
		preworkerDao.update(preworker);	
	}

	//试用期提交：
	public void testSubmit(Preworker model) {
		Preworker preworker = preworkerDao.findById(model.getId());
		
		//获取试用期结果
		int testResult = preworker.getTestresult();
		System.out.println("testResult:"+testResult);
		if(1==testResult){//合格
			preworker.setState(3);//设置入职完成
			
			//给该用户创建一个帐号
			User user = new User(preworker.getTelephone(), "123456", preworker.getStation().getId(), preworker.getId(), preworker.getRegion().getId());		   		
			user.setRegionName(preworker.getRegion().getName());						
			user.setStationName(preworker.getStation().getName());			
			userDao.save(user);		    
		    Role role = new Role("10003");//骑手角色			
			user.getRoles().add(role);//用户对象关联角色对象
			
			//把该骑手添加到正式员工表worker
			Worker worker = new Worker();
			worker.setCardid(preworker.getCardid());
			worker.setGetstate(preworker.getGetstate());
			worker.setId(preworker.getId());
			worker.setIndate(preworker.getIndate());
			worker.setMeituanid(preworker.getMeituanid());
			worker.setName(preworker.getName());
			worker.setPicpath(preworker.getPicpath());
			worker.setPicpathlzd(preworker.getPicpathlzd());
			worker.setRegion(preworker.getRegion());
			worker.setSex(preworker.getSex());
			worker.setState(preworker.getState());
			worker.setStation(preworker.getStation());
			worker.setTelephone(preworker.getTelephone());
			worker.setType(preworker.getType());
			worker.setYhcard(preworker.getYhcard());
			worker.setYhfrom(preworker.getYhfrom());
			worker.setYhperson(preworker.getYhperson());
			workerDao.save(worker);
			
			
		}
		else if(-1==testResult){//劝退
			preworker.setState(-2);
			
			//创建一个离职申请
			Date reqdate = new Date();
			Calendar c = Calendar.getInstance();
	        c.setTime(reqdate);
	        c.add(Calendar.DAY_OF_MONTH, 1); 
	        Date leavedate = c.getTime();
	        
			Leavereq leavereq =new Leavereq(preworker.getId(), preworker.getName(), preworker.getFaildesc(),
					reqdate,leavedate, preworker.getRegion().getId(), preworker.getStation().getId(), 
					0, 0, 0);
			
			leavereqDao.save(leavereq);
		}
	
	}
	
	public List<Region> userRegion() {
		//获取登录者的区域编号
		User user = SessionUtils.getLoginUser();
		Long regionid= user.getRegionid();
	   
		Region region  = regionDao.findById(regionid);
		List<Region> list = new ArrayList<Region>();
		list.add(region);
		return list;
	}

	//上传离职单
	public void updatelzd(Leavereq model, String newFilename) {
		//保存健康证
		Preworker preworker = preworkerDao.findById(model.getPreworkerid());
		preworker.setPicpathlzd(newFilename);
		preworkerDao.update(preworker);						
	}

	//添加时判断手机号是否存在
	public boolean isHasPhone(String telephone) {
		Preworker preworker = preworkerDao.findByPhone(telephone);
		if(preworker == null)
		    return false;
		else
			return true;
	}

	//修改时判断手机号是否存在
	public boolean isHasPhone(Preworker model) {
		Preworker preworker = preworkerDao.findByPhone(model);
		if(preworker == null)
		    return false;
		else
			return true;
	}

	//站长审批判断物料是否归还
	public boolean isBackMatZ(String preworkerid) {
		
		return MaterialinitDao.isBackMatZ(preworkerid);
	}

	@Override
	public boolean isBackMatR(String preworkerid) {
		return MaterialinitDao.isBackMatR(preworkerid);
	}

	@Override
	public boolean matcheck(String id) {
		// TODO Auto-generated method stub
		return MaterialinitDao.matcheck(id);
	}

	@Override
	public boolean matcheckwmx(String id) {
		// TODO Auto-generated method stub
		return MaterialinitDao.matcheckwmx(id);
	}

	@Override
	public Preworker findByTelephone(String telephone) {
		Preworker preworker = preworkerDao.findByPhone(telephone);
		return preworker;
	}
}
