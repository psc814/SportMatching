<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<link type="text/css" rel="stylesheet" href="./css/userMain.css">
<link type="text/css" rel="stylesheet" href="./css/bootstrap.css">
</head>
<script type="text/javascript" src="./js/UserMain.js"></script>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<body>
<jsp:include page="header.jsp"/>
	<div id="userMainContainer">
		<div id="searchbox">
			<select id="searchoption" onchange="chg(this)">
				<option value="stadium" id="stadium">구장검색</option>
				<option value="matching" id="matching">매칭카드 검색</option>
				<option value="team" id="team">팀 검색</option>
			</select>
			<input type="text" id="searchbar" placeholder="구장뭐로검색하더라;">
			<button id="btnSearch" class="btn btn-link" onclick="search()">검색</button>
		</div>
	</div>
</body>
</html>