package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Kaoqinwh;
import com.velvol.hr.domain.Statkaoqin;

public interface IKaoqinwhDao extends IBaseDao<Kaoqinwh> {

	void statkaoqin(Statkaoqin statkaoqin);

}
