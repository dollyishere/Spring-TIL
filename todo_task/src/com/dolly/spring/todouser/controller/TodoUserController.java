package com.dolly.spring.todouser.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dolly.spring.todouser.vo.TodoUserVO;

public interface TodoUserController {
	public ModelAndView login(
			@RequestParam("userId") String userId,
			@RequestParam("userPwd") String userPwd,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView signup(
			@ModelAttribute("todoUser") TodoUserVO todoUserVO,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView removeUser(
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception;
}
