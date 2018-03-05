package com.velvol.hr.utils;

public class Result {
   private Boolean success;
   private String picpath;

//	public Result(boolean result, String msg) {
//		this.success = result;
//		this.picpath = msg;
//	}
public Boolean getSuccess() {
	return success;
}
public void setSuccess(Boolean success) {
	this.success = success;
}
public String getPicpath() {
	return picpath;
}
public void setPicpath(String picpath) {
	this.picpath = picpath;
}
   
   
}
