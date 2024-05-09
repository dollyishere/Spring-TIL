package com.dolly.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.member.dao.MemberDAO;
import com.dolly.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		System.out.println("public MemberServiceImpl()");
	}

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		System.out.println("public list listMembers() throws DataAccessException");
		
		List<MemberVO> membersList = null;
		membersList = memberDAO.selectAllMembers();
		System.out.println(membersList.size());
		return membersList;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		System.out.println("this.memberDAO = memberDAO;");
	}
	
	

}
