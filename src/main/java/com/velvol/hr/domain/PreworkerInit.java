package com.velvol.hr.domain;

import java.sql.Date;

//新骑手及其初始化相关数据
public class PreworkerInit {
    
	//预注册相关数据
	private String workerid;   //骑手编号uuid
	private String name; //姓名	
	private String telephone;//手机号码
	private int initstate; //初始化状态：0：未初始化，1：已初始化	
	private int hascar;      //是否自备车：0：无，1：自备车
	private String picpath;  //健康证电子文档路径
	private int state; 
	private Long stationid;
	private String station;
	
	//初始化相关数据
	private Long id; //数据库自增ID	
	private int isbx;  //是否购买保险（0:未、1:已购买）
	private Date bx_startdate;//保险开始时间
	private Date bx_enddate;//保险结束时间
	
	private int isht;  //是否签署劳动合同（0:未、1:已）
	private Date ht_startdate;//劳动合同开始时间
	private Date ht_enddate;//劳动合同结束时间
	
	private int isdeduct;  //是否已经扣除培训费
	private int pxmoney;  //培训费金额
	private Date kcpx_date; //扣除培训费时间
	private Date thpx_date; //培训费退还时间
	private int pxthmoney;  //培训费退还金额

	private int isok;  //离职确认状态（0：未办理完成不可离职，1：办理完成可离职）

	public Long getStationid() {
		return stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getInitstate() {
		return initstate;
	}

	public void setInitstate(int initstate) {
		this.initstate = initstate;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIsbx() {
		return isbx;
	}

	public void setIsbx(int isbx) {
		this.isbx = isbx;
	}

	public Date getBx_startdate() {
		return bx_startdate;
	}

	public void setBx_startdate(Date bx_startdate) {
		this.bx_startdate = bx_startdate;
	}

	public Date getBx_enddate() {
		return bx_enddate;
	}

	public void setBx_enddate(Date bx_enddate) {
		this.bx_enddate = bx_enddate;
	}

	public int getIsht() {
		return isht;
	}

	public void setIsht(int isht) {
		this.isht = isht;
	}

	public Date getHt_startdate() {
		return ht_startdate;
	}

	public void setHt_startdate(Date ht_startdate) {
		this.ht_startdate = ht_startdate;
	}

	public Date getHt_enddate() {
		return ht_enddate;
	}

	public void setHt_enddate(Date ht_enddate) {
		this.ht_enddate = ht_enddate;
	}

	public int getIsdeduct() {
		return isdeduct;
	}

	public void setIsdeduct(int isdeduct) {
		this.isdeduct = isdeduct;
	}

	public int getPxmoney() {
		return pxmoney;
	}

	public void setPxmoney(int pxmoney) {
		this.pxmoney = pxmoney;
	}

	public Date getKcpx_date() {
		return kcpx_date;
	}

	public void setKcpx_date(Date kcpx_date) {
		this.kcpx_date = kcpx_date;
	}

	public Date getThpx_date() {
		return thpx_date;
	}

	public void setThpx_date(Date thpx_date) {
		this.thpx_date = thpx_date;
	}

	public int getPxthmoney() {
		return pxthmoney;
	}

	public void setPxthmoney(int pxthmoney) {
		this.pxthmoney = pxthmoney;
	}

	public int getIsok() {
		return isok;
	}

	public void setIsok(int isok) {
		this.isok = isok;
	}
	
	
	
}
