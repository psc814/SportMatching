<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 비밀번호 변경</title>
</head>
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
function changePw() {
	location.href ="./changePw.do";
}
function modifyPW(){
	var pw = document.getElementById("insertPassword").value;
	location.href ="./modifyPW.do?insertPassword="+pw;
}
</script>
<body>
<jsp:include page="AdminLoginHeader.jsp"/>
	<nav style="text-align: center; background-color: red; height: 50px; vertical-align: center;">
		<input type="button" value="일정 등록 & 삭제" onclick="toRegisterPage()">
		<input type="button" value="예약신청목록" onclick="toReservation()">
		<input type="button" value="취소신청목록" onclick="toCancel()">
		<input type="button" value="비밀번호 변경" onclick="changePw()">
	</nav>


<table>
	<tr>
		<th>아이디</th>
		<td>${sadto}</td>
	</tr>
	<tr>
		<th>변경할 비밀번호</th>
		<td><input type="text" id="insertPassword" value=""></td><td><input type="button" value="수정" onclick="modifyPW()"></td>
	</tr>
</table>
</body>
</html>