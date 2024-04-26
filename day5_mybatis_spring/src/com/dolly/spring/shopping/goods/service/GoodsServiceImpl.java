package com.dolly.spring.shopping.goods.service;

import com.dolly.spring.shopping.goods.dao.GoodsDAO;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsDAO;
	
	
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}


	public GoodsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
