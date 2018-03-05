package com.infoyb.supplier.common.shiro;

import com.alibaba.fastjson.JSONArray;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;
import com.infoyb.supplier.system.service.ByUsersService;
import com.infoyb.supplier.system.service.UserSupplierService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.shiro </dt>
 * <dt>ClassName: UserReam </dt>
 * <dd>CreateDate: 2017-08-11 16:30 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:  用户认证            </dd>
 * </dl>
 *
 * @author wangjun
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    ByUsersService byUsersService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        //获取用户信息
        //1需要引入shiro-systemt中的用户实体类
        ByUsers user = (ByUsers) principalCollection.getPrimaryPrincipal();
        //2根据用户id获取用户相应的资源信息
//        permsSet = byUsersService.findPermissions(user.getUserId());
        //3封装用户权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String account = (String) token.getPrincipal();
        //密码
        String password = new String((char[]) token.getCredentials());

        //查询用户信息
        //待引用infoyb-system中的用户相关类
        List<ByUsers> users = byUsersService.selectByEntity(new ByUsers(account));
        ByUsers user = users.size() > 0 ? users.get(0) : null;

        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //账号激活
        if (user.getIsActive() == 1) {
            throw new LockedAccountException("账号未激活，请在邮箱激活账号");
        }
//
//        //账号禁用
//        if(user.getStatus()==1){
//            throw new DisabledAccountException("账号已被禁用");
//        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getUserPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 清空权限缓存(当前用户)
     **/
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清空登录缓存(当前用户)
     **/
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

//    /**
//     * 清空权限缓存(所有)
//     **/
//    public void clearAllCachedAuthorizationInfo() {
//        UserSupplier current=ShiroUtils.getUser();
//        //封装菜单信息
//        List<SysMenu> menus = byUsersService.findMenus(current.getId());
//        SecurityUtils.getSubject().getSession().setAttribute("menuList", JSONArray.toJSON(menus));
//        getAuthorizationCache().clear();
//    }

}
