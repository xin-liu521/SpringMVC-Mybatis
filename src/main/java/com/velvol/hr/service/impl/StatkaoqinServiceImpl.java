package com.velvol.hr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.dao.IStatkaoqinDao;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.IStatkaoqinService;
import com.velvol.hr.service.IWorkerService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;

@Service      
@Transactional
public class StatkaoqinServiceImpl implements IStatkaoqinService {
	@Autowired
	private IStatkaoqinDao statkaoqinDao;
	
	//默认统计一个月的信息
	public void pageQuery(PageBean pageBean) {
		
		User user = SessionUtils.getLoginUser();
		String roleCode = user.getRoleCode();
		Long stationid = user.getStationid();
		Long regionid = user.getRegionid();
		
		//获取1个月的日期范围
		Date begindate = getMonthDate();
		Date enddate = getCurDate();
		
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//如果不是站长角色，则直接返回
		if("zhanzhangrole".equals(roleCode)){
			
			detachedCriteria.add(Restrictions.eq("stationid",stationid));
			detachedCriteria.add(Restrictions.between("kqdate",begindate,enddate));				
			detachedCriteria.addOrder(Order.desc("kqdate"));
			statkaoqinDao.pageQuery(pageBean);
		}
		else if("renshirole".equals(roleCode)){	//如果是人事角色		
			detachedCriteria.add(Restrictions.eq("regionid",regionid));
			detachedCriteria.add(Restrictions.between("kqdate",begindate,enddate));	
			detachedCriteria.addOrder(Order.desc("stationname"));
			detachedCriteria.addOrder(Order.desc("kqdate"));
			statkaoqinDao.pageQuery(pageBean);
		}
		
		
		
		
	}
	
	private Date getMonthDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        return date;
	}
	
	private Date getCurDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();            
        try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        return date;
	}

}
