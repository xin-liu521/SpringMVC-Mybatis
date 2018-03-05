package com.infoyb.supplier.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CODE_OUTUNIT")
public class CodeOutunit {
    /**
     * id 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CODE_OUTUNIT_SEQ.nextval from dual")
    private String id;

    /**
     * 单位代码

     */
    @Column(name = "CODE")
    private String code;

    /**
     * 单位全称

     */
    @Column(name = "FULLNAME")
    private String fullname;

    /**
     * 单位简称

     */
    @Column(name = "SHORTNAME")
    private String shortname;

    /**
     * 英文全称

     */
    @Column(name = "EN_FULLNAME")
    private String enFullname;

    /**
     * 英文简称

     */
    @Column(name = "EN_SHORTNAME")
    private String enShortname;

    /**
     * 单位性质(1:企业
2:政府机关
3：非盈利性事业单位
4：盈利性事业单位
5：军队
6：外国企业 7：个人)
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 工商登记证号

     */
    @Column(name = "GSDJH")
    private String gsdjh;

    /**
     * 税务登记证号

     */
    @Column(name = "SWDJH")
    private String swdjh;

    /**
     * 全国组织机构代码

     */
    @Column(name = "ZZJGM")
    private String zzjgm;

    /**
     * 证明材料编号 (暂时没用 可能需要没有证件号的录入 自动生成)
     */
    @Column(name = "ZMCL_ID")
    private String zmclId;

    /**
     * 是否客户(0：否，1：是)
     */
    @Column(name = "ISCUSTOMER")
    private String iscustomer;

    /**
     * 是否供应商(0：否，1：是)
     */
    @Column(name = "ISPROVIDER")
    private String isprovider;

    /**
     * 国家
     */
    @Column(name = "COUNTRY")
    private String country;

    /**
     * 地区
     */
    @Column(name = "AREA")
    private String area;

    /**
     * 地区城市
     */
    @Column(name = "CITY")
    private String city;

    /**
     * 地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 邮政编码
     */
    @Column(name = "POSTCODE")
    private String postcode;

    /**
     * 语种代码
     */
    @Column(name = "LANAGUECODE")
    private String lanaguecode;

    /**
     * 电话号码
     */
    @Column(name = "TEL")
    private String tel;

    /**
     * 电话分机号
     */
    @Column(name = "TEL_EXT")
    private String telExt;

    /**
     * 传真号
     */
    @Column(name = "FAX")
    private String fax;

    /**
     * 传真分机号
     */
    @Column(name = "FAX_EXT")
    private String faxExt;

    /**
     * 电子邮件地址
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 流程状态标识 0/导入，1/有错误，2/警告，3/无错误，4/审核通过，5/待审核，6/被拒绝
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 提交时间
     */
    @Column(name = "SUBMIT_TIME")
    private Date submitTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 注册资金
     */
    @Column(name = "REGISTERCAPITAL")
    private String registercapital;

    /**
     * 个人有效证件号
     */
    @Column(name = "GRYXZJ")
    private String gryxzj;

    /**
     * 客户冻结表示 1: 活动 2: 冻结
     */
    @Column(name = "FREEZE_STATUS_CUS")
    private String freezeStatusCus;

    /**
     * 供应商冻结表示 1: 活动  2 冻结
     */
    @Column(name = "FREEZE_STATUS_SUP")
    private String freezeStatusSup;

    /**
     * 创建人id
     */
    @Column(name = "CREATOR_ID")
    private String creatorId;

    /**
     * 创建人名称
     */
    @Column(name = "CREATOR_NAME")
    private String creatorName;

    /**
     * 创建时间
     */
    @Column(name = "CREATOR_TIME")
    private Date creatorTime;

    /**
     * 修改人id
     */
    @Column(name = "UPDATE_UID")
    private String updateUid;

    /**
     * 修改人名称
     */
    @Column(name = "UPDATE_UNAME")
    private String updateUname;

