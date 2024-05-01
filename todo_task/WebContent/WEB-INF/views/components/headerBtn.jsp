<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="userId" value="${sessionScope.userId}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <div class="btn-group  btn-group-sm" role="group">
    	<!-- 로그아웃 -->
		<input type="button" class="btn btn-secondary" value="로그아웃" onclick="location.href='<c:url value='/todoUser/logout.do' />'"/>
		<!-- 정보수정 -->
		<%-- <input type="button" class="btn" style="background-color:#D996B5; color:white;" value="회원수정" onclick="location.href='<c:url value="/member/updateServlet"/>'" /> --%>
		<!-- 회원탈퇴 -->
		<form action="${ contextPath }/todoUser/removeUser.do" method="post">
			<input type="submit" class="btn btn-danger" value="회원탈퇴">
		</form>
		
	</div>
</body>
</html>