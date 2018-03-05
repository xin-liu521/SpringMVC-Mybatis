package com.infoyb.supplier.system.controller;

import com.infoyb.supplier.common.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * <dl>
 * <dt>ProjectName : infoyb-supplier </dt>
 * <dt>PakageName : com.infoyb.supplier.system.controller </dt>
 * <dt>ClassName: LoginController </dt>
 * <dd>CreateDate: 2017-10-13 13:46 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: 登录控制器 </dd>
 * </dl>
 *
 * @author lx
 */
@Controller
public class LoginController {
    @Autowired
    Producer producer;


    @RequestMapping(value = "captcha.jpg", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //将验证码放到Httpsession里面
        request.getSession().setAttribute("captcha", text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 用户登录(基于form表单的身份验证过滤器)
     **/
    @RequestMapping("/userLogin")
    public String showLoginForm(HttpServletRequest request, Model model) {

        //登陆表单得到该错误key显示相应的错误消息
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "未知账户！";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误！";
        } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
            error = "帐号未激活！";
        } else if(DisabledAccountException.class.getName().equals(exceptionClassName)){
            error = "账号已禁用！";
        }else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "错误次数过多,账号将会被锁定30分钟！";
        } else if ("jCaptcha.error".equals(exceptionClassName)) {
            error = "验证码错误！";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("message_login", error);
        return "login";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:userLogin";
    }




}
