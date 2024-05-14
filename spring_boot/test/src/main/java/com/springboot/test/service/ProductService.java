package com.springboot.test.service;

import com.springboot.test.data.dto.ProductDTO;
import com.springboot.test.data.dto.ProductResponseDTO;

public interface ProductService {
	ProductResponseDTO getProduct(Long number);
	ProductResponseDTO saveProduct(ProductDTO productDTO);
	ProductResponseDTO changeProductName(Long number, String name) throws Exception;
	void deleteProduct(Long number) throws Exception;
}
