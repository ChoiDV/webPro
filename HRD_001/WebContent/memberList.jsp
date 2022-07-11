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
	<style>
		section{width : 780px ; margin: 0 auto;  
			border: 1px solid blue;
			padding:10px;
			height:480px;
		}
		section ol { margin-left: 50px;}
		table {width:90%; margin: 10px auto;}
		table caption { font-size: 1.5em; padding:10px;}
	</style>
	<c:if test="${joinResult == 0}">
		<script>
			alert('회원가입이 실패되었습니다');
			history.back();
		</script>
	</c:if>
	<c:if test="${joinResult == 1}">
		<script>
			alert('회원가입이 완료되었습니다');
		</script>
	</c:if>
</head>
<body>
	<jsp:include page="main/header.jsp"/>
	<section>
		<table>
			<caption>회원목록 / 조회</caption>
			<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
			<c:if test="${memberList.size() eq 0 }">
				<tr><td colspan="7">등록된 회원이 없습니다</td></tr>
			</c:if>
			<c:if test="${memberList.size() != 0 }">
				<c:forEach var="member" items="${memberList}">
					<tr>
						<td><a href="${conPath }/getMember.do?custno=${member.custno}">${member.custno}</a></td>
						<td>${member.custname }</td>
						<td>${member.phone }</td>
						<td>${member.address }</td>
						<td>${member.joindate }</td>
						<td>${member.grade }</td>
						<td>${member.city }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>