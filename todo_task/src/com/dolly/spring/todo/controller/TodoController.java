package com.dolly.spring.todo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dolly.spring.todo.vo.TodoVO;

public interface TodoController {
	public ModelAndView todoList(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView addTodo(
			@ModelAttribute("todoVO") TodoVO todoVO,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView removeTodo(
			@ModelAttribute("todoSeq") int todoSeq,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView todoUpdateform(
			@RequestParam("todoSeq") int todoSeq,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ModelAndView updateTodo(
			@ModelAttribute("todoVO") TodoVO todoVO,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView searchTodo(
			@ModelAttribute("todoVO") TodoVO todoVO,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
}
