package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BY_USERS")
public class ByUsers extends BaseModel {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BY_USERS_SEQ.nextval from dual")
    private Long userId;

    /**
     * 账号
     */
    @Column(name = "USER_ACCOUNT")
    private String userAccount;

    /**
     * 密码
     */
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    /**
     * 联系电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 电子邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 是否激活(0 是，1 否)
     */
    @Column(name = "IS_ACTIVE")
    private Integer isActive;

    /**
     * 邮件发送时间
     */
    @Column(name = "EMAIL_SEND_TIME")
    private Date emailSendTime;

    /**
     * @return USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取账号
     *
     * @return USER_ACCOUNT - 账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置账号
     *
     * @param userAccount 账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取密码
     *
     * @return USER_PASSWORD - 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取联系电话
     *
     * @return PHONE - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取电子邮箱
     *
     * @return EMAIL - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 获取是否激活(0 是，1 否)
     *
     * @return IS_ACTIVE - 是否激活(0 是，1 否)
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * 设置是否激活(0 是，1 否)
     *
     * @param isActive 是否激活(0 是，1 否)
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * 获取邮件发送时间
     *
     * @return EMAIL_SEND_TIME - 邮件发送时间
     */
    public Date getEmailSendTime() {
        return emailSendTime;
    }

    /**
     * 设置邮件发送时间
     *
     * @param emailSendTime 邮件发送时间
     */
    public void setEmailSendTime(Date emailSendTime) {
        this.emailSendTime = emailSendTime;
    }

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 加密
     */
    @Column(name = "SALT")
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 图片
     */
    @Column(name = "PICTURE_URL")
    private String pictureUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     *加密字符
     **/
    public String getCredentialsSalt(){
        return userAccount+salt;
    }

    public ByUsers(){
    }

    public ByUsers(String userAccount){
        this.userAccount=userAccount;
    }
}

