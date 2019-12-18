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
	<h2>글수정</h2>
	<form action="./memberBoardModify.do" method="post">
		<div>
			<table>
				<tr>
					<th>닉네임</th>
					<td>${MmFyDto.member_id}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td><input type="text" name="title"
						value="${MmFyDto.board_title}"></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${MmFyDto.regdate}</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea rows="10" cols="40" name="content">${MmFyDto.board_content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="수정완료"> 
						<input type="reset" value="초기화"> 
						<input type="button" oncancel="memberBoardModifyCancel()" value="취소">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>