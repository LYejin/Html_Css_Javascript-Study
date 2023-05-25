<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	//list.do?id=kglim&pwd=1004
	//list.do?id=kglim&pwd=1004&hobby=농구&hobby=야구&hobby=당구
	
	//String[] hobbys = request.getParameterValues("hobby")
	
	//EL > ${param.id}  ${param.pwd}   ${paramVaues.hobby}

	//Ex08_EL_JSTL_Quiz.jsp?id=kglim&pwd=1004&hobby=농구&hobby=야구&hobby=당구
			
	//html name과 동일하다 name=id, name=pwd, name=hobby
	//html name=hobby 인 것을 불러옴
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		hobby 다중값을 받아서 choose 구문을 사용하여 값이 하나도 선택되지 않았다면
		"선택을 하세요" 라는 문자를 출력하고 
		값이 하나라도 넘어 왔다면 ... <ul><li>java</li><li>oracle</li></ul> 과 같은 형식으로
		출력하도록  forEach 를 작성하세요
	 -->
	<h3>EL 다중값 처리</h3>
	<c:choose>
		<c:when test="${not empty paramValues.hobby}">
		당신의 선택은
			<ul>
				<c:forEach var="hobby" items="${paramValues.hobby}" varStatus="status"> <!-- index와 count를 사용할 수 있다 -->
					<li>${hobby} - ${status.index} - ${status.count}</li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<b>선택하세요</b>
		</c:otherwise>
	</c:choose>
</body>
</html>


