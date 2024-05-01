package com.dolly.spring.todo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.todo.vo.TodoVO;

public interface TodoDAO {
	public List selectAllTodoList(String userId) throws DataAccessException;
	public TodoVO selectOneTodo(int todoSeq) throws DataAccessException;
	public int insertTodo(TodoVO todoVO) throws DataAccessException;
	public int deleteTodo(int todoSeq) throws DataAccessException;
	public int updateTodo(TodoVO todoVO) throws DataAccessException;
	public List searchTodo(TodoVO todoVO) throws DataAccessException;
}
