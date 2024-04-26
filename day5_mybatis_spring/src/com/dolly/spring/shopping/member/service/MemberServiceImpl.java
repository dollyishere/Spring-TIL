package com.dolly.spring.shopping.member.service;

import com.dolly.spring.shopping.member.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
