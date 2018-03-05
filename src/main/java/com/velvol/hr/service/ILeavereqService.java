package com.velvol.hr.service;

import java.util.List;

import com.velvol.hr.domain.Leavereq;
import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.utils.PageBean;

public interface ILeavereqService {

	void save(Leavereq model);

	List<Leavereq> findListByWorkerId(String string);

	void edit(Leavereq model);

	void delete(Long id);

	void doSubmit(Long id);

	void zsave(Leavereq model,String workerid);

	List<Leavereq> findListByStationId(Long stationid,int state);

	void zedit(Leavereq model);

	void doRedo(Long id);

	void zShipi(Long id);

	void rShipi(Long id);

	List<Leavereq> findListByRegionId(Long regionid, int state);
	
	void pageQuery(PageBean pageBean,Long regionid,int state);

	Leavereq getById(Long id);

	void backMaterial(Materialinit materialinit);

	void backFee(Materialinit materialinit);

	List<Leavereq> findListByStationId(Long stationid);

	void wmxkoukuan(Materialinit materialinit);

	void htmatback(Materialinit materialinit);

	void rkoufei(Long id);

}
