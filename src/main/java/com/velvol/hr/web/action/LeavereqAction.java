package com.velvol.hr.web.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.velvol.hr.domain.Leavereq;
import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.ILeavereqService;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.utils.MatResult;
import com.velvol.hr.utils.Result;
import com.velvol.hr.utils.SessionUtils;
import com.velvol.hr.web.action.base.BaseAction;

@Controller   
@Scope("prototype")
public class LeavereqAction extends BaseAction<Leavereq>{

	@Autowired
	private IPreworkerService preworkerService;
	@Autowired
	private ILeavereqService leavereqService;
	
	//获取用户信息
	public String getUserinfo(){
		User user = SessionUtils.getLoginUser();
		
		//为了测试先写死
		Preworker preworker = preworkerService.findById(user.getWorkerid());
		java2Json(preworker,new String[]{"predate","initinfo","region","spredate","reqtime","sreqtime",
				"getstate","initstate","hascar","faildesc","predate","reqtime"});		
		return NONE;
	}
	
	//离职信息添加
	public String add(){
		leavereqService.save(model);
		return LIST;
	}
	
	//属性驱动接收骑手ID
	private String workerid;		
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	
	public String edit(){
		leavereqService.edit(model);
		return LIST;
	}
	
	//删除
	public String delete(){
		leavereqService.delete(model.getId());
		return LIST;
	}
	
	//提交离职申请
	public String doSubmit(){
		leavereqService.doSubmit(model.getId());
		return LIST;
	}
	
	//获取离职列表
	public String list(){
		User user = SessionUtils.getLoginUser();
		List<Leavereq> list = leavereqService.findListByWorkerId(user.getWorkerid());
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}
	
	//站长代发离职申请
	public String zadd(){
		System.out.println("骑手ID:"+workerid);
		leavereqService.zsave(model,workerid);
		return "zlist";
	}
	
