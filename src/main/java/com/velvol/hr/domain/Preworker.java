package com.velvol.hr.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//预注册员工表对象
public class Preworker implements java.io.Serializable{
	//字段
	private String id;   //骑手编号uuid
	private String name; //姓名
	private String sex;  //性别
	private String cardid; //身份证号
	private String telephone;//手机号码
	private Date predate;   //预计到岗日期
	private String spredate;   //预计到岗日期字符串
	private int type;     //申请类别（0:扫码、1:人事、2：站长）
	private Timestamp reqtime; //申请时间
	private String sreqtime; //申请时间字符串
	private String referee; //推荐人
	private int getstate;  //物料领取状态：0：未领取，1：已领取
	private int initstate; //初始化状态：0：未初始化，1：已初始化	
	private int hascar;      //是否自备车：0：无，1：自备车
	private String picpath;  //健康证电子文档路径
	private String picpathlzd;  //离职单电子文档路径
	private int state;   // 状态（0:预注册、1、审核通过、-1:审核未通过、-2：试用期劝退，1：待站点报到、2、试用期 3：入职完成 4：已离职） 
	private String faildesc;//审核未通过原因
	
	private Region region;   //所在区域	
	private Station station; //分配站点
	private Initinfo initinfo; //初始化信息
	
	//后续补充
	private String infofrom; //信息来源
	private String yhcard;//银行卡号
	private String yhperson;//持卡人regionid
	private String yhfrom; //开户行
	
	private Date baodaodate;   //报到日期
	private String sbaodaodate;   //报到日期字符串
	
	private int deltag=0;  //删除标注，0：正常未删除，-1：删除
	
	private String meituanid;//美团ID
	private Date indate; //入职日期，即美团ID分配时间
	private String sindate; 
	
	private int testresult;//试用期结果。0：无，1：合格 -1：劝退
	
	private int resttime=0;//试用期剩余天数
	
	private String sinfofrom;
	
	public String getSinfofrom() {
		return infofrom;
	}
	public void setSinfofrom(String sinfofrom) {
		this.sinfofrom = sinfofrom;
	}
	public String getPicpathlzd() {
		return picpathlzd;
	}
	public void setPicpathlzd(String picpathlzd) {
		this.picpathlzd = picpathlzd;
	}
	public int getResttime() {
		return resttime;
	}
	public void setResttime(int resttime) {
		this.resttime = resttime;
	}
	public int getTestresult() {
		return testresult;
	}
	public void setTestresult(int testresult) {
		this.testresult = testresult;
	}
	public String getSindate() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		if(indate !=null)
			sindate=sdf.format(indate);  
		
		return sindate;	
	}
	public void setSindate(String sindate) {
		this.sindate = sindate;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getMeituanid() {
		return meituanid;
	}
	public void setMeituanid(String meituanid) {
		this.meituanid = meituanid;
	}
	public Date getBaodaodate() {
		return baodaodate;
	}
	public void setBaodaodate(Date baodaodate) {
		this.baodaodate = baodaodate;
	}
	public String getSbaodaodate() {
		return sbaodaodate;
	}
	public void setSbaodaodate(String sbaodaodate) {
		this.sbaodaodate = sbaodaodate;
	}
	public String getInfofrom() {
		return infofrom;
	}
	public void setInfofrom(String infofrom) {
		this.infofrom = infofrom;
	}
	public String getYhcard() {
		return yhcard;
	}
	public void setYhcard(String yhcard) {
		this.yhcard = yhcard;
	}
	public String getYhperson() {
		return yhperson;
	}
	public void setYhperson(String yhperson) {
		this.yhperson = yhperson;
	}
	public String getYhfrom() {
		return yhfrom;
	}
	public void setYhfrom(String yhfrom) {
		this.yhfrom = yhfrom;
	}
	public Initinfo getInitinfo() {
		return initinfo;
	}
	public void setInitinfo(Initinfo initinfo) {
		this.initinfo = initinfo;
	}
	public String getSreqtime() {
		return sreqtime;
	}
	public void setSreqtime(String sreqtime) {
		this.sreqtime = sreqtime;
	}
	public String getSpredate() {
		return spredate;
	}
	public void setSpredate(String spredate) {
		this.spredate = spredate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public int getDeltag() {
		return deltag;
	}
	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Date getPredate() {
		return predate;
	}
	public void setPredate(Date predate) {
		this.predate = predate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getReqtime() {
		return reqtime;
	}
	public void setReqtime(Timestamp reqtime) {
		this.reqtime = reqtime;
	}
	public String getReferee() {
		return referee;
	}
	public void setReferee(String referee) {
		this.referee = referee;
	}
	public int getGetstate() {
		return getstate;
	}
	public void setGetstate(int getstate) {
		this.getstate = getstate;
	}
	public int getInitstate() {
		return initstate;
	}
	public void setInitstate(int initstate) {
		this.initstate = initstate;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public int getHascar() {
		return hascar;
	}
	public void setHascar(int hascar) {
		this.hascar = hascar;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getFaildesc() {
		return faildesc;
	}
	public void setFaildesc(String faildesc) {
		this.faildesc = faildesc;
	}
	
	
}
