package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByAptitude;
import com.infoyb.supplier.system.model.ByBank;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Service
public interface ByBankDao extends BaseDao<ByBank> {

    int updateBatchBank(List<ByBank> bybankEditList);

    int insertBatchBank(List<ByBank> bybankAddList);

    /**
     * @desc 摸索搜索银行类别
     * @param bankTypeName
     * @return
     */
    List<Map<String, Object>> selectByBankTypeName(String bankTypeName);

    /**
     * @desc 查询开户银行
     * @param bankCode
     * @return
     */
    List<Map<String, Object>> selectCodeName(String bankCode);

    /**
     * @desc 查询银行信息
     * @param params
     * @return
     */
    List<ByBank> selectBankList(Map<String, Object> params);

    /**
     * @desc 删除银行信息
     * @param params
     * @return
     */
    int deleteByBank(Map<String, Object> params);

    List<Map<String, Object>> selectByDepositBankName(Map<String, Object> params);

    /**
     * @查银行主键
     * @param depositBank
     * @return
     */
    String selectOutBank(String depositBank);

    int insertOutBank(Map<String, Object> params);

    int deleteOutBank(Map<String, Object> params);
}