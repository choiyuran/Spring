<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:forEach var="row" items="${list }">
	<div>
		<a class="link" data-addr="${row.addr1 }" data-facltnm="${row.facltnm }">
			${row.facltnm }
			${row.addr1 }
		</a>		
	</div>
</c:forEach>

<div id="map" style="width: 700px; height: 550px;"></div> 
	
	
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a5f98cddb99a6595fc86122e8b7be5d&libraries=services"></script>
	<script>
	
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };  
	
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		var links = document.querySelectorAll('.link')
		
		
		links.forEach(function(link) {
			link.addEventListener('click', function() {
				var addr = link.getAttribute('data-addr')
				var facltnm = link.getAttribute('data-facltnm')
				console.log(addr)
	
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr, function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				
				     	// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
				        var iwContent = '<div style="padding:5px; text-align:center;">' + facltnm + '</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

				        // 인포윈도우를 생성합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content : iwContent
				        });
				     	// 마커에 마우스오버 이벤트를 등록합니다
				        kakao.maps.event.addListener(marker, 'mouseover', function() {
				          // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
				            infowindow.open(map, marker);
				        });

				        // 마커에 마우스아웃 이벤트를 등록합니다
				        kakao.maps.event.addListener(marker, 'mouseout', function() {
				            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
				            infowindow.close();
				        });
				
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
			});
		});
	</script>


</body>
</html>