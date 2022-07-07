<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			list = ${list};
			$.each(list, function(idx, item){
				alert(idx+'번째 : ' + item);
			});
		});
	</script>
</head>
<body>

</body>
</html>