package com.velvol.hr.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.velvol.hr.domain.*;
import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IWorkerDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;

@Repository
public class WorkerDaoImpl  extends BaseDaoImpl<Worker> implements IWorkerDao {

	//判断今天是否加入考勤了
	public boolean isInsert(Long stationid) {
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	
		String dateNowStr = sdf.format(now);  
		try {
			now = sdf.parse(dateNowStr);
										
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String hql = "FROM Kaoqindate k WHERE k.stationid = ? and k.kqdate=? ";
		List<Kaoqindate> list = (List<Kaoqindate>) this.getHibernateTemplate().find(hql, stationid,now);
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}

	
	public List findListByStation(Station station) {
		String hql = "FROM Worker w WHERE w.station = ? ";
		List<Worker> list = (List<Worker>) this.getHibernateTemplate().find(hql, station);
		return list;
	}

	@Override
	public List selectRegionWorkerCount(Region region) {
		String hql = "FROM Worker w WHERE w.region = ? ";
		List<Worker> list = (List<Worker>) this.getHibernateTemplate().find(hql, region);
		return list;
	}

}
