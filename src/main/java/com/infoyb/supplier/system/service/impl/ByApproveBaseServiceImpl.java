package com.infoyb.supplier.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.infoyb.supplier.base.OutUnitService;
import com.infoyb.supplier.base.OutUnitSubmit;
import com.infoyb.supplier.base.SubmitOutUnitService;
import com.infoyb.supplier.common.service.impl.BaseServiceImpl;
import com.infoyb.supplier.common.utils.date.DateUtil;
import com.infoyb.supplier.system.dao.*;
import com.infoyb.supplier.system.model.*;
import com.infoyb.supplier.system.service.ByApproveBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.*;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.service.impl </dt>
 * <dt>ClassName: ByApproveBaseServiceImpl </dt>
 * <dd>CreateDate: 2017-10-23 17:28 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: 客商认证实现类</dd>
 * </dl>
 *
 * @author lx
 */
@Service
public class ByApproveBaseServiceImpl extends BaseServiceImpl<ByApproveBase> implements ByApproveBaseService {

    //注入基本信息持久层接口
    @Autowired
    ByApproveBaseDao byApproveBaseDao;

    //注入产品持久层接口
    @Autowired
    ByIndustryDao byIndustryDao;

    //注入产品持久层接口
    @Autowired
    ByProductDao byProductDao;

    //银行持久层接口
    @Autowired
    ByBankDao byBankDao;

    //附件至久层接口
    @Autowired
    ByDocDao byDocDao;

    //记录附件持久层接口
    @Autowired
    ByDocRecordDao byDocRecordDao;

    //记录产品分类持久层接口
    @Autowired
    ByProductRecordDao byProductRecordDao;

    //记录银行持久层接口
    @Autowired
    ByBankRecordDao byBankRecordDao;

    @Autowired
    ByApproveBaseRecordDao byApproveBaseRecordDao;

    @Autowired
    CodeOutunitDao codeOutunitDao;


    private static final QName SERVICE_NAME = new QName("urn:SubmitOutUnitService", "SubmitOutUnitService");

