<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="isErrorPage.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page 지시어 - errorPage, isErrorPage 속성</title>
  </head>
  <body>
	  <%
//	 try{
		  	int myAge = Integer.parseInt(request.getParameter("age")) + 10; //age 가 정의되지 않아 에러발생
		  	out.println ("추가된 년수가 " +myAge+ "입니다.");		// 에러발생으로 실행 건너뜀
//	  }
//		catch(Exception e){
//			out.println("예외 발생 : 매개변수 age가 null입니다. ");
			//메시지가 아닌 에러 페이지를 작성해서 에러 페이지를 보여 줄 수도 있음
			// try & catch를 하면 errorPage 보다 catch 실행문이 우선됨
//		}
	  %>
  </body>
</html>