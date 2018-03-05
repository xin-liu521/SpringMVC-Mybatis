package com.velvol.hr.domain;

import java.util.Date;

public class Leavereq implements java.io.Serializable{
	//骑手编号、姓名、离职原因、申请日期、所属站点编号、状态：申请离职、站长审批通过、站长驳回、已离职。申请类型：试岗期不合格申请、骑手申请、缺勤申请
    private Long id;
    private String preworkerid;//骑手编号
    private String name;//姓名
    private String reason;//离职原因
    private Date reqdate;//申请日期
    private String sreqdate;
    private Date leavedate;//离职日期
    private String sleavedate;
    private Long regionid;//区域ID
    private Long stationid;//站点ID
    private int state; //状态：0:申请离职、1:已提交   2:站长审批通过、-1:站长驳回、3：人事审批通过 4:已离职
    private int reqtype;//申请类型：0:试岗不合格、1:骑手申请、2:缺勤申请 3：站长代申请（正常申请）
    private int who; //谁发起的申请:0:骑手申请 1：站长代申请
	
    //后续补充只用来model驱动，不是数据库字段
    private String meituanid;
    private String stationname;
    private String telephone;
	private String regionname;

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public String getMeituanid() {
		return meituanid;
	}
	public void setMeituanid(String meituanid) {
		this.meituanid = meituanid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSreqdate() {
		return sreqdate;
	}
	public void setSreqdate(String sreqdate) {
		this.sreqdate = sreqdate;
	}
	public String getSleavedate() {
		return sleavedate;
	}
	public void setSleavedate(String sleavedate) {
		this.sleavedate = sleavedate;
	}
	public Leavereq() {
	
	}
	public Leavereq(String preworkerid, String name, String reason, Date reqdate, Date leavedate, Long regionid,
			Long stationid, int state, int reqtype, int who) {		
		this.preworkerid = preworkerid;
		this.name = name;
		this.reason = reason;
		this.reqdate = reqdate;
		this.leavedate = leavedate;
		this.regionid = regionid;
		this.stationid = stationid;
		this.state = state;
		this.reqtype = reqtype;
		this.who = who;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPreworkerid() {
		return preworkerid;
	}
	public void setPreworkerid(String preworkerid) {
		this.preworkerid = preworkerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getReqtype() {
		return reqtype;
	}
	public void setReqtype(int reqtype) {
		this.reqtype = reqtype;
	}
	public int getWho() {
		return who;
	}
	public void setWho(int who) {
		this.who = who;
	}
    
    
}
