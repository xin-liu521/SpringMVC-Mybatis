package com.velvol.hr.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IKaoqinwhDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Kaoqinwh;
import com.velvol.hr.domain.Statkaoqin;

@Repository
public class KaoqinwhDaoImpl extends BaseDaoImpl<Kaoqinwh> implements IKaoqinwhDao {

	public void statkaoqin(Statkaoqin statkaoqin) {
		Long stationid = statkaoqin.getStationid();
		Date date = statkaoqin.getKqdate();
		//获取总人数
		String hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.stationid = ? and k.kqdate=? ";		
		Long count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();  		
		statkaoqin.setTotal(count.intValue());
		
		//获取参加考勤人数
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();   		
		statkaoqin.setKqnumber(count.intValue());
		//获取出勤人数
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and (k.state=1 or k.state=2 or k.state=3 or k.state=5) and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next(); 	
		statkaoqin.setCqnumber(count.intValue());
		//获取缺勤人数
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and (k.state=8) and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();   		
		statkaoqin.setNcqnumber(count.intValue());
		//获取事假
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and (k.state=6) and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();   		
		statkaoqin.setSjnumber(count.intValue());
		//获取病假
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and (k.state=7) and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();   		
		statkaoqin.setBjnumber(count.intValue());
		//获取迟到
		hql = "SELECT count(*) FROM Kaoqinwh k  WHERE k.issubmit=1 and (k.state=5) and k.stationid = ? and k.kqdate=? ";		
		count = (Long)getHibernateTemplate().find(hql,stationid,date).listIterator().next();   		
		statkaoqin.setCdnumber(count.intValue());
	}

}
