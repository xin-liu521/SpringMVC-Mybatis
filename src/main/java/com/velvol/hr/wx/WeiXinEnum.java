package com.velvol.hr.wx;

/**
 * Created by Administrator on 2018/2/24.
 */
public class WeiXinEnum {
    // 缓存类型
    public enum CACHE_TYPE {
        CACHE_WX_ACCESS_TOKEN,   //模板消息access_token
    }
    // 模板消息编号
    public enum WX_TEMPLATE_MSG_NUMBER {
        USER_REGISTER_SUCCESS(0, "OPENTM407796225", "注册成功"),
        ORDER_PAYED_SUCCESS(1, "OPENTM207421553", "订单支付");
        private int code;
        private String msgNumber;
        private String label;

        WX_TEMPLATE_MSG_NUMBER(int code, String msgNumber, String label) {
            this.code = code;
            this.msgNumber = msgNumber;
            this.label = label;
        }

        public int getCode() {
            return code;
        }

        public String getMsgNumber() {
            return msgNumber;
        }

        public String getLabel() {
            return label;
        }
    }
}
