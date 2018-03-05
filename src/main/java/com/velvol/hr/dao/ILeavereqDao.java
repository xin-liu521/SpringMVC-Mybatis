package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Leavereq;

public interface ILeavereqDao  extends IBaseDao<Leavereq> {

	List<Leavereq> findListByWorkerId(String preworkerid);

	List<Leavereq> findListByStationId(Long stationid, int state);

	List<Leavereq> findListByRegionId(Long regionid, int state);

	List<Leavereq> findListByStationId(Long stationid);

}
