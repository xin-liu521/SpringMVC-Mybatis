package com.velvol.hr.service;

import java.util.List;

import com.velvol.hr.domain.*;
import com.velvol.hr.utils.PageBean;


public interface IPreworkerService {

	//保存
	void save(Preworker model, Long regionid);
	//扫码添加
	Tipinfo scansave(Preworker model, Long regionid, Long stationid);
	//修改
	void update(Preworker preworker);
	//批量删除
	void deleteBatch(String ids);
    //分页查询
	void pageQuery(PageBean pageBean,int state);

	List movePageQuery(PageBean pageBean,int state);

	List<Preworker> movePageQueryCount();
	//查询在职人员数
	List selectWorkerCount();
	//查询出勤数
	List selectCqWorkerCount();

	List selectLeaverWorkerCount();

	//根据id查询
	Preworker findById(String id);
	List<Region> findRegionList();
	void delete(String id);
	void auditok(String id,int state);
	void auditno(String id, String faildesc);
	void pageQueryM(PageBean pageBean, int getstate);
	List<Station> findStations();
	List<Station> moveFindStations(Long regionid);
	void assignStation(String id, Long stationid);
	List<Materialinit> findMListById(String id);
	void putMaterial(Materialmodel materialmodel);
	void updatejkz(Materialmodel model, String newFilename);
	void quantui(String id, String faildesc);
	void hege(String id);
	void testSubmit(Preworker model);
	
	List<Region> userRegion();
	void updatelzd(Leavereq model, String newFilename);
	boolean isHasPhone(String telephone);
	void zsave(Preworker model, Long regionid);
	boolean isHasPhone(Preworker model);
	boolean isBackMatZ(String preworkerid);
	boolean isBackMatR(String preworkerid);
	boolean matcheck(String id);
	boolean matcheckwmx(String id);

	Preworker findByTelephone(String telephone);
}
