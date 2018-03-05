package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_APTITUDE")
public class ByAptitude extends BaseModel {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_APTITUDE_SEQ.nextval from dual")
    private Long id;

    /**
     * 资质分类
     */
    @Column(name = "APTITUDE_TYPE")
    private Integer aptitudeType;

    /**
     * 分类名称
     */
    @Column(name = "APTITUDE_TYPE_NAME")
    private String aptitudeTypeName;

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
     * 获取主键
     *
     * @return ID - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资质分类
     *
     * @return APTITUDE_TYPE - 资质分类
     */
    public Integer getAptitudeType() {
        return aptitudeType;
    }

    /**
     * 设置资质分类
     *
     * @param aptitudeType 资质分类
     */
    public void setAptitudeType(Integer aptitudeType) {
        this.aptitudeType = aptitudeType;
    }

    /**
     * 获取分类名称
     *
     * @return APTITUDE_TYPE_NAME - 分类名称
     */
    public String getAptitudeTypeName() {
        return aptitudeTypeName;
    }

    /**
     * 设置分类名称
     *
     * @param aptitudeTypeName 分类名称
     */
    public void setAptitudeTypeName(String aptitudeTypeName) {
        this.aptitudeTypeName = aptitudeTypeName;
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