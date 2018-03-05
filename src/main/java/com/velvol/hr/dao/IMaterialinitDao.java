package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Materialinit;

public interface IMaterialinitDao   extends IBaseDao<Materialinit>  {

	List<Materialinit> findAllByWorkerid(String preworkerid);

	void deleteByPreworkerid(String id);

	Materialinit findByType(String preworkerid, int i);

	boolean isBackMatZ(String preworkerid);

	boolean isBackMatR(String preworkerid);

	boolean matcheck(String id);

	boolean matcheckwmx(String id);	
}