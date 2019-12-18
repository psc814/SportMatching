<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>게시글 상세 조회</h2>
	<div>
		<table>
			<tr>
				<th>닉네임</th>
				<td>${MDetail.member_id}</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>${MDetail.board_title}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${MDetail.regdate}</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="40" name="content" readonly="readonly">${MDetail.board_content}</textarea></td>
			</tr>
		</table>
		<div class="but">
			<form action="MemberDetailButton" id="MemberDetailButton">
				<input type="button" name="but" value="글수정" id="memberBoardModifyPage">
				<input type="button" name="but" value="글삭제" id="memberBoardDelPage">
				<input type="button" name="but" value="답글&nbsp;&nbsp;&nbsp;" id="memberBoardReply">				
			</form>
		</div>
	</div>
</body>
</html>