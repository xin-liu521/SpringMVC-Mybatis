package com.velvol.hr.domain;

import java.util.HashSet;
import java.util.Set;

//区域表对象
public class Region implements java.io.Serializable {
   //字段：区域ID、区域编号、区域名称、办公地址、区域经理、电话、联系人、电话、备注
	private Long id; //数据库自增ID
	private String regionbh; //区域编号：人工录入
	private String name; //区域名称	
	private String addr; //区域地址
	private String manager; //区域经理
	private String managertel; //区域经理电话
	private String linkman; //联系人
	private String linkmantel; //联系人电话
	private String remark; //备注
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegionbh() {
		return regionbh;
	}

	public void setRegionbh(String regionbh) {
		this.regionbh = regionbh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagertel() {
		return managertel;
	}

	public void setManagertel(String managertel) {
		this.managertel = managertel;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
