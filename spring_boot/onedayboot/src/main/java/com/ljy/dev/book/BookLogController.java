package com.ljy.dev.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljy.dev.book.dto.BookLogCreateDTO;
import com.ljy.dev.book.dto.BookLogCreateResponseDTO;
import com.ljy.dev.book.service.BookLogService;

@RestController // 일반 컨트롤러에 response를 합해둔 것
// 해당 화면에서 요청하면 해당 화면으로 즉시 응답
// 새로 고침이 없다! => 현재 페이지에 결과값을 직접 전달하니까
// 뷰를 거치지 않고 컨버터(객체를 다른 객체 형식으로 바꿔주는)를 거쳐 응답하는 클래스라는 뜻
@RequestMapping("/book-log")
public class BookLogController {
	// service가 주입되어 있어야 하므로 service 주입
	private BookLogService bookLogService;
	
	// 여기서는 Autowired를 setter에 붙여둠
	// 이걸 setter 인젝션이라고 함
	// 권장하거나 많이 사용하는 방법은 아니구...
	@Autowired
	public void setBookLogService(BookLogService bookLogService) {
		this.bookLogService = bookLogService;
	}
	
	// 뷰를 내보낸다는 건, 새로 고침을 한다는 뜻이기에 내보내지 않음
	// ResponseEntity? => 
	// @RequestBody?
	@PostMapping("/create")
	public ResponseEntity<BookLogCreateResponseDTO> insert(@RequestBody BookLogCreateDTO bookLogCreateDTO){
		BookLogCreateResponseDTO bookLogCreateResponseDTO = this.bookLogService.insert(bookLogCreateDTO);
		return ResponseEntity.ok(bookLogCreateResponseDTO);
	}
}