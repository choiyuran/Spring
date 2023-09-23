<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<h3>리뷰 목록</h3>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td><a href="${cpath }/review/view/${dto.idx}">${dto.title }</a>
				<span>💾<span>
				</td>
				<td>${dto.account_userid }</td>
				<td>${dto.wdate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${cpath }/review/write"><button>리뷰 작성</button></a>
</div>
</body>
</html>