package com.infoyb.supplier.common.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.shiro </dt>
 * <dt>ClassName: CustomizedSessionManager </dt>
 * <dd>CreateDate: 2017-08-11 16:38 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: 重写DefaultWebSessionManager类中的retrieveSession方法(检索会话时，获取不到session不做处理)</dd>
 * </dl>
 *
 * @author wangjun
 */
public class CustomizedSessionManager extends DefaultWebSessionManager {

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        // TODO Auto-generated method stub
        try {
            return super.retrieveSession(sessionKey);
        } catch (UnknownSessionException e) {
            // TODO: handle exception
            //获取不到session不抛出异常 避免获取不到session后台报错
            return null;
        }
    }
}
