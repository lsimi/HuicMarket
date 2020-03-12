package com.huic.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huic.addrinfo.entity.AddrInfo;
import com.huic.addrinfo.service.AddrInfoService;
import com.huic.express.entity.Express;
import com.huic.express.service.ExpressService;
import com.huic.goods.service.GoodsdetailService;
import com.huic.order.entity.Order;
import com.huic.order.entity.OrdersDetailList;
import com.huic.order.service.OrderService;
import com.huic.saleCar.entity.SaleCar;
import com.huic.saleCar.service.SaleCarService;
import com.huic.user.entity.User;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	AddrInfoService addrInfoService;
	
	/*@Resource
	StoreService storeService;*/
	
	@Resource
	ExpressService expressService ;
	
	@Resource
	SaleCarService saleCarService;
	
	@Resource
	GoodsdetailService goodsdetailService;
	
	@Resource
	OrderService orderService;
	
	public static User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		return user;
	}
	/**
	 * 展示购物车选中结算商品 ==》cartItems
	 * 展示已知相关的快递信息==》express
	 * 展示结算用户的下单地址==》addrInfos
	 * @param model
	 * @param request
	 * @param carIds《==购物车信息也携带过来的结算商品购车车项id
	 * @return
	 */
	@RequestMapping("/toPay")
	public String toPay(ModelMap model,HttpServletRequest request,int[] carIds){
		//User user=getUser(request);
		//List<AddrInfo> addrInfos = addrInfoService.selectAddrByUserId(user.getUserId());
		
		//获取该用户的所有收货地址
		List<AddrInfo> addrInfos = addrInfoService.selectAddrByUserId(1);
		//获得购物车商品
		List<SaleCar> cartItems=saleCarService.selectSaleCarInfoByCarId(carIds, 1);
		//获得快递信息
		List<Express> express = expressService.selectAll();
		model.put("addrInfos", addrInfos);
		model.put("cartItems", cartItems);
		model.put("express", express);
		return "home/home/pay";
	}
	/**
	 * 下单 ==》同时操作3张表 ：goodsdetail order orderdetail 
	 * @param order
	 * @param orderDetails
	 * @param request
	 * @return
	 */
	@RequestMapping("/place")
	public String place(Order order,OrdersDetailList orderDetails,HttpServletRequest request,ModelMap model){
		
		if(order.getAddrId()==null){
			//默认地址
			order.setAddrId(addrInfoService.selectAddrByDefaltstatus(0, 1));
		}
		order.setUserId(1);
		int i = orderService.insertSelective(order, orderDetails);
		if(i>0){
			model.put("order", order);
			return "alipay/index";
		}
		return null;
	}
	
	@RequestMapping("/success")
	public String toSuccess(){
		return "home/home/success";
	}
}
