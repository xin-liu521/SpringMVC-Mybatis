package com.velvol.hr.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ShiyongqiAction  extends BaseAction<Preworker>{

	@Autowired
	private IPreworkerService preworkerService;
	
	//分页查询：查询待入职骑手列表，其中的页号page、每页的记录数rows、查询对象detachedCriteria已经在基类注入
	public String pageQuery() throws IOException{	
		
		preworkerService.pageQuery(pageBean,2);
		
		//处理时间格式转json串的混乱问题
		formatRzDate(pageBean);
				
		java2Json(pageBean,new String[]{"detachedCriteria","initinfo","region",
				"getstate","initstate","hascar","faildesc","predate","reqtime"});
		return NONE;
	}

	//站长试用期查询待入职骑手列表
	public String moveSypageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,2);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveSyList";
	}

	//人事试用期查询待入职骑手列表
	public String moveRsSypageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,2);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveRsSyList";
	}
	
	//分配美团ID
	public String setMeituanid(){
		Preworker preworker = preworkerService.findById(model.getId());
		String sindate = model.getSindate();
		
		if(StringUtils.isNotBlank(sindate)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			
			try {
				Date date = sdf.parse(sindate);	
				preworker.setIndate(date);
				preworker.setMeituanid(model.getMeituanid());
				System.out.println(preworker.getMeituanid());
				System.out.println(preworker.getIndate());
				preworkerService.update(preworker);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		return LIST;
	}
	
	//人事分配美团ID
	public String rsetMeituanid(){
		Preworker preworker = preworkerService.findById(model.getId());
		String sindate = model.getSindate();
		
		if(StringUtils.isNotBlank(sindate)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			
			try {
				Date date = sdf.parse(sindate);	
				preworker.setIndate(date);
				preworker.setMeituanid(model.getMeituanid());
				System.out.println(preworker.getMeituanid());
				System.out.println(preworker.getIndate());
				preworkerService.update(preworker);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		return "rlist";
	}
	
	//劝退
	public String quantui(){
		preworkerService.quantui(model.getId(),model.getFaildesc());
		System.out.println(model.getFaildesc());
		return LIST;
	}
	
	//合格
	public String hege(){
		preworkerService.hege(model.getId());	
		System.out.println(model.getId());
		return LIST;
	}
	
	//试用期完成确认:劝退的需要发离职申请，合格的要创建一个用户
	//同时要把该骑手的信息添加到正式员工表worker
	public String auditok(){
		
		preworkerService.testSubmit(model);	
		return LIST;
	}
	
	private void formatRzDate(PageBean pageBean){
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 			
		List<Preworker> list0 = new ArrayList<Preworker>(); 
		List<Preworker> list = pageBean.getRows();
		for (Preworker preworker : list) {
			//入职日期变成字符串
			Date inDate = preworker.getIndate();
			if(inDate!=null){
			   String strIndate = sdf.format(inDate);			
			   preworker.setSindate(strIndate);
			   
			   //设置剩余天数
				Date date = new Date();
				try {
					int num = daysBetween(inDate,date);
					preworker.setResttime(num);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			list0.add(preworker);
		}
		pageBean.setRows(list0);
	}
	
	//计算日期的天数差
	private int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
             
       return Integer.parseInt(String.valueOf(between_days));           
    }    
}
