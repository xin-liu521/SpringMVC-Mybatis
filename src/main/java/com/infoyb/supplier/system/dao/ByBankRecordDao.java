package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByBank;
import com.infoyb.supplier.system.model.ByBankRecord;
import com.infoyb.supplier.system.model.ByProductRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Service
public interface ByBankRecordDao extends BaseDao<ByBankRecord> {
    /**
     * 新增银行记录
     * @param bankJsonList
     * @return
     */
    int insertByBankRecordList(List<ByBankRecord> bankJsonList);

    /**
     * @desc 查询版本
     * @param byBank
     * @return
     */
    Integer selectBankVersionNumber(ByBank byBank);

    int deleteByBankRecord(Map<String, Object> params);
}