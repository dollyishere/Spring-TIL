<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>\<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>회원가입</title>
<c:import url="../../utils/jQuerys.jsp" />
<c:import url="../../utils/css.jsp" />
</head>
	<body>
		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
		        <div class="col-md-auto">
		        	<h1 class="m-5">회원가입</h1>
		            <div class="custom-form text-center" style="width: 20rem;"> <!-- text-center 클래스 추가 -->
		                <form  method="post"  action="${contextPath}/todoUser/signup.do">
		                    <div class="mb-2">
		                        <label for="exampleInputEmail1" class="form-label" style="color:#292929;"><b>Id</b></label>
		                        <input type="text" class="form-control" name="userId" required />
		                    </div>
		                    <div class="mb-2">
		                        <label for="exampleInputPassword1" class="form-label" style="color:#292929;"><b>Password</b></label>
		                        <input type="password" name="userPwd" class="form-control" required />
		                    </div>
		                    <div class="mb-2">
		                        <label for="exampleInputName1" class="form-label" style="color:#292929;"><b>Name</b></label>
		                        <input type="text" name="userName" class="form-control" required />
		                    </div>
		                    <div class="mb-2 d-flex justify-content-end">
		                        <input type="submit" value="signup" class="btn" style="background-color:#D996B5; color:white;" />
		                        &nbsp;
		                        <input type="reset" value="reset" class="btn btn-secondary"/>
		                    </div>
		                </form>
		            </div>
		        </div>
			 </div>
		</div>
	</body>
</html>