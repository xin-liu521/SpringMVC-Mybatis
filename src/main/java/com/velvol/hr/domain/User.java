package com.velvol.hr.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//用户表对象
public class User implements java.io.Serializable{
    //字段：用户ID、骑手编号、帐号、密码、区域id、站点id、角色（骑手、人事、站长等后续补充）
	private String id;
	private String username;//帐号
	private String password;//密码
	
	private Long regionid;//区域id
	private String regionName;//区域名
	private Long stationid;//站点id
	private String stationName;//站点名
	private String workerid;//骑手编号
	//private int roletype; //角色类型:0:骑手；1：站长 ；2：人事、区域经理；3：总部
		
	
	private Set<Role> roles = new HashSet(0);

	
	public User() {	
	}

	public User(String username, String password, Long stationid, String workerid,Long regionid) {	
		this.username = username;
		this.password = password;
		this.stationid = stationid;
		this.workerid = workerid;
		this.regionid = regionid;
	}
	
	public String getRoleName(){
		String roleName = "";
		for(Role role : roles){
			String name = role.getName();
			roleName = name;
			break;
		}
		return roleName;
	}
	
	//获取角色编码
	public String getRoleCode(){
		String roleCode = "";
		for(Role role : roles){
			String code = role.getCode();
			roleCode = code;
			break;
		}
		return roleCode;
	}
	
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	
		
}
