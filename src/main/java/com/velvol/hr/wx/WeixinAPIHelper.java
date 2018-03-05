package com.velvol.hr.wx;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/24.
 */
public class WeixinAPIHelper {
    /**
     * 获取token接口
     */
    private String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
    /**
     * 拉微信用户信息接口
     */
    private String getUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}";
    /**
     * 主动推送信息接口
     */
    private String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/send?access_token={0}";
    private HttpClient webClient;
    private Log log = LogFactory.getLog(getClass());

    public void initWebClient(String proxyHost, int proxyPort){
        this.initWebClient();
        if(webClient != null && !StringUtils.isEmpty(proxyHost)){
            HttpHost proxy = new HttpHost(proxyHost, proxyPort);
            webClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        }
    }
    /**
     * @desc 初始化创建 WebClient
     */
    public void initWebClient() {
        log.info("initWebClient start....");
        try {
            PoolingClientConnectionManager tcm = new PoolingClientConnectionManager();
            tcm.setMaxTotal(10);
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new X509TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            Scheme sch = new Scheme("https", 443, ssf);
            tcm.getSchemeRegistry().register(sch);
            webClient = new DefaultHttpClient(tcm);
        } catch (Exception ex) {
            log.error("initWebClient exception", ex);
        } finally {
            log.info("initWebClient end....");
        }
    }
    /**
     * @desc 获取授权token
     * @param appid
     * @param secret
     * @return
     */
//    public String getAccessToken(String appid, String secret) {
//        String accessToken = null;
//        try {
//            log.info("getAccessToken start.{appid=" + appid + ",secret:" + secret + "}");
//            String url = MessageFormat.format(this.getTokenUrl, appid, secret);
//            String response = executeHttpGet(url);
//            accessToken = JsonUtils.read(response, "access_token");
//        } catch (Exception e) {
//            log.error("get access toekn exception", e);
//        }
//        return accessToken;
//    }
    /**
     * @desc 推送信息
     * @param token
     * @param msg
     * @return
     */
    public String sendMessage(String token,String msg){
        try{
            log.info("sendMessage start.token:"+token+",msg:"+msg);
            String url = MessageFormat.format(this.sendMsgUrl, token);
            HttpPost post = new HttpPost(url);
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            StringEntity entity = new StringEntity(msg);
            post.setEntity(entity);
            String response = (String) this.webClient.execute(post, responseHandler);
            log.info("return response=====start======");
            log.info(response);
            log.info("return response=====end======");
            return response;

        }catch (Exception e) {
            log.error("get user info exception", e);
            return null;
        }
    }
    /**
     * @desc 拉取用户信息
     * @param token
     * @param openid
     * @return
     */
//    public WeixinOpenUser getUserInfo(String token, String openid) {
//        try {
//            log.info("getUserInfo start.{token:" + token + ",openid:" + openid + "}");
//            String url = MessageFormat.format(this.getUserInfoUrl, token, openid);
//            String response = executeHttpGet(url);
//            JsonNode json = JsonUtils.read(response);
//            if (json.get("openid") != null) {
//                WeixinOpenUser user = new WeixinOpenUser();
//                user.setOpenUserId(json.get("openid").asText());
//                user.setState(json.get("subscribe").asText());
//                if ("1".equals(user.getState())) {
//                    user.setUserName(json.get("nickname").asText());
//                    user.setSex(json.get("sex").asText());
//                    user.setCity(json.get("city").asText());
//                    user.setLanguage(json.get("language").asText());
//                }
//                return user;
//            }
//        } catch (Exception e) {
//            log.error("get user info exception", e);
//        }
//        return null;
//    }
    /**
     * @desc 发起HTTP GET请求返回数据
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    private String executeHttpGet(String url) throws IOException, ClientProtocolException {
        ResponseHandler<?> responseHandler = new BasicResponseHandler();
        String response = (String) this.webClient.execute(new HttpGet(url), responseHandler);
        log.info("return response=====start======");
        log.info(response);
        log.info("return response=====end======");
        return response;
    }

    /**
     * 获得ACCESS_TOKEN
     * @param appid
     * @param secret
     * @return ACCESS_TOKEN
     */
    public static String getAccessToken(String appid, String secret) {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
        JSONObject jsonObject = httpRequest(url, "GET", null);
        try {
            if(jsonObject.getString("errcode")!=null){
                return "false";
            }
        }catch (Exception e) {
        }
        return jsonObject.getString("access_token");
    }

    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
