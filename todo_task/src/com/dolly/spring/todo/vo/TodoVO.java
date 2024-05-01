package com.dolly.spring.todo.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 
 * **/
@Component("todoVO")
public class TodoVO {
	private int todoSeq;
	private String userId;
	private String todoData;
	private String sqlRegDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private String importance;
	private String sqlDeadline;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private String result;
	
	// 기본 생성자
	public TodoVO() {

	} // 기본 생성자 END
	
	// getter & setter
	public int getTodoSeq() {
		return todoSeq;
	}

	public void setTodoSeq(int todoSeq) {
		this.todoSeq = todoSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTodoData() {
		return todoData;
	}

	public void setTodoData(String todoData) {
		this.todoData = todoData;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getSqlDeadline() {
		return sqlDeadline;
	}

	public void setSqlDeadline(String sqlDeadline) {
		this.sqlDeadline = sqlDeadline;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getSqlRegDate() {
		return sqlRegDate;
	}

	public void setSqlRegDate(String sqlRegDate) {
		this.sqlRegDate = sqlRegDate;
	}


	// getter & setter END



	// toString() override

	@Override
	public String toString() {
		return "TodoVO [todoSeq=" + todoSeq + ", userId=" + userId + ", todoData=" + todoData + ", sqlRegDate="
				+ sqlRegDate + ", regDate=" + regDate + ", importance=" + importance + ", sqlDeadline=" + sqlDeadline
				+ ", deadline=" + deadline + ", result=" + result + "]";
	}
	 // toString() override END

	

	
}
