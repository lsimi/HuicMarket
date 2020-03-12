package com.huic.user.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author 传智.郭嘉
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static boolean sendMail(String to, String code) {  

        try {  
            Properties props = new Properties();  
            props.put("username", "13928848035@163.com");   
            props.put("password", "ztw13928848035");   
            props.put("mail.transport.protocol", "smtp" );  
            props.put("mail.smtp.host", "smtp.163.com");  
            props.put("mail.smtp.port", "25" );  

            Session mailSession = Session.getDefaultInstance(props);  

            Message msg = new MimeMessage(mailSession);     
            msg.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse("13928848035@163.com"));
            msg.setFrom(new InternetAddress("13928848035@163.com"));  
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));   
            msg.setSubject("汇吃商城验证码");   
            msg.setContent("<h1>欢迎注册汇吃商城</h1><br>"
            		+ "验证码为:"+code,"text/html;charset=UTF-8");

            msg.saveChanges();  

            Transport transport = mailSession.getTransport("smtp");  
            transport.connect(props.getProperty("mail.smtp.host"), props  
                    .getProperty("username"), props.getProperty("password"));   
            transport.sendMessage(msg, msg.getAllRecipients());  
            transport.close();     
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println(e);  
            return false;  
        }  
        return true;  
    }   
    public static void main(String[] args) {
        sendMail("619742786@qq.com", "81239");
    }
}
