<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>
	<div>${dto.movieTag }</div>
	
	<div>
		${dto.title } | ${dto.channel }
	</div>
	
	<div align="right">
		<button id="deleteBtn">삭제</button>
		<a href="${cpath }/update/${dto.idx }"><button>수정</button></a>
	</div>
	<div>
		조회수 : ${dto.viewCount }
	</div>
</div>
<script>
	const deleteBtn = document.getElementById('deleteBtn')
	
	function deleteHandler() {
		const idx = '${dto.idx}'
		const flag = confirm('정말 삭제 하시겠습니까?')
		
		if(flag) {
			location.href='${cpath}/delete/${dto.idx}'
		}
	}
	deleteBtn.addEventListener('click', deleteHandler)
</script>


</body>
</html>