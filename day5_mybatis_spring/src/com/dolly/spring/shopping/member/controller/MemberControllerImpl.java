package com.dolly.spring.shopping.member.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.shopping.member.service.MemberService;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	public MemberControllerImpl() {
		// TODO Auto-generated constructor stub
	}

}
