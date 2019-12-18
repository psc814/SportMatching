<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar cal = Calendar.getInstance();
	String clickedDate;
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);
	if (strYear != null) {
		year = Integer.parseInt(strYear);
		month = Integer.parseInt(strMonth);
	} else {
	}
	//년도/월 셋팅
	cal.set(year, month, 1);
	int startDay = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	//오늘 날짜 저장.

	Calendar todayCal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>

<html lang="ko">
<HEAD>
<TITLE>사용자 신청페이지</TITLE>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javaScript" language="javascript"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style TYPE="text/css">
body {
	scrollbar-face-color: #F6F6F6;
	scrollbar-highlight-color: #bbbbbb;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-shadow-color: #bbbbbb;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #bbbbbb;
	margin-left: "0px";
	margin-right: "0px";
	margin-top: "0px";
	margin-bottom: "0px";
}

td {
	font-family: "돋움";
	font-size: 9pt;
	color: #595959;
}

th {
	font-family: "돋움";
	font-size: 9pt;
	color: #000000;
}

select {
	font-family: "돋움";
	font-size: 9pt;
	color: #595959;
}

.divDotText {
	overflow: hidden;
	text-overflow: ellipsis;
}

A:link {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:visited {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:active {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}

A:hover {
	font-size: 9pt;
	font-family: "돋움";
	text-decoration: none;
}
</style>
</HEAD>

<BODY>
	<jsp:include page="header.jsp" />
	<div id="stadiumDiv" style="width: 700px; margin: auto; background-color: yellow">
		<table style="width: 700px;">
			<tr>
				<td>${dto.stadium_name}</td>
			</tr>
			<tr>
				<td>${dto.pdto.image1}</td>
				<td>${dto.pdto.image2}</td>
				<td>${dto.pdto.image3}</td>
			</tr>
		</table>
	</div>
	<div id="calendarDiv" style="width: 712px; margin: auto;">
		<form name="calendarFrm" id="calendarFrm" action="" method="post">
			<DIV id="content" style="width: 712px; text-align: center;">
				<table width="100%" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td align="right">
							<input type="button" onclick="javascript:location.href='<c:url value='/main.do' />'" value="오늘" />
						</td>
					</tr>
				</table>
				<!--날짜 네비게이션  -->
				<table width="100%" border="0" cellspacing="1" cellpadding="1" id="KOO" bgcolor="#F3F9D7" style="border: 1px solid #CED99C">
					<tr>
						<td height="60">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="10"></td>
								</tr>
								<tr style="text-align: center; font-size: 20px;">
									<td>
										<a href="<c:url value='/main.do' />?year=<%=year - 1%>&amp;month=<%=month%>" target="_self">
											<b>&lt;&lt;</b>
											<!-- 이전해 -->
										</a>
										<%
											if (month > 0) {
										%>
										<a href="<c:url value='/main.do' />?year=<%=year%>&amp;month=<%=month - 1%>" target="_self">
											<b>&lt;</b>
											<!-- 이전달 -->
										</a>
										<%
											} else {
										%>
										<b>&lt;</b>
										<%
											}
										%>
										&nbsp;&nbsp;
										<%=year%>년
										<%=month + 1%>월 &nbsp;&nbsp;
										<%
											if (month < 11) {
										%>
										<a href="<c:url value='/main.do' />?year=<%=year%>&amp;month=<%=month + 1%>" target="_self">
											<!-- 다음달 -->
											<b>&gt;</b>
										</a>
										<%
											} else {
										%>
										<b>&gt;</b>
										<%
											}
										%>
										<a href="<c:url value='/main.do' />?year=<%=year + 1%>&amp;month=<%=month%>" target="_self">
											<!-- 다음해 -->
											<b>&gt;&gt;</b>
										</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<br>
				<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
					<THEAD>
						<TR bgcolor="#CECECE">
							<TD width='100px'>
								<DIV align="center">
									<font color="red">일</font>
								</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">월</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">화</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">수</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">목</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">금</DIV>
							</TD>
							<TD width='100px'>
								<DIV align="center">
									<font color="#529dbc">토</font>
								</DIV>
							</TD>
						</TR>
					</THEAD>
					<TBODY>
						<TR>
							<%
								//처음 빈공란 표시
								for (int index = 1; index < start; index++) {
									out.println("<TD >&nbsp;</TD>");
									newLine++;
								}
								for (int index = 1; index <= endDay; index++) {
									String color = "";
									if (newLine == 0) {
										color = "RED";
									} else if (newLine == 6) {
										color = "#529dbc";
									} else {
										color = "BLACK";
									} ;
									String sUseDate = Integer.toString(year);
									sUseDate += Integer.toString(month + 1).length() == 1
											? "0" + Integer.toString(month + 1)
											: Integer.toString(month + 1);
									sUseDate += Integer.toString(index).length() == 1
											? "0" + Integer.toString(index)
											: Integer.toString(index);
									int iUseDate = Integer.parseInt(sUseDate);
									clickedDate = Integer.toString(iUseDate);
									String backColor = "#EFEFEF";
									if (iUseDate == intToday) {
										backColor = "#c9c9c9";
									}
									out.println("<TD class='clickedDate' align='center' height='92px' bgcolor='" + backColor + "' nowrap>");
							%>
							<font color='<%=color%>' style="font-size: 30px;" name='<%=clickedDate%>>'><%=index%></font>

							<%
								out.println("<br>");
								out.println("<span class='datespan' style='display:none;'>" + clickedDate + "</span>");
									out.println("</TD>");
									newLine++;
									if (newLine == 7) {
										out.println("</TR>");
										if (index <= endDay) {
											out.println("<TR>");
										}
										newLine = 0;
									}
								}
								//마지막 공란 LOOP
								while (newLine > 0 && newLine < 7) {
									out.println("<TD>&nbsp;</TD>");
									newLine++;
								}
							%>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<div>
				<input id="reserveButton" type="button" style="width: 350px; height: 52px;" value="예약하기">
				<input id="chatButton" type="button" style="width: 350px; height: 52px;" value="채팅하기">
			</div>
		</form>
	</div>
	<div class="map_wrap" style="width: 712px; margin: auto;">
		<div id="map" style="width: 712px; height: 450px; margin-top: 50px; margin: auto; overflow: hidden;"></div>
		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<div>
					<form onsubmit="searchPlaces(); return false;">
						검색어 :
						<input type="text" value="${dto.stadium_name}" id="keyword" size="15">
						<button type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul id="placesList"></ul>
			<div id="pagination"></div>
		</div>
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3a1c2bfb6e20541df7e13de6b410f730&libraries=services"></script>
	<script>
		// 마커를 담을 배열입니다
		var markers = [];

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		//장소 검색 서비스 객체를 생성한다.
		//지도 객체를 인자로 넣을경우, 검색에 필요한 옵션들 중 location 이 자동으로 현재 지도의 중심 좌표로 설정되어 검색을 시도한다.
		//필요에 따라서는 useMapBounds 옵션을 통해 현재 지도에 보여지는 영역을 자동 지정할 수 있다.
		var ps = new kakao.maps.services.Places();

		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		// 키워드로 장소를 검색합니다
		searchPlaces();

		// 키워드 검색을 요청하는 함수입니다
		function searchPlaces() {

			var keyword = document.getElementById('keyword').value;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				alert('키워드를 입력해주세요!');
				return false;
			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			ps.keywordSearch(keyword, placesSearchCB);
		}

		// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {
				// 정상적으로 검색이 완료됐으면 검색 목록과 마커를 표출합니다
				displayPlaces(data);
				// 페이지 번호를 표출합니다
				displayPagination(pagination);

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 결과가 존재하지 않습니다.');
				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		// 검색 결과 목록과 마커를 표출하는 함수입니다
		function displayPlaces(places) {

			var listEl = document.getElementById('placesList'), menuEl = document
					.getElementById('menu_wrap'), fragment = document
					.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

			// 검색 결과 목록에 추가된 항목들을 제거합니다
			removeAllChildNods(listEl);

			// 지도에 표시되고 있는 마커를 제거합니다
			removeMarker();
			for (var i = 0; i < places.length; i++) {

				// 마커를 생성하고 지도에 표시합니다
				var placePosition = new kakao.maps.LatLng(places[i].y,
						places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
						i, places[i]); // 검색 결과 항목 Element를 생성합니다
				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				bounds.extend(placePosition);
				// 마커와 검색결과 항목에 mouseover 했을때
				// 해당 장소에 인포윈도우에 장소명을 표시합니다
				// mouseout 했을 때는 인포윈도우를 닫습니다
				(function(marker, title) {
					kakao.maps.event.addListener(marker, 'click', function() {
						window.open("https://map.kakao.com/link/to/" + title
								+ "," + placePosition.getLat() + ","
								+ placePosition.getLng(), '_blank');
					});
					kakao.maps.event.addListener(marker, 'mouseover',
							function() {
								displayInfowindow(marker, title);
							});

					kakao.maps.event.addListener(marker, 'mouseout',
							function() {
								infowindow.close();
							});

					itemEl.onclick = function() {
						window.open("https://map.kakao.com/link/to/" + title
								+ "," + placePosition.getLat() + ","
								+ placePosition.getLng(), '_blank');
					};

					itemEl.onmouseover = function() {
						displayInfowindow(marker, title);
					};

					itemEl.onmouseout = function() {
						infowindow.close();
					};
				})(marker, places[i].place_name);

				fragment.appendChild(itemEl);
			}

			// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
			listEl.appendChild(fragment);
			menuEl.scrollTop = 0;

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			map.setBounds(bounds);
		}

		// 검색결과 항목을 Element로 반환하는 함수입니다
		function getListItem(index, places) {

			var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
					+ (index + 1)
					+ '"></span>'
					+ '<div class="info">'
					+ '   <h5>' + places.place_name + '</h5>';

			if (places.road_address_name) {
				itemStr += '    <span>' + places.road_address_name + '</span>'
						+ '   <span class="jibun gray">' + places.address_name
						+ '</span>';
			} else {
				itemStr += '    <span>' + places.address_name + '</span>';
			}

			itemStr += '  <span class="tel">' + places.phone + '</span>'
					+ '</div>';

			el.innerHTML = itemStr;
			el.className = 'item';

			return el;
		}

		// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
		function addMarker(position, idx, title) {
			var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
			imgOptions = {
				spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
				spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				offset : new kakao.maps.Point(13, 37)
			// 마커 좌표에 일치시킬 이미지 내에서의 좌표
			}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new kakao.maps.Marker({
				position : position, // 마커의 위치
				image : markerImage
			});

			marker.setMap(map); // 지도 위에 마커를 표출합니다
			markers.push(marker); // 배열에 생성된 마커를 추가합니다

			return marker;
		}

		// 지도 위에 표시되고 있는 마커를 모두 제거합니다
		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
		function displayPagination(pagination) {
			var paginationEl = document.getElementById('pagination'), fragment = document
					.createDocumentFragment(), i;

			// 기존에 추가된 페이지번호를 삭제합니다
			while (paginationEl.hasChildNodes()) {
				paginationEl.removeChild(paginationEl.lastChild);
			}

			for (i = 1; i <= pagination.last; i++) {
				var el = document.createElement('a');
				el.href = "#";
				el.innerHTML = i;

				if (i === pagination.current) {
					el.className = 'on';
				} else {
					el.onclick = (function(i) {
						return function() {
							pagination.gotoPage(i);
						}
					})(i);
				}

				fragment.appendChild(el);
			}
			paginationEl.appendChild(fragment);
		}
		// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
		// 인포윈도우에 장소명을 표시합니다
		function displayInfowindow(marker, title) {
			var content = '<div style="padding:5px;z-index:1;">' + title
					+ '</div>';

			infowindow.setContent(content);
			infowindow.open(map, marker);
		}

		// 검색결과 목록의 자식 Element를 제거하는 함수입니다
		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}
	</script>
</BODY>
<script type="text/javascript">
$(document).ready(function() {
	$(".clickedDate").click(function() {
		var game_date = $(this).children('.datespan').text();
		var temp = "<table id='timetable' width='712px'><caption>시간표 선택("+game_date.substr(0, 4)+"년 "+game_date.substr(4, 2)+"월 "+game_date.substr(6, 2)+"일)</caption>";
		$.ajax({
			url : "showSchedule.do?game_date="+game_date,
			type : "post",
			success: function(data) {
				if(data == ""){
					alert("선택한 날의 정보가 없습니다.");
				}else{
					$("#timetable").remove();
					$("#teamInfo").remove();
					$("#tableColor").remove();
					temp += "<tr>";
					$.each(data, function(i, elt) {
						if( i % 6 != 0){
							if(elt.home_team == null && elt.away_team == null){
								temp += "<td bgcolor='#66ff33' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>";	
							}else if(elt.home_team != null && elt.away_team != null){
								temp += "<td bgcolor='#ff0066' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>";
							}else {
								temp += "<td bgcolor='#ffff99' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>";
							}
						}else{
							temp +="</tr>";
							if(elt.home_team == null && elt.away_team == null){
								temp +="<tr><td bgcolor='#66ff33' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>"
							}else if(elt.home_team != null && elt.away_team != null){
								temp +="<tr><td bgcolor='#ff0066' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>"
							}else {
								temp +="<tr><td bgcolor='#ffff99' align='center' height ='40px'><input type='radio' name='time' value='"+game_date+elt.game_date+"'>"+elt.game_date+"시</td>"
							}
						}
					});
					temp +="</tr>";
					temp += "<div align='right' id='tableColor'><span style='background-color:#ff0066'>　</span><span> : 예약불가 </span>"
					temp += "<span style='background-color:#ffff99'>　</span><span> : 한 팀 예약가능 </span>"
					temp+= "<span style='background-color:#66ff33'>　</span><span> : 공석</span>"
					temp += "</div>"
					$("#calendarDiv").append(temp);
					$("input:radio[name=time]").click(function() {
						$("#teamInfo").remove();
						$.ajax({
							url : "selectSchedule.do?game_date="+$(this).val(),
							type: "post",
							success: function(selectedData) {
								tmp = "<table id='teamInfo' width='712px' border='1'><caption>예약한 팀 정보</caption>"
								tmp +="<tr bgcolor='#00ccff' align='center'><td>홈팀</td><td>어웨이팀</td></tr>";
								tmp += "<tr align='center'><td id='reservedHomeTeam'>"+selectedData.home_team+"</td>"
								tmp +="<td id='reservedAwayTeam'>"+selectedData.away_team+"</td></tr><table>";
								$("#calendarDiv").append(tmp);
							},
							error:function(request,status,error){
						        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
						     }
						})
					});
				}
			},
			error:function(request,status,error){
		        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
		     }
		});
	});
	
	
	$("#reserveButton").click(function() {
		var radioValue = $(":input:radio[name=time]:checked").val();
		if(radioValue == null){
			alert("날짜와 시간을 선택한 후 예약해주세요")
		}else{
			var year = radioValue.substr(0, 4);
			var month = radioValue.substr(4, 2);
			var day = radioValue.substr(6, 2);
			var hour = radioValue.substr(8,2);
			if(confirm(year+"년 "+month+"월 "+day+"일 "+hour+"시에 예약하시겠습니까?")){
					$.ajax({
						url : "reserve.do?game_date="+radioValue,
						type : "post",
						success: function(data) {
							alert(data);
						},
						error:function(request,status,error){
					        alert("데이터를 불러올수 없습니다."); // 실패 시 처리
					     }
					});
			}
		}
	});
	$("#chatButton").click(function() {
		location.href ="./chat.do";
	});
});

</script>
</HTML>
