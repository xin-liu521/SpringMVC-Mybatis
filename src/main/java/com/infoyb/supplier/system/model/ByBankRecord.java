package com.infoyb.supplier.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_BANK_RECORD")
public class ByBankRecord {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_BANK_RECORD_SEQ.nextval from dual")
    private Long id;

    /**
     * 银行主键id
     */
    @Column(name = "BY_BANK_ID")
    private Long byBankId;

    /**
     * 基础信息ID
     */
    @Column(name = "BASE_ID")
    private Long baseId;

    /**
     * 银行账号
     */
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;

    /**
     * 银行类别
     */
    @Column(name = "BANK_TYPE")
    private String bankType;

    /**
     * 账户名称
     */
    @Column(name = "BANK_ACCOUNT_NAME")
    private String bankAccountName;

    /**
     * 开户银行
     */
    @Column(name = "DEPOSIT_BANK")
    private Long depositBank;

    /**
     * 银行国家
     */
    @Column(name = "BANK_COUNTRY")
    private String bankCountry;

    /**
     * 联行号
     */
    @Column(name = "ASSOCIATED_NUMBER")
    private String associatedNumber;

    /**
     * 币种
     */
    @Column(name = "CURRENCY_TYPE")
    private String currencyType;

    /**
     * 其他开户行
     */
    @Column(name = "OTHER_BANK")
    private String otherBank;

    /**
     * 银行类别名称
     */
    @Column(name = "BANK_TYPE_NAME")
    private String bankTypeName;

    /**
     * 开户银行名称
     */
    @Column(name = "DEPOSIT_BANK_NAME")
    private String depositBankName;

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
     * 单位类型（0客户  1 供应商）
     */
    @Column(name = "COMPANY_TYPE")
    private Integer companyType;

    /**
     * 是否电子承兑账户
     */
    @Column(name = "IS_ELECTRON_ACCOUNT")
    private Integer isElectronAccount;

    /**
     * 账号性质（0个人账号   1单位账号）
     */
    @Column(name = "ACCOUNT_PROPERTIES")
    private Integer accountProperties;

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

    /**
     * 是否基本户
     */
    @Column(name = "IS_BASE_ACCOUNT")
    private Integer isBaseAccount;

    public Integer getIsBaseAccount() {
        return isBaseAccount;
    }

    public void setIsBaseAccount(Integer isBaseAccount) {
        this.isBaseAccount = isBaseAccount;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Integer getAccountProperties() {
        return accountProperties;
    }

    public void setAccountProperties(Integer accountProperties) {
        this.accountProperties = accountProperties;
    }

    public String getAssociatedNumber() {
        return associatedNumber;
    }

    public void setAssociatedNumber(String associatedNumber) {
        this.associatedNumber = associatedNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankTypeName() {
        return bankTypeName;
    }

    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getByBankId() {
        return byBankId;
    }

    public void setByBankId(Long byBankId) {
        this.byBankId = byBankId;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
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

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Long getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(Long depositBank) {
        this.depositBank = depositBank;
    }

    public String getDepositBankName() {
        return depositBankName;
    }

    public void setDepositBankName(String depositBankName) {
        this.depositBankName = depositBankName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsElectronAccount() {
        return isElectronAccount;
    }

    public void setIsElectronAccount(Integer isElectronAccount) {
        this.isElectronAccount = isElectronAccount;
    }

    public String getOtherBank() {
        return otherBank;
    }

    public void setOtherBank(String otherBank) {
        this.otherBank = otherBank;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}