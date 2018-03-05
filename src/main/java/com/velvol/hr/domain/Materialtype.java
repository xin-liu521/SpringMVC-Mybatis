package com.velvol.hr.domain;

public class Materialtype {

	private Long id; //数据库自增ID
	private String name; //物料分类名称
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
	
	
}
