package com.dolly.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.member.vo.MemberVO;

public interface MemberDAO {
	// 보통 mapper에 미리 선언해둔 쿼리의 id명과 동일하게 만드는 게 일반적
	public List selectAllMemberList() throws DataAccessException;
	public MemberVO selectMemberById(String id) throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
}
