package com.velvol.hr.service;

import com.velvol.hr.domain.Initinfo;
import com.velvol.hr.utils.PageBean;

public interface IInitService {

	void save(Initinfo model);

	void pageQuery(PageBean pageBean);

	Initinfo findById(Long id);

	void update(Initinfo initinfo);

	void delete(Long id);

}
