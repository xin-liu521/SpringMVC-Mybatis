package com.velvol.hr.web.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.velvol.hr.domain.Kaoqinxian;
import com.velvol.hr.service.IWorkerService;
import com.velvol.hr.utils.MatResult;
import com.velvol.hr.utils.Result;
import com.velvol.hr.web.action.base.BaseAction;

import net.sf.json.JSONArray;
import org.springframework.util.StringUtils;

@Controller
@Scope("prototype")
public class KaoqinAction extends BaseAction<Kaoqinxian>{

	@Autowired
	private IWorkerService workerService;
	
	//今日考勤分页查询
   public String pageQuerykq(){	
		
		workerService.pageQuerykq(pageBean,3);
		java2Json(pageBean,new String[]{"detachedCriteria","kqdate","stationid","stationname","workerid"});
		return NONE;
	}

	//微信站长今日早餐班考勤查询
	public String movePageQuerykq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveKaoqinList";
	}

	//微信站长今日正常班考勤查询
	public String movePageZhengckq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveKaoqinZcList";
	}

	//微信站长今日夜宵班考勤查询
	public String movePageYxkq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveKaoqinYxList";
	}

	//微信人事今日正常班考勤查询
	public String moveRsZckq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveRsZcList";
	}

	//微信人事今日夜宵班考勤查询
	public String moveRsYxkq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveRsYxList";
	}

	//微信人事今日考勤查询
	public String moveRsPageQuerykq(){

		List list = workerService.movePageQuerykq(pageBean,3);
		ActionContext ac = ActionContext.getContext();
		ac.put("workerList", list);
		//ac.put("count", list.size());
		return "moveRsKaoqinList";
	}

   //考勤详情页面
   public String detailUI(){	
		
	   ActionContext ac = ActionContext.getContext();
		
		ac.put("stationid", model.getStationid());
		ac.put("skqdate", model.getSkqdate());
		return "detaillist";
	}
   //考勤详情页面分页查询
   public String pageQueryDetail(){
	   workerService.pageQueryDetail(pageBean,model);								
		java2Json(pageBean,new String[]{"detachedCriteria","kqdate","stationid","stationname","workerid"});
		return NONE;
   }
   
   //单个提交考勤
   public String submit(){
	   
	   try {
		model.setRemark(URLDecoder.decode(model.getRemark(), "UTF-8"));
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   workerService.submit(model);
	   
	  
	   MatResult result = new MatResult(true,"");
	   java2Json(result, new String[]{});
	   return NONE;
   }
   
   //属性驱动接收批量考勤数据
   private String entities;  
   public void setEntities(String entities) {
	 this.entities = entities;
   }
	//属性驱动接收批量考勤数据
	private Integer flag;
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
  //批量提交考勤
   public String submits(){

	   String id = entities.substring(1, entities.length()-1).replace("\"", "");
	   String ids[] = id.split(",");
	   List idsLong = Arrays.asList(ids);
	   //JSONArray array =JSONArray.fromObject(entities);
	   workerService.submits(idsLong, model.getState(), flag);
	   Result result = new Result();
	   result.setSuccess(true);
	   this.java2Json(result, new String[]{});
	   return NONE;
   }
   
   //人事查询今日考勤
   public String pageQuerykqrs(){
	    workerService.pageQuerykqrs(pageBean);								
		java2Json(pageBean,new String[]{"detachedCriteria","kqdate","workerid"});
		return NONE;
   }
   
}
