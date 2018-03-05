package com.velvol.hr.dao.impl;
 

import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.ILeavereqDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Leavereq;
import com.velvol.hr.domain.Material;
@Repository
public class LeavereqDaoImpl  extends BaseDaoImpl<Leavereq> implements ILeavereqDao{

	
	public List<Leavereq> findListByWorkerId(String preworkerid) {
		String hql = "FROM Leavereq l WHERE l.preworkerid = ? ";
		List<Leavereq> list =  (List<Leavereq>) this.getHibernateTemplate().find(hql, preworkerid);
		return list;	
	}

	
	public List<Leavereq> findListByStationId(Long stationid, int state) {
		String hql = "FROM Leavereq l WHERE l.stationid = ? and l.state=? ";
		List<Leavereq> list =  (List<Leavereq>) this.getHibernateTemplate().find(hql, stationid,state);
		return list;	
	}

	public List<Leavereq> findListByRegionId(Long regionid, int state) {
		String hql = "FROM Leavereq l WHERE l.regionid = ? and l.state=? ";
		List<Leavereq> list =  (List<Leavereq>) this.getHibernateTemplate().find(hql, regionid,state);
		return list;	
	}


	@Override
	public List<Leavereq> findListByStationId(Long stationid) {
		String hql = "FROM Leavereq l WHERE l.state !=? and l.stationid = ? ";
		List<Leavereq> list =  (List<Leavereq>) this.getHibernateTemplate().find(hql,0,stationid);
		return list;	
	}

}
