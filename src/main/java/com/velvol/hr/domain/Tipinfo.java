package com.velvol.hr.domain;

//提示信息表对象
public class Tipinfo implements java.io.Serializable{
	
	private int id; //数据库自增ID	
	private int type=0; //提示类型：0：预申请	
	private String content; //提示内容
	private Long  regionid;//提示所属区域编号
	private String name;
	private String linkman;
	private String linkmantel;
	private String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmantel() {
		return linkmantel;
	}

	public void setLinkmantel(String linkmantel) {
		this.linkmantel = linkmantel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getRegionid() {
		return regionid;
	}
	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}
	
}
