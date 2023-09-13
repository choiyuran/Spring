<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${not empty searchList }">
<h3>검색 결과</h3>

<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
		<th>내용</th>
	<tr>
	
<c:forEach var="row" items="${searchList }">
	<tr>
		<td>${row.idx }</td>
		<td>
			<a href="${cpath }/board/view/${row.idx}">${row.title }</a>
		</td>
		<td>${row.writer }</td>
		<td>${row.viewCount }</td>
		<td>${row.wdate }</td>
		<td>
			<c:if test="${fn:length(row.content) > 7 }">
				${fn:substring(row.content, 0, 10) }...
			</c:if>
			<c:if test="${fn:length(row.content) <= 7 }">
				${row.content }			
			</c:if>
			
		</td>
	</tr>
</c:forEach>
</table>
</c:if>


<c:if test="${empty searchList }">
<h3>게시판 목록</h3>
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
	<tr>
	
<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.idx }</td>
		<td>
			<a href="${cpath }/board/view/${row.idx}">${row.title }</a>
		</td>
		<td>${row.writer }</td>
		<td>${row.viewCount }</td>
	</tr>
</c:forEach>
</table>
</c:if>


<form method="POST">
	<p>
	<select name="type">
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="content">글내용</option>
	</select>
	<input type="search" name="keyword" placeholder="검색어를 입력하세요">
	<input type="submit" value="검색">
	</p>
</form>

<p>
	<a href="${cpath }/board/write"><button>글 쓰기</button></a>
</p>

</body>
</html>