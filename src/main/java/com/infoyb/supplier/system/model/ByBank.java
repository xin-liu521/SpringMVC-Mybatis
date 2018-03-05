package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;


import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "BY_BANK")
public class ByBank extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_BANK_SEQ.nextval from dual")
    private Long id;

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
     * 单位类型
     */
    @Column(name = "COMPANY_TYPE")
    private Integer companyType;

    /**
     * 是否电子承兑账户
     */
    @Column(name = "IS_ELECTRON_ACCOUNT")
    private Integer isElectronAccount;

    @Transient
    private List<SysCode> sysCodeList;

    @Column(name = "IS_BASE_ACCOUNT")
    private Integer isBaseAccount;

    public Integer getIsBaseAccount() {
        return isBaseAccount;
    }

    public void setIsBaseAccount(Integer isBaseAccount) {
        this.isBaseAccount = isBaseAccount;
    }

    public List<SysCode> getSysCodeList() {
        return sysCodeList;
    }

    public void setSysCodeList(List<SysCode> sysCodeList) {
        this.sysCodeList = sysCodeList;
    }

    public Integer getIsElectronAccount() {
        return isElectronAccount;
    }

    public void setIsElectronAccount(Integer isElectronAccount) {
        this.isElectronAccount = isElectronAccount;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
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
     * 获取基础信息ID
     *
     * @return BASE_ID - 基础信息ID
     */
    public Long getBaseId() {
        return baseId;
    }

    /**
     * 设置基础信息ID
     *
     * @param baseId 基础信息ID
     */
    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    /**
     * 获取银行账号
     *
     * @return BANK_ACCOUNT - 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账号
     *
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 获取银行类别
     *
     * @return BANK_TYPE - 银行类别
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 设置银行类别
     *
     * @param bankType 银行类别
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * 获取账户名称
     *
     * @return BANK_ACCOUNT_NAME - 账户名称
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * 设置账户名称
     *
     * @param bankAccountName 账户名称
     */
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    /**
     * 获取开户银行
     *
     * @return DEPOSIT_BANK - 开户银行
     */
    public Long getDepositBank() {
        return depositBank;
    }

    /**
     * 设置开户银行
     *
     * @param depositBank 开户银行
     */
    public void setDepositBank(Long depositBank) {
        this.depositBank = depositBank;
    }

    /**
     * 获取银行国家
     *
     * @return BANK_COUNTRY - 银行国家
     */
    public String getBankCountry() {
        return bankCountry;
    }

    /**
     * 设置银行国家
     *
     * @param bankCountry 银行国家
     */
    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    /**
     * 获取联行号
     *
     * @return ASSOCIATED_NUMBER - 联行号
     */
    public String getAssociatedNumber() {
        return associatedNumber;
    }

    /**
     * 设置联行号
     *
     * @param associatedNumber 联行号
     */
    public void setAssociatedNumber(String associatedNumber) {
        this.associatedNumber = associatedNumber;
    }

    /**
     * 获取币种
     *
     * @return CURRENCY_TYPE - 币种
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置币种
     *
     * @param currencyType 币种
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * 获取其他开户行
     *
     * @return OTHER_BANK - 其他开户行
     */
    public String getOtherBank() {
        return otherBank;
    }

    /**
     * 设置其他开户行
     *
     * @param otherBank 其他开户行
     */
    public void setOtherBank(String otherBank) {
        this.otherBank = otherBank;
    }

    /**
     * 获取银行类别名称
     *
     * @return BANK_TYPE_NAME - 银行类别名称
     */
    public String getBankTypeName() {
        return bankTypeName;
    }

    /**
     * 设置银行类别名称
     *
     * @param bankTypeName 银行类别名称
     */
    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    /**
     * 获取开户银行名称
     *
     * @return DEPOSIT_BANK_NAME - 开户银行名称
     */
    public String getDepositBankName() {
        return depositBankName;
    }

    /**
     * 设置开户银行名称
     *
     * @param depositBankName 开户银行名称
     */
    public void setDepositBankName(String depositBankName) {
        this.depositBankName = depositBankName;
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
     * 账号性质
     */
    @Column(name = "ACCOUNT_PROPERTIES")
    private Integer accountProperties;

    public Integer getAccountProperties() {
        return accountProperties;
    }

    public void setAccountProperties(Integer accountProperties) {
        this.accountProperties = accountProperties;
    }
}