<%@page import="com.sports.matching.dtos.Belonged_TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 정보</title>
<style type="text/css">
#regiForm{
	margin-left: 550px;
	margin-top: 200px;
}
</style>
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

table{
	width: 300px;
}
th{
	background-color: skyblue;
}

</style>
</head>
<body>
<jsp:include page="TeamLoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./TeamInfo.do">팀 정보</a>
  <a href="./TeamManageMent.do">팀원 관리</a>
  <a href="./CancelRes.do">예약 취소</a>
</nav>

<div style="width: 300px; height: 300px; float: left; margin-top:250px; margin-right: 300px; margin-left: 350px">
	<table border="1px solid;" style="text-align: center;">
			<th>팀 회원들</th>
			<c:forEach items="${lists}" var="lists">
				<tr>
					<td>${lists.member_id}</td>
				</tr>
			</c:forEach>
	</table>
</div>

<div style="width: 300px; height: 300px; float: left; margin-top:250px;">
	<table  border="1px solid;" style="text-align: center;">
		<tr>
			<th>주장 아이디</th>
			<td>${tsdto.captain_id}</td>
		</tr>
		<tr>
			<th>주장 전화번호</th>
			<td>${tsdto.captain_phone_number}</td>
		</tr>
		<tr>
			<th>주활동지</th>
			<td>${tsdto.playground}</td>
		</tr>
		<tr>
			<th>공격력</th>
			<td>${tsdto.attack}</td>
		</tr>
		<tr>
			<th>수비력</th>
			<td>${tsdto.defence}</td>
		</tr>
		<tr>
			<th>매너점수</th>
			<td>${tsdto.manner}</td>
		</tr>
	</table>
</div>
</body>
</html>