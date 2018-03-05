package com.infoyb.supplier.system.service;

import com.infoyb.supplier.system.model.Mail;

/**
 * <p>Encoding    :  UTF-8</p>
 * <p>Created_Time: 2015-10-10 16:50</p>
 * <p>Description: 邮件服务接口</p>
 *
 */
public interface MailService {

    /**
     * <pre>
     *   异步发送邮件
     * </pre>
     *
     * @param mail Mail 邮件对象事例
     */
    void sendMailAsyn(Mail mail);

    /**
     * <pre>
     * 同步发送邮件
     * </pre>
     *
     * @param mail Mail 邮件对象事例
     * @return boolean [true|false],如果发送成功返回true，否则返回false
     */
    boolean sendMail(Mail mail);

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
    boolean sendMail(String to, String subject, String content);

    /**
     * 根据模板文件获取文件内容
     * @param TemplateFile
     * @return
     */
    String getTemplateContentFromFile(String TemplateFile);

}
