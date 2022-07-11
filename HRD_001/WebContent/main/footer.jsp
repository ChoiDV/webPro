<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/section.css" rel="stylesheet">
	<style>
		footer { 
			width : 800px ; margin: 0 auto;
			background-color: blue; font-size: 0.8em; color:white;
			text-align: center;
			height: 50px; line-height: 50px;
		}
	</style>
</head>
<body>
	<footer>
		<p>HRDKOREAD Copyright ⓒ2016. All rights reserved.</p>
	</footer>
</body>
</html>