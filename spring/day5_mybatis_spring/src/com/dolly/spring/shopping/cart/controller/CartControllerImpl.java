package com.dolly.spring.shopping.cart.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.shopping.cart.service.CartService;

public class CartControllerImpl extends MultiActionController implements CartController {
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}


	public CartControllerImpl() {
		
		
		
	}

}