    /**
     * @desc 保存客商认证信息
     * @param approveBase 基本信息对象
     * @param approveProductList 产品对象 集合
     * @param approveBankList 银行对象集合
     * @param bankIdLists 删除银行的id
     * @param productIdLists 产出产品的id
     * @param uploadUrlLists 附件集合
     * @param paramsMap
     * @param flag
     * @return
     */
    @Override
    public int saveClintApproveBase(ByApproveBase approveBase,
                                    List<ByIndustry> approveIndustryList,
                                    List<ByProduct> approveProductList,
                                    List<ByBank> approveBankList,
                                    List<Long> bankIdLists,
                                    List<Long> productIdLists,
                                    List<ByDoc> uploadUrlLists,
                                    Map<String,Object> paramsMap,
                                    int flag) {
        int count = 0;
        int num = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int outCount = 0;

        URL wsdlURL = SubmitOutUnitService.WSDL_LOCATION;

        //主数据外部单对象
        CodeOutunit codeOutunit = new CodeOutunit();

        //附件原信息
        List<ByDoc> docJsonList = JSONArray.parseArray((String) paramsMap.get("docJsonList"), ByDoc.class);
        //产品原信息
        List<ByProduct> productJsonList=JSONArray.parseArray((String) paramsMap.get("productJsonList"),ByProduct.class);
        //银行原始信息
        List<ByBank> bankJsonList=JSONArray.parseArray((String) paramsMap.get("bankJsonList"),ByBank.class);
        //原始基本信息
        String byApproveBaseParams = (String)paramsMap.get("byApproveBase");

        ByApproveBaseRecord byApproveBaseRecord = new ByApproveBaseRecord();
        if (byApproveBaseParams != null&&!"".equals(byApproveBaseParams)) {
            JSONObject byApproveBaseParamsJsonObj = JSON.parseObject(byApproveBaseParams);

            Integer id = byApproveBaseParamsJsonObj.getIntValue("id");
            byApproveBaseRecord.setByApproveBaseId(id.longValue());
            byApproveBaseRecord.setCompanyFullEg((String) byApproveBaseParamsJsonObj.get("companyFullEg"));
            byApproveBaseRecord.setRecordTime(new Date());
            byApproveBaseRecord.setCreateTime(DateUtil.stampToDate(byApproveBaseParamsJsonObj.getLongValue("createTime")));
            byApproveBaseRecord.setAddress(byApproveBaseParamsJsonObj.getString("address"));
            byApproveBaseRecord.setArea(byApproveBaseParamsJsonObj.getString("area"));
            byApproveBaseRecord.setCompanyFullName(byApproveBaseParamsJsonObj.getString("companyFullName"));
            byApproveBaseRecord.setCompanyShortEg(byApproveBaseParamsJsonObj.getString("companyShortEg"));
            byApproveBaseRecord.setCompanyShortName(byApproveBaseParamsJsonObj.getString("companyShortName"));
            byApproveBaseRecord.setCompanySupplierType(byApproveBaseParamsJsonObj.getInteger("companySupplierType"));
            byApproveBaseRecord.setCompanyType(byApproveBaseParamsJsonObj.getInteger("companyType"));
            byApproveBaseRecord.setContact(byApproveBaseParamsJsonObj.getString("contact"));
            byApproveBaseRecord.setContactPhone(byApproveBaseParamsJsonObj.getString("contactPhone"));
            byApproveBaseRecord.setAreaName(byApproveBaseParamsJsonObj.getString("areaName"));
            byApproveBaseRecord.setCreateRegTime(byApproveBaseParamsJsonObj.getDate("createRegTime"));
            byApproveBaseRecord.setCreateUserId(byApproveBaseParamsJsonObj.getInteger("createUserId").longValue());
            byApproveBaseRecord.setEconomicsType(byApproveBaseParamsJsonObj.getInteger("economicsType"));
            byApproveBaseRecord.setEmail(byApproveBaseParamsJsonObj.getString("email"));
            byApproveBaseRecord.setFax(byApproveBaseParamsJsonObj.getString("fax"));
            byApproveBaseRecord.setFund(byApproveBaseParamsJsonObj.getInteger("fund"));
            byApproveBaseRecord.setIsUnity(byApproveBaseParamsJsonObj.getInteger("isUnity"));
            byApproveBaseRecord.setLegalPerson(byApproveBaseParamsJsonObj.getString("legalPerson"));
            byApproveBaseRecord.setLicenseNumber(byApproveBaseParamsJsonObj.getString("licenseNumber"));
            byApproveBaseRecord.setOrganizationCodeNumber(byApproveBaseParamsJsonObj.getString("organizationCodeNumber"));
            byApproveBaseRecord.setPhone(byApproveBaseParamsJsonObj.getString("phone"));
            byApproveBaseRecord.setPostcode(byApproveBaseParamsJsonObj.getInteger("postcode"));
            byApproveBaseRecord.setSocialCreditCode(byApproveBaseParamsJsonObj.getString("socialCreditCode"));
            byApproveBaseRecord.setStatus(byApproveBaseParamsJsonObj.getInteger("status"));
            byApproveBaseRecord.setSupplierStatus(byApproveBaseParamsJsonObj.getInteger("supplierStatus"));
            byApproveBaseRecord.setTaxNumber(byApproveBaseParamsJsonObj.getString("taxNumber"));
            byApproveBaseRecord.setWebAddress(byApproveBaseParamsJsonObj.getString("webAddress"));
            byApproveBaseRecord.setIsChemical(byApproveBaseParamsJsonObj.getInteger("isChemical"));
        }


        codeOutunit.setAddress(approveBase.getAddress());
        codeOutunit.setArea(String.valueOf(approveBase.getArea()));
        codeOutunit.setContacts(approveBase.getContact());
        codeOutunit.setContactsNumber(approveBase.getContactPhone());
        codeOutunit.setEmail(approveBase.getEmail());
        codeOutunit.setEnFullname(approveBase.getCompanyFullEg());
        codeOutunit.setEnShortname(approveBase.getCompanyShortEg());
        codeOutunit.setFax(approveBase.getFax());
        codeOutunit.setFullname(approveBase.getCompanyFullName());
        codeOutunit.setGsdjh(approveBase.getLicenseNumber());
        if (approveBase.getCompanyType() != null && approveBase.getCompanyType() == 0) {
            codeOutunit.setIscustomer("1");
        }else {
            codeOutunit.setIscustomer("0");
        }
        if (approveBase.getCompanySupplierType() != null && approveBase.getCompanySupplierType() == 1) {
            codeOutunit.setIsprovider("1");
        }else {
            codeOutunit.setIsprovider("0");
        }
        codeOutunit.setIsHazardous(String.valueOf(approveBase.getIsChemical()));
        if (approveBase.getPostcode() != null) {
            codeOutunit.setPostcode(approveBase.getPostcode().toString());
        }else {
            codeOutunit.setPostcode("");
        }
        codeOutunit.setShortname(approveBase.getCompanyShortName());
        codeOutunit.setSwdjh(approveBase.getTaxNumber());
        codeOutunit.setTel(approveBase.getPhone());
        codeOutunit.setZzjgm(approveBase.getOrganizationCodeNumber());
        codeOutunit.setRegistercapital(String.valueOf(approveBase.getFund()));
        codeOutunit.setEconomicType(String.valueOf(approveBase.getEconomicsType()));
        codeOutunit.setWebSite(approveBase.getWebAddress());
        codeOutunit.setSzhy(String.valueOf(approveBase.getIsUnity()));
        codeOutunit.setShxydm(approveBase.getSocialCreditCode());
        codeOutunit.setLegalpersion(approveBase.getLegalPerson());
        codeOutunit.setWebSite(approveBase.getWebAddress());
        codeOutunit.setCreatorTime(approveBase.getCreateTime());
        codeOutunit.setState("5");
        codeOutunit.setStatus("1");
        codeOutunit.setVersion("0");
        if (approveBase.getId() == null) {
            //新增基本信息
            count = byApproveBaseDao.insertSelective(approveBase);

            if (flag == 1) {
                //新增主数据外部单位
                codeOutunit.setByApproveId(approveBase.getId());
                outCount = codeOutunitDao.insertSelective(codeOutunit);

                if (outCount > 0) {

                    //调用主数据提交接口
                    //this.submitOutUnitPort(codeOutunit,approveBase);
                    SubmitOutUnitService ss = new SubmitOutUnitService(wsdlURL, SERVICE_NAME);
                    OutUnitService port = ss.getOutUnitServiceImplPort();

                    {
                        com.infoyb.supplier.base.OutUnitSubmit _outUnitSubmit_parameters = null;
                        List<String> ids = new ArrayList<>();
                        ids.add(codeOutunit.getId());
                        _outUnitSubmit_parameters = new OutUnitSubmit();
                        _outUnitSubmit_parameters.setSubmitOutUnit(ids);
                        _outUnitSubmit_parameters.setArg1("10000001");
                        _outUnitSubmit_parameters.setArg2(codeOutunit.getFullname());
                        port.outUnitSubmit(_outUnitSubmit_parameters);


                    }
                }
            }

        }else {
            //修改基本信息
            count = byApproveBaseDao.updateByPrimaryKeySelective(approveBase);
            if (flag == 1) {
                //查询记录版本
                Integer versionNumber = byApproveBaseRecordDao.selectApproveRecord(byApproveBaseRecord);
                if(versionNumber != null && versionNumber>0) {
                    byApproveBaseRecord.setRecordVersion(versionNumber+1);
                }else {
                    byApproveBaseRecord.setRecordVersion(1);
                }
                //记录原始基本信息
                byApproveBaseRecordDao.insertSelective(byApproveBaseRecord);


                codeOutunit.setByApproveId(approveBase.getId());

                //根据客商id查询主数据外部单位id
                String outUnitId = codeOutunitDao.selectOutUnitById(codeOutunit.getByApproveId());
                if (outUnitId != null && !outUnitId.equals("")) {
                    //修改主数据外部单位
                    outCount = codeOutunitDao.updateCodeOutunit(codeOutunit);
                    if (outCount > 0) {
                        //调用主数据提交接口
                        SubmitOutUnitService ss = new SubmitOutUnitService(wsdlURL, SERVICE_NAME);
                        OutUnitService port = ss.getOutUnitServiceImplPort();

                        {
                            com.infoyb.supplier.base.OutUnitSubmit _outUnitSubmit_parameters = null;
                            List<String> ids = new ArrayList<>();
                            ids.add(outUnitId);
                            _outUnitSubmit_parameters = new OutUnitSubmit();
                            _outUnitSubmit_parameters.setSubmitOutUnit(ids);
                            _outUnitSubmit_parameters.setArg1("10000001");
                            _outUnitSubmit_parameters.setArg2(codeOutunit.getFullname());
                            port.outUnitSubmit(_outUnitSubmit_parameters);


                        }
                    }
                }else {
                    codeOutunit.setByApproveId(approveBase.getId());
                    //新增主数据外部单位
                    outCount = codeOutunitDao.insertSelective(codeOutunit);

                    if (outCount > 0) {
                        //调用主数据提交接口
                        SubmitOutUnitService ss = new SubmitOutUnitService(wsdlURL, SERVICE_NAME);
                        OutUnitService port = ss.getOutUnitServiceImplPort();

                        {
                            com.infoyb.supplier.base.OutUnitSubmit _outUnitSubmit_parameters = null;
                            List<String> ids = new ArrayList<>();
                            ids.add(codeOutunit.getId());
                            _outUnitSubmit_parameters = new OutUnitSubmit();
                            _outUnitSubmit_parameters.setSubmitOutUnit(ids);
                            _outUnitSubmit_parameters.setArg1(approveBase.getCreateUserId().toString());
                            _outUnitSubmit_parameters.setArg2(codeOutunit.getFullname());
                            port.outUnitSubmit(_outUnitSubmit_parameters);


                        }
                    }
                }

            }
        }
        //删除银行信息
        if (bankIdLists != null && bankIdLists.size() > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("idsList", bankIdLists);
            num = byBankDao.deleteByBank(params);
        }else {
            num = 1;
        }
        //删除产品分类信息
        if (productIdLists != null && productIdLists.size() > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("idsList", productIdLists);
            num1 = byProductDao.deleteByProduct(params);
        }else {
            num1 = 1;
        }

        //新增修改产品信息
        if (approveProductList.size() != 0 && approveProductList != null) {
            List<ByProduct> byByProductAddList = new ArrayList<>();
            List<ByProduct> byByProductEditList = new ArrayList<>();
            ByProduct byProduct = null;
            for (int i = 0;i < approveProductList.size(); i++) {
                byProduct = new ByProduct();
                ByProduct byProduct1 = approveProductList.get(i);
                if (null == byProduct1.getId()) {
                    byProduct.setBaseId(approveBase.getId());
                    byProduct.setProductType(byProduct1.getProductType());
                    byProduct.setProductTypeName(byProduct1.getProductTypeName());
                    byProduct.setCreateUserId(approveBase.getCreateUserId());
                    byProduct.setCreateTime(approveBase.getCreateTime());
                    if (approveBase.getCompanyType()!=null&&approveBase.getCompanyType() == 0) {
                        byProduct.setCompanyType(approveBase.getCompanyType());
                    }
                    if (approveBase.getCompanySupplierType()!=null&&approveBase.getCompanySupplierType() == 1) {
                        byProduct.setCompanyType(approveBase.getCompanySupplierType());
                    }
                    byByProductAddList.add(byProduct);
                }else {
                    byProduct.setId(byProduct1.getId());
                    byProduct.setProductType(byProduct1.getProductType());
                    byProduct.setProductTypeName(byProduct1.getProductTypeName());
                    byByProductEditList.add(byProduct);
                }
            }
            if (byByProductAddList.size() > 0) {
                num2 = byProductDao.insertBatchProduct(byByProductAddList);
            }else{
                num2 =1;
            }
            if (byByProductEditList.size() > 0) {
               num3 = byProductDao.updateBatchProduct(byByProductEditList);
                if (num3 == -1) {
                    num3=1;
                }
            }else{
                num3=1;
            }

            if (flag == 1) {//状态提交
                if (byApproveBaseRecord.getCompanyType()  != null || byApproveBaseRecord.getCompanySupplierType()!= null) {
                    //判断是否是审核通过和失败的数据
                    if ((byApproveBaseRecord.getCompanyType() == 0 && (byApproveBaseRecord.getStatus() == 2||byApproveBaseRecord.getStatus() == 3))
                            || (byApproveBaseRecord.getCompanySupplierType() == 1 &&
                            (byApproveBaseRecord.getSupplierStatus() == 2||byApproveBaseRecord.getSupplierStatus() == 3))) {

                        Map<String, Object> params = null;
                        for (int i = 0; i < productJsonList.size(); i++) {
                            params = new HashMap<>();
                            ByProduct byProduct2 = productJsonList.get(i);
                            //String wllbId = byProductDao.selectOutProduct(byProduct2.getProductType());
                            params.put("wllbId", byProduct2.getProductType());
                            if (approveBase.getCompanyType() != null && approveBase.getCompanyType() == 0) {
                                params.put("status", 0);//客户
                            }
                            if (approveBase.getCompanySupplierType() != null && approveBase.getCompanySupplierType() == 1) {
                                params.put("status", 1);//供应商
                            }
                            byProductDao.deleteOutProduct(params);
                        }

                        //新增产品记录信息
                        this.insertProductRecord(productJsonList);
                    }
                }

                //新增主数据外部单位产品分类关联信息
                Map<String, Object> paramsPro = null;
                for (int i = 0; i < approveProductList.size(); i++) {
                    paramsPro = new HashMap<>();
                    ByProduct byProduct3 = approveProductList.get(i);
                    paramsPro.put("wllbId", byProduct3.getProductType());
                    Map<String, Object> productOffice = byProductDao.selectByProductOut(paramsPro);
                    if (productOffice != null) {
                        paramsPro.put("nbdwName", productOffice.get("nbdwName"));
                        paramsPro.put("nbdwId", productOffice.get("nbdwId"));
                        //paramsPro.put("approUserId", productOffice.get("approUserId"));
                    }
                    if (codeOutunit.getId() == null) {
                        codeOutunit.setByApproveId(approveBase.getId());
                        //根据客商id查询主数据外部单位id
                        String outUnitId = codeOutunitDao.selectOutUnitById(codeOutunit.getByApproveId());
                        paramsPro.put("unitId", outUnitId);
                    }else {
                        paramsPro.put("unitId", codeOutunit.getId());
                    }
                    if (approveBase.getCompanyType() != null && approveBase.getCompanyType() == 0) {
                        paramsPro.put("status", 0);//客户
                    }
                    if (approveBase.getCompanySupplierType() != null && approveBase.getCompanySupplierType() == 1) {
                        paramsPro.put("status", 1);//供应商
                    }
//                    String bankId = byBankDao.selectOutBank(byBank2.getAssociatedNumber());
//                    params.put("bankId", bankId);
                    byProductDao.insertOutProduct(paramsPro);
                }
            }

        }

        //新增修改银行信息
        if (approveBankList.size() > 0 && approveBankList != null) {
            ByBank byBank = null;
            List<ByBank> bybankAddList = new ArrayList<>();
            List<ByBank> bybankEditList = new ArrayList<>();
            for (int i = 0; i < approveBankList.size(); i++) {
                byBank = new ByBank();
                ByBank byBank1 = approveBankList.get(i);
                if (null == byBank1.getId()) {
                    byBank.setBankAccount(byBank1.getBankAccount());
                    byBank.setAssociatedNumber(byBank1.getAssociatedNumber());
                    byBank.setBankAccountName(byBank1.getBankAccountName());
                    byBank.setBankCountry(byBank1.getBankCountry());
                    byBank.setBankType(byBank1.getBankType());
                    byBank.setBankTypeName(byBank1.getBankTypeName());
                    byBank.setCurrencyType(byBank1.getCurrencyType());
                    byBank.setDepositBank(byBank1.getDepositBank());
                    byBank.setDepositBankName(byBank1.getDepositBankName());
                    byBank.setOtherBank(byBank1.getOtherBank());
                    byBank.setBaseId(approveBase.getId());
                    byBank.setCreateTime(approveBase.getCreateTime());
                    byBank.setCreateUserId(approveBase.getCreateUserId());
                    if (approveBase.getCompanyType() != null && approveBase.getCompanyType() == 0) {
                        byBank.setCompanyType(approveBase.getCompanyType());
                    }
                    if (approveBase.getCompanySupplierType() != null && approveBase.getCompanySupplierType() == 1) {
                        byBank.setCompanyType(approveBase.getCompanySupplierType());
                    }
                    byBank.setIsElectronAccount(byBank1.getIsElectronAccount());
                    byBank.setAccountProperties(byBank1.getAccountProperties());
                    byBank.setIsBaseAccount(byBank1.getIsBaseAccount());
                    bybankAddList.add(byBank);
                } else {
                    byBank.setBankAccount(byBank1.getBankAccount());
                    byBank.setAssociatedNumber(byBank1.getAssociatedNumber());
                    byBank.setBankAccountName(byBank1.getBankAccountName());
                    byBank.setBankCountry(byBank1.getBankCountry());
                    byBank.setBankType(byBank1.getBankType());
                    byBank.setBankTypeName(byBank1.getBankTypeName());
                    byBank.setCurrencyType(byBank1.getCurrencyType());
                    byBank.setDepositBank(byBank1.getDepositBank());
                    byBank.setDepositBankName(byBank1.getDepositBankName());
                    byBank.setOtherBank(byBank1.getOtherBank());
                    byBank.setId(byBank1.getId());
                    byBank.setIsElectronAccount(byBank1.getIsElectronAccount());
                    byBank.setAccountProperties(byBank1.getAccountProperties());
                    bybankEditList.add(byBank);
                }
            }

            if (bybankAddList.size() > 0) {
                num4 = byBankDao.insertBatchBank(bybankAddList);

            } else {
                num4 = 1;
            }
            if (bybankEditList.size() > 0) {
                num5 = byBankDao.updateBatchBank(bybankEditList);
                if (num5 == -1) {
                    num5 = 1;
                }
            } else {
                num5 = 1;
            }

            if (flag == 1) {
                if (byApproveBaseRecord.getCompanyType()  != null || byApproveBaseRecord.getCompanySupplierType()!= null) {
                    //判断是否是审核通过和失败的数据
                    if ((byApproveBaseRecord.getCompanyType() == 0 && (byApproveBaseRecord.getStatus() == 2||byApproveBaseRecord.getStatus() == 3))
                            || (byApproveBaseRecord.getCompanySupplierType() == 1 &&
                            (byApproveBaseRecord.getSupplierStatus() == 2||byApproveBaseRecord.getSupplierStatus() == 3))) {

                        Map<String, Object> params = null;
                        for (int i = 0; i < bankJsonList.size(); i++) {
                            params = new HashMap<>();
                            ByBank byBank3 = bankJsonList.get(i);
                            String bankId = byBankDao.selectOutBank(byBank3.getAssociatedNumber());
                            params.put("bankId", bankId);
                            byBankDao.deleteOutBank(params);
                        }

                        //新增银行记录信息
                        this.insertBankRecord(bankJsonList);
                    }
                }

                //新增主数据银行信息
                Map<String, Object> params = null;
                for (int i = 0; i < approveBankList.size(); i++) {
                    params = new HashMap<>();
                    ByBank byBank2 = approveBankList.get(i);
                    params.put("bankAccount", byBank2.getBankAccount());
                    params.put("bankAccountName", byBank2.getBankAccountName());
                    if (codeOutunit.getId() == null) {
                        codeOutunit.setByApproveId(approveBase.getId());
                        //根据客商id查询主数据外部单位id
                        String outUnitId = codeOutunitDao.selectOutUnitById(codeOutunit.getByApproveId());
                        params.put("unitId", outUnitId);
                    }else {
                        params.put("unitId", codeOutunit.getId());
                    }
                    if (approveBase.getCompanyType() != null && approveBase.getCompanyType() == 0) {
                        params.put("status", 0);//客户
                    }
                    if (approveBase.getCompanySupplierType() != null && approveBase.getCompanySupplierType() == 1) {
                        params.put("status", 1);//供应商
                    }
                    String bankId = byBankDao.selectOutBank(byBank2.getAssociatedNumber());
                    params.put("bankId", bankId);
                    params.put("accountProperties", byBank2.getAccountProperties());
                    params.put("isBaseAccount", byBank2.getIsBaseAccount());
                    byBankDao.insertOutBank(params);
                }
            }

        }
        //删除附件  修改删除状态
        Map<String, Object> params = new HashMap<>();
        params.put("baseId", approveBase.getId());
        params.put("isDelete", 1);
        if (approveBase.getCompanyType()!=null&&approveBase.getCompanyType() == 0) {
            params.put("companyType", approveBase.getCompanyType());
        }
        if (approveBase.getCompanySupplierType()!=null&&approveBase.getCompanySupplierType() == 1) {
            params.put("companyType", approveBase.getCompanySupplierType());
        }
        int line = byDocDao.deleteByDic(params);
        int line1 = byDocDao.deleteByDocRecord(params);

        //新增附件
        if (uploadUrlLists != null && uploadUrlLists.size() > 0) {
            ByDoc byDoc = null;
            List<ByDoc> byDocList = new ArrayList<>();
            for (int i = 0; i < uploadUrlLists.size(); i++){
                byDoc = new ByDoc();
                ByDoc byDoc1 = uploadUrlLists.get(i);
                byDoc.setBaseId(approveBase.getId());
                byDoc.setDocUrl(byDoc1.getDocUrl());
                byDoc.setDocName(byDoc1.getDocName());
                if (approveBase.getCompanyType()!=null&&approveBase.getCompanyType() == 0) {
                    byDoc.setCompanyType(approveBase.getCompanyType());
                }
                if (approveBase.getCompanySupplierType()!=null&&approveBase.getCompanySupplierType() == 1) {
                    byDoc.setCompanyType(approveBase.getCompanySupplierType());
                }
                byDoc.setCreateTime(approveBase.getCreateTime());
                byDoc.setCreateUserId(approveBase.getCreateUserId());
                byDoc.setIsDelete(0);
                byDocList.add(byDoc);
            }
            byDocDao.insertBatchByDoc(byDocList);


            //新增主数据附件信息
            if (flag == 1) {

                if (byApproveBaseRecord.getCompanyType()  != null || byApproveBaseRecord.getCompanySupplierType()!= null) {
                    //判断是否是审核通过和失败的数据
                    if ((byApproveBaseRecord.getCompanyType() == 0 && (byApproveBaseRecord.getStatus() == 2||byApproveBaseRecord.getStatus() == 3))
                            || (byApproveBaseRecord.getCompanySupplierType() == 1 &&
                            (byApproveBaseRecord.getSupplierStatus() == 2||byApproveBaseRecord.getSupplierStatus() == 3))) {

                        Map<String, Object> param4 = null;
                        for (int i = 0; i < docJsonList.size(); i++) {
                            param4 = new HashMap<>();
                            ByDoc byDoc4  = docJsonList.get(i);
                            String outUnitId = codeOutunitDao.selectOutUnitById(byDoc4.getBaseId());
                            param4.put("content_id", outUnitId);
                            byDocDao.deleteOutDoc(param4);
                        }

                        //新增附件记录信息
                        if (docJsonList != null && docJsonList.size() > 0) {
                            List<ByDocRecord> byDocRecordList = new ArrayList<>();
                            ByDocRecord byDocRecord = null;
                            for (int i = 0; i < docJsonList.size(); i++){
                                byDocRecord = new ByDocRecord();
                                ByDoc byDoc1 = docJsonList.get(i);
                                Integer recordVersion = byDocRecordDao.selectDocVersionNumber(byDoc1);
                                if (recordVersion != null && recordVersion > 0) {
                                    byDocRecord.setRecordVersion(recordVersion+1);
                                }else {
                                    byDocRecord.setRecordVersion(1);
                                }
                                byDocRecord.setByDocId(byDoc1.getId());
                                byDocRecord.setDocName(byDoc1.getDocName());
                                byDocRecord.setDocUrl(byDoc1.getDocUrl());
                                byDocRecord.setBaseId(byDoc1.getBaseId());
                                byDocRecord.setCreateUserId(byDoc1.getCreateUserId());
                                byDocRecord.setCompanyType(byDoc1.getCompanyType());
                                byDocRecord.setCreateTime(byDoc1.getCreateTime());
                                byDocRecord.setIsDelete(byDoc1.getIsDelete());
                                byDocRecord.setRecordTime(new Date());
                                byDocRecordList.add(byDocRecord);
                            }
                            byDocRecordDao.insertByDocRecordList(byDocRecordList);
                        }
                    }
                }

                Map<String, Object> param = null;
                for (int i = 0; i < uploadUrlLists.size(); i++){
                    param = new HashMap<>();
                    ByDoc byDoc3 = uploadUrlLists.get(i);
                    param.put("name", byDoc3.getDocName());
                    param.put("survey_type", "CODE_OUTUNIT");
                    if (codeOutunit.getId() == null) {
                        codeOutunit.setByApproveId(approveBase.getId());
                        //根据客商id查询主数据外部单位id
                        String outUnitId = codeOutunitDao.selectOutUnitById(codeOutunit.getByApproveId());
                        param.put("content_id", outUnitId);
                    }else {
                        param.put("content_id", codeOutunit.getId());
                    }
                    param.put("upload_name", byDoc3.getDocUrl());
                    param.put("upload_date", byDoc3.getCreateTime());
                    byDocDao.insertOutUnitDoc(param);

                }
            }
        }
        if ( count> 0 && num > 0  && num1 > 0 && num2 > 0&& num3 > 0 && num4>0&&num5> 0) {
            count = 1;
        }else {
            count = 0;
        }
        return count;
    }


