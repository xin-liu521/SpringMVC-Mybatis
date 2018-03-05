package com.velvol.hr.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velvol.hr.dao.IRegionDao;
import com.velvol.hr.dao.IRoleDao;
import com.velvol.hr.dao.IStationDao;
import com.velvol.hr.dao.IUserDao;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Region;
import com.velvol.hr.domain.Role;
import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.User;
import com.velvol.hr.service.IUserService;
import com.velvol.hr.utils.MD5Utils;
import com.velvol.hr.utils.PageBean;


@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IRegionDao regionDao;
	
	@Autowired
	private IStationDao stationDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
		//String password = MD5Utils.md5(user.getPassword());
		String password = user.getPassword();
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}
	
	 //根据用户id修改密码
	public void editPassword(String id, String password) {
		//使用MD5加密密码
		//password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password,id);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		//排除掉系统管理员
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.add(Restrictions.ne("username","admin")); 
		pageBean.setDetachedCriteria(detachedCriteria);
		
		//加载数据
		userDao.pageQuery(pageBean);		
	}

	//获取角色列表
	public List findRoleList() {
		return roleDao.findAll();
		
	}

	@Override
	public List<Station> findStationList(Long regionid ) {
		
		return stationDao.findAllByRegionid(regionid);
	}

	@Override
	public void save(User user,String roleid) {
		//获取区域名
		Long regionid = user.getRegionid();
		System.out.println("regionid:"+regionid);
		if(regionid != null){
		Region region = regionDao.findById(regionid);
		user.setRegionName(region.getName());
		}
		
		Long stationid = user.getStationid();
		if(stationid != null){
		Station station = stationDao.findById(stationid);
		user.setStationName(station.getName());
		}
		
		//如果角色是系统管理
		if("10005".equals(roleid)){
			user.setRegionid(null);	
			user.setRegionName(null);
			user.setStationid(null);	
			user.setStationName(null);
		}
		
		//如果角色是人事则不用保存站点信息
		if("10001".equals(roleid)){
			user.setStationid(null);	
			user.setStationName(null);
		}
		userDao.save(user);
		if(StringUtils.isNotBlank(roleid)){			
				//手动构造托管对象
				Role role = new Role(roleid);
				//用户对象关联角色对象
				user.getRoles().add(role);			
		}		
	}

	
	public void update(User model, String roleid) {
		User user = userDao.findById(model.getId());		
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
		
		Long regionid = model.getRegionid();
		
		if(regionid != null){
			user.setRegionid(regionid);		
			Region region = regionDao.findById(regionid);
			user.setRegionName(region.getName());
		}
		
		Long stationid = model.getStationid();
		if(stationid != null){
		user.setStationid(stationid);
		Station station = stationDao.findById(stationid);
		user.setStationName(station.getName());
		}
		
		if("10005".equals(roleid)){
			user.setRegionid(null);	
			user.setRegionName(null);
			user.setStationid(null);	
			user.setStationName(null);
		}
		
		//如果角色是人事则不用保存站点信息
		if("10001".equals(roleid)){
			user.setStationid(null);	
			user.setStationName(null);
		}
		
		//更新角色
		Set<Role> roles = new HashSet(0);
		if(StringUtils.isNotBlank(roleid)){			
			//手动构造托管对象
			Role role =roleDao.findById(roleid) ;			
			roles.add(role);			
	    }			
		user.setRoles(roles);
		
		userDao.update(user);
					
	}

	
	public void delete(String id) {
		User user = userDao.findById(id);
		userDao.delete(user);
		
	}

	//判断用户是否存在
	public boolean isHasUser(String username) {
		User user = userDao.findUserByUsername(username);
		if(user == null)
		    return false;
		else
			return true;
	}

	//编辑时判断用户是否存在
	public boolean isHasUser(User model) {
		
		User user = userDao.findUser(model);
		if(user == null)
		    return false;
		else
			return true;
	}

	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}
}
