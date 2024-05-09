package com.dolly.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
	/*
	 * public int addMember(MemberVO member) throws DataAccessException; public
	 * MemberVO memberDetail(String memberId) throws DataAccessException;
	 */
}
