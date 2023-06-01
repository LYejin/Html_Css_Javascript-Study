<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/views/Head.jsp"></jsp:include>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse d-flex" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" href="Ex02_JDBC_Main.jsp">Main</a>
		<a class="nav-link" href="Ex02_JDBC_Login.jsp">Login</a>
		<a class="nav-link" href="Ex02_JDBC_JoinForm.jsp">Register</a>
		<a class="nav-link disabled" href="#">Intro</a>
		<a class="nav-link disabled" href="#">Intro</a>
		<c:choose>
			<c:when test="${userid != null}">
				<b class='nav-link'> ${userid} </b> <span class='nav-link'>로그인 상태</span>
				<a class='nav-link' href='Ex02_JDBC_Logout.do'>[ 로그아웃 ]</a>
			</c:when>
			<c:otherwise>
				<b class='nav-link'>[로그인 하지 않으셨네요]</b>
				<a class='nav-link' href='Ex02_JDBC_Login.do'>[ 로그인 ]</a>
			</c:otherwise>
		</c:choose>
      </div>
    </div>
  </div>
</nav>