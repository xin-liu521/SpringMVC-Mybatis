package com.infoyb.supplier.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_PRODUCT_RECORD")
public class ByProductRecord {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_PRODUCT_RECORD_SEQ.nextval from dual")
    private Long id;

    /**
     * 产品主键id
     */
    @Column(name = "BY_PRODUCT_ID")
    private Long byProductId;

    /**
     * 分类
     */
    @Column(name = "PRODUCT_TYPE")
    private Long productType;

    /**
     * 分类名
     */
    @Column(name = "PRODUCT_TYPE_NAME")
    private String productTypeName;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 基本信息id
     */
    @Column(name = "BASE_ID")
    private Long baseId;

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
     * 单位类型（0客户   1供应商）
     */
    @Column(name = "COMPANY_TYPE")
    private Integer companyType;

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

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getByProductId() {
        return byProductId;
    }

    public void setByProductId(Long byProductId) {
        this.byProductId = byProductId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}