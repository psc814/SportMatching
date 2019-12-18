<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 게시판</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	margin: auto;
	margin-top: 20px;
}
</style>
</head>
<script type="text/javascript" src="./js/Board.js"></script>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h2>게시물 목록</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th>제 목</th>
			<th>닉네임</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty MBL}">
				<tr>
					<td colspan="8">-------- 등록된 글이 없습니다 --------</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="lists" items="${MBL}" begin="${start}" end="${end}">
					<tr>
						<th>${lists.member_board_seq}</th>
						<th><a href="./memberBoardDetailPage.do?seq=${lists.member_board_seq}">${lists.board_title}</a></th>
						<th>${lists.member_id}</th>
						<th>${lists.regdate}</th>
						<th>${lists.replucount}</th>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>
	</table>
	
	<div class="center">
		<ul class="pagination">
			<li><a href="#" onclick="pageFirst()">&laquo;</a></li>
			<li><a href="#" onclick="pagePre()">&lsaquo;</a></li>	
			<c:forEach var="i" begin="" end="">
				<li><a href="#" onclick="pageIndex()"></a></li>
			</c:forEach>
			<li><a href="#" onclick="pageNext()">&rsaquo;</a></li>
			<li><a href="#" onclick="pageLast()">&raquo;</a></li>
			
		</ul>
	</div>


	<div>
		<input type="button" value="글쓰기" onclick="memberBoardWrite()">
	</div>
</body>
</html>