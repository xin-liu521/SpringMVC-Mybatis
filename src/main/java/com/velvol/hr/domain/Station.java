package com.velvol.hr.domain;

public class Station  implements java.io.Serializable {
    //字段：区域ID、站点id、站点名称、站点地址、联系人、备注
	private Long id; //数据库自增ID	
	private String name; //站点名称	
	private String addr; //站点地址	
	private String linkman; //联系人
	private String linkmantel; //联系人电话
	private String remark; //备注
	
	public Long getRegionid() {
		return regionid;
	}

	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}

	//所属区域ID
	private Long regionid;

	
	public Long getId() {
		return id;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
