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
<!-- bean태그 이용하면 getParameter 대체 -->
<jsp:useBean id="member" class="com.lec.hrd.dto.MemberDto"/>
<jsp:setProperty name="member" property="*"/>
<%
	/* int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	MemberDto member = new MemberDto(custno, custname, phone, address, joindate, grade, city); */
	MemberDao memberDao = new MemberDao();
	int result = memberDao.update(member);
	if(result == 1){
%>
		<script>
			alert('회원 정보 수정이 완료되었습니다');
			// location.href = 'update.jsp?custno='+<%=member.getCustno()%>;
			location.href = 'memberList.jsp';
		</script>
<%}else{%>
		<script>
			alert('회원 정보 수정이 실패되었습니다');
			history.back();
		</script>
<%}%>
</body>
</html>