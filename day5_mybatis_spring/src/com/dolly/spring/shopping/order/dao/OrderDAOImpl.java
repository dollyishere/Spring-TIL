package com.dolly.spring.shopping.order.dao;

import org.apache.ibatis.session.SqlSession;

public class OrderDAOImpl implements OrderDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public OrderDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
