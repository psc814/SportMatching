<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색페이지</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="./css/SearchPage.css">
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
<script type="text/javascript" src="./js/SearchPage.js"></script>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<body>
<jsp:include page="LoginHeader.jsp"/>
<nav style="text-align: center;" class="navbar">
  <a href="./MemberMyPage.do">마이페이지</a>
  <a href="./TeamPage.do">팀페이지</a>
  <a href="./MakeTeam.do">팀 창설</a>
  <a href="./AnswerBoard.do">게시판</a>
</nav> 
	<div id="userMainContainer">
		<div id="searchbox">
			<select id="searchoption" onchange="chg(this)">
				<option value="stadium" id="stadium">구장검색</option>
				<option value="matching" id="matching">매칭카드 검색</option>
				<option value="team" id="team">팀 검색</option>
			</select>
			<input type="text" id="searchbar" placeholder="구장명 혹은 지역(시군구)로 구장검색">
			<button id="btnSearch" class="btn btn-link" onclick="search()">검색</button>
		</div>
		<div id="searchResult">
			<div id="tableCase">
				<table id="resultTable">
					<tr>
						<th colspan="2">팀명</th>
					</tr>
					<tr>
						<td colspan="2">주활동지</td>
					</tr>
					<tr>
						<td rowspan="3">스탯</td>
						<td>구장</td>
					</tr>
					<tr>
						<td>경기방식</td>
					</tr>
					<tr>
						<td>팀 소개</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>









