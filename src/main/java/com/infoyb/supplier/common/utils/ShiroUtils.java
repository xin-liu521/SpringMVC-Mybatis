package com.infoyb.supplier.common.utils;

import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.utils </dt>
 * <dt>ClassName: ShiroUtils </dt>
 * <dd>CreateDate: 2017-08-14 9:45 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:     shiro工具类       </dd>
 * </dl>
 *
 * @author wangjun
 */
public class ShiroUtils {

    /**
     * 获取session
     **/
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取当前用户主体
     **/
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 在session中添加属性
     **/
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取session中的属性
     **/
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 判断用户是否登录
     **/
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 用户退出系统
     **/
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取验证码
     **/
    public static String getKaptcha(String key) {
        String kaptcha = getSessionAttribute(key).toString();
        return kaptcha;
    }

    /**
     * 获取用户信息
     **/
    public static ByUsers getUser() {
        return (ByUsers) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取用户id
     **/
    public static Long getUserId() {
        return getUser().getUserId();
    }
}
