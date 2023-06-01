<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#btn1').click(function(){
				console.log("test", $('#test').text()); //getter
			});
			
			$('#btn2').click(function(){
				console.log("test", $('#test').html()); //getter 태그인정 -> 안녕하세요<b>정말</b>
			});
			
			$('#btn3').click(function(){
				//$('#test').text("<div>AAA</div>"); //setter 반영 안되서 <div>AAA</div> 출력
				$('#test').html("<div>AAA</div>"); // 태그를 반영하고 싶으면 반영되어 AAA 출력
			});
		});
	</script>
</head>
<body>
	<p id="test">안녕하세요<b>정말</b></p>
	<button id="btn1">show text</button>
	<button id="btn2">show html</button>
	<button id="btn3">html</button>
</body>
</html>