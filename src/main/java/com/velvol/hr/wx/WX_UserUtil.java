package com.velvol.hr.wx;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WX_UserUtil {
    private static Logger log = LoggerFactory.getLogger(WX_UserUtil.class);
    /**
     * 根据微信openId 获取用户是否订阅
     * @param openId 微信openId
     * @return 是否订阅该公众号标识
     */
    public static Integer subscribeState(String openId){
        String tmpurl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+WeixinAPIHelper.getAccessToken("","") +"&openid="+openId;
        JSONObject result = WeixinAPIHelper.httpRequest(tmpurl, "GET",null);
        //JSONObject resultJson = new JSONObject(result);
        //log.error("获取用户是否订阅 errcode:{} errmsg:{}", result.getInteger("errcode"), result.getString("errmsg"));
        String errmsg = (String) result.get("errmsg");
        if(errmsg==null){
            //用户是否订阅该公众号标识（0代表此用户没有关注该公众号 1表示关注了该公众号）。
            Integer subscribe = (Integer) result.get("subscribe");
            return subscribe;
        }
        return -1;
    }

}