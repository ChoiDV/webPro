<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>ID : ${param.id }</h3>
	<h3>
		키우는 동물은 ${paramValues.pets[0] }
							${paramValues.pets[1] }
							${paramValues.pets[2] }
							${paramValues.pets[3] }
							${paramValues.pets[4] }
		${empty paramValues.pets ? "없습니다":"" }
	</h3>
	<h2>contextID : ${initParam.contextID }</h2>
	<h2>contextPW : ${initParam.contextPW }</h2>
<%--
	String id = request.getParameter("id");
	String[] pets = request.getParameterValues("pets");
	out.println("<h3>ID : " +id +"</h3>");
	out.println("<h3>키우는 동물은 ");
	if(pets!=null){
		for(String pet : pets){
			out.println(pet + " ");
		}
	}else{
		out.println("없습니다");
	}
	out.println("</h3>");
--%>	
</body>
</html>

