    public void insertProductRecord(List<ByProduct> productJsonList){
        if (productJsonList != null && productJsonList.size() > 0) {
            //删除之前记录信息
            Map<String, Object> params =null;
            for (int i = 0; i < productJsonList.size(); i++) {
                params =  new HashMap<>();
                ByProduct byProduct = productJsonList.get(i);
                params.put("baseId", byProduct.getBaseId());
                params.put("companyType", byProduct.getCompanyType());
                byProductRecordDao.deleteByProductRecord(params);
            }


            List<ByProductRecord> byProductRecordList = new ArrayList<>();
            ByProductRecord byProductRecord = null;
            for (int i = 0; i < productJsonList.size(); i++) {
                byProductRecord = new ByProductRecord();
                ByProduct byProduct1 = productJsonList.get(i);
                byProductRecord.setBaseId(byProduct1.getBaseId());
                Integer recordVersion = byProductRecordDao.selectVersionNumber(byProduct1);
                if (recordVersion != null && recordVersion > 0) {
                    byProductRecord.setRecordVersion(recordVersion+1);
                }else {
                    byProductRecord.setRecordVersion(1);
                }
                byProductRecord.setByProductId(byProduct1.getId());
                byProductRecord.setCompanyType(byProduct1.getCompanyType());
                byProductRecord.setCreateTime(byProduct1.getCreateTime());
                byProductRecord.setCreateUserId(byProduct1.getCreateUserId());
                byProductRecord.setProductType(byProduct1.getProductType());
                byProductRecord.setProductTypeName(byProduct1.getProductTypeName());
                byProductRecord.setRecordTime(new Date());
                byProductRecord.setRemark(byProduct1.getRemark());
                byProductRecordList.add(byProductRecord);
            }
            byProductRecordDao.insertByProductRecordList(byProductRecordList);
        }
    }


