<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}
 
tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}
 
td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table style="width: 900px; height: 500px ;margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
							<tr><th colspan="4">회원리스트</th></tr>
							<c:choose>
								<c:when test="${requestScope.rowcount > 0}">
									<c:forEach var="emp" items="${requestScope.emplist}">														 <tr>
										 <tr>
										 	<td>${emp.id}</td>
										 	<td>${emp.name}</td>
										 	<td>${emp.email}</td>
										 </tr>
									</c:forEach>
									<tr>
										<td colspan='3'>
										<b>[${requestScope.name}] 조회결과 ${requestScope.rowcount}건 조회</b>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
									<td colspan='3'>
										<b>[${requestScope.name}] 조회결과가 없습니다</b>
									</td>
									</tr>
								</c:otherwise>
							</c:choose>
				</table>
				<a href="Ex03_Memberlist.do">회원 목록 페이지</a>	
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>