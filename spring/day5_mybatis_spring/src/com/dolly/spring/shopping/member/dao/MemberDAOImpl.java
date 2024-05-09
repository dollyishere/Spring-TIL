package com.dolly.spring.shopping.member.dao;

import org.apache.ibatis.session.SqlSession;

public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
