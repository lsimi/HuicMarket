package com.huic.backgoodsdetail.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backgoodsdetail.entity.Backgoodsdetail;
import com.huic.backgoodsdetail.service.Backgoodsdetailservice;

@Controller
@RequestMapping("/back/goodsdetail")
public class backgoodsdetailController {

	@Resource
	private Backgoodsdetailservice service;
	
	@RequestMapping("/list")
	public String list(BackgoodsPage backgoodsPage,ModelMap model)
	{
		System.out.println(backgoodsPage.getGid());
		//获得用户点击的商品的详细类型
		List<Backgoodsdetail> goodsdetails = service.selectByGid(backgoodsPage);
		model.put("goodsdetails", goodsdetails);
		
		for(Backgoodsdetail backgoodsdetail : goodsdetails) 
		{
			System.out.println(backgoodsdetail);
		}
		return "back/product_type";
	}
	
}
