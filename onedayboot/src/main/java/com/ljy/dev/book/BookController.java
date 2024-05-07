package com.ljy.dev.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
public class BookController {
	@GetMapping("/book/create")
	public String create() {
		return "book/create";
	}
}

