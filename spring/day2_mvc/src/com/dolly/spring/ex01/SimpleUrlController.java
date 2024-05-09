package com.dolly.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/** 일반 클래스가 아닌 컨트롤러를 구현받는 아이 **/
/** SimpleUrlController 역할 수행 **/
public class SimpleUrlController implements Controller {

	public SimpleUrlController() {
		
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws Exception {
		return new ModelAndView("index.jsp");
	}

}