    /**
     * 数据状态   1: 活动  2: 冻结
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 扩展字段2
     */
    @Column(name = "REMARK2")
    private String remark2;

    /**
     * 扩展字段1
     */
    @Column(name = "REMARK1")
    private String remark1;

    /**
     * 扩展字段4
     */
    @Column(name = "REMARK4")
    private String remark4;

    /**
     * 扩展字段3
     */
    @Column(name = "REMARK3")
    private String remark3;

    /**
     * 扩展字段5
     */
    @Column(name = "REMARK5")
    private String remark5;

    /**
     * 版本号
     */
    @Column(name = "VERSION")
    private String version;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 提示信息
     */
    @Column(name = "ERRTEXT")
    private String errtext;

    /**
     * 单位类型(0:生产厂家、1贸易商、2生产厂家及贸易商)
     */
    @Column(name = "DWLX")
    private String dwlx;

    /**
     * 是否三证合一(0：否，1：是)
     */
    @Column(name = "SZHY")
    private String szhy;

    /**
     * 统一社会信用代码
     */
    @Column(name = "SHXYDM")
    private String shxydm;

    /**
     * 法人
     */
    @Column(name = "LEGALPERSION")
    private String legalpersion;

    /**
     * 注册资金币种(0:万人民币、1:万美元、2:万欧元、3:万港币)
     */
    @Column(name = "REGISTERCAPITAL_TYPE")
    private String registercapitalType;

    /**
     * 联系人/委托代理人
     */
    @Column(name = "ENTRUSTED_AGENT")
    private String entrustedAgent;

    /**
     * 扩展字段6
     */
    @Column(name = "REMARK6")
    private String remark6;

    /**
     * 扩展字段7
     */
    @Column(name = "REMARK7")
    private String remark7;

    /**
     * 扩展字段8
     */
    @Column(name = "REMARK8")
    private String remark8;

    /**
     * 扩展字段9
     */
    @Column(name = "REMARK9")
    private String remark9;

    /**
     * 扩展字段10
     */
    @Column(name = "REMARK10")
    private String remark10;

    /**
     * 所属集团公司（0已选   1未选）
     */
    @Column(name = "SS_ORGANIZATION")
    private String ssOrganization;

    /**
     * 客户分类（0已选  1未选）
     */
    @Column(name = "CLIENT_TYPE")
    private String clientType;

    /**
     * 产品分类（0已选  1未选）
     */
    @Column(name = "PRODUCT_TYPE")
    private String productType;

    /**
     * 客商平台主键id
     */
    @Column(name = "BY_APPROVE_ID")
    private Long byApproveId;

    /**
     * 是否危化品 （0是 1否）
     */
    @Column(name = "IS_HAZARDOUS")
    private String isHazardous;

    /**
     * 联系人电话
     */
    @Column(name = "CONTACTS_NUMBER")
    private String contactsNumber;

    /**
     * 联系人
     */
    @Column(name = "CONTACTS")
    private String contacts;

    /**
     * web地址
     */
    @Column(name = "WEB_SITE")
    private String webSite;

    /**
     * 经济类型
     */
    @Column(name = "ECONOMIC_TYPE")
    private String economicType;

    /**
     * 客户分类ID
     */
    @Column(name = "CLIENT_TYPE_ID")
    private String clientTypeId;

    /**
     * 客户分类名称
     */
    @Column(name = "CLIENT_TYPE_NAME")
    private String clientTypeName;

    /**
     * 获取id 主键
     *
     * @return ID - id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id 主键
     *
     * @param id id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取单位代码

     *
     * @return CODE - 单位代码

     */
    public String getCode() {
        return code;
    }

    /**
     * 设置单位代码

     *
     * @param code 单位代码

     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取单位全称

     *
     * @return FULLNAME - 单位全称

     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置单位全称

     *
     * @param fullname 单位全称

     */
    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    /**
     * 获取单位简称

     *
     * @return SHORTNAME - 单位简称

     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置单位简称

     *
     * @param shortname 单位简称

     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    /**
     * 获取英文全称

     *
     * @return EN_FULLNAME - 英文全称

     */
    public String getEnFullname() {
        return enFullname;
    }

