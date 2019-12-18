<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 게시판 글등록</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>멤버 게시판 글작성</h2>

	<div>
		<form action="./memberBoardWrite.do" method="post">
			<table>
				<tr>
					<th>닉네임</th>
					<td>${MbWDto.member_id}</td>
				</tr>
				<tr>
					<th>제   목</th>
					<td><input type="text" name="title">${MbWDto.board_title}</td>
				</tr>
				<tr>
					<th>내   용</th>
					<td><textarea rows="10" cols="40" name="content">${MbWDto.board_content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					<input type="submit" value="글작성"> 
					<input type="reset" value="내용 초기화"> 
					<input type="button" value="취소" onclick="m_WriteCancel()"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	function m_WriteCancel() {
// 		alert("글등록 취소");
		location.href = "./MemberBoardPage.do";
	}

</script>
</html>