package com.huic.goods.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huic.goods.entity.Goods;
import com.huic.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Resource
	GoodsService goodsService;
	
	@RequestMapping("/goodDetail")
	public String introduction(Integer gId,ModelMap model){
		Goods goods = goodsService.selectGoodsByGoodsId(gId);
		model.put("goods", goods);
		return "home/home/introduction"; 
	}
}