    /**
     * 设置英文全称

     *
     * @param enFullname 英文全称

     */
    public void setEnFullname(String enFullname) {
        this.enFullname = enFullname == null ? null : enFullname.trim();
    }

    /**
     * 获取英文简称

     *
     * @return EN_SHORTNAME - 英文简称

     */
    public String getEnShortname() {
        return enShortname;
    }

    /**
     * 设置英文简称

     *
     * @param enShortname 英文简称

     */
    public void setEnShortname(String enShortname) {
        this.enShortname = enShortname == null ? null : enShortname.trim();
    }

    /**
     * 获取单位性质(1:企业
2:政府机关
3：非盈利性事业单位
4：盈利性事业单位
5：军队
6：外国企业 7：个人)
     *
     * @return TYPE - 单位性质(1:企业
2:政府机关
3：非盈利性事业单位
4：盈利性事业单位
5：军队
6：外国企业 7：个人)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置单位性质(1:企业
2:政府机关
3：非盈利性事业单位
4：盈利性事业单位
5：军队
6：外国企业 7：个人)
     *
     * @param type 单位性质(1:企业
2:政府机关
3：非盈利性事业单位
4：盈利性事业单位
5：军队
6：外国企业 7：个人)
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取工商登记证号

     *
     * @return GSDJH - 工商登记证号

     */
    public String getGsdjh() {
        return gsdjh;
    }

    /**
     * 设置工商登记证号

     *
     * @param gsdjh 工商登记证号

     */
    public void setGsdjh(String gsdjh) {
        this.gsdjh = gsdjh == null ? null : gsdjh.trim();
    }

    /**
     * 获取税务登记证号

     *
     * @return SWDJH - 税务登记证号

     */
    public String getSwdjh() {
        return swdjh;
    }

    /**
     * 设置税务登记证号

     *
     * @param swdjh 税务登记证号

     */
    public void setSwdjh(String swdjh) {
        this.swdjh = swdjh == null ? null : swdjh.trim();
    }

    /**
     * 获取全国组织机构代码

     *
     * @return ZZJGM - 全国组织机构代码

     */
    public String getZzjgm() {
        return zzjgm;
    }

    /**
     * 设置全国组织机构代码

     *
     * @param zzjgm 全国组织机构代码

     */
    public void setZzjgm(String zzjgm) {
        this.zzjgm = zzjgm == null ? null : zzjgm.trim();
    }

    /**
     * 获取证明材料编号 (暂时没用 可能需要没有证件号的录入 自动生成)
     *
     * @return ZMCL_ID - 证明材料编号 (暂时没用 可能需要没有证件号的录入 自动生成)
     */
    public String getZmclId() {
        return zmclId;
    }

    /**
     * 设置证明材料编号 (暂时没用 可能需要没有证件号的录入 自动生成)
     *
     * @param zmclId 证明材料编号 (暂时没用 可能需要没有证件号的录入 自动生成)
     */
    public void setZmclId(String zmclId) {
        this.zmclId = zmclId == null ? null : zmclId.trim();
    }

    /**
     * 获取是否客户(0：否，1：是)
     *
     * @return ISCUSTOMER - 是否客户(0：否，1：是)
     */
    public String getIscustomer() {
        return iscustomer;
    }

    /**
     * 设置是否客户(0：否，1：是)
     *
     * @param iscustomer 是否客户(0：否，1：是)
     */
    public void setIscustomer(String iscustomer) {
        this.iscustomer = iscustomer == null ? null : iscustomer.trim();
    }

    /**
     * 获取是否供应商(0：否，1：是)
     *
     * @return ISPROVIDER - 是否供应商(0：否，1：是)
     */
    public String getIsprovider() {
        return isprovider;
    }

