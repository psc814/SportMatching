function deleteStadium(code){
	var stadium_code = code;
	alert(stadium_code);
	$("#tableDiv").empty();
	var temp = "<h2>계정정보 확인</h2>";
	temp += "<div id='loginDiv'>";
	temp += "<form action='./loginCheck.do' method='get'>";
	temp += "<input type='text' name='admin_id' placeholder='아이디 입력'><br>";
	temp += "<input type='text' name='admin_pw' placeholder='비밀번호 입력'>";
	temp += "<input type='hidden' name='stadium_code' value='"+stadium_code+"'>";
	temp += "<input type='submit' value='로그인'>";
	temp += "</form>";
	temp += "</div>";
	$("#tableDiv").append(temp);
}






