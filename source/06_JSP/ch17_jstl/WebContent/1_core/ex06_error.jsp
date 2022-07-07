<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>예외처리</h2>
	<c:catch var="error"> <!-- catch절에서 예외가 발생할 경우, 예외타입과 예외 메세지가 error 저장 -->
		<h2>테스트</h2>
		<%=8/0 %>
		<p>예외가 발생되는 즉시 catch절을 빠져나감. 이 p태그 출력시 예외가 발생안 됨</p>
	</c:catch>
	예외타입과 예외메세지 : <c:out value="${error }" default="예외발생 안 됨"/>
</body>
</html>