    /**
     * 设置是否供应商(0：否，1：是)
     *
     * @param isprovider 是否供应商(0：否，1：是)
     */
    public void setIsprovider(String isprovider) {
        this.isprovider = isprovider == null ? null : isprovider.trim();
    }

    /**
     * 获取国家
     *
     * @return COUNTRY - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取地区
     *
     * @return AREA - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取地区城市
     *
     * @return CITY - 地区城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置地区城市
     *
     * @param city 地区城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取地址
     *
     * @return ADDRESS - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取邮政编码
     *
     * @return POSTCODE - 邮政编码
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮政编码
     *
     * @param postcode 邮政编码
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * 获取语种代码
     *
     * @return LANAGUECODE - 语种代码
     */
    public String getLanaguecode() {
        return lanaguecode;
    }

    /**
     * 设置语种代码
     *
     * @param lanaguecode 语种代码
     */
    public void setLanaguecode(String lanaguecode) {
        this.lanaguecode = lanaguecode == null ? null : lanaguecode.trim();
    }

    /**
     * 获取电话号码
     *
     * @return TEL - 电话号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话号码
     *
     * @param tel 电话号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取电话分机号
     *
     * @return TEL_EXT - 电话分机号
     */
    public String getTelExt() {
        return telExt;
    }

    /**
     * 设置电话分机号
     *
     * @param telExt 电话分机号
     */
    public void setTelExt(String telExt) {
        this.telExt = telExt == null ? null : telExt.trim();
    }

    /**
     * 获取传真号
     *
     * @return FAX - 传真号
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真号
     *
     * @param fax 传真号
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取传真分机号
     *
     * @return FAX_EXT - 传真分机号
     */
    public String getFaxExt() {
        return faxExt;
    }

    /**
     * 设置传真分机号
     *
     * @param faxExt 传真分机号
     */
    public void setFaxExt(String faxExt) {
        this.faxExt = faxExt == null ? null : faxExt.trim();
    }

    /**
     * 获取电子邮件地址
     *
     * @return EMAIL - 电子邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件地址
     *
     * @param email 电子邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取流程状态标识 0/导入，1/有错误，2/警告，3/无错误，4/审核通过，5/待审核，6/被拒绝
     *
     * @return STATE - 流程状态标识 0/导入，1/有错误，2/警告，3/无错误，4/审核通过，5/待审核，6/被拒绝
     */
    public String getState() {
        return state;
    }

    /**
     * 设置流程状态标识 0/导入，1/有错误，2/警告，3/无错误，4/审核通过，5/待审核，6/被拒绝
     *
     * @param state 流程状态标识 0/导入，1/有错误，2/警告，3/无错误，4/审核通过，5/待审核，6/被拒绝
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取提交时间
     *
     * @return SUBMIT_TIME - 提交时间
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * 设置提交时间
     *
     * @param submitTime 提交时间
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * 获取修改时间
     *
     * @return UPDATE_TIME - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取注册资金
     *
     * @return REGISTERCAPITAL - 注册资金
     */
    public String getRegistercapital() {
        return registercapital;
    }

    /**
     * 设置注册资金
     *
     * @param registercapital 注册资金
     */
    public void setRegistercapital(String registercapital) {
        this.registercapital = registercapital == null ? null : registercapital.trim();
    }

    /**
     * 获取个人有效证件号
     *
     * @return GRYXZJ - 个人有效证件号
     */
    public String getGryxzj() {
        return gryxzj;
    }

    /**
     * 设置个人有效证件号
     *
     * @param gryxzj 个人有效证件号
     */
    public void setGryxzj(String gryxzj) {
        this.gryxzj = gryxzj == null ? null : gryxzj.trim();
    }

    /**
     * 获取客户冻结表示 1: 活动 2: 冻结
     *
     * @return FREEZE_STATUS_CUS - 客户冻结表示 1: 活动 2: 冻结
     */
    public String getFreezeStatusCus() {
        return freezeStatusCus;
    }

