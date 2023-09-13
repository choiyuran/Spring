<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>단일 조회</h3>

<table>
	<tr>
		<th>글번호</th>
		<td>${dto.idx }</td>
		
		<th>제목</th>
		<td>${dto.title }</td>
	</tr>
	
	<tr>
		<th>작성자</th>
		<td>${dto.writer }</td>
	
		<th>조회수</th>
		<td>${dto.viewCount }</td>
	
	</tr>

	<tr>
		<th>작성일</th>
		<td colspan="3">
			<fmt:formatDate value="${dto.wdate }" pattern="yyyy-MM-dd a hh:mm" />
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td colspan="3">${dto.content }</td>
	</tr>
</table>

<p>
	<a href="${cpath }/board/update/${dto.idx}"><button>수정</button></a>
	<button id="deleteBtn">삭제</button>
</p>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	
	function deleteHandler() {
		const idx = '${dto.idx}'
		const flag = confirm('정말 삭제하시겠습니까?')
		
		if(flag) {
			location.href='${cpath}/board/delete/' + idx
		}
	}
	deleteBtn.addEventListener('click', deleteHandler)
</script>
</body>
</html>