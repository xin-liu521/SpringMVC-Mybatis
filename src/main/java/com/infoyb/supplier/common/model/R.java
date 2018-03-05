package com.infoyb.supplier.common.model;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>ProjectName : infoyb-common </dt>
 * <dt>PakageName : com.infoyb.common.model </dt>
 * <dt>ClassName: R </dt>
 * <dd>CreateDate: 2017-07-21 15:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: controller 返回结果类     </dd>
 * </dl>
 *
 * @author Minty
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
	}
	
	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok() {
		return new R();
	}


	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}


	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}


	public static R ok(PageInfo pageInfo) {
		R r = new R();
		Map<String, Object> map = new HashMap<>();
		if (null != pageInfo){
			map.put("total", pageInfo.getTotal());
			map.put("rows", pageInfo.getList());
		}
		r.putAll(map);
		return r;
	}



}
