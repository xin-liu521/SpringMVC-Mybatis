package com.infoyb.supplier.system.service.impl;

import com.infoyb.supplier.system.model.Mail;
import com.infoyb.supplier.system.service.MailService;
import com.infoyb.supplier.system.utils.MailConfig;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by infoyb on 2017.11.02.
 */
@Service
public class MailServiceImpl implements MailService {

    private static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    /**
     * <pre>
     *   异步发送邮件
     * </pre>
     *
     * @param mail Mail 邮件对象事例
     */
    @Override
    public void sendMailAsyn(Mail mail) {
        final Mail mail2 = mail;
        Thread t = new Thread() {
            @Override
            public void run() {
                sendMail(mail2);
            }
        };
        t.start();
    }

    /**
     * <pre>
     * 同步发送邮件
     * </pre>
     *
     * @param mail Mail 邮件对象事例
     * @return boolean [true|false],如果发送成功返回true，否则返回false
     */
    @Override
    public boolean sendMail(Mail mail) {
        boolean result = true;

        if (null == mail.getMailServer()) {
            mail.setMailServer(MailConfig.MAIL_SERVER);
        }
        if (null == mail.getFrom()) {
            mail.setFrom(MailConfig.MAIL_FROM);
        }
        if (null == mail.getContentType()) {
            mail.setContentType(MailConfig.MAIL_CONTENT_TYPE);
        }
        if (null == mail.getSender()) {
            mail.setSender(MailConfig.MAIL_SENDER);
        }

        if (null == mail.getPassword()) {
            mail.setPassword(MailConfig.MAIL_SERVER_PASSWORD);
        }

        if (null == mail.getSubject()) {
            mail.setSubject(MailConfig.MAIL_SUBJECT);
        }

        if (null == mail.getSmtpPort()) {
            mail.setSmtpPort(Integer.valueOf(MailConfig.MAIL_SMTP_PORT));
        }

        SimpleEmail sm = new SimpleEmail();
        sm.setHostName(mail.getMailServer());
        sm.setSubject(mail.getSubject());
        sm.setContent(mail.getContent(), mail.getContentType());
        sm.setSslSmtpPort(mail.getSmtpPort() + "");
//		sm.setSmtpPort(mail.getSmtpPort());

        if (mail.getPassword() != null) {
            sm.setAuthenticator(new DefaultAuthenticator(mail.getFrom(), mail.getPassword()));
        }
        try {
            sm.setFrom(mail.getFrom(), mail.getSender());
            String[] tos = mail.getTo().split("[,;]");
            for (String to : tos) {
                sm.addTo(to);
            }
            sm.send();
        } catch (EmailException ex) {
            result = false;
            logger.error("发送邮件异常:" + ex);
        }

        return result;
    }

    /**
     * <pre>
     * 邮件发送方法重构
     * </pre>
     *
     * @param to      String 邮件接收者
     * @param subject String 邮件标题
     * @param content String 邮件内容
     * @return boolean [true|false],如果发送成功返回true，否则返回false
     */
    @Override
    public boolean sendMail(String to, String subject, String content) {
        boolean result = false;
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setContent(content);
        result = sendMail(mail);
        return result;
    }

    /**
     * 根据模板文件获取文件内容
     *
     * @param templateFile
     * @return String
     */
    @Override
    public String getTemplateContentFromFile(String templateFile) {
        String result = "";

        InputStream is = MailServiceImpl.class.getClassLoader().getResourceAsStream("email/" + templateFile + ".html");
        InputStreamReader isr;
        try {
            isr = new InputStreamReader(is, "UTF-8");

            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                result += s;
            }
            br.close();

        } catch (IOException ex) {
            logger.error("获取邮件模板异常");
        }
        return result;
    }

    public static void main(String[] args) {
        Mail m = new Mail();
        m.setTo("80403948@qq.com");
        m.setContent("测试邮件,请勿回复............");
//		m.setContent("ni hao");
        MailService ms = new MailServiceImpl();
//		ms.sendMail()

        ms.sendMail(m);
        logger.info("-----------");
//		ms.getTemplateContentFromFile("mail-invite-code");

    }

}

