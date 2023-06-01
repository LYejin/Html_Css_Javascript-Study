<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/registerok.do" method="post">
		ID : 	<input type="text" 	 	name="id" 	 placeholder="id입력" 	 required="required"><br> <!-- name도 멤버필드의 이름과 동일하게 -->
		PWD : 	<input type="passward"  name="pwd"   placeholder="pwd입력" 	 required="required"><br>
		EMAIL : <input type="text" 	 	name="email" placeholder="email입력" required="required"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>