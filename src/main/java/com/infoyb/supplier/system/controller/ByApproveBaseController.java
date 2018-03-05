package com.infoyb.supplier.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.infoyb.supplier.common.model.R;
import com.infoyb.supplier.common.utils.ShiroUtils;
import com.infoyb.supplier.system.model.*;
import com.infoyb.supplier.system.service.ByApproveBaseService;
import com.infoyb.supplier.system.utils.RequestParamMap;
import com.infoyb.supplier.system.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.controller </dt>
 * <dt>ClassName: ByApproveBaseController </dt>
 * <dd>CreateDate: 2017-10-23 17:27 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: 客商认证控制器</dd>
 * </dl>
 *
 * @author lx
 */
@Controller
@RequestMapping(value = "/approveBase")
public class ByApproveBaseController {

    //注入服务层接口
    @Autowired
    ByApproveBaseService byApproveBaseServiceImpl;

    /**
     * @desc 客户认证页面
     * @return
     */
    @RequestMapping(value = "/clientApproveBasePage", method = RequestMethod.GET)
    public ModelAndView clientApproveBasePage() {
        ModelAndView view = new ModelAndView();
        ByUsers loginUser = ShiroUtils.getUser();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByApproveBase(loginUser.getUserId());

        List<Map<String, Object>> wullbList = byApproveBaseServiceImpl.selectClientWullbList();
        view.addObject("wullbList", wullbList);
        if (null != byApproveBase) {
            view.addObject("byApproveBase", byApproveBase);
            view.addObject("byApproveBaseJson", JSON.toJSON(byApproveBase));
            if (byApproveBase.getCompanyType() != null && byApproveBase.getCompanyType() == 0) {//客户类型
                Map<String, Object> params = new HashMap<>();
                params.put("baseId", byApproveBase.getId());
                params.put("companyType", 0);
                params.put("isDelete", 0);
                //查询产品分类信息
                List<ByProduct> byProducts = byApproveBaseServiceImpl.selectProductList(params);
                //查询银行信息
                List<ByBank> byBanks = byApproveBaseServiceImpl.selectBankList(params);
                //查询附件信息
                List<ByDoc> byDocList = byApproveBaseServiceImpl.selectByDocList(params);

                view.addObject("byBanksJson",JSONArray.toJSON(byBanks));
                view.addObject("byDocListJson", JSONArray.toJSON(byDocList));
                view.addObject("byProductsJson", JSONArray.toJSON(byProducts));
                view.addObject("byDocList", byDocList);
                view.addObject("byProducts", byProducts);
                view.addObject("byBanks", byBanks);
            }
        }
        view.setViewName("/page/approve/clientapprove_add");
        return view;
    }

    /**
     * @desc 供应商认证页面
     * @return
     */
    @RequestMapping(value = "/supplierApproveBasePage", method = RequestMethod.GET)
    public ModelAndView supplierApproveBasePage() {
        ModelAndView view = new ModelAndView();
        ByUsers loginUser = ShiroUtils.getUser();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByApproveBase(loginUser.getUserId());
        List<Map<String, Object>> wullbList = byApproveBaseServiceImpl.selectSupplierWullbList();
        view.addObject("wullbList", wullbList);
        if (null != byApproveBase) {
            view.addObject("byApproveBase", byApproveBase);
            view.addObject("byApproveBaseJson", JSON.toJSON(byApproveBase));
            if (byApproveBase.getCompanySupplierType() != null && byApproveBase.getCompanySupplierType() == 1) {//供应商类型
                Map<String, Object> params = new HashMap<>();
                params.put("baseId", byApproveBase.getId());
                params.put("companyType", 1);
                params.put("isDelete", 0);
                //查询产品分类信息
                List<ByProduct> byProducts = byApproveBaseServiceImpl.selectProductList(params);
                //查询银行信息
                List<ByBank> byBanks = byApproveBaseServiceImpl.selectBankList(params);
                //查询附件信息
                List<ByDoc> byDocList = byApproveBaseServiceImpl.selectByDocList(params);
                view.addObject("byDocListJson", JSONArray.toJSON(byDocList));
                view.addObject("byProductsJson", JSONArray.toJSON(byProducts));
                view.addObject("byDocList", byDocList);
                view.addObject("byBanksJson",JSONArray.toJSON(byBanks));
                view.addObject("byProducts", byProducts);
                view.addObject("byBanks", byBanks);
            }
        }
        view.setViewName("/page/approve/supplierapprove_add");
        return view;
    }

