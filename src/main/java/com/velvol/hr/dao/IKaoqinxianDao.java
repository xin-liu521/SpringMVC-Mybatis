package com.velvol.hr.dao;


import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Kaoqinxian;
import com.velvol.hr.domain.Statkaoqin;


public interface IKaoqinxianDao extends IBaseDao<Kaoqinxian> {

	void statkaoqin(Statkaoqin statkaoqin);

}
