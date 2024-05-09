package com.dolly.spring.shopping.detail_image.service;

import com.dolly.spring.shopping.detail_image.dao.DetailImageDAO;

public class DetailImageServiceImpl implements DetailImageService {
	private DetailImageDAO detailImageDAO;
	
	public void setDetailImageDAO(DetailImageDAO detailImageDAO) {
		this.detailImageDAO = detailImageDAO;
	}

	public DetailImageServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
