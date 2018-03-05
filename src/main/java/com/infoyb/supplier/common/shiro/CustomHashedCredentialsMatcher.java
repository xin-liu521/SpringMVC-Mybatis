package com.infoyb.supplier.common.shiro;

import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.service.ByUsersService;
import com.infoyb.supplier.system.service.UserSupplierService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.shiro </dt>
 * <dt>ClassName: CustomHashedCredentialsMatcher </dt>
 * <dd>CreateDate: 2017-08-16 16:21 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:     密码验证器(存在slat情况)       </dd>
 * </dl>
 *
 * @author wangjun
 */
public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Autowired
    ByUsersService byUsersService;

    private Cache<String, AtomicInteger> passwordRetryCache;

    public CustomHashedCredentialsMatcher(org.apache.shiro.cache.CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    /**
     * 登录验证，如果加入salt配置，会进入到改方法
     *
     * @param token 获取当前的token
     * @param info  获取当前用户验证成功后的info
     **/
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //可以加载密码输入错误次数超过多少后，限制登录逻辑
        //比对用户信息(密码比对)
        String account = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(account);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(account, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {//密码重复验证5次以上
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry count
            passwordRetryCache.remove(account);
//            List<UserSupplier> users = sysUserService.selectByEntity(new UserSupplier(username));
//            //封装菜单信息
//            List<SysMenu> menus = sysUserService.findMenus(users.get(0).getUserId());
//            SecurityUtils.getSubject().getSession().setAttribute("menuList", JSONArray.toJSON(menus));
        }
        return matches;
    }
}
