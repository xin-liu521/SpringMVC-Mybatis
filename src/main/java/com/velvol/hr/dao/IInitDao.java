package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Initinfo;

public interface IInitDao extends IBaseDao<Initinfo> {

	Initinfo findByWorkerid(String workerid);

}
