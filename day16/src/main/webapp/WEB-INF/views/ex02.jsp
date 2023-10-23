<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    

<h3>json 데이터 요청해서 화면에 출력하기</h3>

<div id="root">
	<table id="table">
		<thead>
			<tr>
				<th>주차장명</th>
				<th>주차장유형</th>
				<th>주차장구획수</th>
				<th>주차기본요금</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>

<script>
	async function parkingLoadHandler() {
		const url = '${cpath}/ajax/parking'
		const json = await fetch(url).then(resp => resp.json())
		console.log(json)
		console.log(json.body.items.item)
		
		const arr = json.body.items.item
		const tbody = document.querySelector('#table tbody')
		
		const columnName = ['pkNam', 'pkFm', 'pkCnt', 'tenMin', 'tponNum']
		arr.forEach(e => {
			const tr = document.createElement('tr')
			
			for(let i = 0; i < columnName.length; i++) {
				const td = document.createElement('td')
				td.innerHTML = e[colunmnName[i]] 
				tr.appendChild(td)
			}
			tbody.appendChild(tr)	
		})
	}
	window.addEventListener('DOMContentLoaded', parkingLoadHandler)
</script>

</body>
</html>