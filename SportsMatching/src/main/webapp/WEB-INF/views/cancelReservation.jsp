<%@page import="org.springframework.ui.Model"%>
<%@page import="com.sports.matching.dtos.ScheduleDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 취소 페이지</title>
<%
	List<ScheduleDto> scLists = (List<ScheduleDto>) request.getAttribute("scLists");
%>
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

.navbar a:hover {
	background-color: red;
}
</style>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
	<jsp:include page="TeamLoginHeader.jsp" />
	<nav style="text-align: center;" class="navbar">
		<a href="./TeamInfo.do?team_id=">팀 정보</a>
		<a href="./TeamManageMent.do">팀원 관리</a>
		<a href="./CancelRes.do">예약 취소</a>
	</nav>
	<div>
		<table style="width: 712px; margin: auto; margin-top: 30px; text-align: center;">
			<tr style="background-color: skyblue;">
				<td>번호</td>
				<td>구장</td>
				<td>경기일자</td>
				<td>홈팀</td>
				<td>어웨이팀</td>
				<td>취소</td>
			</tr>
			<%
				for (ScheduleDto s : scLists) {
			%>
			<tr>
				<td><%=s.getSchedule_id()%></td>
				<td><%=s.getStadium_code()%></td>
				<td><%=s.getGame_date().substring(2, 16)%></td>
				<td><%=s.getHome_team()==null?"없음":s.getHome_team()%></td>
				<td><%=s.getAway_team()==null?"없음":s.getAway_team()%></td>
				<td>
					<%
						if (s.getHome_reservation() != null) {
								if (s.getHome_reservation().equals("Y")) {
					%>
					<button onclick="homecancel(<%=s.getSchedule_id()%>)">홈 취소신청</button>
					<%
						}
							}
					%>
					<%
						if (s.getAway_reservation() != null) {
								if (s.getHome_reservation().equals("Y")) {
					%>
					<button onclick="awaycancel(<%=s.getSchedule_id()%>)">어웨이 취소신청</button>
					<%
						}
							}
					%>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
<script type="text/javascript">
function homecancel(schedule_id) {
	$.ajax({
		url : "homecancel.do?schedule_id="+schedule_id,
		type : "post",
		success: function(data) {
			if(data){
				alert("취소신청완료");
			}else{
				alert("취소실패");
			}
		},
		error: function() {
			alert("데이터를 가져올 수 없습니다.")
		}
	});
}
function awaycancel(schedule_id) {
	$.ajax({
		url : "awaycancel.do?schedule_id="+schedule_id,
		type : "post",
		success: function(data) {
			if(data){
				alert("취소신청완료");
			}else{
				alert("취소실패");
			}
		},
		error: function() {
			alert("데이터를 가져올 수 없습니다.")
		}
	});
}
</script>
</html>