package com.velvol.hr.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IMaterialDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Material;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Station;

@Repository
public class MaterialDaoImpl  extends BaseDaoImpl<Material> implements IMaterialDao {

	public List<Material> findAllByWorkerid(String preworkerid) {
		String hql = "FROM Material m WHERE m.preworkerid = ? ";
		List<Material> list =  (List<Material>) this.getHibernateTemplate().find(hql, preworkerid);
		return list;	
	}

}
