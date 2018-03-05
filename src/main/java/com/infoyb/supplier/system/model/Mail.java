package com.infoyb.supplier.system.model;

import java.io.Serializable;

/**
 * Created by infoyb on 2017.11.02.
 */
public class Mail implements Serializable {

    //mail 接收者
    private String to;
    //mail 发送者
    private String from;
    private String sender;
    private String header;
    //标题
    private String subject;
    //邮件内容
    private String content;

    private String xMailer;
    //mail server密码
    private String password;
    //mail server
    private String mailServer;
    //邮件内容
    private String contentType;
    //发送服务器端口
    private Integer smtpPort;

    private String mimeVersion;

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the xMailer
     */
    public String getxMailer() {
        return xMailer;
    }

    /**
     * @param xMailer the xMailer to set
     */
    public void setxMailer(String xMailer) {
        this.xMailer = xMailer;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mailServer
     */
    public String getMailServer() {
        return mailServer;
    }

    /**
     * @param mailServer the mailServer to set
     */
    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the mimeVersion
     */
    public String getMimeVersion() {
        return mimeVersion;
    }

    /**
     * @param mimeVersion the mimeVersion to set
     */
    public void setMimeVersion(String mimeVersion) {
        this.mimeVersion = mimeVersion;
    }

    @Override
    public String toString() {
        return "Mail{" + "to=" + to + ", from=" + from + ", sender=" + sender + ", header=" + header + ", subject=" + subject + ", content=" + content + ", xMailer=" + xMailer + ", password=" + password + ", mailServer=" + mailServer + ", contentType=" + contentType + ", mimeVersion=" + mimeVersion + '}';
    }


}

