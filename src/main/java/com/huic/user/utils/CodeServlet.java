package com.huic.user.utils;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.google.code.kaptcha.servlet.KaptchaServlet;


/**
 * KaptchaServlet是HttpServlet子类  
 * CodeServlet继承了KaptchaServlet，里面实现了自动生成验证码的功能
 * 
 * initParams:设置servlet初始化参数
 * kaptcha.session.key：指定当前的验证码字符串绑定到session的 attribute上面的key值
 * @author Administrator
 *
 */
@WebServlet(value="/kapacha.jpg",
initParams={
		@WebInitParam(name="kaptcha.session.key",value="vcode"),
		@WebInitParam(name="kaptcha.image.width",value="135"),
		@WebInitParam(name="kaptcha.image.height",value="40"),
		@WebInitParam(name="kaptcha.noise.color",value="248,248,255"),
		@WebInitParam(name="kaptcha.textproducer.char.string",value="abcde2345678gfynmnpwx"),
		@WebInitParam(name="kaptcha.textproducer.char.length",value="4"),
		@WebInitParam(name="kaptcha.textproducer.font.size",value="30"),
		@WebInitParam(name="kaptcha.textproducer.font.color",value="blue")
})
public class CodeServlet extends KaptchaServlet{

}
