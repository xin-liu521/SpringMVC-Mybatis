package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByDoc;
import com.infoyb.supplier.system.model.ByDocRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Service
public interface ByDocRecordDao extends BaseDao<ByDocRecord> {

    /**
     * @desc 新增附件记录
     * @param docJsonList
     * @return
     */
    int insertByDocRecordList(List<ByDocRecord> docJsonList);

    /**
     * @desc 查询版本
     * @param byDoc
     * @return
     */
    Integer selectDocVersionNumber(ByDoc byDoc);
}