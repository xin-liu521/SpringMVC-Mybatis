package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByIndustry;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Service
public interface ByIndustryDao extends BaseDao<ByIndustry> {

    int insertBatchIndustry(List<ByIndustry> byIndustryEditList);

    int updateBatchIndustry(List<ByIndustry> byIndustryEditList);

    /**
     * @desc 摸索搜索产品分类
     * @param productTypeName
     * @return
     */
    List<Map<String, Object>> selectByProductTypeName(String productTypeName);

    List<Map<String, Object>> selectByProductTypeNameSupplier(String productTypeName);

    /**
     * @desc 查询行业信息
     * @param params
     * @return
     */
    List<ByIndustry> selectIndustryList(Map<String, Object> params);

}