package com.velvol.hr.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

//表现层通用实现
public class BaseAction <T> extends ActionSupport implements ModelDriven<T> {
    //定义返回结果字符串常量
	public static final String HOME = "home";
	public static final String LIST = "list";
	
	//模型对象：接收form表单提交的参数
	protected T model;
	public T getModel() {
		return model;
	}
	
	//抽取出的分页对象，并通过参数驱动获取提交的参数：前台传递page、rows参数可以接收到
	protected PageBean pageBean = new PageBean();
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
		
	}	
	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	
	//抽取hibernate分离的标准查询对象：hibernate另外一种查询方式QBC
	DetachedCriteria detachedCriteria = null;
	
	//在构造方法中动态获取实体类型，通过反射创建model对象
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得BaseAction上声明的泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		//通过反射创建对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//创建一个分离的标准查询对象
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		//传递查询对象给pageBean
		pageBean.setDetachedCriteria(detachedCriteria);
	}

	//java对象转换为json并写回客户端
	public void java2Json(Object o ,String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json：排除哪些属性
		jsonConfig.setExcludes(exclueds);
		//java对象转换为json对象在转变成json字符串
		String json = JSONObject.fromObject(o,jsonConfig).toString();
		
		//获取设置响应头，并把json串写回
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//java对象列表list转换为json串
	public void java2Json(List o ,String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		
		//指定哪些属性不需要转json
		jsonConfig.setExcludes(exclueds);
		
		//list先转换为json数组对象，然后在转换为字符串
		String json = JSONArray.fromObject(o,jsonConfig).toString();
		System.out.println(json);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//处理时间格式转json串的混乱问题
	public void formatTime(PageBean pageBean){
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA); 
		List<Preworker> list0 = new ArrayList<Preworker>(); 
		List<Preworker> list = pageBean.getRows();
		for (Preworker preworker : list) {
			Date predate = preworker.getPredate();
			if(predate!=null){
			   String strPredate = sdf.format(predate);			
			   preworker.setSpredate(strPredate);
			}
		   Timestamp reqtime = preworker.getReqtime();
		   if(reqtime != null)
			    preworker.setSreqtime(sdf1.format(reqtime));
		   
			list0.add(preworker);
		}
		pageBean.setRows(list0);
	}
}
