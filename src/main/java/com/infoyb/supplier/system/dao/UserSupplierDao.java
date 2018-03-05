package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.system.model.UserSupplier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;
@Service
public interface UserSupplierDao extends BaseDao<UserSupplier>  {

    /**
     * @desc 查询账号
     * @param userAccount
     * @return
     */
    UserSupplier selectUserByAccount(String userAccount);

    /**
     * @desc 保存账号
     * @param userSupplier
     * @return
     */
    int saveUser(UserSupplier userSupplier);

    /**
     * @desc 校验账号
     * @param userAccount
     * @return
     */
    int queryUser(String userAccount);

    /**
     * @desc 根据id查用户信息
     * @param userId
     * @return
     */
    Map<String, Object> selectByUserId(Long userId);


}