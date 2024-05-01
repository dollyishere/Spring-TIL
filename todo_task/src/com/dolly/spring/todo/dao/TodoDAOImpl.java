package com.dolly.spring.todo.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dolly.spring.todo.vo.TodoVO;

@Repository("todoDAO")
public class TodoDAOImpl implements TodoDAO {

	// sqlSession di
	@Autowired
	private SqlSession sqlSession;
	
	// 기본 생성자
	public TodoDAOImpl() {
	} // 기본 생성자 END

	@Override
	public List selectAllTodoList(String userId) throws DataAccessException {
		List<TodoDAO> todosList = null;
		todosList = sqlSession.selectList("mapper.todo.selectAllTodoList", userId);
		return todosList;
	}

	@Override
	public int insertTodo(TodoVO todoVO) throws DataAccessException {
		return sqlSession.insert("mapper.todo.insertTodo", todoVO);
	}

	@Override
	public int deleteTodo(int todoSeq) throws DataAccessException {
		return sqlSession.delete("mapper.todo.deleteTodo", todoSeq);
	}

	@Override
	public int updateTodo(TodoVO todoVO) throws DataAccessException {
		return sqlSession.update("mapper.todo.updateTodo", todoVO);
	}

	@Override
	public TodoVO selectOneTodo(int todoSeq) throws DataAccessException {
		TodoVO todoVo = null;
		todoVo = (TodoVO) sqlSession.selectOne("mapper.todo.selectOneTodo", todoSeq);
		return todoVo;
	}

	@Override
	public List searchTodo(TodoVO todoVO) throws DataAccessException {
		List<TodoDAO> todosList = null;
		todosList = sqlSession.selectList("mapper.todo.ssearchTodo", todoVO);
		return todosList;
	}

}
