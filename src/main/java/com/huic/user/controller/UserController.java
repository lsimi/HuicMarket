package com.huic.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huic.user.entity.User;
import com.huic.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService userService;

	//转到index.jsp
	@RequestMapping("/toUserIndex")
	public String toUserIndex() {
		return "home/person/index";
	}
	
	//转到Information.jsp
	@RequestMapping("/toInformation")
	public String toinformation() {
		return "home/person/information";
	}
	
	//查询
	@RequestMapping("/selectUser")
	public String toSelectUser(@RequestParam(defaultValue="1")Integer userId,ModelMap model ) {
		User user = userService.selectByPrimaryKey(userId);
		model.put("user", user);
		return "home/person/information";
	}
	
	
}
