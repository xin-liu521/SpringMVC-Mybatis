package com.velvol.hr.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.dao.IMaterialDao;
import com.velvol.hr.dao.IMaterialtypeDao;
import com.velvol.hr.dao.IPreworkerDao;
import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.domain.Material;
import com.velvol.hr.domain.Materialtype;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.IMaterialService;
import com.velvol.hr.utils.PageBean;
import com.velvol.hr.utils.SessionUtils;

@Service      
@Transactional
public class MaterialServiceImpl implements IMaterialService{

	@Autowired
	private IPreworkerDao preworkerDao;	
	@Autowired
	private IRegionDao regionDao;
	@Autowired
	private IMaterialDao materialDao;
	@Autowired
	private IMaterialtypeDao materialtypeDao;
	
	//获取预注册和物料分页查询
	public void pageQuery(PageBean pageBean) {
		//设置查询的状态为审核通过的骑手
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.eq("state",new Integer(1)));
				
		//设置查询的骑手所在的区域
		User user = SessionUtils.getLoginUser();
		Long regionid= user.getRegionid();
		Region region = regionDao.findById(regionid);
		detachedCriteria.add(Restrictions.eq("region",region));
				
		pageBean.setDetachedCriteria(detachedCriteria);	
		
		//这查询的是预注册列表的分页数据
		preworkerDao.pageQuery(pageBean);	
		
	}

	//根据骑手编号获取物料列表
	public List<Material> findMaterList(String preworkerid) {
		
		List<Material> list = materialDao.findAllByWorkerid(preworkerid);
		return list;
	}

	//获取物料类型列表
	public List<Materialtype> findTypeList() {
		
		return materialtypeDao.findAll();
	}

	@Override
	public void add(Material model) {
		materialDao.save(model);		
		//System.out.println("model.getPreworkerid():"+model.getPreworkerid());
		Preworker preworker = preworkerDao.findById(model.getPreworkerid());
		preworker.setGetstate(1);		
	}

	//删除物料，并判断是否还有该骑手的物料，没有则更新物料状态为未领取
	public void delete(Material model) {
		Material material = materialDao.findById(model.getId());
		String preworkerid = material.getPreworkerid();
		materialDao.delete(material);
		List<Material> list = materialDao.findAllByWorkerid(preworkerid);
		if(list != null && list.size() > 0){			
		}
		else {
			Preworker preworker = preworkerDao.findById(preworkerid);
			preworker.setGetstate(0);		
		}
			
	}

	@Override
	public Material findById(Long id) {
		
		return materialDao.findById(id);
	}

	@Override
	public void update(Material material) {
		materialDao.update(material);
		
	}

}
