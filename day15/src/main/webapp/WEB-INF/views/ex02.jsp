<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="root">
	<table id="dataList" border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>이미지</th>
				<th>이름</th>
				<th>주소</th>
				<th>위도</th>
				<th>경도</th>
				<th>좌석수</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
<script>
	async function getPlaceAPIHandler() {
		let url = 'https://apis.data.go.kr/6260000/BusanCulturePerformPlaceService/getBusanCulturePerformPlace'
		const params =  {
			'pageNo' : '1',
			'numOfRows' : '10',
			'resultType' : 'json',
			'serviceKey' : 'VK%2FIrbQeozR6bw%2BzxsN%2FJL0VtbE0J9imnS7at3NjHjV2FYprJ1xBqc2X6JVHe2OHTlzA8gDcbDrxMf4seJyu0Q%3D%3D'
		}
		url += '?'
		for(let key in params) {
			url += key + '=' + params[key] + '&'
		}
		const result = await fetch(url).then(resp => resp.json())
// 		console.log(result)
		
		const arr = result.getBusanCulturePerformPlace.item
		const tbody = document.querySelector('#dataList tbody')
		// 가져오고 싶은 필드(컬럼)의 이름을 배열로 미리 준비해두면 편리하다
		// attech, placeNm, addr, lngt, lttd, seatCnt
		
		const columnName = ['attech', 'placeNm', 'addr', 'lngt', 'lttd', 'seatCnt']
		arr.forEach(e => {
			const tr = document.createElement('tr')
			
			for(let i = 0; i < columnName.length; i++) {
				const td = document.createElement('td')
				
				td.innerText = e[columnName[i]] 
				if(i == 0) {
					td.innerHTML = '<img src="' + e.attech + '" width="200">'
				}
				tr.appendChild(td)
			}
			tbody.appendChild(tr)
		})
		
		
// 		let tag = ''
// 		arr.forEach(e => {
// 			tag += '<tr>'
// 			tag += '<td>' + '<img src="' + e.attech + '"><td>'
// 			tag += '<td>' + e.placeNm + '</td>'
// 			tag += '<td>' + e.addr + '</td>'
// 			tag += '<td>' + e.lttd + '</td>'
// 			tag += '<td>' + e.lngt + '</td>'
// 			tag += '<td>' + e.seatCnt + '</td>'
// 			tag += '</tr>'
			
// 		})
// 		tbody.innerHTML = tag
	}
	window.addEventListener('DOMContentLoaded', getPlaceAPIHandler)
</script>

</body>
</html>