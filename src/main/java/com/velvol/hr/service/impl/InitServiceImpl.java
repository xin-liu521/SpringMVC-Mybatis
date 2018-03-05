package com.velvol.hr.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.dao.IInitDao;
import com.velvol.hr.dao.IPreworkerDao;
import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.IInitService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;


@Service      
@Transactional
public class InitServiceImpl implements IInitService{

	@Autowired
	private IPreworkerDao preworkerDao;
	@Autowired
	private IRegionDao regionDao;
	@Autowired
	private IInitDao initDao;
	
	//添加初始化信息:
	public void save(Initinfo model) {
		//前台通过，preworker.id传递预注册骑手的id
		Preworker preworker = preworkerDao.findById(model.getPreworker().getId());
		//判断该骑手是否添加了初始化信息，添加过了则不添加	
		Initinfo initinfo = preworker.getInitinfo();		
		//如果没有添加过该骑手的初始化信息，则添加
		if(initinfo == null){
			//设置预注册初始化状态为已初始化
			preworker.setInitstate(1);
		   model.setPreworker(preworker);
		   /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = null;
			try {
				date = (Date) sdf.parse("2017-10-11");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		   model.setBx_startdate(date);*/
		   initDao.save(model);	
		}
		   
	}

	//预注册骑手初始化数据
	public void pageQuery(PageBean pageBean) {
		//设置查询的状态为审核通过的骑手
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",new Integer(1)));
				
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		Long regionid= user.getRegionid();
		Region region = regionDao.findById(regionid);
		detachedCriteria.add(Restrictions.eq("region",region));
				
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		//这查询的是预注册列表的分页数据
		preworkerDao.pageQuery(pageBean);	
				
	}

	@Override
	public Initinfo findById(Long id) {
		// TODO Auto-generated method stub
		return initDao.findById(id);
	}

	@Override
	public void update(Initinfo initinfo) {
		initDao.update(initinfo);		
	}

	//删除初始化数据
	public void delete(Long id) {
		//获取初始化对象
		Initinfo initinfo = initDao.findById(id);		
		//获取预注册对象
		Preworker preworker = initinfo.getPreworker();
		//设置预注册对象初始化状态为0
		preworker.setInitstate(0);
		//删除初始化对象
		initDao.delete(initinfo);
		
	}
	
  	

}
