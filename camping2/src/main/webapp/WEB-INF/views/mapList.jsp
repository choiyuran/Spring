<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div style="margin: auto; width: 1200px;">
	지역
	<div style="display:flex">
		<form style="margin-bottom: 10px;" action="${cpath }/mapList">
			<select id="firstSelect" name="firstSelect" onchange="changeSecondOptions()">
				<option value="전체">전체</option>
				<option value="서울시">서울시</option>
				<option value="부산시">부산시</option>
				<option value="대구시">대구시</option>
				<option value="인천시">인천시</option>
				<option value="광주시">광주시</option>
				<option value="대전시">대전시</option>
				<option value="울산시">울산시</option>
				<option value="세종시">세종시</option>
				<option value="경기도">경기도</option>
				<option value="강원도">강원도</option>
				<option value="충청북도">충청북도</option>
				<option value="충청남도">충청남도</option>
				<option value="전라북도">전라북도</option>
				<option value="전라남도">전라남도</option>
				<option value="경상북도">경상북도</option>
				<option value="경상남도">경상남도</option>
				<option value="제주도">제주도</option>
			</select>
			
			<select id="secondSelect" name="secondSelect"></select>

			<select id="details" name="details">
				<option value="전체">전체테마</option>
				<option value="해변">해변</option>
				<option value="섬">섬</option>
				<option value="산">산</option>
				<option value="숲">숲</option>
				<option value="계곡">계곡</option>
				<option value="강">강</option>
				<option value="호수">호수</option>
				<option value="도심">도심</option>
			</select>
			<br>
			<input type="search" name="keyword"> 
			<input type="submit" value="캠핑장 검색">
		</form>
	</div>
</div>

<div style="width:860px; margin:auto;">
	<a href="${cpath }/searchList?page=${page}&firstSelect=${param.get('firstSelect')}&secondSelect=${param.get('secondSelect')}
					&details=${param.get('details')}&keyword=${param.get('keyword')}" id="aLink"><button type="button"
					class="btn btn-primary" style="margin-left:800px; width: 160px;">리스트로 보기</button></a>
</div>
					
<div style="display: flex; height: 700px; width: 1200px; margin: auto; margin-top: 50px;">
	
	<div id="map" style="width: 860px; height: 700px;"></div>

	<div style="overflow-y: auto; background-color: #fafbfe;">
		<c:if test="${empty list }">
			검색 결과가 없습니다
		</c:if>

		<c:if test="${not empty list }">
			<c:forEach var="row" items="${list}">
				<ul class="ul"
					style="list-style: none; padding-left: 0; height: 120px; width: 300px; border-bottom: 1px solid grey; margin: 0; padding: 15px;">
					<c:set var="address" value="${fn:split(row.addr1, ' ') }" />
					<li>[${address[0]} ${address[1]}] ${row.facltnm }</li>
					<li class="addr" data-addr="${row.addr1 }">${row.addr1 }</li>
					<li>${row.tel }</li>
				</ul>
			</c:forEach>

			<!-- 페이징 -->
			<div class="paging"
				style="display: flex; height: 30px; width: 300px;">
				<div
					style="border-right: 1px solid black; padding: 3px; width: 100px;">
					<c:if test="${empty param }">
						<a href="${cpath }/mapList/${paging.page - 1}" class="pagingA">
							PREV </a>
					</c:if>
					<c:if test="${not empty param }">
						<a href="${cpath }/mapList?page=${paging.page - 1}&firstSelect=${param.get('firstSelect')}&secondSelect=${param.get('secondSelect')}
					&details=${param.get('details')}&keyword=${param.get('keyword')}" class="pagingA">
							PREV </a>
					</c:if>
				</div>
				<div style="border-right: 1px solid black; padding: 3px; width: 100px;">
					<c:if test="${empty param }">
						<a href="${cpath }/mapList/${i}" class="pagingA">
						 <c:choose>
							<c:when test="${paging.page > 0}">
								<c:choose>
									<c:when test="${paging.page >= paging.pageCount}">
			                ${paging.pageCount}
			            </c:when>
							<c:otherwise>
			                ${paging.page}
			            </c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
				        1
				    </c:otherwise>
						</c:choose>
					</a>
					</c:if>
					
					<c:if test="${not empty param }">
						<a href="${cpath }/mapList?page=${i}&firstSelect=${param.get('firstSelect')}&secondSelect=${param.get('secondSelect')}
					&details=${param.get('details')}&keyword=${param.get('keyword')}" class="pagingA">
						 <c:choose>
							<c:when test="${paging.page > 0}">
								<c:choose>
									<c:when test="${paging.page >= paging.pageCount}">
			                ${paging.pageCount}
			            </c:when>
							<c:otherwise>
			                ${paging.page}
			            </c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
				        1
				    </c:otherwise>
						</c:choose>
					</a>
					</c:if>
				</div>
				
				<div style="padding: 3px; width: 100px;">
					<c:if test="${empty param }">
						<a href="${cpath }/mapList/${paging.page + 1}" class="pagingA">
							NEXT </a>
					</c:if>
					<c:if test="${not empty param }">
						<a href="${cpath }/mapList?page=${paging.page + 1}&firstSelect=${param.get('firstSelect')}&secondSelect=${param.get('secondSelect')}
					&details=${param.get('details')}&keyword=${param.get('keyword')}" class="pagingA">
							NEXT </a>
					</c:if>
				</div>
				<br>
				<br>
			</div>
		</c:if>
	</div>
