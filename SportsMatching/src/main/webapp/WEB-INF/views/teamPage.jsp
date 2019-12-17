<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 페이지</title>
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

</style>
</head>
<body>
<jsp:include page="LoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./MemberMyPage.do">마이페이지</a>
  <a href="./TeamPage.do">팀페이지</a>
  <a href="./MakeTeam.do">팀 창설</a>
  <a href="./AnswerBoard.do">게시판</a>
</nav>











</body>
</html>