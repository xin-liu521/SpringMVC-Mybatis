package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Tipinfo;

public interface IRegionDao extends IBaseDao<Region> {

	Tipinfo getTipinfo(String name);

	Tipinfo getTipinfoByRegion(Long regionid);

}
