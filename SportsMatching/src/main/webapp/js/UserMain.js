
function chg(val){
// 		alert(val.value);
		var sel = document.getElementById("searchbar");
		if(val.value == "stadium"){
// 			$("#searchbar").attr("palceholder", "");
			sel.setAttribute("placeholder", "구장 뭐로 검색하더라;");
		}else if(val.value == "matching"){
			sel.setAttribute("placeholder", "매칭카드 뭐로 검색하더라;;");			
		}else{
			sel.setAttribute("placeholder", "팀 뭐로 검색하더라;");			
		}
	}
function search(){
	
	$.ajax({
		type: "POST",
		url:"./search.do",
		data: "id=zz",
		async: true,
		success: function(msg){
			alert(msg);
		},
		error: function(){
			
		}
	})
		
	
}
