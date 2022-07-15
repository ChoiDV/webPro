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
</head>
<body>
	<c:if test="${not empty nameError }">
		<script>alert('${nameError}')</script>
	</c:if>
	<c:if test="${not empty scoreError }">
		<script>alert('${scoreError}')</script>
	</c:if>
	<div id="wrap">
		<span class="cnt">"현재 총 ${cnt }명"</span>
		<form action="${conPath }/quizInput.do" method="post">
			<table>
				<caption>개인 정보 입력</caption>
		 		<tr><th>이름 : </th><td><input type="text" name="name" value="${quiz.name }"></td></tr>
		 		<tr><th>국어 : </th><td><input type="number" name="kor" value="${quiz.kor }"></td></tr>
		 		<tr><th>영어 : </th><td><input type="number" name="eng" value="${quiz.eng }"></td></tr>
		 		<tr><th>수학 : </th><td><input type="number" name="mat" value="${quiz.mat }"></td></tr>
		 		<tr><td colspan="2"><input type="submit" value="입력"></td></tr>
		 	</table>
		</form>
	 </div>
</body>
</html>