<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.modal {border: 1px solid gray;}
		.modal_content {
			width:50%;
			margin: 0 auto;
			border: 1px solid red;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#wrap').click(function(e){
				var target = e.target; // 이벤트가 적용된 부분
				if(!$('.modal_content').has(target).length){
					alert('modal_content를 제외한 부분 클릭했구먼');
				}
			});
		});
	</script>
</head>
<body>
	<div id="wrap">
		<div class="modal">model
			<div class="modal_content">
				<h1>modal_content</h1>
			</div>
		</div>
	</div>
</body>
</html>