package com.ljy.dev.book.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ljy.dev.book.entity.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 매개변수가 없는 기본 생성자를 뜻함
// 매개변수 있을 시 No가 아닌 All로 바뀜
@Getter
public class BookReadResponseDTO {
	private Integer bookId;
	private String title;
	private Integer price;
	private LocalDateTime insertDateTime;
	private List<BookLogReadResponseDTO> bookLogs;
	
	public BookReadResponseDTO fromBook(Book book) {
		this.bookId = book.getBookId();
		this.title = book.getTitle();
		this.price = book.getPrice();
		this.insertDateTime = book.getInsertDateTime();
		this.bookLogs = book.getBookLogList().stream().map(bookLog ->
		BookLogReadResponseDTO.BookLogFactory(bookLog)
		).collect(Collectors.toList());

		return this;
	}
	
	// 사용할 때마다 새로운 객체를 만들고, 그 값을 넣어주기 위해 fromBook을 이용함
	// 이런 팩토리 패턴을 만들지 않는다면, 생성할 때마다 값을 원시적으로 집어넣어줘야 함...
	// 앱이 실행될 때 필요한 객체들을 미리 생성해서 주입하는 게 바로 DI..
	// 하지만 이 아이는 사전에 데이터를 넣을 수 없음(엔티티가 데이터를 긁어와야 하기 때문
	// 생성자 주입 방식처럼 나중에 주입할 수 있게 해야 함
	// 엔티티가 DB에서 가져온 정보들을 주입한다고 보면 될 듯
	// 그래서 Getter와 생성자를 필요로 함, fromBook은 데이터 실제 주입하는 과정
	// 다른 생성자에서도 필요하면 객체 생성할 때 자동으로 값이 주입되기에 불필요한 코드를 생략할 수 있게 됨!
	// 즉, 정적 메소드로 객체를 생성하는 방법이 팩토리 패턴임! => 대단히 중요
	public static BookReadResponseDTO BookFactory(Book book) {
		// 자기 자신 객체 생성
		BookReadResponseDTO bookReadResponseDTO = new BookReadResponseDTO();
		// 위에 있는 메서드 호출해서 값 넣어줌
		bookReadResponseDTO.fromBook(book);
		// 자기 자신 리턴
		return bookReadResponseDTO;
	}
}
