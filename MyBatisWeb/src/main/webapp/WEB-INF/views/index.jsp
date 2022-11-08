<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var = "loginout" value = "${sessionScope.id==null? 'Login' : 'Logout' }"/>
<c:set var = "loginoutlink" value ="${sessionScope.id == null? '/login/login' : '/login/logout' }" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인</title>
<link rel="stylesheet" href="<c:url value = '/resources/css/menu.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">ezen</li>
			<li><a href="<c:url value='/'/>">Home</a></li>
			<li><a href="<c:url value='/board/list'/>">Board</a></li>
			<li><a href="<c:url value='${loginoutlink }'/>">${loginout }</a></li>
			<li><a href="<c:url value='/register/add'/>">SignUp</a></li>
			<li><a href=""><i class = "fas fa-search small"></i></a></li>
		</ul>
	</div>
	<div style="text-align: center;">
		<h1>세상을 바꾸는 HOME!</h1>
		<h1>후손들에게 빌린 지구!</h1>
		<h1>LOVE YOUR SELF!</h1>
	</div>



</body>
</html>