    public void insertBankRecord(List<ByBank> bankJsonList) {
        if (bankJsonList != null && bankJsonList.size() > 0) {
            //删除之前记录信息
            Map<String, Object> params =null;
            for (int i = 0; i < bankJsonList.size(); i++) {
                params =  new HashMap<>();
                ByBank byBank1 = bankJsonList.get(i);
                params.put("baseId", byBank1.getBaseId());
                params.put("companyType", byBank1.getCompanyType());
                byBankRecordDao.deleteByBankRecord(params);
            }


            List<ByBankRecord> byBankRecordList = new ArrayList<>();
            ByBankRecord byBankRecord = null;
            for (int i = 0; i < bankJsonList.size(); i++) {
                byBankRecord = new ByBankRecord();
                ByBank byBank1 = bankJsonList.get(i);
                Integer recordVersion = byBankRecordDao.selectBankVersionNumber(byBank1);
                if (recordVersion != null && recordVersion > 0) {
                    byBankRecord.setRecordVersion(recordVersion+1);
                }else {
                    byBankRecord.setRecordVersion(1);
                }
                byBankRecord.setAccountProperties(byBank1.getAccountProperties());
                byBankRecord.setAssociatedNumber(byBank1.getAssociatedNumber());
                byBankRecord.setBankAccount(byBank1.getBankAccount());
                byBankRecord.setBankAccountName(byBank1.getBankAccountName());
                byBankRecord.setBankCountry(byBank1.getBankCountry());
                byBankRecord.setBankType(byBank1.getBankType());
                byBankRecord.setBankTypeName(byBank1.getBankTypeName());
                byBankRecord.setBaseId(byBank1.getBaseId());
                byBankRecord.setByBankId(byBank1.getId());
                byBankRecord.setCompanyType(byBank1.getCompanyType());
                byBankRecord.setCreateTime(byBank1.getCreateTime());
                byBankRecord.setCreateUserId(byBank1.getCreateUserId());
                byBankRecord.setCurrencyType(byBank1.getCurrencyType());
                byBankRecord.setDepositBank(byBank1.getDepositBank());
                byBankRecord.setDepositBankName(byBank1.getDepositBankName());
                byBankRecord.setIsElectronAccount(byBank1.getIsElectronAccount());
                byBankRecord.setOtherBank(byBank1.getOtherBank());
                byBankRecord.setRecordTime(new Date());
                byBankRecord.setIsBaseAccount(byBank1.getIsBaseAccount());
                byBankRecordList.add(byBankRecord);
            }
            byBankRecordDao.insertByBankRecordList(byBankRecordList);
        }
    }

