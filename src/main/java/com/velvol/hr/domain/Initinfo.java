package com.velvol.hr.domain;

import java.sql.Date;

//骑手初始化信息表对象
public class Initinfo implements java.io.Serializable {
   //字段：
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
	private int isok;   //离职确认状态（0：未办理完成不可离职，1：办理完成可离职）
	
	private Preworker preworker;//关联的骑手对象
	

	public Preworker getPreworker() {
		return preworker;
	}

	public void setPreworker(Preworker preworker) {
		this.preworker = preworker;
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
