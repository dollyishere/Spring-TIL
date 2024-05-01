<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>
<c:set var="userId" value="${sessionScope.userId}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo 등록</title>
<c:import url="../../utils/Querys.jsp" />
<c:import url="../../utils/jQuerys.jsp" />
<c:import url="../../utils/css.jsp" />
</head>
</head>
	<body>
		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
		        <div class="col-md-auto">
		        	<h1 class="m-5">ToDo 등록</h1>
		            <div class="custom-form text-center" style="width: 25rem;"> <!-- text-center 클래스 추가 -->
		                <form  method="post"  action="${contextPath}/todo/updateTodo.do">
		                 	<!-- 내용 -->
		                    <div class="mb-2 row  justify-content-start align-items-center">
		                    	<div class="col-md-3">
		                         <label for="exampleInputName" class="form-label" style="color:#292929;"><b>Content</b></label>
		                        </div>
		                        <div class="col-md-auto">
		                        	<input name="todoData" id="editor" class="form-control"  size="10" maxlength="10" value="${ todo.todoData }" required />
		                        </div>
		                    </div>
		                    <!-- 종료일 -->
		                    <div class="mb-2 row  justify-content-start align-items-center">
		                    	<div class="col-md-3">
		                         <label for="exampleInputdeadline" class="form-label" style="color:#292929;"><b>Deadline</b></label>
		                        </div>
		                        <div class="col-md-auto">
		                        	<input type="date" id="deadline" name="sqlDeadline" size="10"  class="form-control" value="${ todo.deadline }" >
		                        </div>
		                        <div class="col-md-3">
							    </div>
		                    </div>
		                    <!-- 중요도 -->
		                     <div class="mb-2 row  justify-content-start align-items-center">
		                    	<div class="col-md-3">
		                         <label for="exampleInputImportance" class="form-label" style="color:#292929;"><b>Importance</b></label>
		                        </div>
		                        <div class="col-md-auto">
			                        <select name="importance" class="form-select" >
									  <option value="" disabled>선택하세요</option>
									  <option value="good" ${ todo.importance eq 'good' ? selected : '' }>중요</option>
									  <option value="average" ${ todo.importance eq 'average' ? selected : '' }>보통</option>
									  <option value="poor" ${ todo.importance eq 'poor' ? selected : '' }>별로</option>
									</select>
		                        </div>
		                        <div class="col-md-3">
							    </div>
		                    </div>
		                      <!-- 진행상황 -->
		                    <div class="mb-2 row  justify-content-start align-items-center">
		                    	<div class="col-md-3">
		                         <label for="exampleInputResult" class="form-label" style="color:#292929;"><b>Result</b></label>
		                        </div>
		                        <div class="col-md-auto  row  justify-content-center align-items-center">
		                        	<div class="col-md-auto form-check">
			                	 <input class="form-check-input" type="radio" id="result1" name="result" value="complete" ${ todo.result eq 'complete' ? 'checked' : ''}>
					                 <label class="form-check-label" for="result1">
									   	<b>완료</b>
									  </label>
				                </div>
				                <div class="col-md-auto form-check">
					                <input class="form-check-input" type="radio" id="result2" name="result" value="pend" ${todo.result eq 'pend' ? 'checked' : ''}>
					                <label class="form-check-label" for="result2">
									    <b>보류</b>
									  </label>
				                </div>
				                <div class="col-md-auto form-check">
					                <input class="form-check-input" type="radio" id="result3" name="result" value="failure" ${todo.result eq 'failure' ? 'checked' : ''}>
					                <label class="form-check-label" for="result3">
									    <b>취소</b>
									</label>
								</div>
			                    </div>
			                    <div class="col-md-3">
							    </div>
		                    </div>
		                    <input type="hidden" name="userId" value="${ userId }" />
		                    <input type="hidden" name="todoSeq" value="${ todo.todoSeq }" />
		                    <!-- 버튼 -->
		                    <div class="mb-2 d-flex justify-content-end">
		                        <input type="submit" value="update" class="btn" style="background-color:#D996B5; color:white;" />
		                        &nbsp;
		                        <input type="reset" value="reset" class="btn btn-secondary"/>
		                        &nbsp;
		                    </div>
		                </form>
		            </div>
		        </div>
			 </div>
		</div>
	</body>
</html>
