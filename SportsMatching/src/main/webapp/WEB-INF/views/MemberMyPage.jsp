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

#userInfo{
	margin-left: 660px;
	margin-top: 200px;
}

#delbtn{
	margin-top: 30px;
	margin-left: 710px;
}

</style>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<script type="text/javascript">
	function withdraw(){
		var withdraw = confirm("정말로 탈퇴하시겠습니까?")
		if(withdraw){
			alert("탈퇴되었습니다");
			location.href = "./withdraw.do";
		}else{
			alert("취소되었습니다")
		}
	}
	
	function delTeam(data){
		var delTeam = confirm("정말로 소속팀을 탈퇴하시겠습니까?")
		if(delTeam){
			alert("탈퇴되었습니다");
			location.href = "./delTeam.do?team_id="+data;
		}else{
			alert("취소되었습니다")
		}		
	}
	
	function addTeam(){
		location.href="./addTeam.do";
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
<div id="userInfo">	
	<table>
		<tr>
			<th>회원아이디:</th>
			<td>${btdto[0].member_id}</td>
		</tr>
		<c:forEach items="${btdto}" var="bt">
			<tr>
				<td colspan="2">소속팀 :&nbsp;${bt.team_id} <input type="button" value="탈퇴" onclick="delTeam('${bt.team_id}')"></td>
			</tr>
		</c:forEach>	
		<c:if test="${btdto[2] eq null}">
			 <td colspan="2">팀을 가입해주세요 <input type="button" value="추가" onclick="addTeam('${bt.team_id}')"></td>
		</c:if>
	</table>
</div>
	<div id="delbtn">
		<input type="button" value="회원탈퇴" onclick="withdraw()">
	</div>
</body>
</html>