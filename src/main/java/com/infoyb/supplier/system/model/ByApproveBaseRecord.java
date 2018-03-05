package com.infoyb.supplier.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_APPROVE_BASE_RECORD")
public class ByApproveBaseRecord {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_APPROVE_BASE_RECORD_SEQ.nextval from dual")
    private Long id;

    /**
     * 认证基础表主键
     */
    @Column(name = "BY_APPROVE_BASE_ID")
    private Long byApproveBaseId;

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
     * 客户单位类型(0: 客户)
     */
    @Column(name = "COMPANY_TYPE")
    private Integer companyType;

    /**
     * 客户审核状态( 0未提交   1待审   2审核通过    3审核失败)
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
    private Long updateUserId;

    /**
     * 所属地区名称
     */
    @Column(name = "AREA_NAME")
    private String areaName;

    /**
     * 所属地区
     */
    @Column(name = "AREA")
    private String area;

    /**
     * 审核失败原因
     */
    @Column(name = "APPROVE_BACK_CAUSE")
    private String approveBackCause;

    /**
     * 供应商单位类型(1: 供应商)
     */
    @Column(name = "COMPANY_SUPPLIER_TYPE")
    private Integer companySupplierType;

    /**
     * 供应商审核状态( 0未提交   1待审   2审核通过    3审核失败)
     */
    @Column(name = "SUPPLIER_STATUS")
    private Integer supplierStatus;

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 联系人手机号
     */
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;

    /**
     * 是否危化品   （ 0 是）
     */
    @Column(name = "IS_CHEMICAL")
    private Integer isChemical;

    /**
     * 记录时间
     */
    @Column(name = "RECORD_TIME")
    private Date recordTime;

    /**
     * 记录版本
     */
    @Column(name = "RECORD_VERSION")
    private Integer recordVersion;

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApproveBackCause() {
        return approveBackCause;
    }

    public void setApproveBackCause(String approveBackCause) {
        this.approveBackCause = approveBackCause;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getByApproveBaseId() {
        return byApproveBaseId;
    }

    public void setByApproveBaseId(Long byApproveBaseId) {
        this.byApproveBaseId = byApproveBaseId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyFullEg() {
        return companyFullEg;
    }

    public void setCompanyFullEg(String companyFullEg) {
        this.companyFullEg = companyFullEg;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getCompanyShortEg() {
        return companyShortEg;
    }

    public void setCompanyShortEg(String companyShortEg) {
        this.companyShortEg = companyShortEg;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public Integer getCompanySupplierType() {
        return companySupplierType;
    }

    public void setCompanySupplierType(Integer companySupplierType) {
        this.companySupplierType = companySupplierType;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getCreateRegTime() {
        return createRegTime;
    }

    public void setCreateRegTime(Date createRegTime) {
        this.createRegTime = createRegTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getEconomicsType() {
        return economicsType;
    }

    public void setEconomicsType(Integer economicsType) {
        this.economicsType = economicsType;
    }

    public String getEconomicsTypeName() {
        return economicsTypeName;
    }

    public void setEconomicsTypeName(String economicsTypeName) {
        this.economicsTypeName = economicsTypeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getFund() {
        return fund;
    }

    public void setFund(Integer fund) {
        this.fund = fund;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsChemical() {
        return isChemical;
    }

    public void setIsChemical(Integer isChemical) {
        this.isChemical = isChemical;
    }

    public Integer getIsUnity() {
        return isUnity;
    }

    public void setIsUnity(Integer isUnity) {
        this.isUnity = isUnity;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getOrganizationCodeNumber() {
        return organizationCodeNumber;
    }

    public void setOrganizationCodeNumber(String organizationCodeNumber) {
        this.organizationCodeNumber = organizationCodeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(Integer supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
}