    /**
     * 设置客户冻结表示 1: 活动 2: 冻结
     *
     * @param freezeStatusCus 客户冻结表示 1: 活动 2: 冻结
     */
    public void setFreezeStatusCus(String freezeStatusCus) {
        this.freezeStatusCus = freezeStatusCus == null ? null : freezeStatusCus.trim();
    }

    /**
     * 获取供应商冻结表示 1: 活动  2 冻结
     *
     * @return FREEZE_STATUS_SUP - 供应商冻结表示 1: 活动  2 冻结
     */
    public String getFreezeStatusSup() {
        return freezeStatusSup;
    }

    /**
     * 设置供应商冻结表示 1: 活动  2 冻结
     *
     * @param freezeStatusSup 供应商冻结表示 1: 活动  2 冻结
     */
    public void setFreezeStatusSup(String freezeStatusSup) {
        this.freezeStatusSup = freezeStatusSup == null ? null : freezeStatusSup.trim();
    }

    /**
     * 获取创建人id
     *
     * @return CREATOR_ID - 创建人id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 获取创建人名称
     *
     * @return CREATOR_NAME - 创建人名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置创建人名称
     *
     * @param creatorName 创建人名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATOR_TIME - 创建时间
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 设置创建时间
     *
     * @param creatorTime 创建时间
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    /**
     * 获取修改人id
     *
     * @return UPDATE_UID - 修改人id
     */
    public String getUpdateUid() {
        return updateUid;
    }

