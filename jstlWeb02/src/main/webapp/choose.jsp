<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL - choose/when/otherwise</title>
  </head>
  <body>
	  <!-- 변수 선언 -->
	  <c:set var = "number" value = "100"/>
	  
	  
	 	<h4>choose 태그로 홀짝 판단</h4>
	 	<c:choose>
	 		<c:when test="${ number mod 2 eq 0 }"> ${number }는 짝수</c:when>
	 		<c:otherwise>${number }는 홀수</c:otherwise>
	 	</c:choose>
	 	
	 	<h4>국영수 점수를 입력하면 평균을 내어 학점 출력</h4>
	 	<form action="#">
	 		국어 : <input type="text" name ="kor"/><br/>
	 	영어 : <input type="text" name ="eng"/><br/>
	 		수학 : <input type="text" name ="math"/><br/>
	 		<input type = "submit" value = "학점구하기" />
	 	</form>
	 	
	 	<c:if test="${not(empty param.kor or empty param.eng or empty param.math) }">
	 	<!-- 빈 값이 없는지 체크 후 // 평균 계산 -->
	 		<c:set var ="avg" value="${(param.kor+param.eng+param.math)/3 }"></c:set>
	 		평균 점수는 ${avg } 이고<br/> 학점은
	 	<!-- 학점 출력 -->
	 		<c:choose>
	 			<c:when test="${avg >= 90}">A</c:when>
	 			<c:when test="${avg >= 80}">B</c:when>
	 			<c:when test="${avg ge 70}">C</c:when>
	 			<c:when test="${avg ge 60}">D</c:when>
	 			<c:otherwise>-- F --</c:otherwise>
	 		</c:choose>
	 		이다.
	 	</c:if>
  </body>
</html>