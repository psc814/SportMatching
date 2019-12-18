<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar cal = Calendar.getInstance();
	String clickedDate;
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);
	if (strYear != null) {
		year = Integer.parseInt(strYear);
		month = Integer.parseInt(strMonth);
	} else {
	}
	//년도/월 셋팅
	cal.set(year, month, 1);
	int startDay = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	//오늘 날짜 저장.

	Calendar todayCal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 예약취소 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<style TYPE="text/css">
body {
	scrollbar-face-color: #F6F6F6;
	scrollbar-highlight-color: #bbbbbb;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-shadow-color: #bbbbbb;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #bbbbbb;
	margin-left: "0px";
	margin-right: "0px";
	margin-top: "0px";
	margin-bottom: "0px";
}

td {
	font-family: "돋움";
	font-size: 9pt;
	color: #595959;
}

th {
	font-family: "돋움";
	font-size: 9pt;
	color: #000000;
}

select {
	font-family: "돋움";
	font-size: 9pt;
	color: #595959;
}

.divDotText {
	overflow: hidden;
	text-overflow: ellipsis;
}

 A:link {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:visited {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:active {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:hover {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
} 
</style>

<script type="text/javascript">
function toRegisterPage() {
	location.href ="./AdminRegisterSchedulePage.do";
}
function toReservation() {
	location.href ="./AdminReservation.do";
}
function toCancel() {
	location.href ="./AdminCancel.do";
}
</script>
<body>
	<jsp:include page="header.jsp" />
 	<nav style="text-align: center; background-color: #333; height: 50px;">
		<input type="button" value="일정 등록 & 삭제" onclick="toRegisterPage()">
		<input type="button" value="예약신청목록" onclick="toReservation()">
		<input type="button" value="취소신청목록" onclick="toCancel()">
	</nav> 
	<div style="width: 712px; margin: auto; text-align: center; font-size: 40px;">예약취소목록</div>
	<div id="calendarDiv" style="width: 712px; margin: auto;">
		<form name="calendarFrm" id="calendarFrm" action="" method="post">
			<DIV id="content" style="width: 712px; text-align: center;">
				<table width="100%" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td align="right">
							<input type="button" onclick="javascript:location.href='<c:url value='/AdminReservation.do' />'" value="오늘" />
						</td>
					</tr>
				</table>
				<!--날짜 네비게이션  -->
				<table width="100%" border="0" cellspacing="1" cellpadding="1" id="KOO" bgcolor="#F3F9D7" style="border: 1px solid #CED99C">
					<tr>
						<td height="60">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="10"></td>
								</tr>
								<tr style="text-align: center; font-size: 20px;">
									<td>
										<a href="<c:url value='/AdminReservation.do' />?year=<%=year - 1%>&amp;month=<%=month%>" target="_self">
											<b>&lt;&lt;</b>
											<!-- 이전해 -->
										</a>
										<%
											if (month > 0) {
										%>
										<a href="<c:url value='/AdminReservation.do' />?year=<%=year%>&amp;month=<%=month - 1%>" target="_self">
											<b>&lt;</b>
											<!-- 이전달 -->
										</a>
										<%
											} else {
										%>
										<b>&lt;</b>
										<%
											}
										%>
										&nbsp;&nbsp;
										<%=year%>년
										<%=month + 1%>월 &nbsp;&nbsp;
										<%
											if (month < 11) {
										%>
										<a href="<c:url value='/AdminReservation.do' />?year=<%=year%>&amp;month=<%=month + 1%>" target="_self">
											<!-- 다음달 -->
											<b>&gt;</b>
										</a>
										<%
											} else {
										%>
										<b>&gt;</b>
										<%
											}
										%>
										<a href="<c:url value='/AdminReservation.do' />?year=<%=year + 1%>&amp;month=<%=month%>" target="_self">
											<!-- 다음해 -->
											<b>&gt;&gt;</b>
										</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<br>
				<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
					<THEAD>
						<TR bgcolor="#CECECE">
							<TD width='100px'>
								<DIV align="center">
									<font color="red">일</font>
								</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">월</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">화</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">수</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">목</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">금</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">
									<font color="#529dbc">토</font>
								</DIV>
							</TD>
						</TR>
					</THEAD>
					<TBODY>
						<TR>
							<%
								//처음 빈공란 표시
								for (int index = 1; index < start; index++) {
									out.println("<TD >&nbsp;</TD>");
									newLine++;
								}
								for (int index = 1; index <= endDay; index++) {
									String color = "";
									if (newLine == 0) {
										color = "RED";
									} else if (newLine == 6) {
										color = "#529dbc";
									} else {
										color = "BLACK";
									} ;
									String sUseDate = Integer.toString(year);
									sUseDate += Integer.toString(month + 1).length() == 1
											? "0" + Integer.toString(month + 1)
											: Integer.toString(month + 1);
									sUseDate += Integer.toString(index).length() == 1
											? "0" + Integer.toString(index)
											: Integer.toString(index);
									int iUseDate = Integer.parseInt(sUseDate);
									clickedDate = Integer.toString(iUseDate);
									String backColor = "#EFEFEF";
									if (iUseDate == intToday) {
										backColor = "#c9c9c9";
									}
									out.println("<TD class='clickedDate' align='center' height='92px' bgcolor='" + backColor + "' nowrap>");
							%>
							<font color='<%=color%>' style="font-size: 30px;" name='<%=clickedDate%>>'><%=index%></font>

							<%
								out.println("<br>");
									out.println("<span class='datespan' style='display:none;'>" + clickedDate + "</span>");
									out.println("</TD>");
									newLine++;
									if (newLine == 7) {
										out.println("</TR>");
										if (index <= endDay) {
											out.println("<TR>");
										}
										newLine = 0;
									}
								}
								//마지막 공란 LOOP
								while (newLine > 0 && newLine < 7) {
									out.println("<TD>&nbsp;</TD>");
									newLine++;
								}
							%>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</form>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	$(".clickedDate").click(function() {
		var game_date_val = $(this).children('.datespan').text();
		var temp = "<table id='timetable' width='712px'>";
		temp+="<tr align='center' bgcolor='#00ffcc'>";
		temp+="<td>예약번호</td>";
		temp+="<td>홈팀</td>";
		temp+="<td>어웨이팀</td>";
		temp+="<td>경기날짜</td>";
		temp+="<td>승인여부</td>";
		temp+="</tr>";
		$.ajax({
			url : "showRequestCancel.do?game_date="+game_date_val,
			type : "post",
			success: function(data) {
				$("#timetable").remove();
				if(data == ""){
					temp+="<tr><td colspan='5' align='center'>조회된 일정이 없습니다.</td></tr>";
					temp+="</table>";
					$("#calendarDiv").append(temp);
				}else{
					$.each(data, function(i, elt) {
						temp += "<tr align='center' bgcolor='#9999ff'>";
						temp += "<td>"+elt.schedule_id+"</td>";
						if(elt.home_team == null){
							temp += "<td>등록된 팀 없음</td>";
						}else{
							temp += "<td>"+elt.home_team+"</td>";
						}
						if(elt.away_team == null){
							temp += "<td>등록된 팀 없음</td>";
						}else{
							temp += "<td>"+elt.away_team+"</td>";
						}
						temp += "<td>"+elt.game_date+"</td>";
						temp += "<td><button onclick='approval(\""+elt.schedule_id+"\",\""+elt.home_cancel+"\",\""+elt.away_cancel+"\")'>취소승인</button>"
						temp +="<button onclick='deny(\""+elt.schedule_id+"\",\""+elt.home_cancel+"\",\""+elt.away_cancel+"\")'>취소거절</button></td>"
						temp += "</tr>";
					});
					temp += "</table>"
					$("#calendarDiv").append(temp);
				}
			},
			error:function(request,status,error){
		        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
		     }
		});
	});
});

function approval(schedule_id,home, away) {
	 $.ajax({
		url : "confirmCancel.do?schedule_id="+schedule_id+"&home_cancel="+home+"&away_cancel="+away,
		type: "post",
		success: function(data) {
			if(data==true){
				alert("승인완료!");
			}else {
				alert("승인오류!");
			}
		},
		error : function(){
			  alert("데이터를 불러올수 없습니다."); // 실패 시 처리
		}
	});
};

function deny(schedule_id, home, away) {
	 $.ajax({
		url : "denyCancel.do?schedule_id="+schedule_id+"&home_cancel="+home+"&away_cancel="+away,
		type: "post",
		success: function(data) {
			if(data==true){
				alert("거절완료!");
			}else {
				alert("거절오류!");
			}
		},
		error : function(){
			  alert("데이터를 불러올수 없습니다."); // 실패 시 처리
		}
	});
};
</script>
</html>