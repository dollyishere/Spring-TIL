package com.springboot.test.controller;

import com.google.gson.Gson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.test.data.dto.ProductDTO;
import com.springboot.test.data.dto.ProductResponseDTO;
import com.springboot.test.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl productService;

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        // given 메서드로 mock 설정
        given(productService.getProduct(123L)).willReturn(
                new ProductResponseDTO(123L, "pen", 5000, 2000));

        String productId = "123";

        // MockMvc를 사용하여 HTTP GET 요청 수행 및 검증
        mockMvc.perform(get("/product?number=" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        // verify 메서드로 mock 메서드 호출 검증
        verify(productService).getProduct(123L);
    }
    
    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        // given 메서드로 mock 설정
        given(productService.saveProduct(new ProductDTO("pen", 5000, 2000))).willReturn(
                new ProductResponseDTO(123L, "pen", 5000, 2000));

        ProductDTO productDTO = ProductDTO.builder()
        		.name("pen")
        		.price(5000)
        		.stock(2000)
        		.build();

        Gson gson = new Gson();
        String content = gson.toJson(productDTO);
        
        // MockMvc를 사용하여 HTTP POST 요청 수행 및 검증
        mockMvc.perform(post("/product")
        			.content(content)
        			.contentType(MediaType.APPLICATION_JSON)
        		)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        // verify 메서드로 mock 메서드 호출 검증
        verify(productService).saveProduct(new ProductDTO("pen", 5000, 2000));
    }
}
