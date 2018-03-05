package com.infoyb.supplier.system.service;

import com.infoyb.supplier.common.service.BaseService;
import com.infoyb.supplier.system.model.ByUsers;

import java.util.Map;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.service </dt>
 * <dt>ClassName: ByUsersService </dt>
 * <dd>CreateDate: 2017-10-26 18:26 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:            </dd>
 * </dl>
 *
 * @author lx
 */
public interface ByUsersService extends BaseService<ByUsers> {

    /**
     * @desc 查询账号
     * @param userAccount
     * @return
     */
    ByUsers selectUserByAccount(String userAccount);

    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(ByUsers user);

    /**
     * @desc 校验账号
     * @param userAccount
     * @return
     */
    int queryUser(String userAccount);

    /**
     * @desc 校验邮箱
     * @param email
     * @return
     */
    int queryEmail(String email);

    /**
     * @desc 校验联系电话
     * @param phone
     * @return
     */
    int queryPhone(String phone);

    /**
     * @desc 根据id查用户信息
     * @param userId
     * @return
     */
    Map<String, Object> selectByUserId(Long userId);

    /**
     * 邮件激活
     * @param users
     * @param email
     * @throws Exception
     */
    void emailActivate(ByUsers users, String email) throws Exception;

    /**
     * 更改激活状态
     * @param users
     * @return
     */
    int updateByUsers(ByUsers users);

    /**
     * 删除激活失败用户
     * @param users
     * @return
     */
    int delByUsers(ByUsers users);

}
