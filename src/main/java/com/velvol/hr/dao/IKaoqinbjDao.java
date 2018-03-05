package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Kaoqinbj;
import com.velvol.hr.domain.Statkaoqin;

public interface IKaoqinbjDao extends IBaseDao<Kaoqinbj> {

	void statkaoqin(Statkaoqin statkaoqin);

}
