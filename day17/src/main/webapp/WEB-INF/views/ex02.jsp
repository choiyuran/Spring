<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<div id="root">
	<canvas id="myChart"></canvas>
</div>

<script>
	async function handler() {
		let url = 'https://apis.data.go.kr/1741000/admmPpltnHhStus/selectAdmmPpltnHhStus'
		url += '?'
		const param = {
				serviceKey = 'VK%2FIrbQeozR6bw%2BzxsN%2FJL0VtbE0J9imnS7at3NjHjV2FYprJ1xBqc2X6JVHe2OHTlzA8gDcbDrxMf4seJyu0Q%3D%3D',
				admmCd : '2600000000',		// 행정구역코드
				srchFrYm: '202307',			// 조회시작년월. 2022.10부터 조회가능 
				srchToYm: '202309',			// 조회종료년월. 3개월 기간내 설정
				lv: '1',					// 광역시도 단위 : 1, 시군구 단위 : 2, 읍면동 단위 : 3, 읍면동 통반 단위: 4
				regSecd: '1',				// 등록구분. 전체:1, 거구자:2, 거주불명자:3, 재외국민:4(기본값 : 1)
				type: 'JSON'
				numOfRows: '10', 
				pageNo: '1',
		}
		for(let key in param) {
			url += key + '=' + param[key] + '&'
		}
		// 주소와 파라미터로 요청하여 결과를 json으로 받는다
		const result = await fetch(url).then(resp => resp.json())
		
		// 전체 응답 데이터에서 필요한 부분만 가져온다
		let arr = result.Response.items.item
		
		// 배열을 차트로 띄우기 전 보기 편한 형태로 정렬을 수행한다
		arr = arr.sort((a,b) => b.totNmprCnt - a.totNmprCnt)
		
		// canvas 태그 불러오기
		const context = document.getElementById('myChart')
		
		const data = {
			labels: arr.map(e => e.ctpvNm),		// 행정구역
			datasets: [
				{
					label: '전체',
					data: arr.map(e => e.totNmprCnt)
					backgroundColor: 'lime'				// '#00ff00'
				},
				{
					label: '남성',
					data: arr.map(e => e.maleNmprCnt),
					backgroundColor: 'blue'
				},
				{
					label: '여성'
					data: arr.map(e => e.femlNmprCnt),
					backgroundColor: 'red'
				},
			]
		}
		const config = {
			type: 'bar', 		// 막대그래프 (line: 꺾은선 그래프)
			data: data,			// 위에서 만든 데이터
			options: {}
		}
		const myChart - new Chart(context, config)
		// 데이터와 설정을 이용하여 canvas태그에 그림을 그리기
		
	}	// end of function handler()
	// DOM내용이 모두 로드 끝나면 handler를 실행하도록 한다
	window.addEventListener('DOMContentLoaded', handler)	
</script>

</body>
</html>