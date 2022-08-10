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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			var list = ${list};
			$(list).each(function(idx, item){
				alert('이름은 '+item.name +',아이디는' + item.id + ', 비번은 ' + item.pw);
			});
			var test = ${test};
			alert(test);
		});
	</script>
</head>
<body>
	<h3>list(DTO ArrayList) : ${list }</h3>
	<h3>test(String ArrayList) : ${test }</h3>
	<hr>
	<form action="${conPath }/member/join6">
		<table>
			<caption>개인 정보 입력</caption>
			<tr><th>이름</th><td><input type="text" name="name"></td></tr>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><td colspan="2"><input type="submit" value="join"></td></tr>
		</table>
	</form>
</body>
</html>












