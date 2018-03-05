package com.velvol.hr.domain;

import java.util.Date;

//考勤日期表对象:记录站点当日的考勤是否已经添加到考勤表
public class Kaoqindate implements java.io.Serializable {
	 //字段：
	private Long id; //数据库自增ID
	private Long regionid; //区域ID 
	private Long stationid; //站点ID 
	
	private Date kqdate;//考勤日期

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegionid() {
		return regionid;
	}

	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}

	public Long getStationid() {
		return stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}

	public Date getKqdate() {
		return kqdate;
	}

	public void setKqdate(Date kqdate) {
		this.kqdate = kqdate;
	}

	
	
}
