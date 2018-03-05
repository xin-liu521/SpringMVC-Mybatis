package com.velvol.hr.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Statkaoqin;
import com.velvol.hr.service.IInitService;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.service.IStatkaoqinService;
import com.velvol.hr.web.action.base.BaseAction;

@Controller   
@Scope("prototype")
public class StatkqAction  extends BaseAction<Statkaoqin> {
	
	@Autowired
	private IStatkaoqinService statkaoqinService;
	
	 public String pageQuery() throws IOException{	
			
		    statkaoqinService.pageQuery(pageBean);								
			java2Json(pageBean,new String[]{"detachedCriteria","kqdate"});
			return NONE;
		}
	
}