    /**
     * @desc 摸索搜索产品分类
     * @param productTypeName
     * @return
     */
    @Override
    public List<Map<String, Object>> selectByProductTypeName(String productTypeName, int flag) {
        List<Map<String, Object>>  productTypeList = null;
        if (flag == 0) {
            productTypeList = byIndustryDao.selectByProductTypeName(productTypeName);
        }else {
            productTypeList = byIndustryDao.selectByProductTypeNameSupplier(productTypeName);
        }
        return productTypeList;
    }

    /**
     * @desc 摸索搜索所属地区
     * @param areaName
     * @return
     */
    @Override
    public List<Map<String, Object>> selectByAreaName(String areaName) {
        return byApproveBaseDao.selectByAreaName(areaName);
    }

    /**
     * @desc 摸索搜索银行类别
     * @param bankTypeName
     * @return
     */
    @Override
    public List<Map<String, Object>> selectByBankTypeName(String bankTypeName) {
        return byBankDao.selectByBankTypeName(bankTypeName);
    }

    /**
     * @desc 查询开户银行
     * @param bankCode
     * @return
     */
    @Override
    public List<Map<String, Object>> selectCodeName(String bankCode) {
        return byBankDao.selectCodeName(bankCode);
    }

    /**
     * @desc 查询行业信息
     * @param params
     * @return
     */
    @Override
    public List<ByIndustry> selectIndustryList(Map<String, Object> params) {
        return byIndustryDao.selectIndustryList(params);
    }

