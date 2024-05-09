package com.dolly.spring.shopping.order.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.shopping.order.service.OrderService;

public class OrderControllerImpl extends MultiActionController implements OrderController {
	private OrderService orderService;
	
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public OrderControllerImpl() {
		// TODO Auto-generated constructor stub
	}

}
