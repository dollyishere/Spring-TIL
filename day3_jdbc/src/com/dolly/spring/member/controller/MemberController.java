package com.dolly.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	// request 무조건 있어야 함
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 사용자 입력한 거 추가해줘야 하므로 request 있어야 함
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 사실 request도, response도 필요 없음(그냥 폼으로만 이동하면 되니까)
	// 메서드마다 다 쓸 필요 없고, 필요 없으면 생략도 가능함
	// service에는 필요 없는 메서드
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 필요해용
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