</div>
<!-- 	<div class="paging"> -->
<%-- 		<c:if test="${paging.prev }"> --%>
<%-- 			<a href="${cpath }/mapList/${paging.begin - 10}" class="pagingA"> < </a> --%>
<%-- 		</c:if> --%>

<%-- 		<c:forEach var="i" begin="${paging.begin }" end="${paging.end }"> --%>
<%-- 			<a href="${cpath }/mapList/${i}" class="pagingA"> --%>
<%-- 			${paging.page == i ? '<b>' : '' } --%>
<%-- 				[${i }]${paging.page == i ? '</b>' : '' }</a> --%>
<%-- 		</c:forEach> --%>

<%-- 		<c:if test="${paging.next }"> --%>
<%-- 			<a href="${cpath }/mapList/${paging.end + 1}" class="pagingA"> > </a> --%>
<%-- 		</c:if> --%>
<!-- 		<br><br> -->
<!-- 	</div> -->



<!-- 지도 -->
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a5f98cddb99a6595fc86122e8b7be5d&libraries=services"></script>
<script>
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 12 // 지도의 확대 레벨
	};  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	var rows = document.querySelectorAll('.ul')			
	rows.forEach(row => {
		var firstValue = row.querySelector('li:first-of-type').textContent;	 
		var addressValue = row.querySelector('li:nth-of-type(2)').textContent;		// 주소
		var telValue = row.querySelector('li:last-of-type').textContent;			// 문의처
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(addressValue, function(result, status) {
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		     	// 마커 위에 표시할 인포윈도우를 생성합니다
		        var iwContent = '<div style="text-align:center; width: 250px; height: fit-content; border-radius: 10px;">' 
		        			+'<ul style="list-style:none; padding-left:0;">' + 
		        			'<li>' + firstValue + '</li>' + 
		        			'<li>' + telValue + '</li>' + 
		        			'</ul>' +   
		        			'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		        	iwRemoveable = true; 		// removeable 속성을 ture로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시 
		        // 인포윈도우를 생성합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content : iwContent,
		            removable : iwRemoveable
		        });
		        
		     	// 마커에 클릭 이벤트를 등록합니다
		        kakao.maps.event.addListener(marker, 'click', function() {
		          // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
		            infowindow.open(map, marker);
		        });
		   		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		     } 
		});   
		

		var infowindow = new kakao.maps.InfoWindow(); // 전역으로 InfoWindow 선언
		rows.forEach(row => {
			row.addEventListener('click', function() {
				 if (infowindow !== null) {
				        infowindow.close();
				 }
				var firstValue = row.querySelector('li:first-of-type').textContent;	 
				var addressValue = row.querySelector('li:nth-of-type(2)').textContent;
				var telValue = row.querySelector('li:last-of-type').textContent;
			
				geocoder.addressSearch(addressValue, function(result, status) {
					if(status == kakao.maps.services.Status.OK) {
						var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
						
						// 지도 중심을 이동 시킵니다
		 			    map.setCenter(coords);
		 			    map.setLevel(9);		// 지도 확대
		 			    
		 			   var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
		 			    
		 				// 마커 위에 표시할 인포윈도우를 생성합니다
		 		        var iwContent = '<div style="text-align:center; width: 250px; height: fit-content; border-radius: 10px;">' 
		 		        			+'<ul style="list-style:none; padding-left:0;">' + 
		 		        			'<li>' + firstValue + '</li>' + 
		 		        			'<li>' + telValue + '</li>' + 
		 		        			'</ul>' +   
		 		        			'</div>' // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		 		      		
		 			    // 인포윈도우를 생성합니다
				       	infowindow = new kakao.maps.InfoWindow({
				            map: map,
				        	content : iwContent,
				            position: coords
				        });
					    infowindow.open(map, marker);
					}
				})
			})
		})
	})
