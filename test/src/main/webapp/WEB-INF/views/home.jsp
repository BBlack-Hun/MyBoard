<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	애옹이야 게시판이야~~~ 
</h1>
<sec:authorize access="isAnonymous()">
    <h5><a href='<c:url value="/users/login"/>'>LOGIN</a> 로그인 해주세요.</h5>
    <P>  The time on the server is ${serverTime}. </P>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a href="#" onclick="document.getElementById('logout-form').submit();">Sign out</a>
	<form id="logout-form" action='<c:url value='/logout'/>' method="POST">
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
	</form>

   <p><a href="/board/index">게시판으로 넘어갑니다.</a></p>
	<a href='<c:url value="/users/Guest"/>'>GUEST</a>
	<a href='<c:url value="/users/user"/>'>USER</a>
	<a href='<c:url value="/users/member"/>'>MEMBER</a>
	<a href='<c:url value="/users/admin"/>'>ADMIN</a>
</sec:authorize>
	

</body>
</html>
