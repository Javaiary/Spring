<%@page import="java.util.Set"%>
<%@page import="kr.co.ezenac.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>application 영역</title>
  </head>
  <body>
	  <h2>application 영역의 공유</h2>
	  <%
	  Map<String, Person> maps = (Map<String,Person>) application.getAttribute("maps");  
	  Set<String> keys = maps.keySet();
	  for(String key : keys){
		 Person person= maps.get(key);
		 out.println(String.format("이름 : %s, 나이 : %d<br/>", person.getName(), person.getAge()));
	  }
	  
	  %>
	  
  </body>
</html>