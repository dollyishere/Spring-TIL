<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>>기사번호</b></td> <td><b>>기자번호</b></td>
			<td><b>>제목</b></td> <td><b>>내용</b></td>
			<td><b>>이미지명</b></td> <td><b>>작성일</b></td>
			<td><b>>아이디</b></td>
		</tr>
		
		<c:forEach var="article" items="${articlesList}">
			<tr align="center">
				<td>${article.articleNo}</td> <td>${article.parentNo}</td>
				<td>${article.title}</td> <td>${article.content}</td>
				<td>${article.imageFilename}</td> <td>${article.writeDate}</td>
				<td>${article.id}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${contextPath}/article/articleForm.do">
		<h1 style="text-align: center">기사작성</h1>
	</a>
</body>
</html>
