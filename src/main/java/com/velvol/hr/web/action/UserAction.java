package com.velvol.hr.web.action;

import java.util.List;
import java.util.Set;

import com.velvol.hr.utils.Result;
import com.velvol.hr.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Role;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.IUserService;
import com.velvol.hr.utils.MD5Utils;
import com.velvol.hr.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Autowired
	private IUserService userService;
	
	public String loginUI(){
		return LOGIN;
	}
	
	/**
	 * 用户登录,使用shiro框架提供的方式进行认证操作
	 */
	public String login(){
				
		//获得shiro框架的当前用户对象,状态为“未认证”
		Subject subject = SecurityUtils.getSubject();
		//创建用户名密码令牌对象：根据登录的用户名和密码
		AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),model.getPassword());
		try{
			//向shiro框架认证：该方法就会调用安全管理器，安全管理器会调用realm
			subject.login(token);
		}
		catch(Exception e){//如果抛异常则登录没成功
			//e.printStackTrace(); //测试时，可放开查看异常
			this.addActionError("用户名或者密码输入错误！");
			return LOGIN;
		}
		User user = (User) subject.getPrincipal();
		ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
		
		
		ActionContext ac = ActionContext.getContext();
		ac.put("loginUser", user);
		
		//获取角色编码，不同角色跳转到不同页面
	    String roleCode = user.getRoleCode();
	    System.out.println("roleCode:("+roleCode+")");
		
//	    if("qishourole".equals(roleCode)){
//	    	return "home_qs";
//	    }
	     if("renshirole".equals(roleCode)){
	    	return "home_rs";
	    }
	    else if("zhanzhangrole".equals(roleCode)){
	    	return "home";
	    }
//	    else if("xitongguanlirole".equals(roleCode)){
//	    	return "home_xt";
//	    }
	    
	    
	    return HOME;
		
	}
	
	//用户登录
	public String login_bak(){
		
	  User user = userService.login(model);
	  if(user != null){
		  //登录成功,将user对象放入session，跳转到首页
		  ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
		  return HOME;
		}
	   else{
			//登录失败，,设置提示信息，跳转到登录页面
			//输入的验证码错误,设置提示信息，跳转到登录页面
			this.addActionError("用户名或者密码输入错误！");
			return LOGIN;
		}
	}
	
	//用户注销
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	//分页查询
	public String pageQuery(){
		
		userService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"noticebills","roles"});
		return NONE;
	}
	
	public String findRoleList(){
		List<Role> list =  userService.findRoleList();
		this.java2Json(list, new String[]{"functions","users","description"});
		return NONE;
	}
	
	public String findStationList(){
		List<Station> list =  userService.findStationList(model.getRegionid());
		this.java2Json(list, new String[]{"addr","linkman","linkmantel","remark"});
		return NONE;
	}
	
	private String roleid;
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	//添加用户
	public String add(){
		ActionContext ac = ActionContext.getContext();
		if(userService.isHasUser(model.getUsername())){			
			ac.put("errmsg", "该用户名已经存在，添加用户失败！");			
		}
		else{
			userService.save(model,roleid);
		  ac.put("errmsg", null);		
		}
		
		return LIST;
	}
	
	//编辑用户
	public String edit(){	
		
		ActionContext ac = ActionContext.getContext();
		if(userService.isHasUser(model)){			
			ac.put("errmsg", "该用户名已经存在，修改用户失败！");			
		}
		else{
			userService.update(model,roleid);
		  ac.put("errmsg", null);		
		}
		
		return LIST;
	}
	
	//删除用户
	public String delete(){		
		userService.delete(model.getId());
		return LIST;
	}

	public String updatePasswordPage() {
		User user = SessionUtils.getLoginUser();
		ActionContext ac = ActionContext.getContext();
		ac.put("user", user);
		return "updatePwdPage";
	}

	public String updatePwdPage() {
		User user = SessionUtils.getLoginUser();
		ActionContext ac = ActionContext.getContext();
		ac.put("user", user);
		return "updateZzPwdPage";
	}

	private String pwd;
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String updatePassword() {
		User user = SessionUtils.getLoginUser();
		Result result = new Result();
		if (!pwd.equals(user.getPassword())) {
			result.setSuccess(false);
			result.setPicpath("旧密码错误！");
		}else {
			model.setId(user.getId());
			userService.updatePassword(model);
			result.setSuccess(true);
			result.setPicpath("修改成功");
		}
		this.java2Json(result, new String[]{});
		return NONE;
	}
}
