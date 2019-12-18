
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
	var option = $("#searchoption");
	var condition = $("#searchbar");
	if(condition.val().trim() == "" || condition.val().trim() == null){
		condition.focus();
		alert("검색어를 입력하세요");
	}else if(option.val() == stadium){
		$.ajax({
			type: "POST",
			url:"./stadiumSearch.do",
			data: "condition="+searchbar.value,
			async: true,
			success: function(msg){
				$("#tableCase").append("<table id='resultTable'>");
				$("#tableCase").append("<tr>");
				$("#tableCase").append("<th class='listNum'>번호</th>");
				$("#tableCase").append("<th class='listName'>구장명</th>");
				$("#tableCase").append("<th class='listAddress'>주소</th>");
				$("#tableCase").append("</tr>");
				$.each(msg.searchLists, function(i, lists){
					$("#tableCase").append("<tr>");
					$("#tableCase").append("<td class='listNum'>"+i+"</td>");
					$("#tableCase").append("<td class='listName'><a href='./main.do?stadium_code="+lists.stadium_code+"'>"+lists.stadium_name+"</a></td>");
					$("#tableCase").append("<td class='listAddress'>"+lists.address+"</td>");
					$("#tableCase").append("</tr>");
				})
				$("#tableCase").append("</table>");
			},
			error: function(){
				
			}
		})	
	}else if(option == matching){
		$.ajax({
			type: "POST",
			url:"./matchingSearch.do",
			data: "condition="+searchbar.value,
			async: true,
			success: function(msg){
				$("#tableCase").append("<table id='resultTable'>");
				$("#tableCase").append("<tr>");
				$("#tableCase").append("<th class='listNum'>"+lists.team_id+"</th>");
				$("#tableCase").append("</tr>");
				$("#tableCase").append("<tr>");
				$("#tableCase").append("<td class='listNum'>"+lists.playground+"</td>");
				$("#tableCase").append("</tr>");
				$("#tableCase").append("<tr>");
				$("#tableCase").append("<th class='listNum'>"+lists.playground+"</th>");
				$("#tableCase").append("</tr>");
				$("#tableCase").append("<th class='listName'>구장명</th>");
				$("#tableCase").append("<th class='listAddress'>주소</th>");
				$.each(msg.searchLists, function(i, lists){
					$("#tableCase").append("<tr>");
					$("#tableCase").append("<td class='listNum'>"+i+"</td>");
					$("#tableCase").append("<td class='listName'><a href='./main.do?stadium_code="+lists.stadium_code+"'>"+lists.stadium_name+"</a></td>");
					$("#tableCase").append("<td class='listAddress'>"+lists.address+"</td>");
					$("#tableCase").append("</tr>");
				})
				$("#tableCase").append("</table>");
			},
			error: function(){
				
			}
		})
	}else if(option == team){
		
	}else{
		
	}
		
	
}
