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
    <form action="${contextPath}/todo/searchTodo.do" method="get" style="width: 24rem;">
		<div class="mb-3  justify-content-start align-items-center" style="color:white;">
			<div class="col-md-auto">
              <input type="text" class="form-control" name="searchText" maxlength="20"/>
             </div>
             <div class="col-md-auto">
             	 <label><input type="checkbox" class="form-check-input"  name="isCompleted" value="c"> 완료여부</label>
             </div>
          </div>
		  
		  <div class="input-group my-3">
		  	<input type="date" id="regdate" name="sqlRegDate" size="10"  class="form-control" />
		  	<input type="date" id="deadline" name="sqlDeadline" size="10"  class="form-control" />	
		 </div>
		  <input class="btn btn-warning" type="submit" value="검색" />
		  <input type="reset" value="reset" class="btn btn-secondary"/>
	    </form>
</body>
</html>