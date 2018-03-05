package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IStationDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.Tipinfo;

@Repository
public class StationDaoImpl  extends BaseDaoImpl<Station> implements IStationDao {

	//查询区域的站点
	public List<Station> findAllByRegionid(Long regionid) {
		String hql = "FROM Station s WHERE s.regionid = ? ";
		List<Station> list =  (List<Station>) this.getHibernateTemplate().find(hql, regionid);
		return list;		
	}

}