    /**
     * @desc 查询产品信息
     * @param params
     * @return
     */
    @Override
    public List<ByProduct> selectProductList(Map<String, Object> params) {
        return byProductDao.selectProductList(params);
    }

    @Override
    public List<ByBank> selectBankList(Map<String, Object> params) {
        return byBankDao.selectBankList(params);
    }

    /**
     * @desc 查询基本信息
     * @param id
     * @return
     */
    @Override
    public ByApproveBase selectByApproveBase(Long id) {
        return byApproveBaseDao.selectByApproveBase(id);
    }

    /**
     * @desc 查询附件信息
     * @param params
     * @return
     */
    @Override
    public List<ByDoc> selectByDocList(Map<String, Object> params) {
        return byDocDao.selectByDocList(params);
    }

    @Override
    public List<Map<String, Object>> selectByDepositBankName(Map<String, Object> params) {
        return byBankDao.selectByDepositBankName(params);
    }

    /**
     * @desc 查询经济类型树
     * @return
     */
    @Override
    public List<Map<String, Object>> queryEconomicsTypeTree(Map<String, Object> params) {
        return byApproveBaseDao.queryEconomicsTypeTree(params);
    }

    /**
     * @desc 查询客户的产品分类
     * @return
     */
    @Override
    public List<Map<String, Object>> selectClientWullbList() {
        return byApproveBaseDao.selectClientWullbList();
    }

    /**
     * @desc 查询供应商的产品分类
     * @return
     */
    @Override
    public List<Map<String, Object>> selectSupplierWullbList() {
        return byApproveBaseDao.selectSupplierWullbList();
    }

    /**
     * @desc 校验字段唯一性
     * @param byApproveBase
     * @return
     */
    @Override
    public int queryCheckoutNameUnique(ByApproveBase byApproveBase) {
        return byApproveBaseDao.queryCheckoutNameUnique(byApproveBase);
    }
}
