package com.infoyb.supplier.system.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 接受页面传入参数的辅助类
 * 
 * @author yongrong
 * 
 */
public class RequestParamMap {

	public static Map<String, Object> getRequestParamMap(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> e = request.getParameterNames();
			Map<String, Object> map = new HashMap<String, Object>();
			while (e.hasMoreElements()) {
				String string = (String) e.nextElement();
				if (request.getParameter(string) != null && !request.getParameter(string).equals("")) {
					String[] arry = request.getParameterValues(string);
					if (arry.length>1) {
						map.put(string, arry);
					}else {
						map.put(string, request.getParameter(string));
					}
				}
			}
			return map;
		} catch (Exception e) {
			return new HashMap<String, Object>();
		}

	}
	/**
	 * 获取单键多值的请求参数
	 * @param request
	 * @return
	 */
	public static Map<String, String[]> getRequestParamsMap(HttpServletRequest request) {
		try {
			Enumeration<String> e = request.getParameterNames();
			Map<String,  String[]> map = new HashMap<String,  String[]>();
			while (e.hasMoreElements()) {
				String string = (String) e.nextElement();
				if (request.getParameter(string) != null && !request.getParameter(string).equals("")) {
					map.put(string, request.getParameterValues(string));
				}
			}
			return map;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取用户request类
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
