package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.ByApproveBase;
import com.infoyb.supplier.system.model.UserSupplier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Service
public interface ByApproveBaseDao extends BaseDao<ByApproveBase> {


    /**
     * @desc 摸索搜索所属地区
     * @param areaName
     * @return
     */
    List<Map<String, Object>> selectByAreaName(String areaName);

    /**
     * @desc 查询基本信息
     * @param id
     * @return
     */
    ByApproveBase selectByApproveBase(Long id);

    /**
     * @desc 查询经济类型树
     * @return
     */
    List<Map<String, Object>> queryEconomicsTypeTree(Map<String, Object> params);

    /**
     * @desc 查询客户的产品分类
     * @return
     */
    List<Map<String, Object>> selectClientWullbList();

    /**
     * @desc 查询供应商的产品分类
     * @return
     */
    List<Map<String, Object>> selectSupplierWullbList();

    /**
     * @desc 校验字段唯一性
     * @param byApproveBase
     * @return
     */
    int queryCheckoutNameUnique(ByApproveBase byApproveBase);

}