package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.common.model.BaseModel;
import com.infoyb.supplier.system.model.ByDoc;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Service
public interface ByDocDao extends BaseDao<ByDoc> {

    /**
     * @desc 新增附件
     * @param byDocList
     * @return
     */
    int insertBatchByDoc(List<ByDoc> byDocList);

    /**
     * @desc 查询附件信息
     * @param params
     * @return
     */
    List<ByDoc> selectByDocList(Map<String, Object> params);

    /**
     * @desc 删除附件
     * @param params
     * @return
     */
    int deleteByDic(Map<String, Object> params);

    int deleteByDocRecord(Map<String, Object> params);

    int deleteOutDoc(Map<String, Object> params);


    int insertOutUnitDoc(Map<String, Object> params);
    }