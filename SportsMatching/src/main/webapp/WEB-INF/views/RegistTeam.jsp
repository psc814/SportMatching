<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 창설</title>
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
<script type="text/javascript">
	function idChk() {
	    var id = document.getElementById("team_id").value;
	    if (id==""||id==null) {
	       var id = document.getElementById("team_id").focus();
	       alert("값을 입력해 주세요");
	    }else {         
	    var url ="./idchk.do?team_id="+id;
	    var title ="아이디 중복검사";
	    var prop ="width=500px, height =500px";
	    open(url,title,prop);
	    }
	 }
	
	 function idConfirm() {
	      var obj = document.getElementsByName("team_id")[0].title;
	      if (obj == "idchk") {
	         alert("아이디 중복검사를 먼저 실행해주세요");
	         obj.focus();
	      }
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
<form action="./Regist.do" method="post">
<div id="regiForm">
<table>
	<tr>
		<th>팀 아이디</th>
		<td>
			<input type="text" title="idchk" name="team_id" id="team_id">
			<input type="button" value="중복체크" onclick="idChk()">
		</td>
	</tr>
	<tr>
		<th>팀 비밀번호</th>
		<td>
			<input type="password" name="team_pw" onclick="idConfirm()">
		</td>
	</tr>
	<tr>
		<th>주장 아이디</th>
		<td>
			 <input type="text" name="captain_id" required="required">
		</td>
	</tr>
	<tr>
		<th>주장 핸드폰 번호</th>
		<td>
			 <input type="text" name="captain_phone_number" required="required">
		</td>
	</tr>
	<tr>
		<th>주 활동지</th>
		<td>
			 <input type="text" name="playground" required="required">
		</td>
	</tr>
	<tr>
		<th>비밀번호 질문</th>
		<td>
			<select id="pwQuestion"" name="question" onchange="chageLangSelect()">
				<option value="" selected disabled>질문을 선택해주세요</option>              
				<option value="기억에 남는 추억의 장소는">기억에 남는 추억의 장소는?</option>
				<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
				<option value="자신의 보물 제1호는?">자신의 보물 제1호는?</option>
				<option value="자신이 존경하는 인물은?">자신이 존경하는 인물은?</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>비밀번호 답변</th>
		<td>
			 <input type="text" name="answer" required="required">
		</td>
	</tr>
	
</table>
</div>
	<div style="text-align: center;">
		<input type="submit" value="회원가입">
		<input type="button" value="취소" onclick="location.href='./SearchPage.do'">
	</div>
</form>
</body>
</html>