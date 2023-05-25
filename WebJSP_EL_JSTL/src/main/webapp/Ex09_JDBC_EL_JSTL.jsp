<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="kr.or.kosa.dto.EmpDao"%>
<%@page import="UTILS.SingletonHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = null;
conn = SingletonHelper.getConnection("oracle");
%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%
		EmpDao ed = new EmpDao();
		List<Emp> empList = ed.getEmpAllList();
		request.setAttribute("emp", empList);
	%>

	<table class="table">
  <thead>
    <tr>
      <th>empno</th>
      <th>ename</th>
      <th>job</th>
      <th>mgr</th>
      <th>hiredate</th>
      <th>sal</th>
      <th>deptno</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="emp" items="${requestScope.emp}">
        <tr>
	      <td>${emp.empno}</td>
	      <td>${emp.ename}</td>
	      <td>${emp.job}</td>
	      <td>${emp.mgr}</td>
	      <td>${emp.hiredate}</td>
	      <td>${emp.sal}</td>
	      <td>${emp.deptno}</td>
    	</tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>