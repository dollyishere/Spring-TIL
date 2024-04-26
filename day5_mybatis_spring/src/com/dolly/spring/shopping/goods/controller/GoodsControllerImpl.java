package com.dolly.spring.shopping.goods.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.shopping.goods.service.GoodsService;

public class GoodsControllerImpl extends MultiActionController implements GoodsController {
	private GoodsService goodsService;
	
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}


	public GoodsControllerImpl() {
		// TODO Auto-generated constructor stub
	}

}
