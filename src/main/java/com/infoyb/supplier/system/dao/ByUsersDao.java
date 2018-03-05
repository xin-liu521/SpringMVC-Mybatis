package com.infoyb.supplier.system.dao;

import com.infoyb.supplier.common.dao.BaseDao;
import com.infoyb.supplier.common.model.BaseModel;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

@Service
public interface ByUsersDao extends BaseDao<ByUsers> {

    /**
     * @desc 查询账号
     * @param userAccount
     * @return
     */
    ByUsers selectUserByAccount(String userAccount);

    /**
     * @desc 保存账号
     * @param byUsers
     * @return
     */
    int saveUser(ByUsers byUsers);

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