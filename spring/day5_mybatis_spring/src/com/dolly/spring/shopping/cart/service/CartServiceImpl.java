package com.dolly.spring.shopping.cart.service;

import com.dolly.spring.shopping.cart.dao.CartDAO;

public class CartServiceImpl implements CartService {
	private CartDAO cartDAO;
	
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
