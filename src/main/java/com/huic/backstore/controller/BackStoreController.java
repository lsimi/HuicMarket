package com.huic.backstore.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.huic.backgoods.service.BackgoodsService;
import com.huic.backstore.service.BackStoreService;

//@Controller
@RequestMapping("/back/store")
public class BackStoreController {

	@Resource
	private BackStoreService service;
	
	@RequestMapping("/list")
	public String list()
	{
		return "back/product_list";
	}
	
}
