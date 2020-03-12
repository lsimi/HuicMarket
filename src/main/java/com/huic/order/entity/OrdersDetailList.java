package com.huic.order.entity;

import java.util.List;

public class OrdersDetailList {

	List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrdersDetailList [orderDetails=" + orderDetails + "]";
	}

}