    /**
     * @desc 客商待审核页面
     * @return
     */
    @RequestMapping(value = "/clientCheckPendingPage", method = RequestMethod.GET)
    public ModelAndView clientCheckPendingPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/page/approve/clientapprove_pending");
        return view;
    }


    /**
     * @desc 客户审核结果页面
     * @return
     */
    @RequestMapping(value = "/clientApproveResultPage", method = RequestMethod.GET)
    public ModelAndView clientApproveResultPage(Long id) {
        ModelAndView view = new ModelAndView();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByKey(id);
        if (byApproveBase != null) {
            view.addObject("byApproveBase", byApproveBase);
        }
        view.setViewName("/page/approve/clientapprove_result");
        return view;
    }

    /**
     * @desc 供应商审核结果页面
     * @return
     */
    @RequestMapping(value = "/supplierApproveResultPage", method = RequestMethod.GET)
    public ModelAndView supplierApproveResultPage(Long id) {
        ModelAndView view = new ModelAndView();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByKey(id);
        if (byApproveBase != null) {
            view.addObject("byApproveBase", byApproveBase);
        }
        view.setViewName("/page/approve/supplierapprove_result");
        return view;
    }

    /**
     * @desc 保存客户认证信息
     * @param approveBase 基本信息对象
     * @param approveIndustry 行业集合
     * @param approveProduct 产品集合
     * @param approveBank 银行集合
     * @return
     */
    @RequestMapping(value = "/saveClintApproveBase", method = RequestMethod.POST)
    @ResponseBody
    public R saveClintApproveBase (ByApproveBase approveBase,
                                   String approveIndustry,
                                   String approveProduct,
                                   String approveBank,
                                   String bankIdList,
                                   String productIdList,
                                   String uploadDocs,
                                   HttpServletRequest request,
                                   int flag
                              ) {
        List<ByIndustry> approveIndustryList = JSONArray.parseArray(approveIndustry, ByIndustry.class);
        List<ByProduct> approveProductList = JSONArray.parseArray(approveProduct, ByProduct.class);
        List<ByBank> approveBankList = JSONArray.parseArray(approveBank, ByBank.class);
        List<Long> bankIdLists = JSONArray.parseArray(bankIdList, Long.TYPE);
        List<Long> productIdLists = JSONArray.parseArray(productIdList, Long.TYPE);
        List<ByDoc> uploadUrlLists = JSONArray.parseArray(uploadDocs, ByDoc.class);

        Map<String, Object> paramsMap = RequestParamMap.getRequestParamMap(request);

        ByUsers loginUser = ShiroUtils.getUser();
        approveBase.setCreateTime(new Date());
        approveBase.setCreateUserId(loginUser.getUserId());
        if (approveBase.getCompanySupplierType()!= null && approveBase.getCompanySupplierType() == 1) {//供应商
            if (flag == 1) {//提交
                approveBase.setSupplierStatus(1);//待审
            }else if (flag == 0) {//保存
                approveBase.setSupplierStatus(0);//未提交
            }
        }
        if (approveBase.getCompanyType() != null && approveBase.getCompanyType() ==0 ) {//客户
            if (flag == 1) {//提交
                approveBase.setStatus(1);//待审
            }else if (flag == 0) {//保存
                approveBase.setStatus(0);//未提交
            }
        }

        int count = byApproveBaseServiceImpl.saveClintApproveBase(approveBase, approveIndustryList, approveProductList, approveBankList,bankIdLists,productIdLists,uploadUrlLists,paramsMap,flag);
        if (count > 0) {
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }

    /**
     * @desc 摸索搜索产品分类
     * @param productTypeName
     * @return
     */
    @RequestMapping(value = "/selectByProductTypeName", method = RequestMethod.POST)
    @ResponseBody
    public R selectByProductTypeName (String productTypeName, int flag) {
        List<Map<String, Object>> byIndustryList = byApproveBaseServiceImpl.selectByProductTypeName(productTypeName, flag);
        if (byIndustryList.size() > 0) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("data", byIndustryList);
            return R.ok(maps);
        }else {
            return R.error();
        }
    }

    /**
     * @desc 摸索搜索所属地区
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/selectByAreaName", method = RequestMethod.POST)
    @ResponseBody
    public R selectByAreaName (String areaName) {
        List<Map<String, Object>> byAreaList = byApproveBaseServiceImpl.selectByAreaName(areaName);
        if (byAreaList.size() > 0) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("data", byAreaList);
            return R.ok(maps);
        }else {
            return R.error();
        }
    }

    /**
     * @desc 摸索搜索银行类别
     * @param bankTypeName
     * @return
     */
    @RequestMapping(value = "/selectByBankTypeName", method = RequestMethod.POST)
    @ResponseBody
    public R selectByBankTypeName (String bankTypeName) {
        List<Map<String, Object>> bankTypeList = byApproveBaseServiceImpl.selectByBankTypeName(bankTypeName);
        if (bankTypeList.size() > 0) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("data", bankTypeList);
            return R.ok(maps);
        }else {
            return R.error();
        }
    }

    /**
     * @desc 查询开户银行
     * @param bankCode
     * @return
     */
    @RequestMapping(value = "/selectCodeName", method = RequestMethod.POST)
    @ResponseBody
    public R selectCodeName (String bankCode) {
        List<Map<String, Object>> codeNameList = byApproveBaseServiceImpl.selectCodeName(bankCode);
        if (codeNameList.size() > 0) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("data", codeNameList);
            return R.ok(maps);
        }else {
            return R.error();
        }
    }

    /**
     * @desc 模糊查询开户银行
     * @param bankName
     * @return
     */
    @RequestMapping(value = "/selectByDepositBankName", method = RequestMethod.POST)
    @ResponseBody
    public R selectByDepositBankName (String bankName, String bankType) {
        Map<String, Object> params = new HashMap<>();
        params.put("bankName", bankName);
        params.put("bankType", bankType);
        List<Map<String, Object>> codeNameList = byApproveBaseServiceImpl.selectByDepositBankName(params);
        if (codeNameList.size() > 0) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("data", codeNameList);
            return R.ok(maps);
        }else {
            return R.error();
        }
    }

    /**
     * @desc 前台传入时间格式字符串转为时间格式 数据格式绑定
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    /**
     * 供应商查看信息页面
     * @return
     */
    @RequestMapping(value = "/supplierDetail", method = RequestMethod.GET)
    public ModelAndView supplierDetail(Long id) {
        ModelAndView view = new ModelAndView();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByKey(id);
        Map<String, Object> params = new HashMap<>();
        params.put("baseId", id);
        params.put("companyType", 1);
        params.put("isDelete", 0);
        //查询产品分类信息
        List<ByProduct> byProducts = byApproveBaseServiceImpl.selectProductList(params);
        //查询银行信息
        List<ByBank> byBanks = byApproveBaseServiceImpl.selectBankList(params);
        //查询附件信息
        List<ByDoc> byDocList = byApproveBaseServiceImpl.selectByDocList(params);
        view.addObject("byDocList", byDocList);
        view.addObject("byBanksJson",JSONArray.toJSON(byBanks));
        view.addObject("byProducts", byProducts);
        view.addObject("byBanks", byBanks);
        view.addObject("byApproveBase", byApproveBase);
        view.setViewName("/page/approve/supplier_detail");
        return view;
    }

    /**
     * 客户查看信息页面
     * @return
     */
    @RequestMapping(value = "/clientDetail", method = RequestMethod.GET)
    public ModelAndView clientDetail(Long id) {
        ModelAndView view = new ModelAndView();
        ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByKey(id);
        Map<String, Object> params = new HashMap<>();
        params.put("baseId", id);
        params.put("companyType", 0);
        params.put("isDelete", 0);
        //查询产品分类信息
        List<ByProduct> byProducts = byApproveBaseServiceImpl.selectProductList(params);
        //查询银行信息
        List<ByBank> byBanks = byApproveBaseServiceImpl.selectBankList(params);
        //查询附件信息
        List<ByDoc> byDocList = byApproveBaseServiceImpl.selectByDocList(params);
        view.addObject("byBanksJson",JSONArray.toJSON(byBanks));
        view.addObject("byDocList", byDocList);
        view.addObject("byProducts", byProducts);
        view.addObject("byBanks", byBanks);
        view.addObject("byApproveBase", byApproveBase);
        view.setViewName("/page/approve/client_detail");
        return view;
    }

    /**
     * @desc 查询经济类型树
     * @return
     */
    @RequestMapping(value = "/queryEconomicsTypeTree", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject queryEconomicsTypeTree () {
        JSONArray treeArray = new JSONArray();
        Map<String, Object> params = new HashMap<>();
        params.put("economy", "economy");
        List<Map<String, Object>> economicsTypes = byApproveBaseServiceImpl.queryEconomicsTypeTree(params);
        if(economicsTypes != null && economicsTypes.size()>0){
            //Object pId = economicsTypes.get(0).get("ccylTissueParentId");
            for (Map map : economicsTypes){
                JSONObject obj = new JSONObject();
                obj.put("pId",map.get("pid"));
                obj.put("id",map.get("codeValue"));
                obj.put("name",map.get("codeName"));
                obj.put("codeId",map.get("codeId"));
                obj.put("open",false);
                treeArray.add(obj);
            }

        }
        ResultObject resultObject = new ResultObject();
        resultObject.setData(treeArray);

        return resultObject;
    }

    /**
     * @desc 校验字段唯一性
     * @param byApproveBase
     * @return
     */
    @RequestMapping(value = "/queryCheckoutNameUnique", method = RequestMethod.POST)
    @ResponseBody
    public R queryCheckoutNameUnique(ByApproveBase byApproveBase){
        int count = byApproveBaseServiceImpl.queryCheckoutNameUnique(byApproveBase);
        if (count > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
