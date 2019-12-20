
function chg(val){
// 		alert(val.value);
		var sel = document.getElementById("searchbar");
		if(val.value == "stadium"){
// 			$("#searchbar").attr("palceholder", "");
			sel.setAttribute("placeholder", "구장명 혹은 지역(시군구)로 구장검색");
		}else if(val.value == "matching"){
			sel.setAttribute("placeholder", "팀명, 주활동지, 매칭스타일로 매칭카드 검색");			
		}else{
			sel.setAttribute("placeholder", "팀 뭐로 검색하더라;");			
		}
	}
function search(){
	var condition = $("#searchbar");
	var option = $("#searchoption");
//	alert(option.val());
	if(condition.val().trim() == "" || condition.val().trim() == null){
		condition.focus();
		alert("검색어를 입력하세요");
	}
	if(option.val() == "stadium"){
//		alert(option.val());
		$.ajax({
			type: "POST",
			url:"./stadiumSearch.do",
			data: "condition="+searchbar.value,
			async: true,
			success: function(msg){
				$("#tableCase").empty();
				var resultTable = "<table id='resultTable'>";
				resultTable += "<tr>";
				resultTable += "<th class='listNum'>번호</th>";
				resultTable += "<th class='listName'>구장명</th>";
				resultTable += "<th class='listAddress'>주소</th>";
				resultTable += "</tr>";
				$.each(msg.searchLists, function(i, lists){
					resultTable += "<tr>";
					resultTable += "<td class='listNum'>"+i+1+"</td>";
					resultTable += "<td class='listName'><a href='./main.do?stadium_code="+lists.stadium_code+"'>"+lists.stadium_name+"</a></td>";
					resultTable += "<td class='listAddress'>"+lists.address+"</td>";
					resultTable += "</tr>";
				})
				resultTable += "</table>";
				
				$("#tableCase").append(resultTable);
			},
			error: function(){
				
			}
		})	
	}else if(option.val() == "matching"){
//		alert(option.val());
		$.ajax({
			type: "POST",
			url:"./matchingSearch.do",
			data: "condition="+searchbar.value,
			async: true,
			success: function(msg){
				$("#tableCase").empty();
				$.each(msg.searchLists, function(i, lists){
					var temp = "<div class='cardCase'>";
					temp += "<input type='hidden' name='matching_number' value='"+lists.matching_number+"'>" ;
					temp += "<table class='matchingCardTable'>" ;
					temp += "<tr >";
					temp += "<th colspan='2'>"+lists.regist_team_id+"</th>";
					temp += "</tr>";
					temp += "<tr>" ;
					temp += "<td rowspan='3'>스탯</td>";
					temp += "</tr>";
					temp += "<tr> ";
					temp += "<td> ";
					temp += (lists.reservation_stadium == null)?"예약된 구장 없음":lists.reservation_stadium;
					temp += "</td>";
					temp += "</tr>";
					temp += "<tr> ";
					temp += "<td>"+lists.matching_style+"</td>";
					temp += "</tr>";
					temp += "<tr> ";
					temp += "<td colspan='2'>"+lists.regist_team_info+"</td>";
					temp += "</tr>";
					temp += "</table> ";
					temp += "<input type='button' value='신청' onclick='matchingApply()'> ";
					temp += "</div> " ;
					$("#tableCase").append(temp);
				})                                                                                             
			},
			error: function(){
				
			}
		})
	}else if(option.val() == "team"){
//		alert(option.val());
	}else{
//		alert("//?");
	}
}

function matchingApply(){
	var matching_number = $("input[name=matching_number]").val();
	alert(matching_number);
	window.open("./applyForm.do?matching_number="+matching_number, "매칭신청 등록화면", "width=500px, height=200px");
}
function applyMatching(){
	var matching_number = $("input[name=matching_number]").val();
	var applied_team_info = $("input[name=applied_team_info]").val();
	location.href="./matchingApply.do?matching_number="+matching_number+"&applied_team_info="+applied_team_info;
	self.close();
}
function close(){
	self.close();	
}















