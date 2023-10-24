<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="map" style="width: 700px; height: 550px;"></div> 

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a5f98cddb99a6595fc86122e8b7be5d&libraries=services"></script>
<script>
	async function handler() {
		const url = '${cpath}/ajax/camping_around'
		var mapX = '${mapX}'
	    var mapY = '${mapY}'
	   	console.log(mapX)
	   	console.log(mapY)
	   	
	    const json = await fetch(url + '?mapX=' + mapX + '&mapY=' + mapY).then(resp => resp.json());
		console.log(json)
		
		const item = json.body.items.item
		
		// 지도를 표시할 div 
		var container = document.getElementById('map'); 
		var options = { 
			center: new kakao.maps.LatLng(37.402707, 126.922044),	 // 지도의 중심좌표
			level: 6			// 지도의 확대 레벨
		};
	
		// 지도 생성
		var map = new kakao.maps.Map(container, options); 
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		
		var positions = {}
		item.forEach(addr => {
			const address = addr.addr1			// item에서 주소만 뽑기
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(address, function(result, status) {
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:100px;text-align:center;padding:6px 0;">' + address + '</div>'
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});  
		})
		
	
	}; 
	window.addEventListener('DOMContentLoaded', handler)
	
</script>

</body>
</html>