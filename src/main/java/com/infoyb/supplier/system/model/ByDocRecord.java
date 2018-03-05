package com.infoyb.supplier.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_DOC_RECORD")
public class ByDocRecord {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_DOC_RECORD_SEQ.nextval from dual")
    private Long id;

    @Column(name = "BY_DOC_ID")
    private Long byDocId;

    /**
     * 附件名
     */
    @Column(name = "DOC_NAME")
    private String docName;

    /**
     * 附件url
     */
    @Column(name = "DOC_URL")
    private String docUrl;

    /**
     * 基本信息ID
     */
    @Column(name = "BASE_ID")
    private Long baseId;

    /**
     * 0:未删  1:已删
     */
    @Column(name = "IS_DELETE")
    private Integer isDelete;

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

    public Long getByDocId() {
        return byDocId;
    }

    public void setByDocId(Long byDocId) {
        this.byDocId = byDocId;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}