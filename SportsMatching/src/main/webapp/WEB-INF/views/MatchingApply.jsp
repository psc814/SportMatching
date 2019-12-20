<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭신청 등록화면</title>
</head>
<script type="text/javascript" src="./js/SearchPage.js"></script>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<body>

<input type="hidden" value="${matching_number}" name="matching_number">
신청팀 : <input type="text" value="${tdto}" name="applied_team_id" readonly="readonly"><br>
팀정보 : <input type="text" placeholder="팀 정보를 입력하세요" name="applied_team_info"><br>
<button onclick="applyMatching()">작성완료</button>
</body>
</html>