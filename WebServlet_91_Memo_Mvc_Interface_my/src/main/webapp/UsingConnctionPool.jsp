<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection Pool 사용하기</title>
</head>
<body>
	<%
		//JNDI
		Context context = new InitialContext(); // 다형성
		//현재 [프로젝트]에서 특정 이름을 가진 객체를 검색 (이름 기반 검색) = 윈도우 탐색기랑 동일
		
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //lookup 함수안에 정해진 형식의 이름 제공
		//java:comp/env/(공통) + 이름(jdbc/oracle)
		
		//튜브를 주세요
		Connection conn = null; //튜브 가게에서 튜브를 빌려온 것! (반드시 다 놀고 반환하자)
		
		conn = ds.getConnection();
		
		out.print("db 연결여부 : " + conn.isClosed() + "<br>");
		
		//놀아요
		//집에가요
		//반환
		conn.close(); // 자원 해제가 아니고 connection pool 반환
		out.print("db연결여부(true) : " + conn.isClosed() + "<br>");
		
		//그래서 Pool 객체의 scope >> method 단위로 >> 사용하고 반환 
	%>
</body>
</html>