package com.velvol.hr.dao.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.velvol.hr.utils.PageBean;

//持久层通用接口
public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public void saveOrUpdate(T entity);
	public T findById(Serializable id);
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...objects);
	public void pageQuery(PageBean pageBean);

	List xianpageQuery(PageBean pageBean);

	List moveBdPageQuery(PageBean pageBean);

	List movePageQuery(PageBean pageBean);
}
