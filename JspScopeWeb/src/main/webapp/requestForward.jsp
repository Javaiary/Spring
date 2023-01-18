<%@page import="kr.co.ezenac.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>request 영역</title>
  </head>
  <body>
  		<H2>포워드로 전달된 페이지</H2>
	      <h4>requestMain 파일의 리퀘스트 영역</h4>
	      <%
	      Person rPerson = (Person)request.getAttribute("requestPerson");
	      %>
	      	<h2>request 영역 속성값 읽기</h2>
	<ul>
		<li>String 객체: <%= request.getAttribute("requestString") %></li>
		<li>Person 객체: <%= rPerson.getName() %>, <%= rPerson.getAge() %></li>
		
	</ul>
	  <h4>매개변수로 전달된 값 출력하기</h4>
	  <%
	  	request.setCharacterEncoding("utf-8");
	  	out.println(request.getParameter("paramOne"));	  	
	  	out.println(request.getParameter("paramTwo"));

	  %>
  </body>
</html>