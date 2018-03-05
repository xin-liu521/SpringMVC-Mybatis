package com.velvol.hr.service;

import java.util.List;

import com.velvol.hr.domain.Station;
import com.velvol.hr.domain.User;
import com.velvol.hr.utils.PageBean;

public interface IUserService {
	public User login(User model);

	public void editPassword(String id, String password);

	public void pageQuery(PageBean pageBean);

	public List findRoleList();

	public List<Station> findStationList(Long regionid);

	public void save(User model,String roleid);

	public void update(User model, String roleid);

	public void delete(String id);

	public boolean isHasUser(String username);

	public boolean isHasUser(User model);

	void updatePassword(User user);
}
