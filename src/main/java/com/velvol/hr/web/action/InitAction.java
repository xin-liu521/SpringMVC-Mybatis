package com.velvol.hr.web.action;

import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.Statkaoqin;
import com.velvol.hr.service.IInitService;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.service.IStatkaoqinService;
import com.velvol.hr.web.action.base.BaseAction;

//初始化数据管理
@Controller   
@Scope("prototype")
public class InitAction  extends BaseAction<Statkaoqin> {

	//属性驱动，接收页面输入的区域ID
	private Long stationid;
	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}
		
	@Autowired
	private IPreworkerService preworkerService;
	
	@Autowired
	private IInitService initService;
	
	@Autowired
	private IStatkaoqinService statkaoqinService;
	
	 public String pageQuery() throws IOException{	
			
		    statkaoqinService.pageQuery(pageBean);								
			java2Json(pageBean,new String[]{"detachedCriteria","kqdate"});
			return NONE;
		}
	
	//初始化
	public String initstation()
	{
		
		return NONE;
	}
	
	
}
