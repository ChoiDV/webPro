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
		*{padding:0; margin: 0;}
		a {text-decoration: none; font-weight: bold; color:black;}
		header { 
			width : 800px ; margin: 0 auto;
			background-color: blue; font-size: 1.5em; color:white;
			text-align: center;
			height: 100px; line-height: 100px;
		}
		nav{
			background-color: skyblue; font-size: 1.2em; color:white;
			width : 800px ; margin: 0 auto;
		}
		nav ul{overflow: hidden;}
		nav ul li{float: left;	width:25%;  list-style: none; text-align: center;}
	</style>
</head>
<body>
	<header>
		쇼핑몰 회원관리 ver 1.0
	</header>
	<nav>
		<ul>
			<li><a href="${conPath }/joinView.do">회원등록</a></li>
			<li><a href="${conPath }/memberList.do">회원목록/조회</a></li>
			<li><a href="${conPath }/salesList.do">회원매출목록</a></li>
			<li><a href="${conPath }/main.do">홈으로</a></li>
		</ul>
	</nav>
</body>
</html>