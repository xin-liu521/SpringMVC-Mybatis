package com.velvol.hr.web.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.velvol.hr.wx.constants.MaterialTypes;
import com.velvol.hr.wx.constants.MsgTypes;
import com.velvol.hr.wx.util.HttpUtil;
import com.velvol.hr.wx.util.MenuUtil;
import com.velvol.hr.wx.util.SignUtil;
import com.velvol.hr.wx.util.WechatMessageUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName: WeixinController
 * @Description: 响应Controller
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class WeixinAction  extends ActionSupport {
	
	 private Logger log = Logger.getLogger(WeixinAction.class);

	@Override
	public String execute() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		log.info("请求进来了...");
		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				log.info("请求进来了+++++++...");
				String method = ServletActionContext.getRequest().getMethod();
				log.info("请求进来了method="+method);
				if (method.equals("POST")) {

					Map<String , String> map = WechatMessageUtil.parseXml(request);

					String ToUserName = map.get("ToUserName");

					String FromUserName = map.get("FromUserName");

					String CreateTime = map.get("CreateTime");

					String MsgType = map.get("MsgType");

					String Content = map.get("Content");

					String MsgId  = map.get("MsgId ");
					log.info("map="+map);
					String message = null;
					if (MsgType.equals(MsgTypes.TEXT)) {//判断是否为文本消息类型
						if (Content.equals("1")) {
							message = MsgTypes.initText(ToUserName, FromUserName,
									"对啊！我也是这么觉得！这公众号吊炸天了！");
						} else if(Content.equals("2")){
							message = MsgTypes.initText(ToUserName, FromUserName,
									"好可怜啊！你就会乱发言！");
						} else if(Content.equals("?") || Content.equals("？")){

							message = MsgTypes.initText(ToUserName, FromUserName,
									"没让你选的就别瞎嘚瑟！");
						} else {
							message = MsgTypes.initText(ToUserName, FromUserName,
									"没让你选的就别瞎嘚瑟！！！");
						}
					}else if(MsgType.equals(MsgTypes.EVENT)){//判断是否为事件类型
						//从集合中，或许是哪一种事件传入
						String eventType = map.get("Event");
						//关注事件
						if (eventType.equals(MsgTypes.EVENT_TYPE_SUBSCRIBE)) {
							message = MsgTypes.initText(ToUserName, FromUserName, WechatMessageUtil.menuText());
						}
						// 自定义菜单点击事件
						else if (eventType.equals(MsgTypes.EVENT_TYPE_CLICK)) {
							// 事件KEY值，与创建自定义菜单时指定的KEY值对应
							String eventKey = map.get("EventKey");

							if (eventKey.equals("11")) {
								message = MsgTypes.initText(ToUserName, FromUserName,
										"入职进展被点击！！！");
							} else if (eventKey.equals("12")) {
								message = MsgTypes.initText(ToUserName, FromUserName,
										"骑手注册被点击！！！");
							}
						}
						//自定义菜单URL事件
						else if (eventType.equals(MsgTypes.EVENT_TYPE_VIEW)) {
							String url = map.get("EventKey");
							String menuId = url.substring(url.lastIndexOf("_")+1, url.length()-4);
							log.info("menuId========"+menuId);
							//点击的那个菜单
//							if (menuId.equals("register")) {
//								String context = new PreworkerAction().scanAdd();
//								if (context != null && !context.equals("")) {
//									message = MsgTypes.initText(ToUserName, FromUserName,
//											context.equals("注册失败")?"注册失败":context);
//								}
//
//							}
						}


					}

					System.out.println(message);
					out.print(message);

				}else {
					out.print(echostr);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
		return null;
	}

	/**
	 * <b>获取最新accessToken<b>
	 *
	 * @return String
	 */
	public String getAccessToken() {
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + MaterialTypes.APP_ID
				+ "&secret=" + MaterialTypes.APP_SECRET;

		JSONObject json = JSONObject.fromObject(HttpUtil.getJsonObjectByUrl(apiUrl));

		String access_token = json.get("access_token") + "";
		System.out.println("access_token:" + access_token);
		return access_token;
	}

	/**
	 * @desc创建菜单
	 */
	public void createMenus() {
		// 调用接口获取access_token
		String access_token = new WeixinAction().getAccessToken();
		int status = MenuUtil.createMenu(MenuUtil.initMenu(), access_token);
		if(status==0){
			System.out.println("菜单创建成功！");
		}else{
			System.out.println("菜单创建失败！");
		}
	}

	/**
	 * @desc 跳转注册页面
	 * @return
     */
	public String weixinOAuth() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		//得到code
		String CODE = request.getParameter("code");
		log.info("CODE========"+CODE);
		String APPID = MaterialTypes.APP_ID;
		String SECRET = MaterialTypes.APP_SECRET;
		//换取access_token 其中包含了openid
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code".replace("APPID", APPID).replace("SECRET", SECRET).replace("CODE", CODE);
		JSONObject json = JSONObject.fromObject(HttpUtil.getJsonObjectByUrl(URL));
		//System.out.println(jsonStr);
		//out.print(jsonStr);
		String openid = json.get("openid").toString();
		log.info("openid========"+openid);

		String access_token = getAccessToken();
		//有了用户的opendi就可以的到用户的信息了
		String userURL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		//得到用户信息之后返回到一个页面
		JSONObject userJson = JSONObject.fromObject(HttpUtil.getJsonObjectByUrl(userURL));
		ActionContext ac = ActionContext.getContext();
		log.info("userJson========"+userJson);
		log.info("access_token========"+access_token);
		ac.put("openid", openid);
		ac.put("access_token", access_token);
		return "register";
	}
}