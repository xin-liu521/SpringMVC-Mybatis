package com.infoyb.supplier.common.controller;

import com.infoyb.supplier.common.utils.ShiroUtils;
import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.controller </dt>
 * <dt>ClassName: AbstractController </dt>
 * <dd>CreateDate: 2017-08-18 10:18 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:    shiro登录后用户信息公共组件        </dd>
 * </dl>
 *
 * @author wangjun
 */
public abstract class AbstractUserController {
    /**
     *获取用户信息
     **/
    protected ByUsers getCommonUser() {
        return ShiroUtils.getUser();
    }
    /**
     *获取用户ID
     **/
    protected Long getCommonUserId() {
        return getCommonUser().getUserId();
    }
}
