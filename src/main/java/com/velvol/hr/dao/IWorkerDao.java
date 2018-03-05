package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.Worker;

public interface IWorkerDao  extends IBaseDao<Worker>  {

	boolean isInsert(Long stationid);

	List findListByStation(Station station);

	/**
	 * @desc 查询区域的在职人数
	 * @param regionid
	 * @return
     */
	List selectRegionWorkerCount(Region region);

}
