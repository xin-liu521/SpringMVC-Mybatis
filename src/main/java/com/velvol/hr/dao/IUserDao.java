package com.velvol.hr.dao;

import java.util.Set;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.domain.Role;
import com.velvol.hr.domain.User;
import com.velvol.hr.utils.PageBean;

public interface IUserDao extends IBaseDao<User> {
	public User findUserByUsernameAndPassword(String username, String password);

	public User findUserByUsername(String username);

	public User findUser(User model);

	void updatePassword(User model);


}
