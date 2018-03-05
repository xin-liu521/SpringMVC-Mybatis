package com.infoyb.supplier.system.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by infoyb on 2017.11.02.
 */
public class MailConfig {
    //	private static Logger logger = LoggerFactory.getLogger(MailConfig.class);
    private final static Properties props = new Properties();

    //mail server地址
    public static String MAIL_SERVER;
    //mail server 密码
    public static String MAIL_SERVER_PASSWORD;
    //mail from
    public static String MAIL_FROM;
    //发送者
    public static String MAIL_SENDER;
    //标题
    public static String MAIL_SUBJECT;
    //内容类型
    public static String MAIL_CONTENT_TYPE;
    //发送服务器端口
    public static String MAIL_SMTP_PORT;

    //mail server配置文件
    private static final String CONFIG_FILE = "mail.properties";

    static {
        //加载redis配置文件
        InputStream is = MailConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        try {
            props.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
//			logger.error("获取邮件配置文件失败!");
        }

        //set value
        MAIL_SERVER = props.getProperty("mail.server", "smtp.exmail.qq.com");
        MAIL_SERVER_PASSWORD = props.getProperty("mail.password", "Info2015Yb");
        MAIL_FROM = props.getProperty("mail.from", "no-reply@infoyb.com");
        MAIL_SENDER = props.getProperty("mail.sender", "北元客商平台!");
        MAIL_SUBJECT = props.getProperty("mail.subject", "系统自动发出");
        MAIL_CONTENT_TYPE = props.getProperty("mail.contentType", "text/html;charset=UTF-8");
        MAIL_SMTP_PORT = props.getProperty("mail.sslSmtpPort", "465");

    }
}