//            X509TrustManager tm = new X509TrustManager()
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            javax.net.ssl.SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
        } catch (Exception e) {
        }
        return jsonObject;
    }

    /**
     * 获得getUserOpenIDs
     * @param accessToken
     * @return JSONObject
     */
    public static JSONObject getUserOpenIDs(String accessToken) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken;
        return httpRequest(url, "GET", null);
    }

    /**
     * 获得getUserOpenIDs
     * @param accessToken
     * @return JSONObject
     */
    public static JSONObject getUserOpenIDsOne(String accessToken, String next_openid) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken+"&next_openid="+next_openid;
        return httpRequest(url, "GET", null);
    }

    /**
     * 根据模板的编号 新增并获取模板ID
     * @param templateSerialNumber 模板库中模板的 "编号"
     * @return 模板ID
     */
    public  String getWXTemplateMsgId(String templateSerialNumber){
        String tmpurl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="+ getAccessToken("", "");
        JSONObject json = new JSONObject();
        json.put("template_id_short", templateSerialNumber);
        JSONObject result = httpRequest(tmpurl, "POST", json.toString());
        //JSONObject resultJson = new JSONObject(result);
        String errmsg = (String) result.get("errmsg");
        log.info("获取模板编号返回信息：" + errmsg);
        if(!"ok".equals(errmsg)){
            return "error";
        }
        String templateId = (String) result.get("template_id");
        return templateId;
    }

    /**
     * 发送微信消息(模板消息)
     * @param touser 用户 OpenID
     * @param templatId 模板消息ID
     * @param clickurl URL置空，则在发送后，点击模板消息会进入一个空白页面（ios），或无法点击（android）。
     * @param topcolor 标题颜色
     * @param data 详细内容
     * @return
     */
    public  String sendWechatMsgToUser(String touser, String templatId, String clickurl, String topcolor, JSONObject data) {
        String tmpurl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+ getAccessToken("","");
        JSONObject json = new JSONObject();
        json.put("touser", touser);
        json.put("template_id", templatId);
        json.put("url", clickurl);
        json.put("topcolor", topcolor);
        json.put("data", data);
        try{
            JSONObject result =httpRequest(tmpurl, "POST", json.toString());
            //JSONObject resultJson = new JSONObject(result);
            log.info("发送微信消息返回信息：" + result.get("errcode"));
            String errmsg = (String) result.get("errmsg");
            if(!"ok".equals(errmsg)){  //如果为errmsg为ok，则代表发送成功，公众号推送信息给用户了。
                return "error";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }finally {
            if(templatId!=null) {
                //删除新增的 微信模板
                //deleteWXTemplateMsgById(templatId);
            }
        }
        return "success";
    }

    /**
     * 封装模板详细信息
     * @return
     */
    public static JSONObject packJsonmsg(Map<String, TemplateData> param) {
        JSONObject json = new JSONObject();
        for (Map.Entry<String,TemplateData> entry : param.entrySet()) {
            JSONObject keyJson = new JSONObject();
            TemplateData  dta=  entry.getValue();
            keyJson.put("value",dta.getValue());
            keyJson.put("color", dta.getColor());
            json.put(entry.getKey(), keyJson);
        }
        return json;
    }

    /**
     * @desc 发送消息接口
     */
    public void senMsg(){
        JSONObject userJson = getUserOpenIDs(getAccessToken("",""));
        String openId = (String) userJson.get("data");
        String next_openid = (String) userJson.get("next_openid");
        int count = Integer.parseInt(userJson.get("count").toString());
        if (count == 10000){
            JSONObject userJson1 = getUserOpenIDsOne(getAccessToken("",""), next_openid);
        }
        //用户是否订阅该公众号标识 (0代表此用户没有关注该公众号 1表示关注了该公众号)
        Integer  state= WX_UserUtil.subscribeState(openId);
        // 绑定了微信并且关注了服务号的用户 , 注册成功-推送注册短信
        if(state==1){
            Map<String,TemplateData> param = new HashMap<>();
            param.put("first",new TemplateData("恭喜您注册成功！","#696969"));
            param.put("keyword1",new TemplateData("15618551533","#696969"));
            param.put("keyword2",new TemplateData("2017年05月06日","#696969"));
            param.put("remark",new TemplateData("祝投资愉快！","#696969"));
            //注册的微信-模板Id
            String regTempId =  getWXTemplateMsgId(WeiXinEnum.WX_TEMPLATE_MSG_NUMBER.USER_REGISTER_SUCCESS.getMsgNumber());
            //调用发送微信消息给用户的接口
            //JSONObject jsonOb = JSONObject.fromObject(param);
            sendWechatMsgToUser(openId,regTempId, "", "#000000", packJsonmsg(param));
        }
    }
}
