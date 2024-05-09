<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록창</title>

<style>
.text_center {
	text-align: center;
}
</style>
</head>
<body>
	<form method="post" action="${contextPath}/article/addArticle.do">
		<h1 class="text_center">기사 작성창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right" />제목</td>
				<td width="400"><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">내용</td>
				<td width="400"><textarea type="text" name="content"> </textarea></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이미지 파일명</td>
				<td width="400"><p>
						<input type="text" name="imageFilename" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><p>
						<input type="text" name="id" /></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="hidden" value="2" name="parentNo" />
					<input type="submit" value="작성하기" />
					<input type="reset" value="다시입력" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>