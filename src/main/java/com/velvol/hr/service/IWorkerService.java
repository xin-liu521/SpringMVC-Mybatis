package com.velvol.hr.service;

import java.util.List;

import com.velvol.hr.domain.Kaoqinxian;
import com.velvol.hr.domain.Materialinit;
import com.velvol.hr.domain.Worker;
import com.velvol.hr.utils.PageBean;

public interface IWorkerService {

	//分页查询
	void pageQuery(PageBean pageBean,int state);

	List<Materialinit> findMListById(String id);

	void pageQuerykq(PageBean pageBean, int i);

	List movePageQuerykq(PageBean pageBean, int i);

	void submit(Kaoqinxian model);

	void submits(List list,int state, Integer flag);

	void pageQueryDetail(PageBean pageBean, Kaoqinxian model);

	void pageQuerykqrs(PageBean pageBean);

	void lpageQuery(PageBean pageBean, int i);

	Worker selectWorker();

}
