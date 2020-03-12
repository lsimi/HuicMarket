package com.huic.order.service;

import java.util.List;

import com.huic.base.service.BaseService;
import com.huic.order.entity.Order;
import com.huic.order.entity.OrdersDetailList;
import com.huic.store.entity.Store;

public interface OrderService extends BaseService<Order>{
	
	int insertSelective(Order order,OrdersDetailList ordersDetailList);
}
