<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
<!-- 카카오 로그인  -->

<div style="width: 300px; height: 300px; float: left; margin-top:250px; margin-right: 300px; margin-left: 350px">
<div>
	<h1 style="margin-left: 50px;">일반회원</h1>
    <c:if test="${userId eq null}">
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=e97fb06ba1e8aa0fd2e1f2fdf51087d2&redirect_uri=http://localhost:8090/SportsMatching/login.do&response_type=code">
            <img src="./images/kakao_account_login_btn_medium_narrow.png">
        </a>
    </c:if>
 
</div>
<!-- 네이버 로그인  -->
<div style="margin-top: 30px;">
	<a href="${apiURL}"><img width="222" height="49" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
</div>
</div>

<div style="width: 300px; height: 300px; float: left; margin-top:250px;">
<table>
			<caption><h1>로그인</h1></caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="id" value="">
				</td>
			</tr>
			<tr>
			<tr>			
				<th>비밀번호</th>
				<td>
					<input type="password" id="pw" name="password" value="">
				</td>
			</tr>
			<tr>
				<th colspan="3">
					<input type="button" value="관리자 로그인" onclick="adminLogin()" style="margin-left: 50px;">
					<input type="button" value="팀 로그인" onclick="teamLogin()" style="margin-left: 10px;">
				</th>
			</tr>
		</table>
</div>
</body>
<script type="text/javascript">
	function adminLogin(){
		var id = document.getElementById("id").value;
		var pw = document.getElementById("pw").value;
		location.href = "./adminLogin.do?admin_id="+id+"&admin_pw="+pw;
	}
	function teamLogin(){
		var id = document.getElementById("id").value;
		var pw = document.getElementById("pw").value;
		location.href = "./teamLogin.do?team_id="+id+"&team_pw="+pw;
	}
</script>
</html>