    /**
     * 设置修改人id
     *
     * @param updateUid 修改人id
     */
    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid == null ? null : updateUid.trim();
    }

    /**
     * 获取修改人名称
     *
     * @return UPDATE_UNAME - 修改人名称
     */
    public String getUpdateUname() {
        return updateUname;
    }

    /**
     * 设置修改人名称
     *
     * @param updateUname 修改人名称
     */
    public void setUpdateUname(String updateUname) {
        this.updateUname = updateUname == null ? null : updateUname.trim();
    }

    /**
     * 获取数据状态   1: 活动  2: 冻结
     *
     * @return STATUS - 数据状态   1: 活动  2: 冻结
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置数据状态   1: 活动  2: 冻结
     *
     * @param status 数据状态   1: 活动  2: 冻结
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取扩展字段2
     *
     * @return REMARK2 - 扩展字段2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 设置扩展字段2
     *
     * @param remark2 扩展字段2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 获取扩展字段1
     *
     * @return REMARK1 - 扩展字段1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 设置扩展字段1
     *
     * @param remark1 扩展字段1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    /**
     * 获取扩展字段4
     *
     * @return REMARK4 - 扩展字段4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 设置扩展字段4
     *
     * @param remark4 扩展字段4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 获取扩展字段3
     *
     * @return REMARK3 - 扩展字段3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 设置扩展字段3
     *
     * @param remark3 扩展字段3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 获取扩展字段5
     *
     * @return REMARK5 - 扩展字段5
     */
    public String getRemark5() {
        return remark5;
    }

    /**
     * 设置扩展字段5
     *
     * @param remark5 扩展字段5
     */
    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }

    /**
     * 获取版本号
     *
     * @return VERSION - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取提示信息
     *
     * @return ERRTEXT - 提示信息
     */
    public String getErrtext() {
        return errtext;
    }

    /**
     * 设置提示信息
     *
     * @param errtext 提示信息
     */
    public void setErrtext(String errtext) {
        this.errtext = errtext == null ? null : errtext.trim();
    }

    /**
     * 获取单位类型(0:生产厂家、1贸易商、2生产厂家及贸易商)
     *
     * @return DWLX - 单位类型(0:生产厂家、1贸易商、2生产厂家及贸易商)
     */
    public String getDwlx() {
        return dwlx;
    }

    /**
     * 设置单位类型(0:生产厂家、1贸易商、2生产厂家及贸易商)
     *
     * @param dwlx 单位类型(0:生产厂家、1贸易商、2生产厂家及贸易商)
     */
    public void setDwlx(String dwlx) {
        this.dwlx = dwlx == null ? null : dwlx.trim();
    }

    /**
     * 获取是否三证合一(0：否，1：是)
     *
     * @return SZHY - 是否三证合一(0：否，1：是)
     */
    public String getSzhy() {
        return szhy;
    }

    /**
     * 设置是否三证合一(0：否，1：是)
     *
     * @param szhy 是否三证合一(0：否，1：是)
     */
    public void setSzhy(String szhy) {
        this.szhy = szhy == null ? null : szhy.trim();
    }

    /**
     * 获取统一社会信用代码
     *
     * @return SHXYDM - 统一社会信用代码
     */
    public String getShxydm() {
        return shxydm;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param shxydm 统一社会信用代码
     */
    public void setShxydm(String shxydm) {
        this.shxydm = shxydm == null ? null : shxydm.trim();
    }

    /**
     * 获取法人
     *
     * @return LEGALPERSION - 法人
     */
    public String getLegalpersion() {
        return legalpersion;
    }

    /**
     * 设置法人
     *
     * @param legalpersion 法人
     */
    public void setLegalpersion(String legalpersion) {
        this.legalpersion = legalpersion == null ? null : legalpersion.trim();
    }

    /**
     * 获取注册资金币种(0:万人民币、1:万美元、2:万欧元、3:万港币)
     *
     * @return REGISTERCAPITAL_TYPE - 注册资金币种(0:万人民币、1:万美元、2:万欧元、3:万港币)
     */
    public String getRegistercapitalType() {
        return registercapitalType;
    }

    /**
     * 设置注册资金币种(0:万人民币、1:万美元、2:万欧元、3:万港币)
     *
     * @param registercapitalType 注册资金币种(0:万人民币、1:万美元、2:万欧元、3:万港币)
     */
    public void setRegistercapitalType(String registercapitalType) {
        this.registercapitalType = registercapitalType == null ? null : registercapitalType.trim();
    }

    /**
     * 获取联系人/委托代理人
     *
     * @return ENTRUSTED_AGENT - 联系人/委托代理人
     */
    public String getEntrustedAgent() {
        return entrustedAgent;
    }

    /**
     * 设置联系人/委托代理人
     *
     * @param entrustedAgent 联系人/委托代理人
     */
    public void setEntrustedAgent(String entrustedAgent) {
        this.entrustedAgent = entrustedAgent == null ? null : entrustedAgent.trim();
    }

    /**
     * 获取扩展字段6
     *
     * @return REMARK6 - 扩展字段6
     */
    public String getRemark6() {
        return remark6;
    }

    /**
     * 设置扩展字段6
     *
     * @param remark6 扩展字段6
     */
    public void setRemark6(String remark6) {
        this.remark6 = remark6 == null ? null : remark6.trim();
    }

    /**
     * 获取扩展字段7
     *
     * @return REMARK7 - 扩展字段7
     */
    public String getRemark7() {
        return remark7;
    }

    /**
     * 设置扩展字段7
     *
     * @param remark7 扩展字段7
     */
    public void setRemark7(String remark7) {
        this.remark7 = remark7 == null ? null : remark7.trim();
    }

    /**
     * 获取扩展字段8
     *
     * @return REMARK8 - 扩展字段8
     */
    public String getRemark8() {
        return remark8;
    }

    /**
     * 设置扩展字段8
     *
     * @param remark8 扩展字段8
     */
    public void setRemark8(String remark8) {
        this.remark8 = remark8 == null ? null : remark8.trim();
    }

    /**
     * 获取扩展字段9
     *
     * @return REMARK9 - 扩展字段9
     */
    public String getRemark9() {
        return remark9;
    }

    /**
     * 设置扩展字段9
     *
     * @param remark9 扩展字段9
     */
    public void setRemark9(String remark9) {
        this.remark9 = remark9 == null ? null : remark9.trim();
    }

    /**
     * 获取扩展字段10
     *
     * @return REMARK10 - 扩展字段10
     */
    public String getRemark10() {
        return remark10;
    }

    /**
     * 设置扩展字段10
     *
     * @param remark10 扩展字段10
     */
    public void setRemark10(String remark10) {
        this.remark10 = remark10 == null ? null : remark10.trim();
    }

    /**
     * 获取所属集团公司（0已选   1未选）
     *
     * @return SS_ORGANIZATION - 所属集团公司（0已选   1未选）
     */
    public String getSsOrganization() {
        return ssOrganization;
    }

    /**
     * 设置所属集团公司（0已选   1未选）
     *
     * @param ssOrganization 所属集团公司（0已选   1未选）
     */
    public void setSsOrganization(String ssOrganization) {
        this.ssOrganization = ssOrganization == null ? null : ssOrganization.trim();
    }

    /**
     * 获取客户分类（0已选  1未选）
     *
     * @return CLIENT_TYPE - 客户分类（0已选  1未选）
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 设置客户分类（0已选  1未选）
     *
     * @param clientType 客户分类（0已选  1未选）
     */
    public void setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
    }

    /**
     * 获取产品分类（0已选  1未选）
     *
     * @return PRODUCT_TYPE - 产品分类（0已选  1未选）
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置产品分类（0已选  1未选）
     *
     * @param productType 产品分类（0已选  1未选）
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * 获取客商平台主键id
     *
     * @return BY_APPROVE_ID - 客商平台主键id
     */
    public Long getByApproveId() {
        return byApproveId;
    }

    /**
     * 设置客商平台主键id
     *
     * @param byApproveId 客商平台主键id
     */
    public void setByApproveId(Long byApproveId) {
        this.byApproveId = byApproveId;
    }

    /**
     * 获取是否危化品 （0是 1否）
     *
     * @return IS_HAZARDOUS - 是否危化品 （0是 1否）
     */
    public String getIsHazardous() {
        return isHazardous;
    }

    /**
     * 设置是否危化品 （0是 1否）
     *
     * @param isHazardous 是否危化品 （0是 1否）
     */
    public void setIsHazardous(String isHazardous) {
        this.isHazardous = isHazardous == null ? null : isHazardous.trim();
    }

    /**
     * 获取联系人电话
     *
     * @return CONTACTS_NUMBER - 联系人电话
     */
    public String getContactsNumber() {
        return contactsNumber;
    }

    /**
     * 设置联系人电话
     *
     * @param contactsNumber 联系人电话
     */
    public void setContactsNumber(String contactsNumber) {
        this.contactsNumber = contactsNumber == null ? null : contactsNumber.trim();
    }

    /**
     * 获取联系人
     *
     * @return CONTACTS - 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     *
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取web地址
     *
     * @return WEB_SITE - web地址
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * 设置web地址
     *
     * @param webSite web地址
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    /**
     * 获取经济类型
     *
     * @return ECONOMIC_TYPE - 经济类型
     */
    public String getEconomicType() {
        return economicType;
    }

    /**
     * 设置经济类型
     *
     * @param economicType 经济类型
     */
    public void setEconomicType(String economicType) {
        this.economicType = economicType == null ? null : economicType.trim();
    }

    /**
     * 获取客户分类ID
     *
     * @return CLIENT_TYPE_ID - 客户分类ID
     */
    public String getClientTypeId() {
        return clientTypeId;
    }

    /**
     * 设置客户分类ID
     *
     * @param clientTypeId 客户分类ID
     */
    public void setClientTypeId(String clientTypeId) {
        this.clientTypeId = clientTypeId == null ? null : clientTypeId.trim();
    }

    /**
     * 获取客户分类名称
     *
     * @return CLIENT_TYPE_NAME - 客户分类名称
     */
    public String getClientTypeName() {
        return clientTypeName;
    }

    /**
     * 设置客户分类名称
     *
     * @param clientTypeName 客户分类名称
     */
    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName == null ? null : clientTypeName.trim();
    }
}