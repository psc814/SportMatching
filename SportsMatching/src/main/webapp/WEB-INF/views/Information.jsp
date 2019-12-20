<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>각 팀 정보</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="./css/userMain.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  font-size: 20px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.navbar a:hover{
  background-color: red;
}

#infomation{
	margin-left: 680px;
	margin-top: 200px;
}
table, th, td{
	border: 1px solid;
}
th{
	background: skyblue;
}
td{
	height: 30px;
	width: 100px;
}
</style>
</head>
<script type="text/javascript">
	function teamInfo(team){
		location.href="./teamInfo.do?team_id="+team;
	}
</script>
<body>
<jsp:include page="LoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./MemberMyPage.do">마이페이지</a>
  <a href="./TeamPage.do">팀페이지</a>
  <a href="./MakeTeam.do">팀 창설</a>
  <a href="./AnswerBoard.do">게시판</a>
</nav>
<div id="infomation">
<table>
	<tr>
		<th>팀명:</th>
		<td>${tsdto.team_id}</td>
	</tr>
	<tr>
		<th>주장아이디:</th>
		<td>${tsdto.captain_id}</td>
	</tr>
	<tr>
		<th>주장 전화번호:</th>
		<td>${tsdto.captain_phone_number}</td>
	</tr>
	<tr>
		<th>주활동지:</th>
		<td>${tsdto.playground}</td>
	</tr>
	<tr>
		<th>공격:</th>
		<td>${tsdto.attack}</td>
	</tr>
	<tr>
		<th>수비:</th>
		<td>${tsdto.defence}</td>
	</tr>
	<tr>
		<th>메너:</th>
		<td>${tsdto.manner}</td>
	</tr>
</table>
<input type="button" value="뒤로가기" onclick="history.back(-1);">
</div>
</body>
</html>