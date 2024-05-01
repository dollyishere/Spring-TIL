package com.dolly.spring.todouser.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dolly.spring.todouser.dao.TodoUserDAO;
import com.dolly.spring.todouser.vo.TodoUserVO;

@Service("todoUserService")
@Transactional(propagation = Propagation.REQUIRED)
public class TodoUserServiceImpl implements TodoUserService {

	// TodoDAO DI
	@Autowired
	private TodoUserDAO todoUserDAO;
	
	// 기본 생성자
	public TodoUserServiceImpl() {
	}

	@Override
	public int login(String userId, String userPwd) throws DataAccessException {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userId", userId);
		userMap.put("userPwd", userPwd);
		return todoUserDAO.checkLogin(userMap);
	}

	@Override
	public int signup(TodoUserVO todoUserVO) throws DataAccessException {
		return todoUserDAO.insertUser(todoUserVO);
	}

	@Override
	public int removeUser(String userId) throws DataAccessException {
		return todoUserDAO.deleteUser(userId);
	}

}
