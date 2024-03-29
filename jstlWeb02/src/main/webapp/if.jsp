<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL - if</title>
  </head>
  <body>
	  <!-- 변수 선언 -->
	  <c:set var = "number" value = "100"></c:set>
	  <c:set var= "string"  value = "JSTL"></c:set>
	  
	  <h4>JSTL의 if 태그로 짝수/홀수 판단</h4>
	  <c:if test="${number mod 2 eq 0 }" var="result">
	  	${number }은 짝수입니다.<br/>
	  </c:if>
	  result : ${result }<br/>
	  
	  <h4>문자열 비교, else 구문 흉내</h4>
	  <c:if test = "${ string eq 'Java' }" var = "result2">
	  	${string } 은 'Java'가 아닙니다.<br/>
	  </c:if>
	  <c:if test="${not result2 }"> 
	  <!--result2가 false이기 때문에 not result2는 true-->
	  	${string } 은 'Java'가 아닙니다!!<br/>
	  </c:if>
	  
	  <h4>조건식 주의사항</h4>
	  <c:if test="10" var = "result3">
	  	EL이 아닌 정수를 지정하면 false 
	  </c:if>
	  result3: ${result3 } <br/>
	  
	  <c:if test="true" var = "result4">
	  	대소문자 구분 없이 "true"인 경우 true<br/>
	  </c:if>
	  result4: ${result4 } <br/>
	  
	  <c:if test=" ${true} " var = "result5">
	  	EL 양 쪽에 빈 공백이 있는 경우 false<br/>
	  </c:if>
	   result5: ${result5 } <br/>
	  
	  
	  
	  
  </body>
</html>