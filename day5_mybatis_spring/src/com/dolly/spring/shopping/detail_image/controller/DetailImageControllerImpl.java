package com.dolly.spring.shopping.detail_image.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.shopping.detail_image.service.DetailImageService;

public class DetailImageControllerImpl extends MultiActionController implements DetailImageController {
	private DetailImageService detailImageService;
	
	
	public void setDetailImageService(DetailImageService detailImageService) {
		this.detailImageService = detailImageService;
	}

	public DetailImageControllerImpl() {
		// TODO Auto-generated constructor stub
	}

}
