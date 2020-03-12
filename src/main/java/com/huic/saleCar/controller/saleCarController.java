package com.huic.saleCar.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.huic.collect.entity.Collect;
import com.huic.collect.service.CollectService;
import com.huic.goods.service.GoodsdetailService;
import com.huic.saleCar.entity.SaleCar;
import com.huic.saleCar.service.SaleCarService;
import com.huic.store.entity.Store;
import com.huic.user.entity.User;

@Controller
@RequestMapping("/cart")
public class saleCarController {
	
	
	public static User getUser(HttpServletRequest request){
		//从session中获取user，为空表示没有登录
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		return user;
	}
	
	
	@Resource
	SaleCarService saleCarService;
	
	@Resource
	GoodsdetailService goodsdetailService;
	
	@Resource
	CollectService collectService;
	
	
	
	/**
	 * 跳转到购物车页面，用户已登录状态,根据用户ID显示相应的数据，用户没有登录，获取session值
	 * @return
	 */
	@RequestMapping("/list")
	public String toShopCart(
			ModelMap model,HttpServletRequest request,
			@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="3")Integer pageSize){
		//userId从session的用户获取，后期补上
		PageInfo<SaleCar> pageInfo = saleCarService.selectSaleCarInfo(pageNum, pageSize, 1);
		
		//获取用户购物车中商品所属的店铺Id,是购物车商品进行按店分类的关键
		Set<Store> stores = new HashSet<Store>();
		for (SaleCar pageInfos : pageInfo.getList()) {
			Store store = pageInfos.getGoodsdetail().getGoods().getStore();
			stores.add(store);
		}
		model.put("stores",stores);
		model.put("pageInfo", pageInfo);
		
		return "home/home/shopcart";
	}
	
	/**
	 * 将购物车商品加进收藏夹,实际是往购物车插入数据
	 * @param collection
	 * @return
	 */
	@RequestMapping(value="/collection")
	@ResponseBody
	public int collection(Collect collect){
		Collect coll = collectService.selectByCollect(collect);
		//判断是否为已收藏
		if(coll==null){
			return collectService.insertSelective(collect);
		}else{
			return 0;
		}
		
	}
	/**
	 * 更改购物车商品数量
	 * @param carId
	 * @param salNum
	 * @return
	 */
	@RequestMapping(value="/updateSalNum")
	@ResponseBody
	public Map<String,Object> updateSalNum(int carId,int salNum){
		System.out.println("salNum  :  "+salNum);
		saleCarService.updateSalNum(carId, salNum);
		SaleCar car = saleCarService.selectByPrimaryKey(carId);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("salNum", car.getSalNum());
		return map; 
	}
	/**
	 * 删除单个购物车项的功能
	 * @param carId
	 * @return
	 */
	@RequestMapping("/deleteOneItem")
	public String deleteOneItem(Integer carId){
		SaleCar item = saleCarService.selectByPrimaryKey(carId);
		if(item!=null){
			saleCarService.deleteByPrimaryKey(carId);
			return "redirect:/cart/list";
		}
		return null;
	}
	/**
	 * 批量删除购物车项
	 * @param carIds
	 * @param request
	 * @return
	 */
	@RequestMapping("/delBacthCartItems")
	public String delBacthCartItems(int[] carIds,HttpServletRequest request){
		for(int i:carIds){
			System.out.println(i);
		}
		User user = getUser(request);
		//if(user!=null){
		//user.getUserId()
			//saleCarService.deleteBacth(1, carIds);
			
		//}
		return "redirect:/cart/list";
	}
	
	@RequestMapping("/addcartItem")
	@ResponseBody
	public int insert(Integer gdId) {
		//先判断加入商品是否存在购物车==》 没有的话新插入数据，有的话根据id更改数量
		saleCarService.selectByPrimaryKey(gdId)
		return 0;
	}
}
