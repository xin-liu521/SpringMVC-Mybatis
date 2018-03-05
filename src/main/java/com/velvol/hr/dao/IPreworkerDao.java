package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Preworker;

public interface IPreworkerDao  extends IBaseDao<Preworker>  {

	Preworker findByPhone(String telephone);

	Preworker findByPhone(Preworker model);

}
