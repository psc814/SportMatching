<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<button onclick="goSocket('S','super')">ä�ù� �����ϱ�</button>

	<script type="text/javascript">
		function goSocket(gr_id, mem_id) {
			window
					.open(
							"./socketOpen.do?mem_id=" + mem_id + "&gr_id="
									+ gr_id,
							"�׷�ä��",
							"width = 460, height = 480, resizable = no, toolbar = no, menubar = no, location = no, fullscreen = no, left = 300, top = 50");
		}
	</script>
</body>
</html>