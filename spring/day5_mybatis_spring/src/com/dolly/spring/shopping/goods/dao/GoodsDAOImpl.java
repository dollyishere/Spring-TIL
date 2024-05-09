package com.dolly.spring.shopping.goods.dao;

import org.apache.ibatis.session.SqlSession;

public class GoodsDAOImpl implements GoodsDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public GoodsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
