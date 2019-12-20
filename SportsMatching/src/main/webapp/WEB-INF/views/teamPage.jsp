<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀페이지</title>
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

</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js">
	$(function(){
		$("#teamInfo").click(function(){
			$.ajax({
				type : 'post',
				url : './teamInfo.do',
				dataType : 'jsp',
				success : function(info){
					$("#info").jsp(info);
				}
			});
		})
	})
</script>
<body>
<jsp:include page="LoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./MemberMyPage.do">마이페이지</a>
  <a href="./TeamPage.do">팀페이지</a>
  <a href="./MakeTeam.do">팀 창설</a>
  <a href="./AnswerBoard.do">게시판</a>
</nav>
<table>
<tr>
<c:forEach items="${lists}" var="lists">
		
		<td><input type="button" id="teamInfo" value="${lists.team_id}"></td>

</c:forEach>
</tr>
</table>

</body>
</html>