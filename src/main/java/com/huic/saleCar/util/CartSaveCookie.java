package com.huic.saleCar.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Component;

import com.huic.goods.service.GoodsdetailService;
import com.huic.saleCar.entity.CartItem;
@Component
public class CartSaveCookie {
	
	private List<CartItem> carts;
	
	public List<CartItem> getCarts() {
		return carts;
	}

	public void setCarts(List<CartItem> carts) {
		this.carts = carts;
	}
	
	public void addCartItem(){
		
	}

	public void clearCart(){
		
	}
	
	public void deleteCartItem(){
		
	}
	
	public void updateCartItem(){
		
	}
	
	
	
}
