package com.dolly.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.member.dao.MemberDAO;
import com.dolly.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public MemberServiceImpl() {
		System.out.println("public MemberServiceImpl()");
	}

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.insertMember(memberVO);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		int result = memberDAO.deleteMember(id);
		return result;
	}

	@Override
	public int modMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.updateMember(memberVO);
		return result;
	}

	@Override
	public MemberVO modMemberForm(String id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = memberDAO.selectMemberById(id);
		return memberVO;
	}

}
