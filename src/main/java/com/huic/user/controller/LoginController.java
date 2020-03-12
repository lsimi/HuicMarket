package com.huic.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huic.user.entity.User;
import com.huic.user.service.UserService;
import com.huic.user.utils.MD5Utils;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	UserService userService;
	
	@RequestMapping(value="/toLogin")
	public String toLogin() {
		return "home/home/login";
	}
	
	//进去主页
	@RequestMapping(value="/toHome")
	public String toHome() {
		return "home/home/home";
	}
	
	//登录逻辑代码
	@RequestMapping(value="/login")
	public String login(String email,String password,@RequestParam(defaultValue="0")String remeber,
			ModelMap model,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println(remeber);
		if(email != null && email.length() !=0) {
			User user = userService.selectByEmail(email);
			if(user != null) {
				if(MD5Utils.getPwd(password).equals(user.getPassword())) {
					if(remeber.equals("1")){
						Cookie cookie = new Cookie("autoLogin", user.getEmail()+":"+URLEncoder.encode(password, "UTF-8"));
						cookie.setMaxAge(7*24*60*60);
						cookie.setPath("/");
						System.out.println("用户实现了记住密码");
						response.addCookie(cookie);
					}else {
						request.getSession().removeAttribute("email");
						request.getSession().removeAttribute("password");
						request.getSession().removeAttribute("loginStatus");
						Cookie cookie = new Cookie("autoLogin", null);
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
					request.getSession().setAttribute("user", user);
					return "home/home/home";
				}else {
					model.put("msg", "密码不正确");
					model.put("email", user.getEmail());
					return "home/home/login";
				}
			}else {
				model.put("msg", "邮箱不存在");
				return "home/home/login";
			}
		}else {
			model.put("msg", "邮箱不能为空");
			return "home/home/login";
		}
		
	}
}
