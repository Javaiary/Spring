<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그아웃 페이지</title>
  </head>
  <body>
	  <h1> Logout Page</h1>
 
	<form action="/springsecurity/logoutForm" method='post'>
	<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>
	<button>로그아웃</button>
	</form>
	  
  </body>
</html>