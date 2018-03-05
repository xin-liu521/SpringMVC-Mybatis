package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_INDUSTRY")
public class ByIndustry extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_INDUSTRY_SEQ.nextval from dual")
    private Long id;

    /**
     * 基本信息ID
     */
    @Column(name = "BASE_ID")
    private Long baseId;

    /**
     * 所属行业
     */
    @Column(name = "INDUSTRY")
    private Long industry;

    /**
     * 所属行业名称
     */
    @Column(name = "INDUSTRY_NAME")
    private String industryName;

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
     * 获取基本信息ID
     *
     * @return BASE_ID - 基本信息ID
     */
    public Long getBaseId() {
        return baseId;
    }

    /**
     * 设置基本信息ID
     *
     * @param baseId 基本信息ID
     */
    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    /**
     * 获取所属行业
     *
     * @return INDUSTRY - 所属行业
     */
    public Long getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业
     *
     * @param industry 所属行业
     */
    public void setIndustry(Long industry) {
        this.industry = industry;
    }

    /**
     * 获取所属行业名称
     *
     * @return INDUSTRY_NAME - 所属行业名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 设置所属行业名称
     *
     * @param industryName 所属行业名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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
}