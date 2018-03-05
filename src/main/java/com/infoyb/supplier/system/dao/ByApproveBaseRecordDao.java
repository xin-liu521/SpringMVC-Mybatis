package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByApproveBaseRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
@Service
public interface ByApproveBaseRecordDao extends BaseDao<ByApproveBaseRecord> {

    Integer selectApproveRecord(ByApproveBaseRecord byApproveBaseRecord);
}