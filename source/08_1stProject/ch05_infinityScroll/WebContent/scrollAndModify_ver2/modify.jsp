<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[type="button"]').click(function(){
				opener.document.getElementById('name${param.no}').innerHTML = $('input[name="name"]').val();
				opener.document.getElementById('tel${param.no}').innerHTML = $('input[name="tel"]').val();
				opener.document.getElementById('addr${param.no}').innerHTML = $('input[name="addr"]').val();
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<form action="modify.do">
		<table>
			<tr>
				<td><input type="text" name="no" value="${param.no }"></td>
				<td><input type="text" name="name" value="${param.name }"></td>
				<td><input type="text" name="tel" value="${param.tel }"></td>
				<td><input type="text" name="addr" value="${param.addr }"></td>
				<td><input type="button" value="수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>