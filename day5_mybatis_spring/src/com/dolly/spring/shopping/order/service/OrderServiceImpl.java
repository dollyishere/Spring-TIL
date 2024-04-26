package com.dolly.spring.shopping.order.service;

import com.dolly.spring.shopping.order.dao.OrderDAO;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO;
	
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}


	public OrderServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
