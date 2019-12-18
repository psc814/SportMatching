<%@page import="com.sports.matching.dtos.Belonged_TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀원 관리</title>
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
	border: 1px solid;
}
td, tr, th{
	border: 1px solid;
}
th{
	background-color: skyblue;
}

#userList{
	margin-top: 250px;
	margin-left: 600px;
}
</style>
</head>
<script type="text/javascript">
	function checkAll(bool) {
		var chk = document.getElementsByName("chk");
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = bool;
		}
	}
</script>
<body>
<jsp:include page="TeamLoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./TeamInfo.do">팀 정보</a>
  <a href="./TeamManageMent.do">팀원 관리</a>
  <a href="./CancelRes.do">예약 취소</a>
</nav>

<div id="userList">
<form action="./mutliDel.do" method="post">
	<table style="text-align: center;">
		<tr>
			<td><input type="checkbox" onclick="checkAll(this.checked)"></td>
			<th colspan="1">팀 회원들</th>
		<tr>
			<c:forEach items="${lists}" var="lists">
				<tr>
					<td><input type="checkbox" name="chk" value="${lists.member_id}"></td>
					<td>${lists.member_id}</td>
				</tr>
			</c:forEach>
	</table>
	<input type="submit" value="추방" style="width: 300px;">
</form>
</div>


</body>
</html>