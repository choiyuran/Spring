<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<h3>ex01.jsp</h3>

<div id="root">
	<canvas id="myChart"></canvas>
</div>

<script>
	const arr = [				// openAPI를 이용하여 JSON데이터를 받아온 후 처리할 수도 있다
		{username: "홍길동", score: 85},
		{username: "이순신", score: 92},
		{username: "유관순", score: 78},
		{username: "강감찬", score: 96},
		{username: "정몽주", score: 88},
	]
	// canvas 태그 불러오기
	const context = document.getElementById('myChart')
	
	const data = {
			labels: arr.map(e => e.username),			// 이름만 추출
			datasets: [
				{
					label: '점수',
					data: arr.map(e => e.score),		// 점수만 추출
				}
			]
	}
	const config = {
			type: 'bar',			// 막대그래프(line : 꺾은선 그래프)
			data: data,				// 위에서 만든 데이터
			options = {}
	}
	const myChart = new Chart(context, config)	// 데이터와 설정을 이용하여 canvas
</script>


</body>
</html>