<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	웹 환경
	
	Client     ->     server (요청된 정보를 request 객체를 통해서 얻어서 사용)
			(request 요청)
			
	Server     -> 		Client ( response 응답 >> 결과 >> 클라이언트에게 전달
			(request 응답) : 클라이언트 브라우저가 해석가능한 형태 (text, html, css, javascript)로 보냄
	
	내장 객체 
	request
	response
	session
	application
	out 등등
	(아파치 톰켓 서버가 가지고 있는 자원들이다) : javax. 으로 시작 (패키지)
	
	response
	1. 표현식 (출력) %=
	2. 페이지 이동 (response.sendRedirect())
	response.sendRedirect("이동할 주소") >> 해석의 주체 서버 (렌더링) >> 클라이언트 전달(어떤 코드)
	javascript 페이지 이동 >> location.href="이동할 주소"
	*******javascript 페이지 이동 >> location.href="이동할 주소"******
	*******웹 브라우저에서 F5의 (새로고침) >> 서버로부터 갱신된 페이지를 받겠다...


 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1. 일반적인 출력 담당: <%= 100+200+300 %><br>
	2. sendRedirect : response객체의 함수<br>
	<%
		//response.sendRedirect("Ex01_index.jsp"); // Ex01_index.jsp 다시보여주세요!
	%>
</body>
<script type="text/javascript">
	location.href="Ex01_index.jsp";
</script>
</html>