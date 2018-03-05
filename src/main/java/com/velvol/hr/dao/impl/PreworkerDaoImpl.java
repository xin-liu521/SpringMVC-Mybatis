package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IPreworkerDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.domain.Preworker;

@Repository
public class PreworkerDaoImpl extends BaseDaoImpl<Preworker> implements IPreworkerDao {

	//添加时判断手机号是否存在
	public Preworker findByPhone(String telephone) {
		String hql = "FROM Preworker p WHERE p.telephone = ? ";
		List<Preworker> list = (List<Preworker>) this.getHibernateTemplate().find(hql, telephone);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	//修改时判断手机号是否存在
	public Preworker findByPhone(Preworker model) {
		String hql = "FROM Preworker p WHERE p.telephone = ? and p.id<>?";
		List<Preworker> list = (List<Preworker>) this.getHibernateTemplate().find(hql, model.getTelephone(),model.getId());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
