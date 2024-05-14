package com.springboot.test.service.impl;

import java.time.LocalDateTime;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.data.dto.ProductDTO;
import com.springboot.test.data.dto.ProductResponseDTO;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;
import com.springboot.test.service.ProductService;

import ch.qos.logback.classic.Logger;


@Service
public class ProductServiceImpl implements ProductService {
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductServiceImpl.class);
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponseDTO getProduct(Long number) {
		// logger에서 특정 변수를 문자열 내로 집어 넣으려면 해당 위치에 {} 해주고 넣을 값은 ','로 표시
		LOGGER.info("[getProduct] input number : {}", number);
		Product product = productRepository.findById(number).get();
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(product.getNumber());
		productResponseDTO.setName(product.getName());
		productResponseDTO.setPrice(product.getPrice());
		productResponseDTO.setStock(product.getStock());
		
		return productResponseDTO;
	}

	@Override
	public ProductResponseDTO saveProduct(ProductDTO productDTO) {
		LOGGER.info("[saveProduct] productDTO : {}", productDTO.toString());
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setCreatedAt(LocalDateTime.now());
		product.setUpdateAt(LocalDateTime.now());
		
		Product savedProduct = productRepository.save(product);
		LOGGER.info("[saveProduct] saveProduct : {}", savedProduct);
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(savedProduct.getNumber());
		productResponseDTO.setName(savedProduct.getName());
		productResponseDTO.setPrice(savedProduct.getPrice());
		productResponseDTO.setStock(savedProduct.getStock());
		
		return productResponseDTO;
	}

	@Override
	public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
		Product foundProduct = productRepository.findById(number).get();
		foundProduct.setName(name);
		Product changedProduct = productRepository.save(foundProduct);
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setNumber(changedProduct.getNumber());
		productResponseDTO.setName(changedProduct.getName());
		productResponseDTO.setPrice(changedProduct.getPrice());
		productResponseDTO.setStock(changedProduct.getStock());
		
		return productResponseDTO;
	}

	@Override
	public void deleteProduct(Long number) throws Exception {
		productRepository.deleteById(number);

	}

}
