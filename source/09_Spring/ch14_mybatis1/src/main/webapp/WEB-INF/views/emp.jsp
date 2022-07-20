<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<div id="wrap">
		<form action="" method="get">
			사원 <input type="text" name="ename" value="${schEmp.ename }" size="5">
			직책 <input type="text" name="job" value="${schEmp.job }" size="5">
			부서번호 
			<select name="deptno">
				<option value="0">모든부서</option>
				<c:forEach items="${deptList }" var="dept" >
					<option value="${dept.deptno }"
						<c:if test="${schEmp.deptno eq dept.deptno }">
							selected="selected"
						</c:if>
					>
						${dept.dname }
					</option>
				</c:forEach>
			</select>
			<input type="submit" value="검색">
		</form>
	</div>
	${empList }
</body>
</html>















