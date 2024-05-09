package com.dolly.spring.shopping.detail_image.dao;

import org.apache.ibatis.session.SqlSession;

public class DetailImageDAOImpl implements DetailImageDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public DetailImageDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
