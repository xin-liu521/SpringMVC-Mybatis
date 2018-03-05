package com.velvol.hr.dao;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Kaoqinbb;
import com.velvol.hr.domain.Statkaoqin;

public interface IKaoqinbbDao extends IBaseDao<Kaoqinbb> {

	void statkaoqin(Statkaoqin statkaoqin);

}
