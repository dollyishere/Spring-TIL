package com.dolly.spring.todo.controller;

import java.util.List;

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

import com.dolly.spring.todo.service.TodoService;
import com.dolly.spring.todo.vo.TodoVO;
import com.dolly.spring.util.Utils;

/** todoController **/
@Controller("todoController")
public class TodoControllerImpl implements TodoController {
	@Autowired
	private TodoService todoService;

	// 기본 생성자
	public TodoControllerImpl() {
	}

	@RequestMapping(value="/todo/todoForm.do", method=RequestMethod.GET)
	public ModelAndView todoform(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "/todo" + Utils.getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todo/todoUpdateForm.do", method=RequestMethod.GET)
	public ModelAndView todoUpdateform(
			@RequestParam("todoSeq") int todoSeq,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = "/todo" + Utils.getViewName(request);
		TodoVO todoVO = null;
		todoVO = todoService.todoUpdateform(todoSeq);
		if (todoVO == null) {
			viewName ="error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todo", todoVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/todo/todoList.do", method=RequestMethod.GET)
	public ModelAndView todoList(
			HttpServletRequest request, 
			HttpServletResponse response)
					throws Exception {
		String viewName = "/todo" + Utils.getViewName(request);
		HttpSession session = request.getSession(false);
		List todosList = null;
		if (session.getAttribute("userId") != null) {
			todosList = todoService.todoList((String) session.getAttribute("userId"));
		} else {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todosList", todosList);
		return mav;
	}

	@Override
	@RequestMapping(value="/todo/addTodo.do", method=RequestMethod.POST)
	public ModelAndView addTodo(
			@ModelAttribute("todoVO") TodoVO todoVO, 
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		String viewName = "redirect:/todo/todoList.do";
		
		 // HTML에서 넘어온 날짜 문자열을 java.sql.Date로 변환
		if (!todoVO.getSqlDeadline().equals("")) {
			String dateString = todoVO.getSqlDeadline();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
	        // todoVO에 변환된 날짜를 설정
	        todoVO.setDeadline(sqlDate);
		}
        
        int result = todoService.addTodo(todoVO); 
        if (result < 1) { viewName ="error"; }
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todo/removeTodo.do", method=RequestMethod.POST)
	public ModelAndView removeTodo(
			@RequestParam("todoSeq") int todoSeq,
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		String viewName = "redirect:/todo/todoList.do";
		int result = todoService.removeTodo(todoSeq);
		if (result < 1) {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todo/updateTodo.do", method=RequestMethod.POST)
	public ModelAndView updateTodo(
			@ModelAttribute("todoVO") TodoVO todoVO, 
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		String viewName = "redirect:/todo/todoList.do";
		 // HTML에서 넘어온 날짜 문자열을 java.sql.Date로 변환
		if (!todoVO.getSqlDeadline().equals("")) {
			String dateString = todoVO.getSqlDeadline();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
	        // todoVO에 변환된 날짜를 설정
	        todoVO.setDeadline(sqlDate);
		}
        System.out.println(todoVO.toString());
		int result = todoService.updateTodo(todoVO);
		if (result < 1) {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/todo/searchTodo.do", method=RequestMethod.GET)
	public ModelAndView searchTodo(
			@ModelAttribute("todoVO") TodoVO todoVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = "todoList";
		List todosList = null;
		todosList = todoService.searchTodo(todoVO);
		 // HTML에서 넘어온 날짜 문자열을 java.sql.Date로 변환
		if (!todoVO.getSqlDeadline().equals("")) {
			String dateString = todoVO.getSqlDeadline();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
	        // todoVO에 변환된 날짜를 설정
	        todoVO.setDeadline(sqlDate);
		}
		 // HTML에서 넘어온 날짜 문자열을 java.sql.Date로 변환
		if (!todoVO.getSqlRegDate().equals("")) {
			String dateString = todoVO.getSqlRegDate();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
	        // todoVO에 변환된 날짜를 설정
	        todoVO.setRegDate(sqlDate);
		}
        
		if (todosList == null) {
			viewName = "error";
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todosList", todosList);
		return mav;
	}
}
