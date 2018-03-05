package com.velvol.hr.dao;

import java.util.List;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Material;

public interface IMaterialDao  extends IBaseDao<Material>  {

	List<Material> findAllByWorkerid(String preworkerid);	
}
