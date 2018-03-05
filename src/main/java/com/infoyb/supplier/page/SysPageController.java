package com.infoyb.supplier.page;

import com.infoyb.supplier.common.utils.ShiroUtils;
import com.infoyb.supplier.system.model.ByApproveBase;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;
import com.infoyb.supplier.system.service.ByApproveBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统页面视图
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {


	//注入基本信息服务层接口
	@Autowired
	ByApproveBaseService byApproveBaseServiceImpl;
	
	@RequestMapping(value = {"","/","index"})
	public ModelAndView redirIndex(){
		ModelAndView view=new ModelAndView();
		ByUsers loginUser = ShiroUtils.getUser();
		ByApproveBase byApproveBase = byApproveBaseServiceImpl.selectByApproveBase(loginUser.getUserId());
		if (byApproveBase != null) {
			view.addObject("byApproveBase", byApproveBase);
		}

		view.setViewName("/index");
		return view;
	}

	@RequestMapping("login")
	public ModelAndView redirLogin(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/login");
		return view;
	}

}
