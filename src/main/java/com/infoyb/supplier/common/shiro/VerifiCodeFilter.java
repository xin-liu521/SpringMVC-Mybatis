package com.infoyb.supplier.common.shiro;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证码过滤器
 * AccessControlFilter提供了访问控制的基础功能；
 * 比如是否允许访问，当访问拒绝时如何处理
 */
public class VerifiCodeFilter extends AccessControlFilter {

    private boolean jcaptchaEnabled = true;//是否开启验证码支持
    private String jcaptchaParam = "captcha";//存储的验证码
    private String failureKeyAttribute = "shiroLoginFailure";//验证失败后存储的属性名


    public boolean isJcaptchaEnabled() {
        return jcaptchaEnabled;
    }

    public void setJcaptchaEnabled(boolean jcaptchaEnabled) {
        this.jcaptchaEnabled = jcaptchaEnabled;
    }

    public String getJcaptchaParam() {
        return jcaptchaParam;
    }

    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }

    public String getFailureKeyAttribute() {
        return failureKeyAttribute;
    }

    public void setFailureKeyAttribute(String failureKeyAttribute) {
        this.failureKeyAttribute = failureKeyAttribute;
    }

    /**
     * isAccessAllowed:表示是否允许访问；
     *
     * @param o 就是【urls】配置中拦截器参数部分，如果允许方位返回true，否则返回false
     **/
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        //通过shiro获取request的请求
        HttpServletRequest httpServletRequest = WebUtils.toHttp(servletRequest);
        //获取httpSession中的验证码
        String code = (String) httpServletRequest.getSession().getAttribute(jcaptchaParam);
        //获取用户表单中输入的验证码
        String submitCode = WebUtils.getCleanParam(httpServletRequest, jcaptchaParam);
        //判断验证码是否禁用或不是表单提交(允许访问)
        if (jcaptchaEnabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
            return true;
        }
        //此时是表单提交，校验验证码是否正确
        return !StringUtils.isEmpty(submitCode) && StringUtils.equals(code.toLowerCase(), submitCode.toLowerCase());
    }

    /**
     * onAccessDenied:表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理，如果返回false表示该拦截器已经处理了，将直接返回
     **/
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //如果验证码校验不通过，存储失败的key值
        servletRequest.setAttribute(failureKeyAttribute, "jCaptcha.error");
        return true;
    }
}
