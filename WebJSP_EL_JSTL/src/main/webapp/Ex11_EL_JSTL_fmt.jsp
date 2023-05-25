<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   <!-- 포맷팅(서버쪽에서 가지고 있는 데이터를 클라이언트에 뿌리기 전에 포맷 처리가 가능 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL Fmt 포맷관련</title>
	</head>
<body>
	<!-- http://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm -->
	 <h3>숫자관련</h3>
	 변수선언 : <c:set var="price" value="1000000"></c:set><br>
	 변수값 출력:${price}<br>
	 
	 
	 
	 <fmt:formatNumber value="${price}" type="number" /><br>                        <!-- 타입 지정, 문자열이다. 1,000,000으로 처리 -->
	 <fmt:formatNumber value="50000000" type="currency" currencySymbol="$" /><br>   <!-- &50,000,000 --> 
	 <fmt:formatNumber value="0.13"     type="percent"/>                            <!-- 13% -->
	 변수에 설정 <br>
	 <fmt:formatNumber value="123456789" pattern="###,###,###" var="pdata" />       <!-- 변환된결과를 변수에 담을 수 있다 = pdata -->
	 변수에 설정한 값 : ${pdata}<br>
	 
	 <hr>
	 <h3>날짜 관련 format</h3>
	 변수선언 : <c:set var="now" value="<%= new Date() %>" /><br>                                 <!-- Thu May 25 09:17:40 KST 2023 -->
	 변수값 : ${now}<br>
	 Basic Date : <fmt:formatDate value="${now}" type="date" /><br>                             <!-- 년월일 : 2023. 5. 25. -->
	 DateStyle(full) : <fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>       <!-- 2023년 5월 25일 목요일 -->
	 DateStyle(short) : <fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>     <!-- 23. 5. 25. -->
	 시간:<fmt:formatDate value="${now}" type="time"/><br>                                       <!-- 오전 9:17:40 -->
	 날짜 + 시간:<fmt:formatDate value="${now}" type="both"/><br>                                 <!-- both : 날짜+시간 / 2023. 5. 25. 오전 9:17:40 -->
	 혼합:<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>    <!-- 2023년 5월 25일 목요일 오전 9시 17분 40초 대한민국 표준시 -->
	 혼합2:<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br> <!-- 23. 5. 25. 오전 9:17 -->
</body>
</html>