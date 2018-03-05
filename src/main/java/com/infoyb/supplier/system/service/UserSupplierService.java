package com.infoyb.supplier.system.service;

import com.infoyb.supplier.common.service.BaseService;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.SysLog;
import com.infoyb.supplier.system.model.UserSupplier;

import java.util.Map;

/**
 * Created by infoyb on 2017.10.13.
 */
public interface UserSupplierService extends BaseService<UserSupplier> {

    /**
     * 查询账号
     * @param userAccount
     * @return
     */
    UserSupplier selectUserByAccount(String userAccount);

    /**
     * @desc 保存用户
     * @param user
     * @return
     */
    int saveUser(UserSupplier user);

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


