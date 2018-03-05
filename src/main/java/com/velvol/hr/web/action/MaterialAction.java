package com.velvol.hr.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Material;
import com.velvol.hr.domain.Materialtype;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Region;
import com.velvol.hr.service.IMaterialService;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.web.action.base.BaseAction;

//领取物料管理
@Controller
@Scope("prototype")
public class MaterialAction extends BaseAction<Material>{
	
	@Autowired
	private IPreworkerService preworkerService;
	
	@Autowired
	private IMaterialService materialService;
			
	//物料管理新骑手列表
	public String pageQuery()
	{
		//需要重新创建一个分离的标准查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Preworker.class);
		//传递查询对象给pageBean
		pageBean.setDetachedCriteria(detachedCriteria);
				
		materialService.pageQuery(pageBean);	
		
		//处理时间格式转json串的混乱问题
		formatTime(pageBean);	
		
		java2Json(pageBean,new String[]{"detachedCriteria","region","station","initinfo",
				"cardid","referee","spredate","type","deltag","materials",
				"initstate","hascar","picpath","faildesc","predate","reqtime"});
		return NONE;
	}
	
	
	//物料管理-->某个骑手的物料列表:前端传递的骑手ID需为preworkerid
	public String materlist()
	{
		//根据骑手编号获取物料列表
		List<Material> list = materialService.findMaterList(model.getPreworkerid());
		this.java2Json(list, new String[]{"handledesc"});
		return NONE;
	}
	
	//物料种类列表
	public String typelist()
	{
		//根据骑手编号获取物料列表
		List<Materialtype> list = materialService.findTypeList();
		this.java2Json(list, new String[]{});
		return NONE;
	}
	
	//领取物料操作:添加完成后，前台通过ajax请求，自动请求materlist，刷新列表数据
	//添加完成后，需要更新骑手表的领取物料状态为已领取
	public String add(){
		materialService.add(model);
		return NONE;
	}
	
	//删除后，要判断物料表还有该骑手的物料吗，没有的话得更新骑手表的状态为未领取
	public String delete(){
		materialService.delete(model);
		return NONE;
	}
	
	//物料编辑模块
	public String edit(){
		//显查询数据库，根据id查询原始数据
		Material material = materialService.findById(model.getId());
		
		//使用页面提交的数据进行覆盖
		material.setGetdate(model.getGetdate());
		material.setMaterialbh(model.getMaterialbh());
		material.setName(model.getName());
		material.setSort(model.getSort());
		material.setYardage(model.getYardage());
		materialService.update(material);
		return NONE;
	}
	
	//物料确认归还
	public String back(){
		//显查询数据库，根据id查询原始数据
		Material material = materialService.findById(model.getId());
		
		//使用页面提交的数据进行覆盖
		material.setIsback(model.getIsback());
		material.setBacktype(model.getBacktype());
		material.setHandledesc(model.getHandledesc());		
		material.setBackdate(model.getBackdate());
		
		materialService.update(material);
		return NONE;
	}
	
}
