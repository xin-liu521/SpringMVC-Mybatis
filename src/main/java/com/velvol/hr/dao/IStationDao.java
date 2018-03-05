package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Station;

public interface IStationDao extends IBaseDao<Station>  {

	List<Station> findAllByRegionid(Long regionid);

}
