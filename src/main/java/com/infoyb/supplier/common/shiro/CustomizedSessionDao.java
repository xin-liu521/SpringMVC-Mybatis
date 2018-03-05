package com.infoyb.supplier.common.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import java.io.Serializable;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.shiro </dt>
 * <dt>ClassName: CustomizedSessionDao </dt>
 * <dd>CreateDate: 2017-08-14 14:54 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:      shiro session dao(方便以后扩展移动app方面的功能，如保持app长久登录)      </dd>
 * </dl>
 *
 * @author wangjun
 */
public class CustomizedSessionDao extends EnterpriseCacheSessionDAO {
    @Override
    public Serializable create(Session session) {
        return super.create(session);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        super.update(session);
        //可以操作移动app token逻辑(预留)
    }

    @Override
    public void delete(Session session) {
        //删除session(缓存中的)
        super.delete(session);
        //可以操作移动app token逻辑(预留)
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        Session session = null;
        try {
            session = super.readSession(sessionId);
        } catch (Exception e) {
        }
        //可以操作移动app token逻辑(预留)
        return session;
    }
}
