package com.dolly.spring.shopping.cart.dao;

import org.apache.ibatis.session.SqlSession;

public class CartDAOImpl implements CartDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public CartDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
