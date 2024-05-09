package com.ljy.dev.book.dto;

import com.ljy.dev.book.entity.Book;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookEditDTO {
	// null이 아닐 때 insert 가능하도록 설정
	// 테이블과는 아무 연관도 없음
	// 따라서 엔티티 안붙임 => 테이블 만든다던지, 값 수정한다든지에는 관여하지 않음
	// 생성자 annotation은 따로 있음
	@NonNull
	@Positive
	private Integer bookId;
	
	@NonNull
	@NotBlank
	private String title;
	
	
	@NonNull
	@Min(1000)
	private Integer price;
	
	public Book fill(Book book) {
		book.setTitle(this.title);
		book.setPrice(this.price);
		return book;
	}

}
