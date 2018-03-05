package com.velvol.hr.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.domain.*;
import com.velvol.hr.smsutils.SmsUtils;
import com.velvol.hr.utils.MatResult;
import com.velvol.hr.utils.Result;
import com.velvol.hr.wx.WeixinAPIHelper;
import com.velvol.hr.wx.util.MenuUtil;
import com.velvol.hr.wx.util.WechatMessageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;
import com.velvol.hr.web.action.base.BaseAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//预注册管理
@Controller         //由spring框架扫描自动创建
@Scope("prototype") //每次请求创建一个对象
public class PreworkerAction extends BaseAction<Preworker>{

	//属性驱动，接收页面输入的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	//属性驱动，接收页面输入的区域ID
	private Long regionid;
	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}

	@Autowired
	private IPreworkerService preworkerService;

	@Autowired
	private IRegionDao regionDao;

    //扫码入职申请添加:被权限控制模块拦截了，一定要排除拦截
	public String scanAdd() throws ParseException{

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String openid = request.getParameter("openid");
		String access_token = request.getParameter("access_token");
		Tipinfo tipinfo = preworkerService.scansave(model,regionid,stationid);
		//获取区域，并设置区域对象
		Region region = regionDao.findById(regionid);
		ActionContext ac = ActionContext.getContext();
		ac.put("tipinfo", tipinfo);
		ac.put("spredate", model.getSpredate());
		ac.put("reginname", region.getName());
		if (tipinfo != null) {
			try {
				//此处发送短信消息给骑手
				SmsUtils.smsSend(""+model.getTelephone()+"", "请于"+model.getSpredate()+"到"+tipinfo.getName()+""+tipinfo.getAddr()+"面试！联系人："+tipinfo.getLinkman()+"，电话："+tipinfo.getLinkmantel()+"【威沃科技】");
				//给微信自动推送消息
				String content = "请于"+model.getSpredate()+"到"+tipinfo.getName()+""+tipinfo.getAddr()+"面试！联系人："+tipinfo.getLinkman()+"，电话："+tipinfo.getLinkmantel()+"【威沃科技】";
				String tmpurl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?&body=0&access_token="+ access_token;
				String strJson = "{\"touser\" :\""+openid+"\",";
				strJson += "\"msgtype\":\"text\",";
				strJson += "\"text\":{";
				strJson += "\"content\":\""+content+"\"";
				strJson += "}}";
				//WechatMessageUtil.post(tmpurl, strJson);
				JSONObject result = WeixinAPIHelper.httpRequest(tmpurl, "POST", strJson);
				System.out.println("发送微信json信息："+strJson);
				System.out.println("发送微信消息返回信息："+result.get("errcode"));

			} catch (IOException e) {
				e.printStackTrace();
			}

			//此处发送短信消息给站长或人事
			try {
				SmsUtils.smsSend(""+tipinfo.getLinkmantel()+"", "新人报到提醒："+model.getName()+"，电话："+model.getTelephone()+"，将于"+model.getSpredate()+"到贵处报到面试【威沃科技】");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "registerok"; //跳转到申请成功页面
	}

	/**
	 * @desc 短信获取验证码
	 * @return
	 */
	public String valideCode() {
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//此处发送短信消息
		try {
			SmsUtils.smsSend(""+model.getTelephone()+"", "您的验证码是"+validatecode+"【威沃科技】");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Result result = new Result();
		result.setSuccess(true);
		this.java2Json(result, new String[]{});
		return NONE;
	}

	/**
	 * @desc 校验手机号重复
	 * @return
     */
	public String isHasPhone() {
		boolean phonePoolean = preworkerService.isHasPhone(model.getTelephone());
		Result result = new Result();
		if (phonePoolean) {
			result.setSuccess(true);
		}else {
			result.setSuccess(false);
		}
		this.java2Json(result, new String[]{});
		return NONE;
	}

	/**
	 * @desc 校验验证码
	 * @return
	 */
	public String isHasCode() {
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		Result result = new Result();
		//校验验证码是否输入正确
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			result.setSuccess(true);
		}else {
			result.setSuccess(false);
		}
		this.java2Json(result, new String[]{});
		return NONE;
	}

	//微信站长查询预登记骑手列表
	public String movePageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,0);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveReList";
	}

	//微信人事查询预登记骑手列表
	public String moveRsPageQuery() throws IOException{

		List preworkerList = preworkerService.movePageQuery(pageBean,0);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerList", preworkerList);
		ac.put("count", preworkerList.size());
		return "moveRensList";
	}

	//首页显示
	public String pageQueryCount() throws IOException{

		//查询入职
		List<Preworker> preworkerList = preworkerService.movePageQueryCount();
		//查询在岗人数
		List zgList = preworkerService.selectWorkerCount();
		//查询考勤人数
		List cqList = preworkerService.selectCqWorkerCount();
		//查询离职人数
		List leaverList = preworkerService.selectLeaverWorkerCount();

		JSONArray preworkerJson = JSONArray.fromObject(preworkerList);
		JSONArray jsonCqList = JSONArray.fromObject(cqList);
		JSONArray jsonLeaverList = JSONArray.fromObject(leaverList);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerJson", preworkerJson);
		ac.put("zgCount", zgList.size());
		ac.put("cqList", jsonCqList.toString());
		ac.put("cqListCount", cqList.size());
		ac.put("leaverCount", leaverList.size());
		ac.put("leaverList", jsonLeaverList);
		return "indexList";
	}

	//微信人事首页显示
	public String pageRsQueryCount() throws IOException{

		//查询入职
		List<Preworker> preworkerList = preworkerService.movePageQueryCount();

		//查询在岗人数
		List zgList = preworkerService.selectWorkerCount();
		//查询考勤人数
		List cqList = preworkerService.selectCqWorkerCount();
		//查询离职人数
		List leaverList = preworkerService.selectLeaverWorkerCount();

		JSONArray preworkerJson = JSONArray.fromObject(preworkerList);
		JSONArray jsonCqList = JSONArray.fromObject(cqList);
		JSONArray jsonLeaverList = JSONArray.fromObject(leaverList);
		ActionContext ac = ActionContext.getContext();
		ac.put("preworkerJson", preworkerJson);

		ac.put("zgCount", zgList.size());
		ac.put("cqList", jsonCqList.toString());
		ac.put("cqListCount", cqList.size());
		ac.put("leaverCount", leaverList.size());
		ac.put("leaverList", jsonLeaverList);
		return "rsIndexList";
	}

	//微信注册获取区域列表
	public String findRegionList() {
		List<Region> list = preworkerService.findRegionList();
		this.java2Json(list, new String[]{"addr", "manager", "regionbh", "managertel", "linkman", "linkmantel", "remark"});
		return NONE;
	}
	//微信注册获取站点列表
	public String moveFindStations(){
		List<Station> list = preworkerService.moveFindStations(regionid);
		this.java2Json(list, new String[]{"addr","linkman","linkmantel","remark"});
		return NONE;
	}

	//微信查询入职进程
	public String findByTelephone(){
		Preworker preworker = preworkerService.findByTelephone(model.getTelephone());
		if (preworker != null) {
			Date predate = preworker.getPredate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
			if(predate!=null){
				String strPredate = sdf.format(predate);
				preworker.setSpredate(strPredate);
			}
		}
		this.java2Json(preworker, new String[]{});
		return NONE;
	}



	//人事添加预注册申请:添加完成后返回到列表
	public String add(){
		ActionContext ac = ActionContext.getContext();
		if(preworkerService.isHasPhone(model.getTelephone())){			
			ac.put("errmsg", "该手机号已经被注册，注册失败！");			
		}
		else{
		  preworkerService.save(model,regionid);
		  ac.put("errmsg", null);		
		}
		return LIST;
	}
	
	//站长添加预注册申请:添加完成后返回到列表
	public String zadd(){
		ActionContext ac = ActionContext.getContext();
		if(preworkerService.isHasPhone(model.getTelephone())){			
			ac.put("errmsg", "该手机号已经被注册，注册失败！");			
		}
		else{
		  preworkerService.zsave(model,regionid);
		  ac.put("errmsg", null);		
		}
		return "zlist";
	}
	
	//人事预注册申请修改
	public String edit(){
		
		ActionContext ac = ActionContext.getContext();
		if(preworkerService.isHasPhone(model)){			
			ac.put("errmsg", "该手机号已经被注册，修改失败！");			
		}
		else{

			//显查询数据库，根据id查询原始数据
			Preworker preworker = preworkerService.findById(model.getId());
			//
			String spredate1 = model.getSpredate();
			System.out.println(spredate1);
			if(StringUtils.isNotBlank(spredate1)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				
				try {
					Date date = sdf.parse(spredate1);
					//System.out.println(date.getDate());				
					preworker.setPredate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
			}
			
			//使用页面提交的数据进行覆盖
			preworker.setName(model.getName());
			preworker.setSex(model.getSex());
			preworker.setTelephone(model.getTelephone());
			preworker.setCardid(model.getCardid());
			preworker.setInfofrom(model.getInfofrom());
			preworker.setReferee(model.getReferee());
			preworkerService.update(preworker);
		
			ac.put("errmsg", null);		
		}
		return LIST;
	}
	
	 //站长预注册修改
     public String zedit(){
		
		ActionContext ac = ActionContext.getContext();
		if(preworkerService.isHasPhone(model)){			
			ac.put("errmsg", "该手机号已经被注册，修改失败！");			
		}
		else{

			//显查询数据库，根据id查询原始数据
			Preworker preworker = preworkerService.findById(model.getId());
			//
			String spredate1 = model.getSpredate();
			System.out.println(spredate1);
			if(StringUtils.isNotBlank(spredate1)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				
				try {
					Date date = sdf.parse(spredate1);
					//System.out.println(date.getDate());				
					preworker.setPredate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
			}
			
			//使用页面提交的数据进行覆盖
			preworker.setName(model.getName());
			preworker.setSex(model.getSex());
			preworker.setTelephone(model.getTelephone());
			preworker.setCardid(model.getCardid());
			preworker.setInfofrom(model.getInfofrom());
			preworker.setReferee(model.getReferee());
			preworkerService.update(preworker);
		
			ac.put("errmsg", null);		
		}
		return "zlist";
	}

	//人事修改银行卡信息
	public String edityh(){
		//显查询数据库，根据id查询原始数据
		Preworker preworker = preworkerService.findById(model.getId());
		
		//使用页面提交的数据进行覆盖
		preworker.setYhcard(model.getYhcard());
		preworker.setYhfrom(model.getYhfrom());
		preworker.setYhperson(model.getYhperson());			
		preworkerService.update(preworker);
		return LIST;
	}
	
	//站长修改银行卡信息
	public String zedityh(){
		//显查询数据库，根据id查询原始数据
		Preworker preworker = preworkerService.findById(model.getId());
		
		//使用页面提交的数据进行覆盖
		preworker.setYhcard(model.getYhcard());
		preworker.setYhfrom(model.getYhfrom());
		preworker.setYhperson(model.getYhperson());			
		preworkerService.update(preworker);
		return "zlist";
	}
	
	//删除：
	//@RequiresPermissions("staff-delete")
	public String delete(){
		preworkerService.delete(model.getId());
		return LIST;
	}
	
	//属性驱动，接收页面提交的ids参数
	private String ids;	
	public void setIds(String ids) {
		this.ids = ids;
	}

	//人事批量删除
	//@RequiresPermissions("staff-delete")
	public String deleteBatch(){
		preworkerService.deleteBatch(ids);
		return LIST;
	}
		
	//站长批量删除		
	public String zdeleteBatch(){
		preworkerService.deleteBatch(ids);
		return "zlist";
	}
		
	//人事审核通过//预登记完成提交确认
	public String auditok(){
		preworkerService.auditok(model.getId(),1);
		return LIST;
	}
	
     //站长审核通过//预登记完成提交确认
	public String zauditok(){
		preworkerService.auditok(model.getId(),1);	
		return "zlist";
	}
	
	//人事审核不通过:加入黑名单
	public String black(){
		preworkerService.auditno(model.getId(),model.getFaildesc());
		System.out.println(model.getFaildesc());
		return LIST;
	}
	
	//站长审核不通过:加入黑名单
	public String zblack(){
		preworkerService.auditno(model.getId(),model.getFaildesc());
		System.out.println(model.getFaildesc());
		return "zlist";
	}
		
	//分页查询：查询待入职骑手列表，其中的页号page、每页的记录数rows、查询对象detachedCriteria已经在基类注入
	public String pageQuery() throws IOException{	
		System.out.println("当前页号："+pageBean.getCurrentPage());
		System.out.println("每页显示记录数："+pageBean.getPageSize());
		preworkerService.pageQuery(pageBean,0);
		
		//处理时间格式转json串的混乱问题
		formatTime(pageBean);
				
		java2Json(pageBean,new String[]{"detachedCriteria","initinfo",
				"getstate","initstate","hascar","picpath","faildesc","predate","reqtime"});
		return NONE;
	}



	//跳转到物料发放界面
	public String matputUI(){
		System.out.println("骑手ID:"+model.getId());
		List<Materialinit> list = preworkerService.findMListById(model.getId());
		if(list != null){
			System.out.println(list.size());
		  formatPutdate(list);
		}

		ActionContext ac = ActionContext.getContext();
		ac.put("materialList", list);
		ac.put("preworkerid", model.getId());
		return "matput";
	}
	
	//跳转到站长物料补充页面
	public String zmatputUI(){
		System.out.println("骑手ID:"+model.getId());
		List<Materialinit> list = preworkerService.findMListById(model.getId());
		if(list != null){
			System.out.println(list.size());
		  formatPutdate(list);
		}
		
		ActionContext ac = ActionContext.getContext();
		ac.put("materialList", list);
		ac.put("preworkerid", model.getId());
		return "zmatput";
	}
	
	//点击一个骑手记录，获取该骑手的初始化信息列表
	public String materialinitlist(){
		System.out.println("骑手ID:"+model.getId());
		List<Materialinit> list = preworkerService.findMListById(model.getId());
		if(list != null){
			System.out.println(list.size());
		  formatPutdate(list);
		}
		this.java2Json(list, new String[]{"isback","backtype","handledesc","backdate","putdate"});
		return NONE;
	}
	
	//获取站点列表数据
    public String findStations(){		
		List<Station> list = preworkerService.findStations();
		this.java2Json(list, new String[]{"addr","linkman","linkmantel","remark"});
		return NONE;
	}

  //属性驱动，接收页面输入的区域ID
  	private Long stationid;
  	public void setStationid(Long stationid) {
  		this.stationid = stationid;
  	}
    //分配站点:返回到审核通过骑手列表
    public String assignStation(){
    	//前台通过，preworker.id传递预注册骑手的id
    	System.out.println(model.getId());
    	System.out.println("2222222222retr:"+stationid);
    	preworkerService.assignStation(model.getId(),stationid);
		
		return LIST;
    }
    
       
	//格式化物料发放的时间格式
	private void formatPutdate(List<Materialinit> list){
		//处理时间格式转json串的混乱问题
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA); 			
		for (Materialinit materialinit : list) {
			Date putdate = materialinit.getPutdate();
			if(putdate!=null){
			   String strputdate = sdf.format(putdate);			
			   materialinit.setSputdate(sdf.format(putdate));
			}		   		
		}	
	}
}
