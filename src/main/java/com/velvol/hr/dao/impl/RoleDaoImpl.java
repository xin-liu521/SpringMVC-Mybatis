package com.velvol.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.dao.IRoleDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {

}
