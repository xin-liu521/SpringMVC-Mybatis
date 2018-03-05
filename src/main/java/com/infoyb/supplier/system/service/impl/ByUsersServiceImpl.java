package com.infoyb.supplier.system.service.impl;

import com.infoyb.supplier.common.service.impl.BaseServiceImpl;
import com.infoyb.supplier.system.dao.ByUsersDao;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.Mail;
import com.infoyb.supplier.system.service.ByUsersService;
import com.infoyb.supplier.system.service.MailService;
import com.infoyb.supplier.system.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.service.impl </dt>
 * <dt>ClassName: ByUsersServiceImpl </dt>
 * <dd>CreateDate: 2017-10-26 18:26 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:            </dd>
 * </dl>
 *
 * @author lx
 */
@Service
public class ByUsersServiceImpl extends BaseServiceImpl<ByUsers> implements ByUsersService {

    @Autowired
    ByUsersDao byUsersDao;

    //邮件服务
    @Autowired
    MailService mailServiceImpl;


    /**
     * @desc 查询账号
     * @param userAccount
     * @return
     */
    @Override
    public ByUsers selectUserByAccount(String userAccount) {
        return byUsersDao.selectUserByAccount(userAccount);
    }


    /**
     * @desc 保存用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(ByUsers user) {
        return byUsersDao.saveUser(user);
    }


    /**
     * @desc 校验账号
     * @param userAccount
     * @return
     */
    @Override
    public int queryUser(String userAccount){
        return byUsersDao.queryUser(userAccount);
    }

    /**
     * @desc 校验邮箱
     * @param email
     * @return
     */
    @Override
    public int queryEmail(String email){
        return byUsersDao.queryEmail(email);
    }

    public int queryPhone(String phone){
        return byUsersDao.queryPhone(phone);
    }

    /**
     * @desc 根据id查用户信息
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> selectByUserId(Long userId) {
        return byUsersDao.selectByUserId(userId);
    }

    /**
     * 邮件激活
     * @param users
     * @param email
     * @throws Exception
     */
    @Override
    public void emailActivate(ByUsers users, String email) throws Exception {
        Mail mail = new Mail();
        StringBuffer code = new StringBuffer();
        code.append("email=").append(Encoder.symmetricEncrypto(email)).append("&");
        code.append("id=").append(Encoder.symmetricEncrypto(users.getUserId() + "")).append("&");
        code.append("account=").append(Encoder.symmetricEncrypto(users.getUserAccount()));
        mail.setTo(email);
        mail.setSubject("邮箱激活,欢迎使用北元客商平台!");
        mail.setContent(mailServiceImpl.getTemplateContentFromFile("email_activate").replace("#ACCOUNT#",
                users.getUserAccount()).replace("#userId#", Encoder.symmetricEncrypto(users.getUserId().toString())));
        mailServiceImpl.sendMailAsyn(mail);
    }

    /**
     * 更改激活状态
     * @param users
     * @return
     */
    @Override
    public int updateByUsers(ByUsers users) {
        return byUsersDao.updateByUsers(users);
    }

    /**
     * 删除激活失败用户
     * @param users
     * @return
     */
    @Override
    public int delByUsers(ByUsers users) {
        return byUsersDao.delByUsers(users);
    }

}
