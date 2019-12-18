<%@page import="com.sports.matching.dtos.Belonged_TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</style>
</head>
<body>
<jsp:include page="TeamLoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./TeamInfo.do">팀 정보</a>
  <a href="./TeamManageMent.do">팀원 관리</a>
  <a href="./CancelRes.do">예약 취소</a>
</nav>
${lists}

</body>
</html>