package com.velvol.hr.domain;

import java.util.Date;

public class Kaoqinbj implements java.io.Serializable {

	private Long id; //数据库自增ID
	private Long stationid; //站点ID 
	private String stationname;//站点名称
	private String workerid;//员工id
	private String name;
	private String meituanid;
	private String telephone;
	private Date kqdate;//考勤日期
	private String remark;	
	private String regionname;
	
	private int zcstate=0; //早餐班状态：0:为考勤 1:出勤  4:调休  5:迟到  6:事假    7:病假   8:旷工   9:其他
	private int btstate=0; //正常班
	private int yxstate=0; //夜宵班
	
	
	public int getZcstate() {
		return zcstate;
	}
	public void setZcstate(int zcstate) {
		this.zcstate = zcstate;
	}
	public int getBtstate() {
		return btstate;
	}
	public void setBtstate(int btstate) {
		this.btstate = btstate;
	}
	public int getYxstate() {
		return yxstate;
	}
	public void setYxstate(int yxstate) {
		this.yxstate = yxstate;
	}
	public String getRegionname() {
		return "北京";
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private int state=0; //0：未考勤  1:早餐班   2:正常班  3:夜宵班  4:调休  5:迟到  6:事假    7:病假   8:缺勤   9:其他

	private int issubmit=0;//是否提交了考勤：0：未提交  1：提交
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIssubmit() {
		return issubmit;
	}

	public void setIssubmit(int issubmit) {
		this.issubmit = issubmit;
	}

	public Long getStationid() {
		return stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}

	public String getStationname() {
		return stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeituanid() {
		return meituanid;
	}

	public void setMeituanid(String meituanid) {
		this.meituanid = meituanid;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getKqdate() {
		return kqdate;
	}

	public void setKqdate(Date kqdate) {
		this.kqdate = kqdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
