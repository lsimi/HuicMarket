package com.huic.saleCar.entity;

import com.huic.goods.entity.Goodsdetail;

//购物项
public class CartItem {
	
	private Integer salNum;
	private Goodsdetail goodsdetail;
	
	public Integer getSalNum() {
		return salNum;
	}
	public void setSalNum(Integer salNum) {
		this.salNum = salNum;
	}
	public Goodsdetail getGoodsdetail() {
		return goodsdetail;
	}
	public void setGoodsdetail(Goodsdetail goodsdetail) {
		this.goodsdetail = goodsdetail;
	}
	@Override
	public String toString() {
		return "CartItem [salNum=" + salNum + ", goodsdetail=" + goodsdetail + "]";
	}
	
	
}
