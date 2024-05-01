<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<c:import url="../../utils/jQuerys.jsp" />
<c:import url="../../utils/css.jsp" />
</head>
<body>
	<div class="container-fluid m-5">
		<c:import url="../components/headerBtn.jsp" />
		<div class="row justify-content-center align-items-center h-100">
			<!-- 내 todo 리스트 -->
			<div class="col-md-auto  mb-3">
				<h1 class="mb-3">My Todo</h1>
				<div class="row justify-content-center align-items-center my-3">
					<c:import url="../components/searchForm.jsp" />
				</div>
				<div class="custom-form text-center my-3" style="width: 46rem; min-height: 30rem;">
				<table class="m-3" style="width: 40rem;">
				  <thead>
				    <tr>
				    <th scope="col">#</th>
				      <th scope="col">내용</th>
				      <th scope="col">시작일</th>
				      <th scope="col">종료일</th>
				      <th scope="col">상태</th>
				      <th scope="col">상세보기</th>
				    </tr>
				  </thead>
					  <tbody class="table-group-divider">
					  	<c:choose>
							<c:when test="${ empty todosList }">
								<%-- if() 부분 --%>
								<tr>
									<td class="my-5" valign="middle" align="center" colspan="7">진행 중인 todo가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<%-- else 부분 --%>
								<c:forEach var="todo" items="${ todosList }" varStatus="status">
									<tr class="my-3">
										<!-- 인덱스 번호 -->
										<td align="center"><b><c:out value="${ status.index + 1 }" /></b></td>
										<!-- todo 내용 -->
										<td align="center" class="text-ellipsis"><c:out value="${ todo.todoData }" /></td>
										<!-- 등록일 -->
										<td align="center"><c:out value="${ todo.regDate }" /></td>
										<!-- 종료일 -->
										<td align="center"><c:out value="${ todo.deadline }" /></td>
										<!-- 중요도 -->
										<td align="center">
											<c:choose>
											    <c:when test="${todo.importance eq 'good'}">
											        <b>중요</b>
											    </c:when>
											    <c:when test="${todo.importance eq 'average'}">
											        <b>평균</b>
											    </c:when>
											    <c:otherwise>
											        <b>별로</b>
											    </c:otherwise>
											</c:choose>
										</td>
										<!-- 상태 -->
										<td align="center">
											<c:choose>
											    <c:when test="${todo.result eq 'complete'}">
											        <p class="card-text"><span class="badge text-bg-success">완료</span></p>
											    </c:when>
											    <c:when test="${todo.result eq 'pend'}">
											        <p class="card-text"><span class="badge text-bg-info">보류</span></p>
											    </c:when>
											    <c:when test="${todo.result eq 'failure'}">
											        <p class="card-text"><span class="badge text-bg-danger">실패</span></p>
											    </c:when>
											    <c:otherwise>
											    	<p class="card-text"><span class="badge text-bg-primary">진행중</span></p>
											    </c:otherwise>
											</c:choose>
										</td>
										<td>
											<div class="btn-group" role="group">
				                           		<button class="btn btn-warning  btn-sm" onclick="location.href='${ contextPath }/todo/todoUpdateForm.do?todoSeq=${todo.todoSeq}'" >수정</button>  
				                              	<form action="${ contextPath }/todo/removeTodo.do?todoSeq=${todo.todoSeq}" method="post">
				                              		<input type="submit" value="삭제" class="btn btn-danger  btn-sm" >
				                              	</form>
			                           		</div>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					  </tbody>
					</table>
				</div>
				<div class="my-3 d-flex justify-content-end">
					<a href="<c:url value="/todo/todoForm.do" />" class="btn" style="background-color:#D996B5; color:white;" style="text-decoration: none;">
						Todo Register
					</a>
               </div>
			</div>
		</div>
	</div>
</body>
</html>