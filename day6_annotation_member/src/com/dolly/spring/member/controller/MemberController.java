package com.dolly.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dolly.spring.member.vo.MemberVO;

public interface MemberController {
	// 얘네들을 구현받는 친구들은 Multi어쩌고 컨트롤러 상속받지 말고 얘 구현만 받으면 됨 => 이미 어노테이션으로 지정해놨기 때문
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(
			@ModelAttribute("info") MemberVO memberVO,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception;
	public ModelAndView removeMember(
			@ModelAttribute("id") String id,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
}
