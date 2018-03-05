package com.velvol.hr.domain;

import java.sql.Timestamp;
import java.util.Date;

//物料表对象
public class Material implements java.io.Serializable {
   //字段：
	private Long id; //数据库自增ID
	private String preworkerid;
	private String name; //物料名称
	private String materialbh;  //物料编号
	private String yardage; //物料规格尺码
	private String sort;//物料种类:春夏秋冬
	
	private int isback;    //是否已归还（0:未归还、1:已归还）
	private int backtype;   //归还方式（0:未归还、1:正常归还、2:丢失赔偿、3:折价赔偿）	
	private String handledesc; //赔偿处理说明
		
	private Date getdate; //领取日期
	private Date backdate; //归还日期
	
	//发放状态描述文字
	private String statedesc;
	//经手人
	private String broker;
	
	
	//多对一
	//private Preworker preworker;
	
	
	public String getStatedesc() {
		return statedesc;
	}
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public void setStatedesc(String statedesc) {
		this.statedesc = statedesc;
	}
	public Long getId() {
		return id;
	}
	public Date getGetdate() {
		return getdate;
	}
	public void setGetdate(Date getdate) {
		this.getdate = getdate;
	}
	public Date getBackdate() {
		return backdate;
	}
	public void setBackdate(Date backdate) {
		this.backdate = backdate;
	}
	public String getPreworkerid() {
		return preworkerid;
	}
	public void setPreworkerid(String preworkerid) {
		this.preworkerid = preworkerid;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaterialbh() {
		return materialbh;
	}
	public void setMaterialbh(String materialbh) {
		this.materialbh = materialbh;
	}
	public String getYardage() {
		return yardage;
	}
	public void setYardage(String yardage) {
		this.yardage = yardage;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getIsback() {
		return isback;
	}
	public void setIsback(int isback) {
		this.isback = isback;
	}
	public int getBacktype() {
		return backtype;
	}
	public void setBacktype(int backtype) {
		this.backtype = backtype;
	}
	public String getHandledesc() {
		return handledesc;
	}
	public void setHandledesc(String handledesc) {
		this.handledesc = handledesc;
	}
	
	
	
}
