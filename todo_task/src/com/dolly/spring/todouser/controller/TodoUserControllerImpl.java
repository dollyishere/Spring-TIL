package com.dolly.spring.todouser.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dolly.spring.todouser.service.TodoUserService;
import com.dolly.spring.todouser.vo.TodoUserVO;
import com.dolly.spring.util.Utils;

/** todoController **/
@Controller("todoUserController")
public class TodoUserControllerImpl implements TodoUserController {

	@Autowired
	private TodoUserService todoUserService;
	
	// 기본 생성자
	public TodoUserControllerImpl() {

	} // 기본 생성자 END

	@RequestMapping(value="/todoUser/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "/user" + Utils.getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	@RequestMapping(value="/todoUser/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/todoUser/loginForm.do");
		// 세션 불러온 후 세션에 id 값 저장되어 있을 시, logout
		HttpSession session = request.getSession(false);
        if (session.getAttribute("userId") != null) {
            session.removeAttribute("userId");
        }
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/todoUser/login.do", method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("userId") String userId,
			@RequestParam("userPwd") String userPwd,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		String viewName = "redirect:/todo/todoList.do";
		int result = todoUserService.login(userId.trim(), userPwd.trim());
		if (result < 1) {
			viewName = "error";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todoUser/signup.do", method=RequestMethod.POST)
	public ModelAndView signup(
			TodoUserVO todoUserVO, 
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		String viewName = "redirect:/todoUser/loginForm.do";
		int result = todoUserService.signup(todoUserVO);
		if (result < 1) {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todoUser/removeUser.do", method=RequestMethod.POST)
	public ModelAndView removeUser(
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		int result = 0;
		String viewName = "redirect:/todoUser/loginForm.do";
		HttpSession session = request.getSession(false);
        if (session.getAttribute("userId") != null) {
        	result = todoUserService.removeUser((String) session.getAttribute("userId"));
            session.removeAttribute("userId");
        }
		if (result < 1) {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

}
