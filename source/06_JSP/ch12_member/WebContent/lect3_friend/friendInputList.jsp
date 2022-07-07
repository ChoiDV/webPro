<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<style>
		p {width:400px; margin: 0 auto;}
	</style>
</head>
<body>
<%
	String result = request.getParameter("result");
	if(result!=null && result.equals("1")){
		out.println("<script>alert('친구추가 성공');</script>");
	}else if(result!=null && result.equals("0")){
		out.println("<script>alert('친구추가 실패. 이름이나 전화번호가 너무 길면 안되요');</script>");
	}
%>
	<form action="friendInputListPro.jsp">
		<p>친구이름 <input type="text" name="name" required="required"	size="10">
			 전화 <input type="text" name="tel" size="10">
			 <input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		<%
			FriendDao friendDao = FriendDao.getInstance();
			ArrayList<FriendDto> friends = friendDao.selectAll();
			for(int idx=0; idx<friends.size() ; idx++){%>
				<tr>
					<td><%=friends.get(idx).getNo() %></td>
					<td><%=friends.get(idx).getName() %></td>
					<td><%=friends.get(idx).getTel()!=null?  friends.get(idx).getTel():"-"%></td>
				</tr>
		<%}%>
	</table>
</body>
</html>