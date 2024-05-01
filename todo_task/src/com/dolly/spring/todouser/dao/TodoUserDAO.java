package com.dolly.spring.todouser.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.todouser.vo.TodoUserVO;

public interface TodoUserDAO {
	public int checkId(String userId) throws DataAccessException;
	public int checkLogin(Map<String, String> userMap) throws DataAccessException;
	public int insertUser(TodoUserVO todoUserVO) throws DataAccessException;
	public int deleteUser(String userId) throws DataAccessException;
}