	public String zlist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long stationid = user.getStationid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByStationId(stationid,0);
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}	
		
	public String zedit(){
		leavereqService.zedit(model);
		return "zlist";
	}
		
	public String zdelete(){
		leavereqService.delete(model.getId());
		return "zlist";
	}
	public String zdoSubmit(){
		leavereqService.doSubmit(model.getId());
		return "zlist";
	}
	
	//站长审批列表
	public String zsplist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long stationid = user.getStationid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByStationId(stationid,1);
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}

	//微信站长审批列表
	public String moveZsplist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long stationid = user.getStationid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByStationId(stationid,1);
		ActionContext ac = ActionContext.getContext();

		ac.put("preworkerList", list);
		ac.put("count", list.size());
		return "moveApproveList";
	}

	//站长审批结果列表
	public String zspresultlist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long stationid = user.getStationid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByStationId(stationid);
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}
	//站长驳回
	public String doRedo(){
		leavereqService.doRedo(model.getId());
		return "zsplist";
	}
	
	//站长审批通过
	public String zShipi(){
		leavereqService.zShipi(model.getId());
		return "zsplist";	
	}
	
	//人事审批列表
	public String rsplist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByRegionId(regionid,2);
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}


	//微信人事审批列表
	public String moveRsplist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByRegionId(regionid,2);
		ActionContext ac = ActionContext.getContext();

		ac.put("preworkerList", list);
		ac.put("count", list.size());
		return "moveRsApproveList";
	}

	//人事审批通过完成离职手续
	public String rShipi(){
		leavereqService.rShipi(model.getId());
		return "rsplist";	
	}
	
	//离职完成列表
	public String pageQueryf(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
				
		leavereqService.pageQuery(pageBean,regionid,4);
		//处理时间格式转json串的混乱问题
		//formatTime(pageBean);
				
		java2Json(pageBean,new String[]{"reqdate","leavedate"});
			
		return NONE;
	}
	
	//人事审批的物料返回界面
	public String matbackUI(){
		Leavereq leavereq = leavereqService.getById(model.getId());		
		//获取物料列表
		List<Materialinit> list = preworkerService.findMListById(leavereq.getPreworkerid());
		//通过设置属性把数据传回页面
		ActionContext ac = ActionContext.getContext();
		
		ac.put("preworkerid", leavereq.getPreworkerid());
		ac.put("list", list);
		return "matback";
	}
	
	//属性驱动获取物料归还参数
	private String sbackdate;
	private String backremark;
	private int   backtype;	
	private int ddcbacktype;
	private Float pcjin;
	private Float ddcpcjin;
	
	public void setDdcpcjin(Float ddcpcjin) {
		this.ddcpcjin = ddcpcjin;
	}

	public void setPcjin(Float pcjin) {
		this.pcjin = pcjin;
	}

	public void setSbackdate(String sbackdate) {
		this.sbackdate = sbackdate;
	}
	public void setBackremark(String backremark) {
		this.backremark = backremark;
	}
	
	
	public void setBacktype(int backtype) {
		this.backtype = backtype;
	}


	public void setDdcbacktype(int ddcbacktype) {
		this.ddcbacktype = ddcbacktype;
	}

	//人事物料返回操作
	public String matback(){		
		Materialinit materialinit = new Materialinit();
	    materialinit.setId(model.getId());
	    materialinit.setSbackdate(sbackdate);
	    materialinit.setBackremark(backremark);
	    materialinit.setBacktype(backtype);
	    materialinit.setPcjin(pcjin);
		
	    System.out.println(model.getId());
	    System.out.println(sbackdate);
	    System.out.println(backremark);
	    System.out.println(backtype);
	    System.out.println(pcjin);
	    
	    leavereqService.backMaterial(materialinit);
		
		return NONE;
	}
	//人事培训保险扣费
	public String feematback(){		
		Materialinit materialinit = new Materialinit();
	    materialinit.setId(model.getId());
	    materialinit.setSbackdate(sbackdate);
	    materialinit.setBackremark(backremark);
	    materialinit.setPcjin(pcjin);
		leavereqService.backFee(materialinit);
		
		return NONE;
	}
	
	//解除合同
	public String  htmatback(){		
		Materialinit materialinit = new Materialinit();
	    materialinit.setId(model.getId());
	    materialinit.setSbackdate(sbackdate);
	    materialinit.setBackremark(backremark);
	   
		leavereqService.htmatback(materialinit);
		
		return NONE;
	}
	
	//站长物料归还界面
	public String zmatbackUI(){
		Leavereq leavereq = leavereqService.getById(model.getId());		
		//获取物料列表
		List<Materialinit> list = preworkerService.findMListById(leavereq.getPreworkerid());
		//通过设置属性把数据传回页面
		ActionContext ac = ActionContext.getContext();
		
		Preworker preworker =preworkerService.findById(leavereq.getPreworkerid());
		
		ac.put("preworkerid", leavereq.getPreworkerid());
		ac.put("list", list);
		ac.put("Picpath", preworker.getPicpathlzd());
		return "zmatback";
	}
	
	//站长审批判断物料是否归还
	public String isBackMatZ(){
		Leavereq leavereq = leavereqService.getById(model.getId());
		boolean isBack = preworkerService.isBackMatZ(leavereq.getPreworkerid());
		MatResult result = new MatResult(isBack, "");
		this.java2Json(result,  new String[]{});
		return NONE;
	}
	
	//人事审批判断物料是否归还
	public String isBackMatR(){
		Leavereq leavereq = leavereqService.getById(model.getId());
		boolean isBack = preworkerService.isBackMatR(leavereq.getPreworkerid());
		MatResult result = new MatResult(isBack, "");
		this.java2Json(result,  new String[]{});
		return NONE;	
	}
		
	//站长物料返回操作
	public String zmatback(){
		System.out.println(model.getId());
		System.out.println(sbackdate);
		System.out.println(backremark);
		System.out.println(backtype);
	    Materialinit materialinit = new Materialinit();
	    materialinit.setId(model.getId());
	    materialinit.setSbackdate(sbackdate);
	    materialinit.setBackremark(backremark);
	    materialinit.setBacktype(backtype);
		leavereqService.backMaterial(materialinit);
		
		return NONE;
	}
		
	//站长电动车物料归还
	public String zdmatback(){
		 Materialinit materialinit = new Materialinit();
	    materialinit.setId(model.getId());
	    materialinit.setSbackdate(sbackdate);
	    materialinit.setBackremark(backremark);
	    materialinit.setBacktype(ddcbacktype);
		leavereqService.backMaterial(materialinit);
		
		return NONE;
	}
	
	//外卖箱扣款
	public String wmxkoukuan(){
		Materialinit materialinit = new Materialinit();
	
		materialinit.setId(model.getId());
	    materialinit.setPcjin(pcjin);
	    leavereqService.wmxkoukuan(materialinit);	  	    
		return NONE;
	}
	
	//电动车扣款
	public String ddckoukuan(){
		Materialinit materialinit = new Materialinit();
	
		materialinit.setId(model.getId());
	    materialinit.setPcjin(ddcpcjin);
	    leavereqService.wmxkoukuan(materialinit);	  	    
		return NONE;
	}
	
	
	//扣款界面
	public String koukuanUI(){
		Leavereq leavereq = leavereqService.getById(model.getId());		
		//获取物料列表
		List<Materialinit> list = preworkerService.findMListById(leavereq.getPreworkerid());
		//通过设置属性把数据传回页面
		ActionContext ac = ActionContext.getContext();
		
		ac.put("preworkerid", leavereq.getPreworkerid());
		ac.put("list", list);
		return "koukuan";
	}
	
	//删除完成列表里记录
	public String deletef(){
		leavereqService.delete(model.getId());
		return "leavefinish";
	}
	
	//属性封装的方式获取传递过来的工地地图
	private File image; //用来接收上传文件的参数，注意该参数名称用同jsp页面的文件输入框的参数名称一致
	private String imageFileName; //用来接收上传文件的文件名，注意格式必须这样写
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}	
	public void setImage(File image) {
		this.image = image;
	}
    //上传离职单
	public String uploadlzd() throws IOException{
		if(image !=null&&imageFileName!=null&&!"".equals(imageFileName)){
		     			
			//获取健康证存放目录
			String realpath = ServletActionContext.getServletContext().getRealPath("/");
			System.out.println(realpath);			
			File file = new File(realpath+"\\lzdimage");
		     if(!file.exists())
			    file.mkdirs();
			    
		     //生成一个随机唯一的文件名
		     String newFilename = UUID.randomUUID() + imageFileName.substring(imageFileName.lastIndexOf("."));
		     //通过commons-io包里的FileUtils，把接收到的源文件image，复制到指定的目录下的文件名为imageFileName
		    FileUtils.copyFile(image, new File(file,newFilename));
		  
		    System.out.println(newFilename);
		    
		    preworkerService.updatelzd(model,newFilename);			
			
		    Result result  = new Result() ;
		    result.setSuccess(true);
		    result.setPicpath(newFilename);
		    
		    this.java2Json(result,new String[]{});
   		}
		return NONE;
	}
	
	//待结算列表	
	public String djslist(){
		//根据用户获取站点ID
		User user = SessionUtils.getLoginUser();
		Long regionid = user.getRegionid();
		//获取没有提交的站长代申请离职列表
		List<Leavereq> list = leavereqService.findListByRegionId(regionid,3);
		if(list != null){			
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"reqdate","leavedate"});
		return NONE;
	}	
	
	//人事扣费确认
	public String rkoufei(){
		leavereqService.rkoufei(model.getId());
		return "daijieduan";	
	}
	
	
	private void formatPutdate(List<Leavereq> list){
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 			
		for (Leavereq leavereq : list) {
			Date reqdate = leavereq.getReqdate();
			if(reqdate!=null){
			   String sreqdate = sdf.format(reqdate);			
			   leavereq.setSreqdate(sreqdate);
			}	
			Date leavedate = leavereq.getLeavedate();
			if(leavedate!=null){
			   String sleavedate = sdf.format(leavedate);			
			   leavereq.setSleavedate(sleavedate);
			}	
		}	
	}
	
	
}
