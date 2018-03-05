package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "INFOYB.SYS_LOG")
public class SysLog extends BaseModel {
    /**
     * 主键id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SYS_LOG_SEQ.nextval from dual")
    @Column(name = "ID")
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 用户name
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户操作
     */
    @Column(name = "OPERATION")
    private String operation;

    /**
     * 请求方法
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 请求参数
     */
    @Column(name = "PARAMS")
    private String params;

    /**
     * IP地址
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 获取主键id
     *
     * @return ID - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户name
     *
     * @return USER_NAME - 用户name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户name
     *
     * @param userName 用户name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户操作
     *
     * @return OPERATION - 用户操作
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置用户操作
     *
     * @param operation 用户操作
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取请求方法
     *
     * @return METHOD - 请求方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求方法
     *
     * @param method 请求方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取请求参数
     *
     * @return PARAMS - 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置请求参数
     *
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取IP地址
     *
     * @return IP - IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP地址
     *
     * @param ip IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
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
}