</script>

<!-- 옵션 적용 -->
<script>
	window.onload = function() {
	    // 기본값으로 '전체'를 선택하도록 함
	    var firstSelect = document.getElementById('firstSelect');
	    firstSelect.value = '전체';
	    
	    // '전체'를 선택했을 때 두 번째 셀렉트 박스가 채워지도록 호출
	    changeSecondOptions();
	}


	function changeSecondOptions() {
	    var firstSelect = document.getElementById('firstSelect');
	    var secondSelect = document.getElementById('secondSelect');
	    var selectedValue = firstSelect.value;
	
	    // 비우고 새로운 목록 추가
	    secondSelect.innerHTML = '';
		if (selectedValue == '전체') {
			var allOptions = ["전체"]
			fillSecondOptions(allOptions);
		}
		else if (selectedValue == '서울시') {
	        var seoulOptions = ["전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구",
	        	"동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
	        fillSecondOptions(seoulOptions);
	    } else if (selectedValue == '부산시') {
	        var busanOptions = ["전체", "강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구",
	        	"서구", "수영구", "연제구", "영도구", "중구", "해운대구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '대구시') {
	        var busanOptions = ["전체", "남구", "달서구", "달성군", "동구", "북구", "상주", "서구", "수성구", "중구", "군위구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '인천시') {
	        var busanOptions = ["전체", "강화군", "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "웅진군", "중구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '광주시') {
	        var busanOptions = ["전체", "광산구", "남구", "동구", " 북구", "서구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '대전시') {
	        var busanOptions = ["전체", "대덕구", "동구", "서구", "유성구", "중구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '울산시') {
	        var busanOptions = ["전체", "남구", "동구", "북구", "울주군", "중구"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '세종시') {
	        var busanOptions = ["전체", "금남면", "세종시", "소정면", "연서면", "전동면"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '경기도') {
	        var busanOptions = ["전체", "가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시",
	        	"동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시",
	        	"용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '강원도') {
	        var busanOptions = ["전체", "강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시",
	        	"인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "흥천군", "화천군", "횡성군"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '충청북도') {
	        var busanOptions = ["전체", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군",
	        	"청원군", "청주시", "충주시"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '충청남도') {
	        var busanOptions = ["전체", "계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군",
	        	"아산시", "예산군", "천안시", "청양군", "태안군", "홍성군"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '전라북도') {
	        var busanOptions = ["전체", "고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시",
	        	"임실군", "장수군", "전주시", "정읍시", "진안군"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '전라남도') {
	        var busanOptions = ["전체", "강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군",
	        	"보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"];
	        fillSecondOptions(busanOptions);
	    
		} else if (selectedValue == '경상북도') {
	        var busanOptions = ["전체", "경산시", "경주시", "고령군", "구미시", "김천시", "문경시", "봉화군", "상주시", "성주군",
	        	"안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군", "포항시"];
	        fillSecondOptions(busanOptions);
	    
		} else if(selectedValue == '경상남도') {
	        var busanOptions = ["전체", "서귀포시", "제주시"];
	        fillSecondOptions(busanOptions);
	    }
		
	}
	
	function fillSecondOptions(options) {
	    var secondSelect = document.getElementById('secondSelect');
	
	    options.forEach(function(option) {
	        var opt = document.createElement('option');
	        opt.textContent = option;
	        opt.value = option;
	        secondSelect.appendChild(opt);
	    });
	}
</script>

</body>
</html>