package com.springboot.test.service.impl;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.test.data.dto.ProductDTO;
import com.springboot.test.data.dto.ProductResponseDTO;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;

public class ProductServiceTest2 {

	@MockBean
	ProductRepository productRepository;
	
	@Autowired
	private ProductServiceImpl productService;
	
	/*
	 * @BeforeEach public void setUpTest() { productService = new
	 * ProductServiceImpl(productRepository); }
	 */
	
	@Test
	void getProductTest() {
		Product givenProduct = new Product();
		givenProduct.setNumber(123L);
		givenProduct.setName("펜");
		givenProduct.setPrice(1000);
		givenProduct.setStock(1234);
		
		Mockito.when(productRepository.findById(123L))
			.thenReturn(Optional.of(givenProduct));
		
		ProductResponseDTO productResponseDTO = productService.getProduct(123L);
		
		Assertions.assertEquals(productResponseDTO.getNumber(), givenProduct.getNumber());
		Assertions.assertEquals(productResponseDTO.getName(), givenProduct.getName());
		Assertions.assertEquals(productResponseDTO.getPrice(), givenProduct.getPrice());
		Assertions.assertEquals(productResponseDTO.getStock(), givenProduct.getStock());
		
		verify(productRepository).findById(123L);
	}
	
	@Test
	void saveProductTest() {
		Mockito.when(productRepository.save(any(Product.class)))
			.then(returnsFirstArg());
		
		ProductResponseDTO productResponseDTO = productService.saveProduct(
					new ProductDTO("펜", 1000, 1234)
				);
		
		Assertions.assertEquals(productResponseDTO.getName(), "펜");
		Assertions.assertEquals(productResponseDTO.getPrice(), 1000);
		Assertions.assertEquals(productResponseDTO.getStock(), 1234);
		
		verify(productRepository).save(any());
	}
}
