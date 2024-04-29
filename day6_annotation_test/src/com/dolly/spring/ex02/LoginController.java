package com.dolly.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value= {"/test/loginForm.do", "/test/loginForm2.do"},
			method= {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value= {"/test/login.do"},
			method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.setViewName("result");
		return mav;
	}
	
	/*
	 * @RequestMapping(value= {"/test/login2.do"}, method= {RequestMethod.GET,
	 * RequestMethod.POST}) public ModelAndView login2(@RequestParam("userID")
	 * String userID,
	 * 
	 * @RequestParam("userName") String userName, HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { ModelAndView mav = new
	 * ModelAndView(); mav.addObject("userID", userID); mav.addObject("userName",
	 * userName); System.out.println("userID : " + userID);
	 * System.out.println("userName : " + userName); mav.setViewName("result");
	 * return mav; }
	 */
	
	@RequestMapping(value= {"/test/login2.do"},
			method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login2(@RequestParam("userID") String userID,
			// 필수 입력 사항 안넣어도 오류 안뜨도록 오류 처리한 것
			// 즉, 어플리케이션이 완전 종료되지 않도록 한 것
			@RequestParam(value = "userName", required=true) String userName, // 필수사항
			@RequestParam(value = "email", required=false) String email, // 선택사항
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		System.out.println("userID : " + userID);
		System.out.println("userName : " + userName);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value= {"/test/login3.do"},
			method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login3(
			@RequestParam Map<String, String> info, // Map 형태로 전송
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("info", info);

		System.out.println("userID : " + info.get("userID"));
		System.out.println("userName : " + info.get("userName"));
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value= {"/test/login4.do"},
			method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login4(
			// info라는 이름으로 자동 매칭
			@ModelAttribute("info") LoginVO loginVO,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("userID : " + loginVO.getUserID());
		System.out.println("userName : " + loginVO.getUserName());
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value= {"/test/login5.do"},
			method= {RequestMethod.GET, RequestMethod.POST})
	public String login4(
			// 순수 Model 클래스 사용
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "홍길동");
		return "result";
	}
	
	public LoginController() {
	}

}
