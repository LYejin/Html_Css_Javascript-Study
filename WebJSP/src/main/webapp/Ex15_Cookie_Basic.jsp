<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	정보(자료) 데이터 저장 > 어디에 (where)
	
	웹이라는 환경 관점 : 데이터는 어디에 저장
	
	클라이언트(개인 로컬 pc)   :   서버(웹서버 (웹 서비스가 가능한 pc, 아파치 or DB 서버))
	
	어디에 저장 (보관)
	고민 (기준점) : 보완 (데이터 중요성), 소멸(일시적, 영속적) 
	
	보완 : 클라이언트 - 서버
	소멸 : 메모리, 파일, DB
	
	Client (Local PC) : 웹 브라우저 
	1. Cookie (메모리 쿠키(브라우저 닫히면 같이 사라짐) - 파일 쿠키(파일 닫혀도 사라지지 않음 / local 디스크에 txt 암호화 시켜서 저장 : 소멸))
	2. Local storage  (key, value) 형태 > JSON 형태로 read, write
		장점) 크기, 객체 사용(데이터 : 의미있는 데이터 저장)
		
	Server (웹 서버 (WAS) : 메모리 + 파일, DB서버)
	1. server memory : session 객체 (로그인 -> 세션 취득) = 사이트에 접속하는 접속하는 [사용자마다] 고유하게 부여되는 메모리(객체) > 서버 리부팅, 개발코드 변경 > 소멸
	보통 20분 기준(로그아웃), 1000명 -> 100개
	2. server memory : application 객체 = 사이트 접속하는 [모든 사용자]에게 부여되는 메모리(객체) >
	1개도 가능, ex) 접속자 수
	3. server 영속적 : 파일.txt (관리가 힘들어요)
	4. DB server    : 보안, 영속적인 데이터 관리 >> 비용 >> 클라우드
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie mycookie = new Cookie("cname", "1004");
		//서버 쿠키 생성
		//아직 전달 안했어요
		//Cookie 클라이언트 전달 : response
		response.addCookie(mycookie); // 한줄로 전달
		// F12 session 삭제 -> 새롭게 생성(새로 왔구나!) -> 아니면 똑같은 값 전달
	%>
</body>
</html>