package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.velvol.hr.dao.IMaterialinitDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.domain.Materialinit;

import ognl.ElementsAccessor;


@Repository
public class MaterialinitDaoImpl  extends BaseDaoImpl<Materialinit> implements IMaterialinitDao {

	public List<Materialinit> findAllByWorkerid(String preworkerid) {
		
		String hql = "FROM Materialinit u WHERE  u.preworkerid = ?";
	
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, preworkerid);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;	
	}

	//根据骑手ID删除物料初始数据
	public void deleteByPreworkerid(String preworkerid) {
		
		
	}

	//根据骑手ID和类型查询物料记录
	public Materialinit findByType(String preworkerid, int type) {
		
		String hql = "FROM Materialinit m WHERE m.preworkerid = ? and m.type = ?";
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, preworkerid,type);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	//判断外卖箱和电动车是否处理
	public boolean isBackMatZ(String preworkerid) {
		boolean bisBack=true;
		String hql = "FROM Materialinit m WHERE m.preworkerid = ? and (m.type = 2 or m.type = 5)";
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, preworkerid);
		for (Materialinit materialinit : list) {
			if(materialinit.getBacktype()==0)
				bisBack=false;
		}
		
		return bisBack;
	}

	//判断
	public boolean isBackMatR(String preworkerid) {
		boolean bisBack=true;
		String hql = "FROM Materialinit m WHERE m.preworkerid = ? and m.type <> 4";
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, preworkerid);
		for (Materialinit materialinit : list) {
			if(materialinit.getIsback()==0)
				bisBack=false;
		}
		
		return bisBack;
	}

	@Override
	public boolean matcheck(String id) {
		boolean bistk=false;
		boolean bissy=false;
		String hql = "FROM Materialinit m WHERE m.preworkerid = ? ";
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, id);
		for (Materialinit materialinit : list) {
			if(materialinit.getType()==0&&materialinit.getPutstate()==1)
				bistk=true;
			if(materialinit.getType()==1&&materialinit.getPutstate()==1)
				bissy=true;
		}
		  if(bistk&&bissy)
			  return true;
		  else
			  return false;
	}

	@Override
	public boolean matcheckwmx(String id) {
		boolean biswmx=false;
		String hql = "FROM Materialinit m WHERE m.type=2 and m.preworkerid = ? ";
		List<Materialinit> list = (List<Materialinit>) this.getHibernateTemplate().find(hql, id);
		for (Materialinit materialinit : list) {
			if(materialinit.getPutstate()==1)
				biswmx=true;			
		}
		 
	    return biswmx;
	}

}
