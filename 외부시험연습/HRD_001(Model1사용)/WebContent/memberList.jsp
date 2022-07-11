<%@page import="com.lec.hrd.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.hrd.dao.MemberDao"%>
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
		table {width:90%; margin: 10px auto;}
		table caption { font-size: 1.5em; padding:10px;}
	</style>
</head>
<body>
<%
	MemberDao memberDao = new MemberDao();
	ArrayList<MemberDto> memberList = memberDao.memberList();
%>
	<jsp:include page="main/header.jsp"/>
	<section>
		<table border="1">
			<caption>회원목록 / 조회</caption>
			<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
			<%for(MemberDto member : memberList){ %>
					<tr>
						<td><a href="update.jsp?custno=<%=member.getCustno() %>"><%=member.getCustno() %></a></td>
						<td><%=member.getCustname() %></td>
						<td><%=member.getPhone()%></td>
						<td><%=member.getAddress() %></td>
						<td><%=member.getJoindate() %></td>
						<td><%=member.getGrade() %></td>
						<td><%=member.getCity()%></td>
					</tr>
			<%} %>
		</table>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>