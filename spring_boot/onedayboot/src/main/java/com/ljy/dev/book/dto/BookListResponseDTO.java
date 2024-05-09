package com.ljy.dev.book.dto;

import java.util.Optional;

import lombok.Getter;

@Getter
public class BookListResponseDTO {
	private Integer bookId;
	private String title;
	private Optional<String> commonAuthor;
	
	public BookListResponseDTO(Integer bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}
	
	// 저자에 관한 생성자
	// 생성자는 때에 따라서 3~4개가 될 수도 있음(공동 저자는 2~3명 기술한 뒤에 그외로 처리하니까)
	// 한 명일수도, 2명일수도 있어서 optional이 됨
	// optional도 collection의 일종임!
	public BookListResponseDTO(Integer bookId, String title, Optional<String> commonAuthor) {
		this.bookId = bookId;
		this.title = title;
		this.commonAuthor = commonAuthor;
	}
}
