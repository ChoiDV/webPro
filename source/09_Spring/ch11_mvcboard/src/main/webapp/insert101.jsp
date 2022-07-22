<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
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
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto bDto = new BoardDto();
	for(int i=0 ; i<101 ; i++){
		if(i%3==1){
			bDto.setBname("홍길동");
		}else if(i%3==1){
			bDto.setBname("이춘추");
		}else{
			bDto.setBname("마리오");
		}
		bDto.setBtitle("제목 "+i);
		bDto.setBcontent("본문입니다");
		bDto.setBip("127.12.10."+i);
		int result = boardDao.write(bDto);
		System.out.println(i+"번째 : " + (result==1? "성공" : "실패"));
	}
	response.sendRedirect("mvcboard/list.do");
%>
</body>
</html>
















