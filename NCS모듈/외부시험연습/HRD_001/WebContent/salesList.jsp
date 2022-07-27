<%@page import="com.lec.hrd.dto.MoneyDto"%>
<%@page import="com.lec.hrd.dao.MoneyDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		section{width : 780px ; margin: 0 auto;  
			border: 1px solid blue;
			padding:10px;
			height:500px;
		}
		section ol { margin-left: 50px;}
		table {width:80%; margin: 10px auto; }
		table caption { font-size: 1.5em; padding:10px;}
		table td { text-align: center;}
	</style>
</head>
<body>
<%
	MoneyDao moneyDao = new MoneyDao();
	ArrayList<MoneyDto> saleslist = moneyDao.salesList();
%>
	<jsp:include page="main/header.jsp"/>
	<section>
		<table border="1">
			<caption>회원매출조회</caption>
			<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
			<%
				for(MoneyDto sale : saleslist){
			%>
					<tr>
						<td><%=sale.getCustno() %></td>
						<td><%=sale.getCustname() %></td>
						<td><%=sale.getGradename() %></td>
						<td><%=sale.getPrice() %></td>
					</tr>
			<%} %>
		</table>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>