<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="./css/AdminMyPage.css">
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/AdminMyPage.js"></script>
<body>
	<jsp:include page="AdminLoginHeader.jsp"/>
	<nav style="text-align: center; background-color: red; height: 50px; vertical-align: center;">
		<input type="button" value="일정 등록 & 삭제" onclick="toRegisterPage()">
		<input type="button" value="예약신청목록" onclick="toReservation()">
		<input type="button" value="취소신청목록" onclick="toCancel()">
		<input type="button" value="비밀번호 변경" onclick="changePw()">
		<input type="button" value="내 구장 조회">
	</nav>	
	<div id="tableDiv">
		<table id="resultTable">
			<tr class="result">
				<th class="result">구장코드</th>
				<th class="result">구장명</th>
				<th class="result">삭제</th>
			</tr>
			<c:forEach var="list" items="${stadiumLists}" begin="${page}" end="${page+9}">
				<tr class="result">
					<td class="result">${list.stadium_code}</td>
					<td class="result"><a href="./main.do?stadium_code=${list.stadium_code}">${list.stadium_name}</a></td>
					<td class="result"><input type="button" class="btn btn-link btn-sm" value="삭제하기" onclick="deleteStadium('${list.stadium_code}')"></td>
				</tr>
			</c:forEach>
		</table>
		<table id="pagingTable">
			<tr>
				<c:choose>
					<c:when test="${page > 1}">
						<td><a href="./selectMyStadium.do?page=1">◁◁</a></td>
						<td><a href="./selectMyStadium.do?page=${page-1}">◁</a></td>
						<td><a href="./selectMyStadium.do?page=${page-2}">${page-2}</a></td>
						<td><a href="./selectMyStadium.do?page=${page-1}">${page-1}</a></td>
					</c:when>
					<c:otherwise>
						<td>◁◁</td>
						<td>◁</td>
					</c:otherwise>
				</c:choose>
				<td><a>${page}</a></td>
				<td><a href="./selectMyStadium.do?page=${page+1}">${page+1}</a></td>
				<td><a href="./selectMyStadium.do?page=${page+2}">${page+2}</a></td>
				<td><a href="./selectMyStadium.do?page=${page+1}">▷</a></td>
				<td><a href="./selectMyStadium.do?page=">▷▷</a></td>
			</tr>
		</table>
		<script type="text/javascript">
			
		</script>
	</div>
</body>
</html>
















