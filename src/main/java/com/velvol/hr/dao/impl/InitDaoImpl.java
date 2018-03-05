package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.velvol.hr.dao.IInitDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.domain.Tipinfo;


@Repository
public class InitDaoImpl extends BaseDaoImpl<Initinfo> implements IInitDao{

	//判断该骑手是否添加过初始化数据
	public Initinfo findByWorkerid(String workerid) {
		String hql = "FROM Initinfo t WHERE t.workerid = ? ";
		List<Initinfo> list = (List<Initinfo>) this.getHibernateTemplate().find(hql, workerid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
		
	}

}
