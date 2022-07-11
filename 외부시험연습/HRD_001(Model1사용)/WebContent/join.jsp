<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	<script>
		function chk(){
			if(!frm.custname.value){
				alert('회원성명이 입력되지 않았습니다');
				frm.custname.focus();
				return false;
			}
		}
	</script>
</head>
<body>
<%
	MemberDao memberDao = new MemberDao();
	int custno = memberDao.getCustno();
	Date today = new Date(System.currentTimeMillis());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String todayStr = sdf.format(today);
%>
	<jsp:include page="main/header.jsp"/>
	<section>
		<form action="joinPro.jsp" name="frm" onsubmit="return chk()">
			<table >
				<caption>홈쇼핑 회원등록</caption>
				<tr><th>회원번호(자동발생)</th><td><input type="text" name="custno" value="<%=custno%>"></td></tr>
				<tr><th>회원성명</th><td><input type="text" name="custname"></td></tr>
				<tr><th>회원전화</th><td><input type="text" name="phone"></td></tr>
				<tr><th>회원주소</th><td><input type="text" name="address"></td></tr>
				<tr><th>가입일자</th><td><input type="text" name="joindate" value="<%=todayStr%>"></td></tr>
				<tr><th>고객등급(A:VIP, B:일반, C:직원)</th><td><input type="text" name="grade"></td></tr>
				<tr><th>도시코드</th><td><input type="text" name="city"></td></tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="등록">
						<input type="button" value="조회" onclick="location.href='memberList.jsp'">
			</table>
		</form>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>