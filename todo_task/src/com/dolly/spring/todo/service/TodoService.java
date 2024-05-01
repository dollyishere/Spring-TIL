package com.dolly.spring.todo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dolly.spring.todo.vo.TodoVO;

public interface TodoService {
	public List todoList(String userId) throws DataAccessException;
	public int addTodo(TodoVO todoVO) throws DataAccessException;
	public int removeTodo(int todoSeq) throws DataAccessException;
	public TodoVO todoUpdateform(int todoSeq) throws DataAccessException;
	public int updateTodo(TodoVO todoVO) throws DataAccessException;
	public List searchTodo(TodoVO todoVO) throws DataAccessException;
}
