<%@page import="com.lec.hrd.dao.MemberDao"%>
<%@page import="com.lec.hrd.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	MemberDto member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
	MemberDao memberDao = new MemberDao();
	int result = memberDao.join(member);
	if(result == 1){
%>
		<script>
			alert('회원가입이 완료되었습니다');
			location.href = 'memberList.jsp';
		</script>
<%}else{%>
		<script>
			alert('회원가입이 실패되었습니다');
			history.back();
		</script>
<%}%>
</body>
</html>