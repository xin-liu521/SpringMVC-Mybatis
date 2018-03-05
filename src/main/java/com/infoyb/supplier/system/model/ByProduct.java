package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_PRODUCT")
public class ByProduct extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_PRODUCT_SEQ.nextval from dual")
    private Long id;

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
     * 获取分类
     *
     * @return PRODUCT_TYPE - 分类
     */
    public Long getProductType() {
        return productType;
    }

    /**
     * 设置分类
     *
     * @param productType 分类
     */
    public void setProductType(Long productType) {
        this.productType = productType;
    }

    /**
     * 获取分类名
     *
     * @return PRODUCT_TYPE_NAME - 分类名
     */
    public String getProductTypeName() {
        return productTypeName;
    }

    /**
     * 设置分类名
     *
     * @param productTypeName 分类名
     */
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取基本信息id
     *
     * @return BASE_ID - 基本信息id
     */
    public Long getBaseId() {
        return baseId;
    }

    /**
     * 设置基本信息id
     *
     * @param baseId 基本信息id
     */
    public void setBaseId(Long baseId) {
        this.baseId = baseId;
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