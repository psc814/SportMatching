<%@page import="com.sports.matching.dtos.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Sulphur+Point&display=swap')
	;
</style>
<a> <img alt="홈" src="./images/handshake.png"
	style="position: absolute;"
>
</a>
<header
	style="background-color: skyblue; text-align: center; font-size: 50px; font-family: 'Sulphur Point', sans-serif;"
>
	<a style="text-decoration: none;">SPORTSMATCHING</a>
	
</header>
<div style="position: absolute; right: 10px;top: 10px; height: 50px; text-align: right;">
		<span style="font-size: 10px;"> 관리자&nbsp;:&nbsp;${sadto}</span><br> 
		<span><a href="./teamLogout.do" style="font-size: 10px; text-align: right;">로그아웃</a></span>
</div>