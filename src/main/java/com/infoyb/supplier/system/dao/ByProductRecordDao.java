package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByDocRecord;
import com.infoyb.supplier.system.model.ByProduct;
import com.infoyb.supplier.system.model.ByProductRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Service
public interface ByProductRecordDao extends BaseDao<ByProductRecord> {
    /**
     * 新增产品记录
     * @param productJsonList
     * @return
     */
    int insertByProductRecordList(List<ByProductRecord> productJsonList);

    /**
     * @desc 查询版本
     * @param byProduct
     * @return
     */
    Integer selectVersionNumber(ByProduct byProduct);

    int deleteByProductRecord(Map<String, Object> params);
}