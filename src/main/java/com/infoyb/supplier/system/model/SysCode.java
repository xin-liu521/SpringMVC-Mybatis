package com.infoyb.supplier.system.model;

import javax.persistence.*;

@Table(name = "SYS_CODE")
public class SysCode {
    @Id
    @Column(name = "CODE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SYS_CODE_SEQ.nextval from dual")
    private String codeId;

    /**
     * 字典名称
     */
    @Column(name = "CODE_NAME")
    private String codeName;

    /**
     * 字典类型
     */
    @Column(name = "CODE_TYPE")
    private String codeType;

    /**
     * 字典类型名称
     */
    @Column(name = "CODE_TYPENAME")
    private String codeTypename;

    /**
     * 字典值
     */
    @Column(name = "CODE_VALUE")
    private String codeValue;

    /**
     * 字典排序
     */
    @Column(name = "CODE_INDEX")
    private Integer codeIndex;

    /**
     * 字典状态 0正常 1停用
     */
    @Column(name = "CODE_STATUS")
    private String codeStatus;

    /**
     * 新增树形结构名称
     */
    @Column(name = "TREE_TYPE_NAME")
    private String treeTypeName;

    /**
     * 其他系统字段(可能会用到)
     */
    @Column(name = "OTHER_SYSTEM_NAME")
    private String otherSystemName;

    /**
     * 父节点id
     */
    @Column(name = "PID")
    private String pid;

    /**
     * 子节点id
     */
    @Column(name = "CODE_NAME_ID")
    private String codeNameId;

    /**
     * @return CODE_ID
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * @param codeId
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    /**
     * 获取字典名称
     *
     * @return CODE_NAME - 字典名称
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置字典名称
     *
     * @param codeName 字典名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    /**
     * 获取字典类型
     *
     * @return CODE_TYPE - 字典类型
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置字典类型
     *
     * @param codeType 字典类型
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    /**
     * 获取字典类型名称
     *
     * @return CODE_TYPENAME - 字典类型名称
     */
    public String getCodeTypename() {
        return codeTypename;
    }

    /**
     * 设置字典类型名称
     *
     * @param codeTypename 字典类型名称
     */
    public void setCodeTypename(String codeTypename) {
        this.codeTypename = codeTypename == null ? null : codeTypename.trim();
    }

    /**
     * 获取字典值
     *
     * @return CODE_VALUE - 字典值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置字典值
     *
     * @param codeValue 字典值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
    }

    /**
     * 获取字典排序
     *
     * @return CODE_INDEX - 字典排序
     */
    public Integer getCodeIndex() {
        return codeIndex;
    }

    /**
     * 设置字典排序
     *
     * @param codeIndex 字典排序
     */
    public void setCodeIndex(Integer codeIndex) {
        this.codeIndex = codeIndex;
    }

    /**
     * 获取字典状态 0正常 1停用
     *
     * @return CODE_STATUS - 字典状态 0正常 1停用
     */
    public String getCodeStatus() {
        return codeStatus;
    }

    /**
     * 设置字典状态 0正常 1停用
     *
     * @param codeStatus 字典状态 0正常 1停用
     */
    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus == null ? null : codeStatus.trim();
    }

    /**
     * 获取新增树形结构名称
     *
     * @return TREE_TYPE_NAME - 新增树形结构名称
     */
    public String getTreeTypeName() {
        return treeTypeName;
    }

    /**
     * 设置新增树形结构名称
     *
     * @param treeTypeName 新增树形结构名称
     */
    public void setTreeTypeName(String treeTypeName) {
        this.treeTypeName = treeTypeName == null ? null : treeTypeName.trim();
    }

    /**
     * 获取其他系统字段(可能会用到)
     *
     * @return OTHER_SYSTEM_NAME - 其他系统字段(可能会用到)
     */
    public String getOtherSystemName() {
        return otherSystemName;
    }

    /**
     * 设置其他系统字段(可能会用到)
     *
     * @param otherSystemName 其他系统字段(可能会用到)
     */
    public void setOtherSystemName(String otherSystemName) {
        this.otherSystemName = otherSystemName == null ? null : otherSystemName.trim();
    }

    /**
     * 获取父节点id
     *
     * @return PID - 父节点id
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父节点id
     *
     * @param pid 父节点id
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 获取子节点id
     *
     * @return CODE_NAME_ID - 子节点id
     */
    public String getCodeNameId() {
        return codeNameId;
    }

    /**
     * 设置子节点id
     *
     * @param codeNameId 子节点id
     */
    public void setCodeNameId(String codeNameId) {
        this.codeNameId = codeNameId == null ? null : codeNameId.trim();
    }
}