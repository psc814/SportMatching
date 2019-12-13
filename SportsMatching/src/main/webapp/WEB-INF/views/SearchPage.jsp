<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색페이지</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
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
<jsp:include page="KLoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./MemberMyPage.do">마이페이지</a>
  <a href="./TeamPage.do">팀페이지</a>
  <a href="./AnswerBoard.do">게시판</a>
</nav> 
</body>
</html>