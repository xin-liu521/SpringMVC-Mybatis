package com.infoyb.supplier.system.utils;

/**
 * Created by infoyb on 2017.11.02.
 */
public class Constant {

    public final static String DEFAULT_PWD = "111111";

    //算法名称
    public static final String KEY_ALGORITHM = "DES";

    //算法名称/加密模式/填充方式
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    //启用、停用状态 （ENABLE:启用，UNENABLE:停用）
    public static final Integer STATUS_ENABLE = 1;
    public static final Integer STATUS_UNENABLE = 0;

    //审核状态 （ NONE:未提交，AUDIT:待审核，REJECT:退回，PASS:通过）
    public static final Integer STATE_NONE = 0;
    public static final Integer STATE_AUDIT = 1;
    public static final Integer STATE_REJECT = 2;
    public static final Integer STATE_PASS = 3;
    //短信发送过期时间
    public static final Integer EXPIRATION_TIME = 5;
    //联系电话
    public static final String CONTACT_PHONE = "029-89384996";
    //根目录redis存取key
    public static final String COOIKE_KEY = "r-key";

    public static final Integer COOIKE_LIVE_TIME = 3600;

    public static final Integer REDIS_LIVE_TIME = 1800;

    public static final String LOGIN_PATH = "/users/loginView";


    /**
     * 用户状态
     */
    public abstract static interface USER_STATUS {
        /**
         * 该账号已冻结
         */
        public static final int USER_STATUS_0 = 0;
        /**
         * 该账号未激活
         */
        public static final int USER_STATUS_1 = 1;
        /**
         * 启用
         */
        public static final int USER_STATUS_2 = 2;
    }

    /**
     * 短信发送状态
     */
    public abstract static interface SMS_STATUS {
        //已发送
        public static final String SMS_STATUS_0 = "0";
        //已验证
        public static final String SMS_STATUS_1 = "1";
        //已过期
        public static final String SMS_STATUS_2 = "2";
        //发送失败
        public static final String SMS_STATUS_3 = "3";
    }

    /**
     * 短信操作类型
     */
    public abstract static interface SMS_TYPE {
        //注册
        public static final String SMS_TYPE_0 = "0";
        //修改密码
        public static final String SMS_TYPE_1 = "1";
        //绑定邮箱
        public static final String SMS_TYPE_2 = "2";
        //找回密码
        public static final String SMS_TYPE_3 = "3";
        //重置密码
        public static final String SMS_TYPE_4 = "4";
        //完善企业信息
        public static final String SMS_TYPE_5 = "5";
        //绑定手机
        public static final String SMS_TYPE_6 = "6";
        //解绑手机
        public static final String SMS_TYPE_7 = "7";
    }

    /**
     * 用户站内信类型
     */
    public abstract static interface USER_MSG {
        //企业资料
        public static final int USER_MSG_0 = 0;
        //我的消息
        public static final int USER_MSG_1 = 1;
        //绑定邮箱
        public static final int USER_MSG_2 = 2;
        //修改密码
        public static final int USER_MSG_3 = 3;
        //注册消息
        public static final int USER_MSG_4 = 4;
        //解绑邮箱
        public static final int USER_MSG_5 = 5;
        //绑定手机
        public static final int USER_MSG_6 = 6;
        //解绑手机
        public static final int USER_MSG_7 = 7;
        //审核员
        public static final int USER_MSG_8 = 8;
    }

    /**
     * 用户标识类型
     */
    public abstract static interface USER_FLAG_TYPE {
        /**
         * 个人用户
         */
        public static final int USER_FLAG_TYPE_0 = 0;
        /**
         * 企业员工
         */
        public static final int USER_FLAG_TYPE_1 = 1;
        /**
         * 企业管理员
         */
        public static final int USER_FLAG_TYPE_2 = 2;
    }

    /**
     * 系统用户端角色类型
     */
    public abstract static interface PLAT_ROLE_TYPE {
        /**
         * 个人用户
         */
        public static final int PLAT_ROLE_TYPE_0 = 0;
        /**
         * 企业员工
         */
        public static final int PLAT_ROLE_TYPE_1 = 1;
        /**
         * 企业管理员
         */
        public static final int PLAT_ROLE_TYPE_2 = 2;
        /**
         * 企业审核员
         */
        public static final int PLAT_ROLE_TYPE_3 = 3;
        /**
         * 系统超级管理员
         */
        public static final int PLAT_ROLE_TYPE_4 = 4;
    }

    /**
     * 系统平台类型
     */
    public abstract static interface PLATFORM_TYPE {
        /**
         * 清洗平台
         */
        public static final int PLATFORM_TYPE_0 = 0;
        /**
         * 分享平台
         */
        public static final int PLATFORM_TYPE_1 = 0;
    }

    /**
     * --------------------------供应商推荐常量-------------------------------
     */
    public static final String HTTP_URL = "http://apis.baidu.com/chazhao/ipsearch/ipsearch";
    //集合blions
    public static final String INDEX_BLIONS = "blions";
    //集合类型producy
    public static final String TYPE_PRODUCT = "product";
    //属性name
    public static final String ATTR_NAME = "name";
    //全文检索
    public static final boolean FLAG_TRUE = true;
    public static final Boolean FLAG_FALSE = false;

    /**
     * --------------------------供应商推荐常量-------------------------------
     */

    public static final String IMG_PATH = "http://img.infoyb.com";
}
