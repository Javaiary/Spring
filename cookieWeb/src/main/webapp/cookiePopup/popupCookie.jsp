<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String chkVal = request.getParameter("notopentoday");	//notopentoday 매개변수값 얻기
	
	if(chkVal != null && chkVal.equals("1")){ //값이 "1"이고 체크된 상태이면 ==> 쿠키 생성 & 응답헤더에 추가
		Cookie cookie = new Cookie("PopupClose", "off");		//쿠키 생성
		cookie.setPath(request.getContextPath()); 				//경로 설정
		cookie.setMaxAge(60);									//쿠키 유지 기간 설정(1분)
		response.addCookie(cookie);								//응답 헤더에 추가
		out.println("쿠키 : 1분 동안 열지 않음" );
	
	}
	
	%>