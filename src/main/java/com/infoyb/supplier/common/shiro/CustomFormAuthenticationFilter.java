package com.infoyb.supplier.common.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {


    /**
     * onAccessDenied：表示当访问拒绝时是否已经处理了；如果返回true 表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可
     **/
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response, Object mappedValue) throws Exception {
        // TODO Auto-generated method stub
        if (request.getAttribute(getFailureKeyAttribute()) != null) {
            return true;
        }
        return super.onAccessDenied(request, response, mappedValue);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 如果是登录操作，直接拦截不通过；shiro的实现是，如果用户登录过，再登录时，由于isAuthenticated为true，
        // 则直接不拦截，又跳转到登录页面去了。修改后，如果是post登录操作，则会重新执行登录过程，刷新当前session中的用户信息
        if (isLoginRequest(request, response)) {
            return false;
        }
        return super.isAccessAllowed(request, response, mappedValue) || !this.isLoginRequest(request, response) && this.isPermissive(mappedValue);
    }


}
