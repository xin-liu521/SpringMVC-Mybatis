package com.velvol.hr.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IUserDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Preworker;
import com.velvol.hr.domain.Role;
import com.velvol.hr.domain.User;
import com.velvol.hr.utils.PageBean;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	/**
	 * 根据用户名和密码查询用户
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public User findUserByUsername(String username) {
		String hql = "FROM User u WHERE u.username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findUser(User model) {
		String hql = "FROM User u WHERE u.username = ? and u.id<>?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, model.getUsername(),model.getId());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updatePassword(User model) {
		String hql = "UPDATE User u SET u.password = ? WHERE u.id = ?";
		User user = this.getHibernateTemplate().get(User.class, model.getId());
		user.setId(model.getId());
		user.setPassword(model.getPassword());
		this.getHibernateTemplate().update(hql, user);
	}


}
