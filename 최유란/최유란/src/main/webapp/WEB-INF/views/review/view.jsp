<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<table>
		<tr>
			<td>${dto.idx }. ${dto.title }</td>
			<td>${dto.account_userid }</td>
		</tr>
		<tr>
			<td colspan="2">
				<pre>${dto.content }</pre>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<img src="${cpath }/upload/${dto.fileName}" width="370">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div class="btn">
					<div>
						 <fmt:formatDate value="${dto.wdate }" pattern="yyyy-MM-dd a hh:mm"/> 
					</div>
					<div>
						<a href="${cpath }/review/list"><button>목록</button></a>
						<a href="${cpath }/review/delete/${dto.idx}"><button id="deleteBtn">삭제</button></a>	
					</div>
				 </div>
			</td>
		</tr>
	</table>
	
	
			
	
</div>
<script>
	const deleteBtn = document.getElementById('deleteBtn')
	const deleteHandler = function(event) {
		event.preventDefault()
		if('${dto.account_userid}' != '${login.userid}') {
			alert('본인 글만 삭제할 수 있습니다')
			return			
		}
		if(confirm('정말 삭제하시겠습니까?')) {
			location.href=event.target.parentNode.href
		}
	}
	deleteBtn.onclick = deleteHandler
</script>
</body>
</html>