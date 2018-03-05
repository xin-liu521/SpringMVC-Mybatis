package com.velvol.hr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.velvol.hr.dao.IStatkaoqinDao;
import com.velvol.hr.dao.base.impl.BaseDaoImpl;
import com.velvol.hr.domain.Statkaoqin;

@Repository
public class StatkaoqinDaoImpl  extends BaseDaoImpl<Statkaoqin> implements IStatkaoqinDao{

	//更新统计信息
	public void updatetj(Statkaoqin statkaoqin) {
		//查询该统计信息是否存在
		String hql = "FROM Statkaoqin s WHERE s.stationid = ? and s.kqdate=? ";
		List<Statkaoqin> list = (List<Statkaoqin>) this.getHibernateTemplate().find(hql, statkaoqin.getStationid(),statkaoqin.getKqdate());
		if(list != null && list.size() > 0){//如果存在则更新
			Statkaoqin stat = this.findById(list.get(0).getId());
			stat.setBjnumber(statkaoqin.getBjnumber());
			stat.setCdnumber(statkaoqin.getCdnumber());
			stat.setCqnumber(statkaoqin.getCqnumber());
			stat.setKqnumber(statkaoqin.getKqnumber());
			stat.setNcqnumber(statkaoqin.getNcqnumber());
			stat.setSjnumber(statkaoqin.getSjnumber());
			stat.setTotal(statkaoqin.getTotal());
			
			this.update(stat);
			
		}
		else{
			this.save(statkaoqin);
		}
		
		
	}

}
