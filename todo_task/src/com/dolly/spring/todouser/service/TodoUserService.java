package com.dolly.spring.todouser.service;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.todouser.vo.TodoUserVO;

public interface TodoUserService {
	public int login(String userId, String userPwd) throws DataAccessException;
	public int signup(TodoUserVO todoUserVO) throws DataAccessException;
	public int removeUser(String userId) throws DataAccessException;
}
