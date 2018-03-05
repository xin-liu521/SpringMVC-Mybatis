package com.infoyb.supplier.system.service.impl;

import com.infoyb.supplier.common.service.impl.BaseServiceImpl;
import com.infoyb.supplier.system.dao.ByUsersDao;
import com.infoyb.supplier.system.dao.UserSupplierDao;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.SysLog;
import com.infoyb.supplier.system.model.UserSupplier;
import com.infoyb.supplier.system.service.SysLogService;
import com.infoyb.supplier.system.service.UserSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by infoyb on 2017.10.13.
 */
@Service
public class UserSupplierServiceImpl extends BaseServiceImpl<UserSupplier> implements UserSupplierService {

    @Autowired
    UserSupplierDao userSupplierDao;

    /**
     * @desc 查询账号
     * @param userAccount
     * @return
     */
    @Override
    public UserSupplier selectUserByAccount(String userAccount) {
        return userSupplierDao.selectUserByAccount(userAccount);
    }


    /**
     * @desc 保存用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(UserSupplier user) {
        return userSupplierDao.saveUser(user);
    }


    /**
     * @desc 校验账号
     * @param userAccount
     * @return
     */
    @Override
    public int queryUser(String userAccount){
        return userSupplierDao.queryUser(userAccount);
    }

    /**
     * @desc 根据id查用户信息
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> selectByUserId(Long userId) {
        return userSupplierDao.selectByUserId(userId);
    }

}
