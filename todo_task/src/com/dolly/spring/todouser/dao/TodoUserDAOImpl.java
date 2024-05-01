package com.dolly.spring.todouser.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dolly.spring.todouser.vo.TodoUserVO;

@Repository("todoUserDAO")
public class TodoUserDAOImpl implements TodoUserDAO {

	// sqlSession di
	@Autowired
	private SqlSession sqlSession;
	
	// 기본 생성자
	public TodoUserDAOImpl() {
	}

	@Override
	public int checkId(String userId) throws DataAccessException {
		return (int) sqlSession.selectOne("mapper.todoUser.checkId", userId);
	}

	
	@Override
	public int checkLogin(Map<String, String> userMap) throws DataAccessException {
		return (int) sqlSession.selectOne("mapper.todoUser.checkLogin", userMap);
	}

	@Override
	public int insertUser(TodoUserVO todoUserVO) throws DataAccessException {
		return sqlSession.insert("mapper.todoUser.insertUser", todoUserVO);
	}

	@Override
	public int deleteUser(String userId) throws DataAccessException {
		return sqlSession.delete("mapper.todoUser.deleteUser", userId);
	}


}
