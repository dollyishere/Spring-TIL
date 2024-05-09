package com.ljy.dev.book;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ljy.dev.book.dto.BookCreateDTO;
import com.ljy.dev.book.dto.BookEditDTO;
import com.ljy.dev.book.dto.BookEditResponseDTO;
import com.ljy.dev.book.dto.BookListResponseDTO;
import com.ljy.dev.book.dto.BookReadResponseDTO;
import com.ljy.dev.book.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/create")
	public String create() {
		return "book/create";
	}
	
	@PostMapping("/book/create")
	public String insert(BookCreateDTO bookCreateDTO) {
		Integer bookId = this.bookService.insert(bookCreateDTO);
		// 파라미터 명과 클래스의 멤버변수명이 일치해야 함
		return String.format("redirect:/book/read/%s", bookId);
	}
	
	@GetMapping("/book/read/{bookId}")
	public ModelAndView read(@PathVariable("bookId") Integer bookId) { // 어떤 값을 전달 받는 파라미터 명이 필요
		ModelAndView mav = new ModelAndView();
		BookReadResponseDTO bookReadResponseDTO = this.bookService.read(bookId);
		mav.addObject("bookReadResponseDTO", bookReadResponseDTO);
		mav.setViewName("book/read");
		return mav;
	}
	
	
	@GetMapping("/book/edit/{bookId}")
	public ModelAndView edit(@PathVariable("bookId") Integer bookId) throws NoSuchElementException {
		ModelAndView mav = new ModelAndView();
		BookEditResponseDTO bookEditResponseDTO = this.bookService.edit(bookId);
		mav.addObject("bookEditResponseDTO", bookEditResponseDTO);
		mav.setViewName("book/edit");
		return mav;
	}
	
	@PostMapping("/book/edit/{bookId}")
	public ModelAndView update(
			@Validated BookEditDTO bookEditDTO,
			Errors errors) { // 발생할 수 있는 모든 에러(null값 등)을 받아주는 아이
		// required가 값이 비었는지 아닌지만 검사한다면, validated는 그걸 총체적으로 확인해주는 아이
		if (errors.hasErrors()) {
			String errorMessage = 
					errors
					.getFieldErrors() // 에러 뽑아오기
					.stream() // 뽑아낸 error들 stream 방식으로 바꾸기
					.map(x -> x.getField() + " : " + x.getDefaultMessage()) // error들 하나씩 꺼내서 한 쌍으로 만들어주기
					.collect(Collectors.joining("\n"));
			return this.error422(errorMessage, String.format("/book/edit/%s", bookEditDTO.getBookId()));
		}
		
		this.bookService.update(bookEditDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(String.format("redirect:/book/read/%s", bookEditDTO.getBookId()));
		return mav;

	}

	private ModelAndView error422(String message, String location) {
		ModelAndView mav = new ModelAndView();
		mav.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		mav.addObject("message", message);
		mav.addObject("location", location);
		mav.setViewName("common/error/422");
		return mav;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ModelAndView noSuchElementExceptionHandler(NoSuchElementException ex) {
		return this.error422("책 정보가 없습니다.", "/book/list");
	}
	
	@PostMapping("/book/delete")
	public String delete(Integer bookId) throws NoSuchElementException{
		this.bookService.delete(bookId);
		return "redirect:/book/list";
	}
	
	@GetMapping(value= {"/book/list", "/book"})
	public ModelAndView bookList(String title, Integer page, Integer pageSize, ModelAndView mav){
		mav.setViewName("/book/list");
		List<BookListResponseDTO> books = this.bookService.bookList(title, page, pageSize);
		mav.addObject("books", books);
		return mav;
	}

}

