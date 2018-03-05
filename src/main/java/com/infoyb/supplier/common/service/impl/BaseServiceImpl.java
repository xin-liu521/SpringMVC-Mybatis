package com.infoyb.supplier.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infoyb.supplier.common.model.BaseModel;
import com.infoyb.supplier.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.orderbyhelper.OrderByHelper;

import java.util.List;

/**
 * <dl>
 * <dt>ProjectName : infoyb-base </dt>
 * <dt>PakageName : com.infoyb.base.common.service.impl </dt>
 * <dt>ClassName: BaseServiceImpl </dt>
 * <dd>CreateDate: 2017-07-21 15:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:  通用service接口实现类    </dd>
 * </dl>
 *
 * @author Minty
 */
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    /**
     * 通用mapper
     * <p>
     * 继承了BaseMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>三个组合接口
     */
    @Autowired
    private Mapper<T> mapper;

    /**
     * 批量插入，支持批量插入的数据库可以使用，
     * 例如MySQL,H2等，
     * 另外该接口限制实体包含id属性并且必须为自增列
     */
    @Autowired
    private InsertListMapper<T> insertListMapper;

    /**
     * 通过操作ids字符串进行操作
     * <p>
     * ids 如 "1,2,3" 这种形式的字符串
     */
    @Autowired
    private SelectByIdsMapper<T> selectByIdsMapper;

    /**
     * 通过操作ids字符串进行操作
     * <p>
     * ids 如 "1,2,3" 这种形式的字符串
     */
    @Autowired
    private DeleteByIdsMapper<T> deleteByIdsMapper;


    public Mapper<T> getMapper() {
        return mapper;
    }



    /**
     * 根据主键查询
     *
     * @param key 主键id
     * @return 单表对象
     */
    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * 根据实体中字段值进行查询
     * <p>
     * 如果 entity 为null 可查询出所有
     *
     * @param entity 泛型对象
     * @return List集合
     */
    @Override
    public List<T> selectByEntity(T entity) {
        return mapper.select(entity);
    }


    /**
     * 通过id批量查询
     * <p>
     * 通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，
     * <p>
     * 这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常。
     *
     * @param ids
     * @return
     */
    @Override
    public List<T> selectByKeys(String ids) {
        return selectByIdsMapper.selectByIds(ids);
    }

    /**
     * 根据Example条件进行查询
     *
     * @param example 任意类型参数
     * @return List集合
     */
    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }


    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 泛型对象
     * @return 受影响行数
     */
    @Override
    public int save(T entity) {
        return mapper.insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 泛型对象
     * @return 受影响行数
     */
    @Override
    public int saveNotNull(T entity) {
        return mapper.insertSelective(entity);
    }


    /**
     * 批量插入，支持批量插入的数据库可以使用，
     * 例如MySQL,H2等，
     * 另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param list 泛型list对象
     *
     * @return
     */
    @Override
    public int saveList(List<T> list) {
        return insertListMapper.insertList(list);
    }



    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键id
     * @return 受影响行数
     */
    @Override
    public int deleteByKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }


    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param ids 主键ids "1,2,3"
     * @return 受影响行数
     */
    @Override
    public int deleteByKeys(String ids) {
        return deleteByIdsMapper.deleteByIds(ids);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 泛型对象
     * @return 受影响行数
     */
    @Override
    public int delete(T entity) {
        return mapper.delete(entity);
    }


    /**
     * 根据主键更新实体全部字段，null值会被更新
     * （对象中必须有主键id）
     *
     * @param entity 泛型对象
     * @return 受影响行数
     */
    @Override
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     * （对象中必须有主键id）
     *
     * @param entity 泛型对象
     * @return 受影响行数
     */
    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 根据参数查询分页
     *
     * @param entity 实体类
     * @return 返回分页信息
     */
    @Override
    public PageInfo queryByCondition(T entity){
        Integer pageNum = entity.getPageNumber();
        Integer length = entity.getPageSize();

        String orderBy = entity.getSortName() + " " + entity.getSortOrder();
        OrderByHelper.orderBy(orderBy);
        PageHelper.startPage(pageNum, length);
        List<T> entityList = mapper.select(entity);
        return new PageInfo<>(entityList);
    }


    /**
     * 根据查询条件参数查询分页，用于模糊查询
     *
     * @param entity 类型实体
     * @param example 查询条件
     *
     * @return 返回分页信息
     */
    @Override
    public PageInfo queryByExample(T entity, Example example){
        Integer pageNum = entity.getPageNumber();
        Integer length = entity.getPageSize();
        PageHelper.startPage(pageNum, length);
        List<T> entityList = mapper.selectByExample(example);
        return new PageInfo<>(entityList);
    }

}
