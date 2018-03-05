package com.velvol.hr.utils;

//添加物料的返回结果
public class MatResult {
   private boolean success;
   private String msg;
   
	public MatResult(boolean success, String msg) {
	this.success = success;
	this.msg = msg;
     }
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
   
   
}
