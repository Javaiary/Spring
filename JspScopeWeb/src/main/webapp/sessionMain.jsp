<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    ArrayList<String> lists = new ArrayList<>();
    lists.add("리스트");
    lists.add("컬렉션");
   //세션영역에  속성명 "lists"으로 arrayList객체인 lists 속성값을 지정함;
	session.setAttribute("lists", lists);    
    %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>session 영역</title>
  </head>
  <body>
	  	  <h2>페이지 이동 후 session영역의 속성 읽기</h2>
	  <a href="sessionLocation.jsp">sessionLocation.jsp 바로가기</a>
  </body>
</html>