package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.CodeOutunit;
import tk.mybatis.mapper.common.Mapper;

public interface CodeOutunitDao extends BaseDao<CodeOutunit> {

    int updateCodeOutunit(CodeOutunit codeOutunit);

    String  selectOutUnitById(Long byApproveId);
}