package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {
	public List<Function> findFunctionListByUserId(String id);
	public List<Function> findAllMenu();
	public List<Function> findMenuByUserId(String id);
}
