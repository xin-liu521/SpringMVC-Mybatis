package com.velvol.hr.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.velvol.hr.domain.User;


public class SessionUtils {
	//获取session对象
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	//获取登录用户对象
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
	}
}
