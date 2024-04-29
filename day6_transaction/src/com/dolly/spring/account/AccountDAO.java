package com.dolly.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public AccountDAO() {
		// TODO Auto-generated constructor stub
	}


	public void upBalance1() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance1");
	}
	
	public void upBalance2() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance2");
	}
	
}
