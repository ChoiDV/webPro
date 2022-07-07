<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<a href="xx.jsp">xx</a>
<%--
	BoardDao bDao = BoardDao.getInstance();
	out.println("<h2>1. DB 글갯수 : " + bDao.getBoardTotalCnt()+"입니다</h2>");
	out.println("<h2>2. 글목록</h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos){
		out.println(dto + "<br>");
	}
	out.println("<h2>3. 글쓰기</h2>");
	BoardDto dto = new BoardDto(0, "김길동", "글제목 n", "본문\n임다", "kim@k.com", 0, "1", 0, 0, 0, 
															"127.0.0.2", null);
	int result = bDao.insertBoard(dto);
	out.println(result == BoardDao.SUCCESS ? "글쓰기 성공":"글쓰기실패");
	out.println("<h2>4와5. 조회수 올리고 글번호로 dto가져오기</h2>");
	bDao.readcountUp(7);
	dto = bDao.getBoardOneLine(7);
	out.println("수정전의 7번 글 " + dto);
	out.println("<h2>6.글수정</h2>");
	dto.setSubject("바뀐 제목xxxx");
	dto.setContent("바뀐 본문yyyyyy");
	result = bDao.updateBoard(dto);
	if(result == BoardDao.SUCCESS){
		dto = bDao.getBoardOneLine(7);
		out.println("수정 후의 7번 글 : "+dto);
	}else{
		out.println("수정 실패");
	}
	out.println("<h2>7. 7번글 삭제</h2>");
	result = bDao.deleteBoard(7, "1111");
	out.println(result==BoardDao.SUCCESS ? "7번글 삭제성공":"7번글 삭제실패(비번 인위적으로 틀렸음)");
	result = bDao.deleteBoard(7, "1");
	out.println(result==BoardDao.SUCCESS ? "7번글 삭제성공(비번 맞음)":"7번글 삭제실패");
--%>
</body>
</html>















