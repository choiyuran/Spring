<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01 - 부산광역시_콘서트 목록 서비스</h3>
<div id="result"></div>


<script>
	async function handler() {
		let url = 'https://apis.data.go.kr/6260000/BusanCultureConcertService/getBusanCultureConcert'
		const params = {
				'pageNo' : '1',
				'numOfRows' : '1000',
				'resultType' : 'json',
				'serviceKey' : 'VK%2FIrbQeozR6bw%2BzxsN%2FJL0VtbE0J9imnS7at3NjHjV2FYprJ1xBqc2X6JVHe2OHTlzA8gDcbDrxMf4seJyu0Q%3D%3D'
		}
		url += '?'
		for(let key in params) {
			url += key + '=' + params[key] + '&'
		}
		const result = await fetch(url).then(resp => resp.json())
		console.log(result.getBusanCultureConcert.item)			// result만 출력해서 원하는 데이터가 어디 있는지 체크
		const arr = result.getBusanCultureConcert.item
		
		// Array.filter(), Array.sort(), Array.map(), Array.forEach()
		// 총 23개인데 내가 쓰고 싶은거 3개 빼고 다 버린다 배열로 반환 -> Array.map()
		// 총 23개 중에 3개만 가져온다 -> Array.filter()
		const searchData = arr.filter(e => e.title.includes('싸이'))
		console.log(searchData)
		
		const resultDiv = document.getElementById('result')
		searchData.forEach(e => {
			const div = document.createElement('div') 
			div.innerText = e.title + '/' + e.op_st_dt + ' ~ ' + e.op_ed_dt
			resultDiv.appendChild(div)			// resultDiv의 자식요소로써 맨 마지막에 div를 추가한다
			
		})
	}

	window.addEventListener('DOMContentLoaded', handler)
</script>

</body>
</html>