package com.velvol.hr.web.action;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Worker;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.service.IWorkerService;
import com.velvol.hr.web.action.base.BaseAction;

//在职人员管理
@Controller
@Scope("prototype")
public class WorkerAction  extends BaseAction<Worker>{

	@Autowired
	private IWorkerService workerService;
	
	  
	//分页查询列表数据
    public String pageQuery() throws IOException{	
		
		workerService.pageQuery(pageBean,3);								
		java2Json(pageBean,new String[]{"detachedCriteria","initinfo","indate",
				"getstate","initstate","hascar","picpath","faildesc","predate","reqtime"});
		return NONE;
	}
    
    //根据骑手列表查询物料信息
    public String materialinitlist(){
		List<Materialinit> list = workerService.findMListById(model.getId());		
		this.java2Json(list, new String[]{"isback","backtype","handledesc","backdate","putdate"});
		return NONE;
	}

	//微信站长个人中心查询
    public String selectWorker() {
		ActionContext ac = ActionContext.getContext();
		Worker worker = workerService.selectWorker();
		ac.put("worker", worker);
		return "personalPage";
	}

	//微信人事个人中心查询
	public String selectRsWorker() {
		ActionContext ac = ActionContext.getContext();
		Worker worker = workerService.selectWorker();
		ac.put("worker", worker);
		return "personalRsPage";
	}
}
