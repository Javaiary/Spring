<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>표현언어에서 사용되는 데이터 출력</title>
  </head>
  <body>
	  ${100 } <br/>
	  ${"좋은 월요일일까요?" }<br/>
	  ${10+1 }<br/>
	  ${"10" + 1 } <br/> 		<!--숫자형 문자열은 자동으로 캐스팅되어 연산-->
	  <%-- ${null +10 }<br/> --%>			<!--null 변수 사용해도 예외발생 X  -->
	  

  </body>
</html>