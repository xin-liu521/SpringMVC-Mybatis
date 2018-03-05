package com.velvol.hr.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

//员工表对象
public class Worker  implements java.io.Serializable{
	//字段
		private String id;   //骑手编号uuid
		private String meituanid;//美团ID
		private String name; //姓名
		private String sex;  //性别
		private String cardid; //身份证号
		private String telephone;//手机号码				
		private int type;     //申请类别（0:扫码、1:人事、2：站长				
		private int getstate;  //物料领取状态：0：未领取，1：已领取				
		private String picpath;  //健康证电子文档路径
		private String picpathlzd;  //离职单电子文档路径
		private int state;   // 状态（0:预注册、1、审核通过、-1:审核未通过、-2：试用期劝退，1：待站点报到、2、试用期 3：入职完成  4：已离职） 				
		private Region region;   //所在区域	
		private Station station; //分配站点						
		private String yhcard;//银行卡号
		private String yhperson;//持卡人
		private String yhfrom; //开户行						
		private Date indate; //入职日期，即美团ID分配时间
		private String sindate;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMeituanid() {
			return meituanid;
		}
		public void setMeituanid(String meituanid) {
			this.meituanid = meituanid;
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
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getGetstate() {
			return getstate;
		}
		public void setGetstate(int getstate) {
			this.getstate = getstate;
		}
		public String getPicpath() {
			return picpath;
		}
		public void setPicpath(String picpath) {
			this.picpath = picpath;
		}
		public String getPicpathlzd() {
			return picpathlzd;
		}
		public void setPicpathlzd(String picpathlzd) {
			this.picpathlzd = picpathlzd;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public Region getRegion() {
			return region;
		}
		public void setRegion(Region region) {
			this.region = region;
		}
		public Station getStation() {
			return station;
		}
		public void setStation(Station station) {
			this.station = station;
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
		public Date getIndate() {
			return indate;
		}
		public void setIndate(Date indate) {
			this.indate = indate;
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
		   
  }
