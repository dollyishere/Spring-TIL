package com.ljy.dev.book.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ljy.dev.book.dto.BookCreateDTO;
import com.ljy.dev.book.dto.BookEditDTO;
import com.ljy.dev.book.dto.BookEditResponseDTO;
import com.ljy.dev.book.dto.BookListResponseDTO;
import com.ljy.dev.book.dto.BookReadResponseDTO;
import com.ljy.dev.book.entity.Book;
import com.ljy.dev.book.entity.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public Integer insert(BookCreateDTO bookCreateDTO) {
		// DAO의 insert method와 같은 작용함
		Book book = Book.builder() // book 객체 생성
				.title(bookCreateDTO.getTitle()) // title 데이터 세팅
				.price(bookCreateDTO.getPrice()) // price 데이터 세팅
				.build(); // 객체 생성
		// 레포지토리는 jpa 레포지토리를 상속받았음
		// 따라서 save는 jpa의 것
		  
		this.bookRepository.save(book);
		return book.getBookId();
	}
	
	public BookReadResponseDTO read(Integer bookId) throws NoSuchElementException { // 찾은 결과 없었을 때 예외처리, 컨트롤러 측에서도 throw&catch로 받을 것
		Book book = this.bookRepository.findById(bookId).orElseThrow(); // orElseThrow() => 결과 성공적으로 찾으면 작동 안하지만, 싫패했을 시 그 뒤 처리 담당
		// no argument
		BookReadResponseDTO bookReadResponseDTO = new BookReadResponseDTO();
		bookReadResponseDTO.fromBook(book);
		return bookReadResponseDTO;
	}
	
	public BookEditResponseDTO edit(Integer bookId) throws NoSuchElementException {
		Book book = this.bookRepository.findById(bookId).orElseThrow();
		return BookEditResponseDTO.BookFactory(book);
	}
	
	public void update(BookEditDTO bookEditDTO) throws NoSuchElementException {
		Book book = this.bookRepository.findById(bookEditDTO.getBookId()).orElseThrow();
		book = bookEditDTO.fill(book);
		this.bookRepository.save(book);
	}
	
	public void delete(Integer bookId) throws NoSuchElementException {
		Book book = this.bookRepository.findById(bookId).orElseThrow();
		this.bookRepository.delete(book);
	}
	
	public List<BookListResponseDTO> bookList(String title, Integer page, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		
		List<Book> books;
		if (page == null) {
			page = 0;
		} else {
			page -= 1;
		}
		if (title == null) {
			Pageable pageable = PageRequest.of(page, pageSize, Direction.DESC, "insertDateTime");
			books = this.bookRepository.findAll(pageable).toList();
		}
		
		else {
			Pageable pageable = PageRequest.of(page, pageSize);
			Sort sort = Sort.by(Order.desc("insertDateTime"));
			pageable.getSort().and(sort);
			books = this.bookRepository.findByTitleContains(title, pageable);
		}
		return books.stream().map(
				book -> new BookListResponseDTO(book.getBookId(), book.getTitle())).collect(Collectors.toList());
	}
	
	public Integer booksCnt() {
		return null;
	}

}
