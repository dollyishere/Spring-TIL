package com.dolly.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectAllMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
}
