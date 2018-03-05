package com.velvol.hr.service;

import java.util.List;

import com.velvol.hr.domain.Material;
import com.velvol.hr.domain.Materialtype;
import com.velvol.hr.utils.PageBean;

public interface IMaterialService {

	void pageQuery(PageBean pageBean);

	List<Material> findMaterList(String preworkerid);

	List<Materialtype> findTypeList();

	void add(Material model);

	void delete(Material model);

	Material findById(Long id);

	void update(Material material);

}
