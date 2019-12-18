<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	onload = function() {
		var id = opener.document.getElementById("team_id").value;
		document.getElementById("team_id").value=id;
	}
	
	function confirmChk(bool) {
		if(bool){
		opener.document.getElementsByName("team_pw")[0].focus();
		opener.document.getElementById("team_id").title = "y";			
		}else{
			opener.document.getElementById("team_id").value="";
			opener.document.getElementById("team_id").focus();
		}
		self.close();
	}
	
	function cancel() {
		opener.document.getElementById("team_id").value="";
		opener.document.getElementById("team_id").focus();
		self.close();
	}
</script>
<body>
${isc}
<table>
	<tr>
		<td>
			<input type="text" name="id" id="team_id" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${isc}">
				사용 가능
			</c:if>
			<c:if test="${!isc}">
				사용 불가
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="확인" onclick="confirmChk(${isc})">
			<input type="button" value="취소" onclick="cancel()">
		</td>
	</tr>
</table>
</body>
</html>