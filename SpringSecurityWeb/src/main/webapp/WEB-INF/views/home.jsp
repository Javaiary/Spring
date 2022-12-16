<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<button type = "button" onclick="location.href='/springsecurity/loginForm'">로그인</button> 
<button type = "button" onclick="location.href='/springsecurity/sample/member'">회원 권한 페이지</button>
<button type = "button" onclick="location.href='/springsecurity/sample/admin'">관리자 권한 페이지</button>
</body>
</html>
