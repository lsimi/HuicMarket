package com.huic.addrinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huic.addrinfo.entity.AddrInfo;
import com.huic.addrinfo.service.AddrInfoService;
import com.huic.user.entity.User;

@Controller
@RequestMapping("/address")
public class AddInfoController {
	
	@Resource
	AddrInfoService addrInfoService;
	
	public static User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		return user;
	}
	/**
	 * 修改默认地址
	 * @param addrId
	 * @return
	 */
	@RequestMapping("/updateDefaultAddr")
	@ResponseBody
	public int updateDefaultAddr(Integer addrId){
		//判断用户是否登录，要补上
		return addrInfoService.updateAddrStatus(addrId);
	}
	
	@RequestMapping("/addAddrInfo")
	public String addAddrInfo(AddrInfo addrInfo){
		//判断用户是否登录，要补上
		addrInfo.setAddrStatus(1);
		addrInfo.setUserId(1);
		addrInfoService.insertSelective(addrInfo);
		return "redirect:/order/toPay";
	}
	
	@RequestMapping("/delAddrInfo")
	@ResponseBody
	public int delAddrInfo(Integer addrId){
		//判断用户是否登录，要补上
		int i = addrInfoService.deleteAddrInfo(addrId, 1);
		System.out.println(i);
		return  i;
				
	}
	
	
	
	
	
}
