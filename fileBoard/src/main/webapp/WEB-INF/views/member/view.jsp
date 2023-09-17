<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>${dto.idx }</td>
			<td>
				<a href="${cpath }/member/view/${dto.idx}">${dto.userid }</a>
			</td>
			<td>${dto.username }</td>
			<td>${dto.email }</td>
			<td>${dto.originalFileName }</td>
			
			<c:if test="${dto.originalFileName eq 'default.jpg' }">
				<td style="background-image: url('${cpath}/upload/${dto.originalFileName}');
							background-position: center;
							background-repeat: no-repeat;
							background-size: auto 100%;
							width: 130px;
							height: 130px;">	
				</td>
			</c:if>
			<c:if test="${dto.originalFileName ne 'default.jpg' }">
				<td style="background-image: url('${cpath}/upload/${dto.storedFileName}');
							background-position: center;
							background-repeat: no-repeat;
							background-size: auto 100%;
							width: 130px;
							height: 130px;">	
				</td>
			</c:if>
			
			<c:if test="${dto.originalFileName eq 'default.jpg' }">
				<td>
					<a href="${cpath }/upload/${dto.originalFileName}" download="${dto.originalFileName }"><button>다운로드</button></a>
				</td>
			</c:if>
			<c:if test="${dto.originalFileName ne 'default.jpg' }">
				<td>
					<a href="${cpath }/upload/${dto.storedFileName}" download="${dto.originalFileName }"><button>다운로드</button></a>
				</td>
			</c:if>
		</tr>

</table>

<p>
	<a href="${cpath }/member/update/${dto.idx}"><button>수정</button></a>
	<button id="deleteBtn">삭제</button>
</p>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	deleteBtn.onclick = function() {
		const flag = confirm('정말 삭제하시겠습니까?')
		if(flag) {
			location.href='${cpath}/member/delete/${dto.idx}/${dto.storedFileName}'
		}
	}
	

</script>
</body>
</html>