package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByIndustry;
import com.infoyb.supplier.system.model.ByProduct;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Service
public interface ByProductDao extends BaseDao<ByProduct> {

    int insertBatchProduct(List<ByProduct> byByProductAddList);

    int updateBatchProduct(List<ByProduct> byByProductEditList);

    /**
     * @desc 查询产品信息
     * @param params
     * @return
     */
    List<ByProduct> selectProductList(Map<String, Object> params);

    /**
     * @desc 删除产品信息
     * @param params
     * @return
     */
    int deleteByProduct(Map<String, Object> params);

    /**
     * @desc 删除外部单位产品分类关联信息
     * @param params
     * @return
     */
    int deleteOutProduct(Map<String, Object> params);

    /**
     * @desc 查询分类科室关联信息
     * @param params
     * @return
     */
    Map<String, Object> selectByProductOut(Map<String, Object> params);

    /**
     * @desc 新增外部单位产品分类关联信息
     * @param params
     * @return
     */
    int insertOutProduct(Map<String, Object> params);
}