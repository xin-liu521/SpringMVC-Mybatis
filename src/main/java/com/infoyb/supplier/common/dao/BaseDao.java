package com.infoyb.supplier.common.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * <dl>
 * <dt>ProjectName : infoyb-common </dt>
 * <dt>PakageName : com.infoyb.base.dao </dt>
 * <dt>ClassName: BaseDao </dt>
 * <dd>CreateDate: 2017-07-21 15:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:  dao 基础接口，所有dao必须继承此dao，可自定义方法    </dd>
 * </dl>
 *
 * @author Minty
 */
public  interface BaseDao<T> extends Mapper<T>,InsertListMapper<T>,SelectByIdsMapper<T>,DeleteByIdsMapper<T> {

  
}