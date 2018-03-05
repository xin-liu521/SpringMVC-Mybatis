package com.infoyb.supplier.common.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <dl>
 * <dt>ProjectName : infoyb-base </dt>
 * <dt>PakageName : com.infoyb.base.common.service </dt>
 * <dt>ClassName: BaseService </dt>
 * <dd>CreateDate: 2017-07-21 15:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:  通用service接口   </dd>
 * </dl>
 *
 * @author Minty
 */
@Service
public interface BaseService<T> {
    /**
     *
     * 根据主键查询
     *
     * @param key 主键id
     * @return 单表对象
     */
    T selectByKey(Object key);

    /**
     *
     * 根据实体中字段值进行查询
     *
     * 如果 entity 为null 可查询出所有
     *
     * @param entity 泛型对象
     *
     * @return List集合
     */
    List<T> selectByEntity(T entity);


    /**
     *
     * 根据Example条件进行查询
     *
     * @param example 任意类型参数
     *
     * @return List集合
     */
    List<T> selectByExample(Object example);


    /**
     *
     *
     * 通过id批量查询
     *
     * 通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，
     *
     * 这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常。
     *
     * @param ids
     * @return
     */
    List<T> selectByKeys(String ids);

    /**
     *
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 泛型对象
     *
     * @return 受影响行数
     */
    int save(T entity);

    /**
     *
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 泛型对象
     *
     * @return 受影响行数
     */
    int saveNotNull(T entity);



    /**
     * 批量插入，支持批量插入的数据库可以使用，
     * 例如MySQL,H2等，
     * 另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param list 泛型list对象
     *
     * @return
     */
    int saveList(List<T> list);

    /**
     *
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键id
     *
     * @return 受影响行数
     */
    int deleteByKey(Object key);


    /**
     *
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param ids 主键ids "1,2,3"
     *
     * @return 受影响行数
     */
    int deleteByKeys(String ids);


    /**
     *
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 泛型对象
     *
     * @return 受影响行数
     *
     */
    int delete(T entity);



    /**
     *
     * 根据主键更新实体全部字段，null值会被更新
     * （对象中必须有主键id）
     *
     * @param entity 泛型对象
     *
     * @return 受影响行数
     */
    int updateAll(T entity);

    /**
     *
     * 根据主键更新属性不为null的值
     *  （对象中必须有主键id）
     *
     * @param entity 泛型对象
     *
     * @return 受影响行数
     */
    int updateNotNull(T entity);


    /**
     * 根据参数查询分页
     *
     * @param entity
     * @return
     */
    PageInfo queryByCondition(T entity);

    /**
     * 根据参数查询分页，Example查询
     *
     * @param entity 实体对象
     * @param example example 查询条件
     *
     * @return PageInfo
     */
    PageInfo queryByExample(T entity, Example example);
}
