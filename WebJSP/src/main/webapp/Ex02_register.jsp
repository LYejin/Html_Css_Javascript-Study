<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*
	1. 클라이언트에서 전송된 데이터 받기
	1.1 Tomcat(내장 객체) 클라이언트가 요청 보내면 : 요청 한건에 대해서 서버는 request 객체 자동 생성
	1.2 자동 생성된 request는 객체는 클라이언트의 다양한 정보를 담아요 : 다양한 정보 (입력 데이터 + ip + 브라우저 정보)
	1.3 request 요청 객체 필요한 자원을 불러내면 된다
	
	 GET >> jsp?userid=kglim&pwd=1004......
	 POST >> jsp (http 숨겨서 가져간다)
	*/
	
	String uid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	// hobby > input name="hobby"
	// 배열
	
	String[] hobbyarray = request.getParameterValues("hobby");
	// 알아서 배열에 넣는다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	서버에서 클라이언트에게 응답 <br>
	ID값 <%=uid %><br>
	PWD값 <%=pwd %><br>
	당신의 취미는
	<%
		for (String str : hobbyarray) {
	%>
		<b>hobby : <%=str%></b>
	<%		
		}
	%>
</body>
</html>