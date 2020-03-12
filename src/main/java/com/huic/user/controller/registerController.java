package com.huic.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huic.user.entity.User;
import com.huic.user.service.UserService;
import com.huic.user.utils.MD5Utils;
import com.huic.user.utils.MailUitls;

@Controller
@RequestMapping("/user")
public class registerController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/toRegister")
	public String toregister() {
		return "home/home/register";
	}
	
	//转发到top.jsp页面
	@RequestMapping("/toTop")
	public String toTop() {
		return "home/home/top";
	}
	
	//判断邮箱是否存在
	@RequestMapping(value="/checkEmail")
	@ResponseBody
	public Map<String,Object> checkEmail(String email) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(email == null || email.length() == 0) {
			map.put("msg", " 邮箱不能为空");
			return map;
		}
		User user = userService.selectByEmail(email);
		if(user != null) {
			map.put("msg", "该邮箱已被注册,请更换");
			return map;
		}else {
			map.put("email", email);
			map.put("msg",  "该邮箱没被注册,请放心使用");
			return map;
		}
	}
	
	//把验证码发送到用户邮箱
	@RequestMapping("/sendEmail")
	@ResponseBody
	public boolean sendEmail(String email,HttpSession session) {
		MailUitls uitl = new MailUitls();
		String code = (String) session.getAttribute("vcode");
		System.out.println(email + "  " +code);
		boolean b = uitl.sendMail(email, code);
		return b;
	}
	
	//把用户信息添加到数据库
	@RequestMapping(value="/insertEmail",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertUser(String email,String password,String vcode,HttpSession session) {
		String code = (String) session.getAttribute("vcode");
		System.out.println(vcode+":"+code);
		String msg = "";
		if(!vcode.equals(code)) {
			msg= "验证码不正确";
			return msg;
		}
		User user = new User();
		if(email != null) {
			user.setEmail(email);
		}
		if(password != null) {
			user.setPassword(MD5Utils.getPwd(password));
		}
		user.setUserStatus("1");
		int i = userService.insertSelective(user);
		if(i != 0) {
			msg= "注册成功";
		}
		return msg;
	}

}
