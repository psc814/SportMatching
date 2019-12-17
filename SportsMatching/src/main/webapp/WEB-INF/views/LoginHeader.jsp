<%@page import="com.sports.matching.dtos.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Sulphur+Point&display=swap')
	;
	
	div{
		text-align: right;
		font-size: 20px;
	}
</style>
<a>
	<img alt="홈" src="./images/handshake.png" style="position: absolute;">
</a>
<header style="background-color: skyblue; text-align: center; font-size: 50px; font-family: 'Sulphur Point', sans-serif;">
	<a style="text-decoration: none;">SPORTSMATCHING</a>
	<div>
		${uEmail}님 환영합니다
	</div>
	<div>
		<a href="./logout.do">로그아웃</a>
	</div>
</header>
