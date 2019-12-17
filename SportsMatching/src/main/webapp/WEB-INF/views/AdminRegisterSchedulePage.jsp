<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
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
<title>관리자 일정 등록 페이지</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javaScript" language="javascript"></script>
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

s
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
	<nav style="text-align: center; background-color: red; height: 50px; vertical-align: center;">
		<input type="button" value="일정 등록 & 삭제" onclick="toRegisterPage()">
		<input type="button" value="예약신청목록" onclick="toReservation()">
		<input type="button" value="취소신청목록" onclick="toCancel()">
	</nav>
	<div style="width: 712px; margin: auto; text-align: center; font-size: 40px;">일정 등록 & 삭제</div>
	<div id="calendarDiv" style="width: 712px; margin: auto;">
		<form name="calendarFrm" id="calendarFrm" action="" method="post">
			<DIV id="content" style="width: 712px; text-align: center;">
				<table width="100%" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td align="right">
							<input type="button" onclick="javascript:location.href='<c:url value='/AdminRegisterSchedulePage.do' />'" value="오늘" />
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
										<a href="<c:url value='/AdminRegisterSchedulePage.do' />?year=<%=year - 1%>&amp;month=<%=month%>" target="_self">
											<b>&lt;&lt;</b>
											<!-- 이전해 -->
										</a>
										<%
											if (month > 0) {
										%>
										<a href="<c:url value='/AdminRegisterSchedulePage.do' />?year=<%=year%>&amp;month=<%=month - 1%>" target="_self">
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
										<a href="<c:url value='/AdminRegisterSchedulePage.do' />?year=<%=year%>&amp;month=<%=month + 1%>" target="_self">
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
										<a href="<c:url value='/AdminRegisterSchedulePage.do' />?year=<%=year + 1%>&amp;month=<%=month%>" target="_self">
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
		$("#timetable").remove();
		$("#buttonDiv").remove();
		$("#tablecolor").remove();
		var game_date_val = $(this).children('.datespan').text();
		var temp = "<table id='timetable' width='712px' margin='auto'><caption>등록할 시간선택("+game_date_val+")</caption>";
		temp +="<tr><td colspan ='6' align='center'><input type='checkbox' name='checkAll' value='dd'>모두선택</td></tr>";
		temp += "<tr>"
		$.ajax({
			url : "showSchedule.do?game_date="+game_date_val,
			type : "post",
			success : function(data){
				var timeData= new Array(23);
				for(var i = 0; i < 23;i++){
					timeData[i] ="999";
				}
				$.each(data, function(i, elt) {
					timeData[elt.game_date*1] = elt.game_date*1;
				});
				for(var i = 0; i < 24;i++){
					if(i % 6 == 0){
						temp+="</tr>";
						if(timeData[i] == i){
							temp +="<tr><label for ='a'><td bgcolor ='#ff99cc' align='center' hegith='30px'><input id='a' type='checkbox' name='checkOne' value='"+i+"'><label for='labelCheckBox'>"+i+"시</td>"
						}else{
							temp +="<tr><td bgcolor ='#99ff99' align='center' hegith='30px'><input type='checkbox' name='checkOne' value='"+i+"'><label for='labelCheckBox'>"+i+"시</td>"	
						}
					}else{
						if(timeData[i] == i){
							temp +="<td bgcolor ='#ff99cc' align='center' hegith='30px'><input   type='checkbox' name='checkOne' value='"+i+"'><label for='labelCheckBox'>"+i+"시</td>"
						}else{
							temp +="<td bgcolor ='#99ff99' align='center' hegith='30px'><input   type='checkbox' name='checkOne' value='"+i+"'><label for='labelCheckBox'>"+i+"시</td>"	
						}
					}
				};
				temp += "</tr>";
				temp += "</table>";
				temp += "<div id='tablecolor' align='right'><span style='background-color:#ff99cc'>　</span><span>:등록</span><span style='background-color:#99ff99'>　</span><span>:미등록</span></div>"
				temp += "<div id='buttonDiv' align='center'>"
				temp += "<input id='registerSC' type='button' value='구장 일정 등록' width='350px'>"
				temp += "<input id='deleteSC' type='button' value='구장 일정 삭제' width='350px'>"
				temp += "</div>"
				$("#calendarDiv").append(temp);
				$("[name=checkAll]").click(function(){
					allCheckFunc(this);
				});
				$("[name=checkOne]").each(function(){
					$(this).click(function(){
						oneCheckFunc($(this));
					});
				});
				$("#registerSC").click(function() {
					var selectedTime = 999;
					$("input:checkbox[name='checkOne']").each(function() {
						if($(this).is(":checked")){
							selectedTime += ","+ $(this).val();	
						}
					});
					if(selectedTime == 999){
						alert("등록하실 시간을 선택하여 주세요!");
					}else{
						$.ajax({
							url : "registSchedule.do?game_date="+game_date_val+"&time="+selectedTime,
							type : "post",
							success : function(data){
								if(data){
									alert("일정 등록 완료!");
									location.href = "./AdminRegisterSchedulePage.do";
								}else{
									alert("일정 등록에 뭔가 문제가 있습니다.");
									location.href = "./AdminRegisterSchedulePage.do";
								}
							},
							error:function(request,status,error){
						        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
						    }
						});
					};
				});
				$("#deleteSC").click(function() {
					var selectedTime = 999;
					$("input:checkbox[name='checkOne']").each(function() {
						if($(this).is(":checked")){
							selectedTime += ","+ $(this).val();	
						}
					});
					if(selectedTime == 999){
						alert("삭제하실 시간을 선택하여 주세요!");
					}else{
						$.ajax({
							url : "deleteSchedule.do?game_date="+game_date_val+"&time="+selectedTime,
							type : "post",
							success : function(data){
								if(data){
									alert("일정 삭제 완료!");
									location.href = "./AdminRegisterSchedulePage.do";
								}else{
									alert("일정 삭제에 뭔가 문제가 있습니다.");
									location.href = "./AdminRegisterSchedulePage.do";
								}
							},
							error:function(request,status,error){
						        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
						    }
						});
					};
					alert(selectedTime);
				});
			},
			error:function(request,status,error){
		        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
		    }
		});
		function allCheckFunc(obj) {
			$("[name=checkOne]").prop("checked", $(obj).prop("checked") );
		}
		function oneCheckFunc(obj){
			var allObj = $("[name=checkAll]");
			var objName = $(obj).attr("name");
			if( $(obj).prop("checked") ){
				checkBoxLength = $("[name="+ objName +"]").length;
				checkedLength = $("[name="+ objName +"]:checked").length;
				if( checkBoxLength == checkedLength ) {
					allObj.prop("checked", true);
				} else {
					allObj.prop("checked", false);
				}
			}
			else{
				allObj.prop("checked", false);
			}
		};
	});
});
</script>
</html>