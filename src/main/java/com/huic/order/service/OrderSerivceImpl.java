package com.huic.order.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huic.addrinfo.service.AddrInfoService;
import com.huic.base.service.AbstractServiceImpl;
import com.huic.goods.entity.Goodsdetail;
import com.huic.goods.service.GoodsdetailService;
import com.huic.order.dao.OrderDetailMapper;
import com.huic.order.dao.OrderMapper;
import com.huic.order.entity.Order;
import com.huic.order.entity.OrderDetail;
import com.huic.order.entity.OrdersDetailList;

@Service
public class OrderSerivceImpl extends AbstractServiceImpl<Order> implements OrderService{
	
	@Resource
	OrderMapper orderMapper;
	
	@Resource
	OrderDetailMapper orderDetailMapper;
	
	@Resource
	GoodsdetailService goodsdetailService;
	
	@Resource
	AddrInfoService addrInfoService;
	
	@Override
	public int insertSelective(Order order, OrdersDetailList ordersDetailList) {
		//默认状态是未付款状态
		order.setPayStatus(0);
		
		if(order.getExpressId()==null){
			//设置默认地址为圆通快递
			order.setExpressId(2);
		}
		//所有订单详情信息
		List<OrderDetail> orderDetails = ordersDetailList.getOrderDetails();
		
		//插入订单表  设置下单时间为系统时间，状态都为未发货
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
		order.setOrStatus(0);
		int orderNum = orderMapper.insertSelective(order);
		int odNum =0;
		int gdNum =0;
		for (OrderDetail orderDetail : orderDetails) {
			orderDetail.setOrId(order.getOrId());
			odNum = orderDetailMapper.insertSelective(orderDetail);
			Goodsdetail goodsdetail = goodsdetailService.selectByGdId(orderDetail.getGdId());
			gdNum = goodsdetailService.updateStock(goodsdetail.getStock()-orderDetail.getgNum(), orderDetail.getGdId());
		}
		if(orderNum>0 && odNum>0 && gdNum>0){
			return 1;
		}
		return 0;
	}
	
	
}
