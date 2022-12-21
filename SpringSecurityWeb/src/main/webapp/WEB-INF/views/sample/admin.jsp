<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
  </head>
  <body>
	  <h1>/sample/admin page</h1>
	  <p>principal : <sec:authentication property="principal"/></p>
	  <p>MemberDTO : <sec:authentication property="principal.member"/></p>
	  <p>사용자이름 : <sec:authentication property="principal.member.user_name"/></p>
	  <p>사용자아이디 : <sec:authentication property="principal.username"/></p>
	  <p>사용자 권한 리스트  : <sec:authentication property="principal.member.authList"/></p>
		  
	  <button type = "button" onclick="location.href='/springsecurity/logoutForm'">로그아웃</button>
	  
  </body>
</html>