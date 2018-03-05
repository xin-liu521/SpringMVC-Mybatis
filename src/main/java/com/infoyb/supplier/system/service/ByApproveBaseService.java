package com.infoyb.supplier.system.service;

import com.infoyb.supplier.common.service.BaseService;
import com.infoyb.supplier.system.model.*;

import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.service </dt>
 * <dt>ClassName: ByApproveBaseService </dt>
 * <dd>CreateDate: 2017-10-23 17:28 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: 客商认证服务接口 </dd>
 * </dl>
 *
 * @author lx
 */
public interface ByApproveBaseService extends BaseService<ByApproveBase> {

    /**
     * @desc 保存客户认证信息
     * @param approveBase
     * @param approveIndustryList
     * @param approveProductList
     * @param approveBankList
     * @return
     */
    int saveClintApproveBase(ByApproveBase approveBase,
                             List<ByIndustry> approveIndustryList,
                             List<ByProduct> approveProductList,
                             List<ByBank> approveBankList,
                             List<Long> bankIdLists,
                             List<Long> productIdLists,
                             List<ByDoc> uploadUrlLists,
                             Map<String,Object> paramsMap,
                             int flag
    );

    /**
     * @desc 保存供应商认证信息
     * @param approveBase
     * @param approveProductList
     * @param approveBankList
     * @return
     */
//    int saveSupplierApproveBase(ByApproveBase approveBase, List<ByProduct> approveProductList, List<ByBank> approveBankList);

    /**
     * @desc 摸索搜索产品分类
     * @param productTypeName
     * @return
     */
    List<Map<String, Object>> selectByProductTypeName(String productTypeName, int flag);

    /**
     * @desc 摸索搜索所属地区
     * @param areaName
     * @return
     */
    List<Map<String, Object>> selectByAreaName(String areaName);
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
     * @desc 查询行业信息
     * @param params
     * @return
     */
    List<ByIndustry> selectIndustryList(Map<String, Object> params);

    /**
     * @desc 查询产品信息
     * @param params
     * @return
     */
    List<ByProduct> selectProductList(Map<String, Object> params);

    /**
     * @desc 查询银行信息
     * @param params
     * @return
     */
    List<ByBank> selectBankList(Map<String, Object> params);

    /**
     * @desc 查询基本信息
     * @param id
     * @return
     */
    ByApproveBase selectByApproveBase(Long id);

    /**
     * @desc 查询附件信息
     * @param params
     * @return
     */
    List<ByDoc> selectByDocList(Map<String, Object> params);

    List<Map<String, Object>> selectByDepositBankName(Map<String, Object> params);

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
