package com.infoyb.supplier.system.model;

import com.infoyb.supplier.common.model.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "USER_SUPPLIER")
public class UserSupplier extends BaseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select USER_SUPPLIER_SEQ.nextval from dual")
    /**
     * 主键
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 账号
     */
    @Column(name = "USER_ACCOUNT")
    private String userAccount;

    /**
     * 姓名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "USER_PSW")
    private String userPsw;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 邮编
     */
    @Column(name = "ZIPCODE")
    private String zipcode;

    /**
     * 手机
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 传真
     */
    @Column(name = "FAX")
    private String fax;

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 加密
     */
    @Column(name = "SALT")
    private String salt;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 注册时间
     */
    @Column(name = "REGEDIT_TIME")
    private Date regeditTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegeditTime() {
        return regeditTime;
    }

    public void setRegeditTime(Date regeditTime) {
        this.regeditTime = regeditTime;
    }

    /**
     *加密字符
     **/
    public String getCredentialsSalt(){
        return userAccount+salt;
    }

    public UserSupplier(){
    }

    public UserSupplier(String userAccount){
        this.userAccount=userAccount;
    }
}