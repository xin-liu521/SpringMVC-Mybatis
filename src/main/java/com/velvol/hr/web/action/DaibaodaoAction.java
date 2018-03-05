package com.velvol.hr.web.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Preworker;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.web.action.base.BaseAction;

@Controller   
@Scope("prototype")
public class DaibaodaoAction extends BaseAction<Preworker>{

	@Autowired
	private IPreworkerService preworkerService;
	
	//分页查询：查询待入职骑手列表，其中的页号page、每页的记录数rows、查询对象detachedCriteria已经在基类注入
	public String pageQuery() throws IOException{	
		
		preworkerService.pageQuery(pageBean,1);
		
		//处理时间格式转json串的混乱问题
		formatBdDate(pageBean);
				
		java2Json(pageBean,new String[]{"detachedCriteria","initinfo","region",
				"getstate","initstate","hascar","faildesc","predate","reqtime"});
		return NONE;
	}

	//移动端站长查询待入职骑手列表
	public String moveBdPageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,1);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveBaodaoList";
	}

	//移动端人事查询待入职骑手列表
	public String moveBdRsPageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,1);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveRsBaodaoList";
	}
	
	//待报到完成提交
	public String baodaook(){
	
		Preworker preworker = preworkerService.findById(model.getId());
		String sbaodaodate = model.getSbaodaodate();
		
		if(StringUtils.isNotBlank(sbaodaodate)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			
			try {
				Date date = sdf.parse(sbaodaodate);	
				preworker.setBaodaodate(date);
				preworker.setState(2);
				preworkerService.update(preworker);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		return LIST;
	}
	//设置报到日期
	public String setdate()
	{
		Preworker preworker = preworkerService.findById(model.getId());
		String sbaodaodate = model.getSbaodaodate();
		
		if(StringUtils.isNotBlank(sbaodaodate)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			
			try {
				Date date = sdf.parse(sbaodaodate);	
				preworker.setBaodaodate(date);
				
				preworkerService.update(preworker);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		return LIST;
	}
	
	//待报到完成确认:即更新状态为试用期
	public String auditok(){
        
		preworkerService.auditok(model.getId(),2);
		return LIST;
	}
				
	private void formatBdDate(PageBean pageBean){
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 			
		List<Preworker> list0 = new ArrayList<Preworker>(); 
		List<Preworker> list = pageBean.getRows();
		for (Preworker preworker : list) {
			Date predate = preworker.getPredate();
			if(predate!=null){
			   String strPredate = sdf.format(predate);			
			   preworker.setSpredate(strPredate);
			}
			Date baodaodate = preworker.getBaodaodate();
		   if(baodaodate != null)
			    preworker.setSbaodaodate(sdf.format(baodaodate));
		   
			list0.add(preworker);
		}
		pageBean.setRows(list0);
	}
}
