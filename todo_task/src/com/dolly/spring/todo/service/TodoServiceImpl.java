package com.dolly.spring.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dolly.spring.todo.dao.TodoDAO;
import com.dolly.spring.todo.vo.TodoVO;

@Service("todoService")
@Transactional(propagation = Propagation.REQUIRED)
public class TodoServiceImpl implements TodoService {

	// TodoDAO DI
	@Autowired
	private TodoDAO todoDAO;
	
	// 기본 생성자
	public TodoServiceImpl() {
	}// 기본 생성자 END

	@Override
	public List todoList(String userId) throws DataAccessException {
		List todosList = null;
		todosList = todoDAO.selectAllTodoList(userId);
		return todosList;
	}

	@Override
	public int addTodo(TodoVO todoVO) throws DataAccessException {
		return todoDAO.insertTodo(todoVO);
	}

	@Override
	public int removeTodo(int todoSeq) throws DataAccessException {
		return todoDAO.deleteTodo(todoSeq);
	}

	@Override
	public int updateTodo(TodoVO todoVO) throws DataAccessException {
		return todoDAO.updateTodo(todoVO);
	}

	@Override
	public TodoVO todoUpdateform(int todoSeq) throws DataAccessException {
		TodoVO todoVO = null;
		todoVO = todoDAO.selectOneTodo(todoSeq);
		return todoVO;
	}

	@Override
	public List searchTodo(TodoVO todoVO) throws DataAccessException {
		List todosList = null;
		todosList = todoDAO.searchTodo(todoVO);
		return todosList;
	}

}
