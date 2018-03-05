package com.velvol.hr.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import com.velvol.hr.domain.Preworker;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.base.IBaseDao;
import com.velvol.hr.utils.PageBean;

//持久层通用实现
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	//代表的是某个实体的类型
	private Class<T> entityClass;
	
	/*1、其子类dao添加了@Repository注解，spring框架扫描到后，会自动创建实例
	 *2、创建dao实例对象时，会根据方法上的这个@Resource注解，而自动注入容器里的sessionFactory
	 *3、注入的sessionFactory最终传给了HibernateDaoSupport，拥有了获取session的能力
	 *4、通过this.getHibernateTemplate()代替session的操作实现对数据库操作
	 */
	@Resource//放在方法上，根据类型注入sessionFactory；  spring工厂中的会话工厂对象sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//在父类（BaseDaoImpl）的构造方法中动态获得entityClass
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类上声明的泛型数组
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}
	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public List<T> findAll() {
		String hql = "FROM " + entityClass.getSimpleName() ;
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	//执行对User的通用更新
	public void executeUpdate(String queryName, Object... objects) {
		//获取当前数据库操作的session
		Session session = this.getSessionFactory().getCurrentSession();
		//在实体映射文件中写自己的sql,然后通过getNamedQuery获取查询对象
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objects) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
	}

	/**
	 * 通用分页查询方法
	 */
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
				
		//查询total---总数据量
		detachedCriteria.setProjection(Projections.rowCount());//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());
		
		//指定hibernate框架封装对象的方式：ROOT_ENTITY：在多表关联查询时，封装对象只封装到根对象，而不是封装多个对象
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		
		//查询rows---当前页需要展示的数据集合
		detachedCriteria.setProjection(null);//指定hibernate框架发出sql的形式----》select * from bc_staff;
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}

	@Override
	public List xianpageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

		//查询total---总数据量
		detachedCriteria.setProjection(Projections.rowCount());//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;

		//指定hibernate框架封装对象的方式：ROOT_ENTITY：在多表关联查询时，封装对象只封装到根对象，而不是封装多个对象
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);

		//查询rows---当前页需要展示的数据集合
		detachedCriteria.setProjection(null);//指定hibernate框架发出sql的形式----》select * from bc_staff;
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
		return rows;
	}

	@Override
	public List moveBdPageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

		//查询total---总数据量
		detachedCriteria.setProjection(Projections.rowCount());//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());

		//指定hibernate框架封装对象的方式：ROOT_ENTITY：在多表关联查询时，封装对象只封装到根对象，而不是封装多个对象
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);

		//查询rows---当前页需要展示的数据集合
		detachedCriteria.setProjection(null);//指定hibernate框架发出sql的形式----》select * from bc_staff;
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
		return rows;
	}

	@Override
	public List movePageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

		//查询total---总数据量
		detachedCriteria.setProjection(Projections.rowCount());//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());

		//指定hibernate框架封装对象的方式：ROOT_ENTITY：在多表关联查询时，封装对象只封装到根对象，而不是封装多个对象
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);

		//查询rows---当前页需要展示的数据集合
		detachedCriteria.setProjection(null);//指定hibernate框架发出sql的形式----》select * from bc_staff;
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
		return rows;
	}

	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
}
