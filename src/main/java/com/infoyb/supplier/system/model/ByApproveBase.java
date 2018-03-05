package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_APPROVE_BASE")
public class ByApproveBase extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_APPROVE_BASE_SEQ.nextval from dual")
    private Long id;

    /**
     * 单位代码
     */
    @Column(name = "COMPANY_CODE")
    private String companyCode;

    /**
     * 单位全称
     */
    @Column(name = "COMPANY_FULL_NAME")
    private String companyFullName;

    /**
     * 英文全称
     */
    @Column(name = "COMPANY_FULL_EG")
    private String companyFullEg;

    /**
     * 单位简称
     */
    @Column(name = "COMPANY_SHORT_NAME")
    private String companyShortName;

    /**
     * 英文简称
     */
    @Column(name = "COMPANY_SHORT_EG")
    private String companyShortEg;

    /**
     * 所属地区
     */
    @Column(name = "AREA_NAME")
    private String areaName;

    @Column(name = "AREA")
    private Long area;

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    /**
     * 法人
     */
    @Column(name = "LEGAL_PERSON")
    private String legalPerson;

    /**
     * 注册资金
     */
    @Column(name = "FUND")
    private Integer fund;

    /**
     * 是否三证合一
     */
    @Column(name = "IS_UNITY")
    private Integer isUnity;

    /**
     * 经济类型名称
     */
    @Column(name = "ECONOMICS_TYPE_NAME")
    private String economicsTypeName;

    /**
     * 社会信用代码
     */
    @Column(name = "SOCIAL_CREDIT_CODE")
    private String socialCreditCode;

    /**
     * 营业执照号
     */
    @Column(name = "LICENSE_NUMBER")
    private String licenseNumber;

    /**
     * 组织机构代码证号
     */
    @Column(name = "ORGANIZATION_CODE_NUMBER")
    private String organizationCodeNumber;

    /**
     * 税务登记证号
     */
    @Column(name = "TAX_NUMBER")
    private String taxNumber;

    /**
     * 经济类型
     */
    @Column(name = "ECONOMICS_TYPE")
    private Integer economicsType;

    /**
     * 成立日期
     */
    @Column(name = "CREATE_REG_TIME")
    private Date createRegTime;

    /**
     * 通讯地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 邮编
     */
    @Column(name = "POSTCODE")
    private Integer postcode;

    /**
     * 公司电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * WEB地址
     */
    @Column(name = "WEB_ADDRESS")
    private String webAddress;

    /**
     * 传真
     */
    @Column(name = "FAX")
    private String fax;

    /**
     * 单位类型(0: 客户   1:供应商 )
     */
    @Column(name = "COMPANY_TYPE")
    private Integer companyType;

    /**
     * 状态(0已提交   1未提交   2待审   3审核通过    4审核失败)
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_USER_ID")
    private Long createUserId;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 修改用户
     */
    @Column(name = "UPDATE_USER_ID")
    private Integer updateUserId;

    /**
     * 修改用户
     */
    @Column(name = "COMPANY_SUPPLIER_TYPE")
    private Integer companySupplierType;

    /**
     * 修改用户
     */
    @Column(name = "SUPPLIER_STATUS")
    private Integer supplierStatus;

    /**
     * 审核失败原因
     */
    @Column(name = "APPROVE_BACK_CAUSE")
    private String approveBackCause;

    /**
     * 是否危化品
     */
    @Column(name = "IS_CHEMICAL")
    private Integer isChemical;

    /**
     * 资金币种
     */
    @Column(name = "CURRENCY")
    private Integer currency;

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getIsChemical() {
        return isChemical;
    }

    public void setIsChemical(Integer isChemical) {
        this.isChemical = isChemical;
    }

    public Integer getCompanySupplierType() {
        return companySupplierType;
    }

    public void setCompanySupplierType(Integer companySupplierType) {
        this.companySupplierType = companySupplierType;
    }

    public Integer getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(Integer supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getApproveBackCause() {
        return approveBackCause;
    }

    public void setApproveBackCause(String approveBackCause) {
        this.approveBackCause = approveBackCause;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取单位代码
     *
     * @return COMPANY_CODE - 单位代码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置单位代码
     *
     * @param companyCode 单位代码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取单位全称
     *
     * @return COMPANY_FULL_NAME - 单位全称
     */
    public String getCompanyFullName() {
        return companyFullName;
    }

    /**
     * 设置单位全称
     *
     * @param companyFullName 单位全称
     */
    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    /**
     * 获取英文全称
     *
     * @return COMPANY_FULL_EG - 英文全称
     */
    public String getCompanyFullEg() {
        return companyFullEg;
    }

    /**
     * 设置英文全称
     *
     * @param companyFullEg 英文全称
     */
    public void setCompanyFullEg(String companyFullEg) {
        this.companyFullEg = companyFullEg;
    }

    /**
     * 获取单位简称
     *
     * @return COMPANY_SHORT_NAME - 单位简称
     */
    public String getCompanyShortName() {
        return companyShortName;
    }

    /**
     * 设置单位简称
     *
     * @param companyShortName 单位简称
     */
    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    /**
     * 获取英文简称
     *
     * @return COMPANY_SHORT_EG - 英文简称
     */
    public String getCompanyShortEg() {
        return companyShortEg;
    }

    /**
     * 设置英文简称
     *
     * @param companyShortEg 英文简称
     */
    public void setCompanyShortEg(String companyShortEg) {
        this.companyShortEg = companyShortEg;
    }

    /**
     * 获取法人
     *
     * @return LEGAL_PERSON - 法人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法人
     *
     * @param legalPerson 法人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取注册资金
     *
     * @return FUND - 注册资金
     */
    public Integer getFund() {
        return fund;
    }

    /**
     * 设置注册资金
     *
     * @param fund 注册资金
     */
    public void setFund(Integer fund) {
        this.fund = fund;
    }

    /**
     * 获取是否三证合一
     *
     * @return IS_UNITY - 是否三证合一
     */
    public Integer getIsUnity() {
        return isUnity;
    }

    /**
     * 设置是否三证合一
     *
     * @param isUnity 是否三证合一
     */
    public void setIsUnity(Integer isUnity) {
        this.isUnity = isUnity;
    }

    /**
     * 获取经济类型名称
     *
     * @return ECONOMICS_TYPE_NAME - 经济类型名称
     */
    public String getEconomicsTypeName() {
        return economicsTypeName;
    }

    /**
     * 设置经济类型名称
     *
     * @param economicsTypeName 经济类型名称
     */
    public void setEconomicsTypeName(String economicsTypeName) {
        this.economicsTypeName = economicsTypeName;
    }

    /**
     * 获取社会信用代码
     *
     * @return SOCIAL_CREDIT_CODE - 社会信用代码
     */
    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    /**
     * 设置社会信用代码
     *
     * @param socialCreditCode 社会信用代码
     */
    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    /**
     * 获取营业执照号
     *
     * @return LICENSE_NUMBER - 营业执照号
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * 设置营业执照号
     *
     * @param licenseNumber 营业执照号
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * 获取组织机构代码证号
     *
     * @return ORGANIZATION_CODE_NUMBER - 组织机构代码证号
     */
    public String getOrganizationCodeNumber() {
        return organizationCodeNumber;
    }

    /**
     * 设置组织机构代码证号
     *
     * @param organizationCodeNumber 组织机构代码证号
     */
    public void setOrganizationCodeNumber(String organizationCodeNumber) {
        this.organizationCodeNumber = organizationCodeNumber;
    }

    /**
     * 获取税务登记证号
     *
     * @return TAX_NUMBER - 税务登记证号
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * 设置税务登记证号
     *
     * @param taxNumber 税务登记证号
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * 获取经济类型
     *
     * @return ECONOMICS_TYPE - 经济类型
     */
    public Integer getEconomicsType() {
        return economicsType;
    }

    /**
     * 设置经济类型
     *
     * @param economicsType 经济类型
     */
    public void setEconomicsType(Integer economicsType) {
        this.economicsType = economicsType;
    }

    /**
     * 获取成立日期
     *
     * @return CREATE_REG_TIME - 成立日期
     */
    public Date getCreateRegTime() {
        return createRegTime;
    }

    /**
     * 设置成立日期
     *
     * @param createRegTime 成立日期
     */
    public void setCreateRegTime(Date createRegTime) {
        this.createRegTime = createRegTime;
    }

    /**
     * 获取通讯地址
     *
     * @return ADDRESS - 通讯地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置通讯地址
     *
     * @param address 通讯地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮编
     *
     * @return POSTCODE - 邮编
     */
    public Integer getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取公司电话
     *
     * @return PHONE - 公司电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置公司电话
     *
     * @param phone 公司电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取WEB地址
     *
     * @return WEB_ADDRESS - WEB地址
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * 设置WEB地址
     *
     * @param webAddress WEB地址
     */
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    /**
     * 获取传真
     *
     * @return FAX - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取单位类型(0: 客户   1:供应商 )
     *
     * @return COMPANY_TYPE - 单位类型(0: 客户   1:供应商 )
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * 设置单位类型(0: 客户   1:供应商 )
     *
     * @param companyType 单位类型(0: 客户   1:供应商 )
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取状态(0已提交   1未提交   2待审   3审核通过    4审核失败)
     *
     * @return STATUS - 状态(0已提交   1未提交   2待审   3审核通过    4审核失败)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0已提交   1未提交   2待审   3审核通过    4审核失败)
     *
     * @param status 状态(0已提交   1未提交   2待审   3审核通过    4审核失败)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_USER_ID - 创建用户
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建用户
     *
     * @param createUserId 创建用户
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取修改时间
     *
     * @return UPDATE_TIME - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取修改用户
     *
     * @return UPDATE_USER_ID - 修改用户
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置修改用户
     *
     * @param updateUserId 修改用户
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取所属地区
     *
     * @return AREA_NAME - 所属地区
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置所属地区
     *
     * @param areaName 所属地区
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 联系人手机号
     */
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}