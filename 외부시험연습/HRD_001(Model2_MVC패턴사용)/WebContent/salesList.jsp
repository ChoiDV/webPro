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
			height:300px;
		}
		section ol { margin-left: 50px;}
		table {width:80%; margin: 10px auto; }
		table caption { font-size: 1.5em; padding:10px;}
		table td { text-align: center;}
	</style>
</head>
<body>
	<jsp:include page="main/header.jsp"/>
	<section>
		<table border="1">
			<caption>회원매출조회</caption>
			<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
			<c:if test="${salesList.size() eq 0 }">
				<tr><td colspan="4">등록된 매출이 없습니다</td></tr>
			</c:if>
			<c:if test="${salesList.size() != 0 }">
				<c:forEach var="sale" items="${salesList}">
					<tr>
						<td>${sale.custno}</td>
						<td>${sale.custname }</td>
						<td>${sale.gradename }</td>
						<td>${sale.price }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>