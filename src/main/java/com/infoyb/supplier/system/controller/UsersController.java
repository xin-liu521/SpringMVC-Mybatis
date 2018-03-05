package com.infoyb.supplier.system.controller;


import com.github.pagehelper.PageInfo;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import com.infoyb.supplier.common.controller.AbstractUserController;
import com.infoyb.supplier.common.model.R;
import com.infoyb.supplier.common.shiro.PasswordHelper;
import com.infoyb.supplier.common.utils.ShiroUtils;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.SysLog;
import com.infoyb.supplier.system.service.ByUsersService;
import com.infoyb.supplier.system.service.SysLogService;
import com.infoyb.supplier.system.utils.ResultObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by Minty on 2017/5/22.
 */
@RequestMapping(value = "/users")
@Controller
public class UsersController extends AbstractUserController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    SysLogService sysLogServiceImpl;

    @Autowired
    ByUsersService byUsersServiceImpl;

    //密码生成类
    @Autowired
    PasswordHelper passwordHelper;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public R getList(SysLog sysLog) {
        Example example = new Example(SysLog.class);
        String sortName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sysLog.getSortName());
        example.setOrderByClause(sortName + " " + sysLog.getSortOrder());
        if (!Strings.isNullOrEmpty(sysLog.getUserName())) {
            example.createCriteria()
                    .andLike("userName", "%" + sysLog.getUserName() + "%");
        }
        PageInfo sysLogPageInfo = sysLogServiceImpl.queryByExample(sysLog, example);
        return R.ok(sysLogPageInfo);
    }


    /**
     * @param user 用户对象
     * @return
     * @desc 注册
     */
    @RequestMapping(value = "/userSave", method = RequestMethod.POST)
    @ResponseBody
    public R userSave(ByUsers user, HttpServletRequest httpServletRequest, String captcha) {
        //获取httpSession中的验证码
        String code = (String) httpServletRequest.getSession().getAttribute("captcha");
        //清掉session中的验证码的code
        httpServletRequest.getSession().setAttribute("captcha", "");
        if (!code.equals(captcha)) {
            return R.error("验证码错误");
        }
        user.setSalt("infoybmdm");
        user.setCreateTime(new Date());
        passwordHelper.encryptPassword(user);
        int us = byUsersServiceImpl.saveNotNull(user);
        if (us > 0) {
            return R.ok("注册成功");
        } else {
            return R.error("注册失败");
        }

    }

    /**
     * @param userAccount
     * @return
     * @desc 校验账号
     */
    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    @ResponseBody
    public R queryUser(String userAccount) {
        int count = byUsersServiceImpl.queryUser(userAccount);
        if (count > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * @param email
     * @return
     * @desc 校验邮箱
     */
    @RequestMapping(value = "/queryEmail", method = RequestMethod.POST)
    @ResponseBody
    public R queryEmail(String email) {
        int count = byUsersServiceImpl.queryEmail(email);
        if (count > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * @param phone
     * @return
     * @desc 联系电话校验
     */
    @RequestMapping(value = "/queryPhone", method = RequestMethod.POST)
    @ResponseBody
    public R queryPhone(String phone) {
        int count = byUsersServiceImpl.queryPhone(phone);
        if (count > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 获取用户基本信息
     **/
    @RequestMapping(value = "/baseInfo", method = RequestMethod.POST)
    @ResponseBody
    public R getUserBaseInfo() {
        Map<String, Object> user = byUsersServiceImpl.selectByUserId(getCommonUserId());
        return R.ok().put("info", user);
    }

    /**
     * 修改用户密码
     *
     * @param psw
     * @param newPsw
     * @return r
     **/
    @RequestMapping(value = "/changePsw", method = RequestMethod.POST)
    @ResponseBody
    public R changeUserPsw(String psw, String newPsw) {
        //获取当前用户信息
        ByUsers currentUser = ShiroUtils.getUser();
        //比对用户原始密码
        String tempPsw = passwordHelper.createPwdEncrypt(psw, currentUser.getCredentialsSalt());
        if (!currentUser.getUserPassword().equals(tempPsw)) {
            return R.error("用户密码修改失败,原始密码错误");
        }
        //封装新信息
        ByUsers user = new ByUsers();
        user.setUserId(currentUser.getUserId());
        user.setUserPassword(newPsw);
        user.setUserAccount(currentUser.getUserAccount());
//        user.setUpdateTime(new Date());
//        user.setUpdateId(currentUser != null ? currentUser.getId() : null);
//        user.setUpdateName(currentUser != null ? currentUser.getName() : null);
        passwordHelper.encryptPassword(user);

        int r = byUsersServiceImpl.updateNotNull(user);
        if (r > 0) {
            return R.ok("用户密码修改成功");
        }
        return R.error("用户密码修改失败");
    }

    /**
     * 修改用户基本信息
     *
     * @param user
     * @return R
     **/
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public R updateUserInfo(ByUsers user) throws Exception {
        ByUsers currentUser = ShiroUtils.getUser();
        user.setUserId(currentUser.getUserId());
        int r = byUsersServiceImpl.updateNotNull(user);
        if (r > 0) {
            if (!user.getPictureUrl().equals("") && null != user.getPictureUrl()) {
                currentUser.setPictureUrl(user.getPictureUrl());
            }
            return R.ok("用户信息修改成功");
        }
        return R.error("用户信息修改失败");
    }

    /**
     * 邮件激活
     * @param users
     * @param httpServletRequest
     * @param captcha
     * @return
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject sendEmail(ByUsers users, HttpServletRequest httpServletRequest, String captcha) {
        ResultObject result = new ResultObject();
        try {
            users.setIsActive(1);
            users.setCreateTime(new Date());
            users.setEmailSendTime(new Date());
            String code = (String) httpServletRequest.getSession().getAttribute("captcha");
            //清掉session中的验证码的code
            httpServletRequest.getSession().setAttribute("captcha", "");
            if (!code.equals(captcha)) {
                result.setSuccess(false);
                result.setMsg("验证码错误！");
                return result;
            }
            passwordHelper.encryptPassword(users);
            int i = byUsersServiceImpl.saveNotNull(users);
            if(i > 0){
                byUsersServiceImpl.emailActivate(users, users.getEmail());
                result.setSuccess(true);
                result.setMsg("邮件发送成功,请激活后登录");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsg("发送邮件激活出现异常!");
            logger.error("发送邮件激活出现异常:" + e.getMessage());
        }
        return result;
    }

    /**
     * 邮件激活页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/emailActivateView", method = RequestMethod.GET)
    public ModelAndView emailActivateView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        String userAccount = request.getParameter("userAccount");
        ByUsers users = new ByUsers();
        users = byUsersServiceImpl.selectUserByAccount(userAccount);
        if (users != null){
            if (users.getIsActive()==1){
                Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                if(timeStamp-users.getCreateTime().getTime()>3600000){
                    int num=byUsersServiceImpl.delByUsers(users);
                    if(num>0) {
                        mv.setViewName("page/activate/user_activatefail");
                    }
                } else {
                    users.setIsActive(0);
                    int count = byUsersServiceImpl.updateByUsers(users);
                    if (count > 0) {
                        mv.setViewName("page/activate/user_activate");
                    }
                }
            } else {
                mv.setViewName("page/activate/user_activatesuccess");
            }
        }else{
            mv.setViewName("page/activate/user_activatefail");
        }
        return mv;
    }
}


