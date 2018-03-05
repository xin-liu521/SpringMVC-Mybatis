package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Tipinfo;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {
	
	public Tipinfo getTipinfo(String name) {
		String hql = "FROM Tipinfo t WHERE t.name = ? ";
		List<Tipinfo> tipinfoList = (List<Tipinfo>) this.getHibernateTemplate().find(hql, name);
		Tipinfo tipinfo = null;
		for (int i=0;i<tipinfoList.size(); i++){
			tipinfo = new Tipinfo();
			tipinfo.setId(tipinfoList.get(0).getId());
			tipinfo.setType(tipinfoList.get(0).getType());
			tipinfo.setContent(tipinfoList.get(0).getContent());
			tipinfo.setLinkman(tipinfoList.get(0).getLinkman());
			tipinfo.setName(tipinfoList.get(0).getName());
			tipinfo.setLinkmantel(tipinfoList.get(0).getLinkmantel());
			tipinfo.setAddr(tipinfoList.get(0).getAddr());
		}
		return tipinfo;
	}

	@Override
	public Tipinfo getTipinfoByRegion(Long regionid) {
		String hql = "FROM Tipinfo t WHERE t.regionid = ? ";
		List<Tipinfo> tipinfoList = (List<Tipinfo>) this.getHibernateTemplate().find(hql, regionid);
		Tipinfo tipinfo = null;
		for (int i=0;i<tipinfoList.size(); i++){
			tipinfo = new Tipinfo();
			tipinfo.setId(tipinfoList.get(0).getId());
			tipinfo.setType(tipinfoList.get(0).getType());
			tipinfo.setContent(tipinfoList.get(0).getContent());
			tipinfo.setLinkman(tipinfoList.get(0).getLinkman());
			tipinfo.setName(tipinfoList.get(0).getName());
			tipinfo.setLinkmantel(tipinfoList.get(0).getLinkmantel());
			tipinfo.setAddr(tipinfoList.get(0).getAddr());
		}
		return tipinfo;
	}

}
