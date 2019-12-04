<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<button onclick="goSocket('S','super')">체팅방 입장하기 그룹(S오일):사용자(super)</button> 
<button onclick="goSocket('S','high')">체팅방 입장하기 그룹(S오일):사용자(high)</button> 
<button onclick="goSocket('H','super')">체팅방 입장하기 그룹(HiWay):사용자(super)</button> 
<button onclick="goSocket('H','top')">체팅방 입장하기 그룹(HiWay):사용자(top)</button> 

<script type="text/javascript">
function goSocket(gr_id,mem_id){
			window.open("./socketOpen.do?mem_id="+mem_id+"&gr_id="+gr_id, "그룹채팅", "width = 460, height = 480, resizable = no, toolbar = no, menubar = no, location = no, fullscreen = no, left = 300, top = 50");
	}

</script>
</body>
</html>