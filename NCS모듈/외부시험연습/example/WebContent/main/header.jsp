<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		*{padding:0; margin: 0;}
		a {text-decoration: none; font-weight: bold; color:black;}
		header { 
			width : 800px ; margin: 0 auto;
			background-color: blue; font-size: 1.5em; color:white;
			text-align: center;
			height: 70px; line-height: 70px;
		}
		nav{
			background-color: skyblue; color:white;
			width : 800px ; margin: 0 auto;
		}
		nav ul{overflow: hidden;}
		nav ul li{float: left;	width:25%;  list-style: none; text-align: center;}
	</style>
</head>
<body>
	<header>
		애플리케이션 배포
	</header>
	<nav>
		<ul>
			<li><a href="join.jsp">회원등록</a></li>
			<li><a href="memberList.jsp">회원목록/조회</a></li>
			<li><a href="salesList.jsp">매출목록(회원/제품)</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
</body>
</html>