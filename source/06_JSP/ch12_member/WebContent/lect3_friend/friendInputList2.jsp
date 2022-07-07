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
	<script>
		function search(){
			var name = frm.name.value;
			var tel = frm.tel.value;
			location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
		}
		window.onload = function(){
			document.getElementsByName("name")[0].keyUp = function(){
				var name = frm.name.value;
				var tel = frm.tel.value;
				location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
			};
		};
	</script>
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
	<form action="friendInputListPro2.jsp" name="frm">
		<p>친구이름 <input type="text" name="name" required="required"	size="10"
								value="<%
									String name = request.getParameter("name");
									if(name!=null) out.print(name);
								%>">
			 전화 <input type="text" name="tel" size="10"
			 					value="<%
									String tel = request.getParameter("tel");
									if(tel!=null) out.print(tel);
								%>">
			 <input type="button" value="검색" onclick="search()">
			 <input type="submit" value="추가">			 
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		<%
			FriendDao friendDao = FriendDao.getInstance();
			ArrayList<FriendDto> friends = friendDao.select(name, tel);
			for(FriendDto friend : friends){
				out.println("<tr>");
				out.println("<td>"+friend.getNo()+"</td>");
				out.println("<td>"+friend.getName()+"</td>");
				out.println("<td>"+(friend.getTel()!=null? friend.getTel():"")+"</td>");
				out.println("</tr>");
		}%>
	</table>
</body>
</html>






