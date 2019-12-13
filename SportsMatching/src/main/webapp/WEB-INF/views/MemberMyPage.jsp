<%@page import="java.util.List"%>
<%@page import="com.sports.matching.dtos.Belonged_TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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

</style>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<jsp:include page="KLoginHeader.jsp"/>
		<nav style="text-align: center;" class="navbar">
  			<a href="./MemberMyPage.do">마이페이지</a>
  			<a href="./TeamPage.do">팀페이지</a>
  			<a href="./AnswerBoard.do">게시판</a>
		</nav>
		
	<table>
		<tr>
			<th>회원아이디</th>
			<td>${btdto[0].member_id}</td>
		</tr>
		<tr>
			<th colspan="2">소속팀</th>
		</tr>
		<c:forEach items="${btdto}" var="bt">
			<tr>
				<td colspan="2">소속팀 :&nbsp;${bt.team_id} <input type="button" value="탈퇴" onclick="delete()"></td>
			</tr>
		</c:forEach>	
	</table>
	<input type="button" value="회원탈퇴" onclick="withdraw()">
</body>
</html>