<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="root">
	<table id="table">
		<thead>
			<tr>
				<th>대표이미지(firstImageUrl)</th>
				<th>야영장명(facltNm)</th>
				<th>사업자번호(bizrno)</th>
				<th>특징(featureNm)</th>
				<th>주변이용가능시설(posblFcltyCl)</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
<script>
	async function handler() {
		const url = '${cpath}/ajax/camping'
		const json = await fetch(url).then(resp => resp.json())
		console.log(json)
		
		const columnName = ['firstImageUrl','facltNm','bizrno','featureNm','posblFcltyCl']
		const tbody = document.querySelector('tbody')
		
		const item = json.body.items.item
		
		item.forEach(e => {
			const tr = document.createElement('tr')
			columnName.forEach(c => {
				const td = document.createElement('td')
				td.innerText = e[c]
				if(c == 'firstImageUrl') {
					td.innerHTML = '<img src="' + e.firstImageUrl + '"width="200">'
				}
				c++
				tr.appendChild(td)
			})
			tbody.appendChild(tr)
		})
		
	}
	window.addEventListener('DOMContentLoaded', handler)
</script>

</body>
</html>