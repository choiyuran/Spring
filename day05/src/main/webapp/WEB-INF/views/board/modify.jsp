<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty dto }">
	<form method="POST">
		<h3>게시글 수정(패스워드 입력)</h3>
		<p><input type="password" name="password" placeholder="글 작성시 입력한 패스워드" required autofocus></p>
		<p><input type="submit" value="수정하기"></p>
	</form>
</c:if>

<c:if test="${not empty dto }">
	<form method="POST" action="${cpath }/board/update/${dto.idx}">
		<p><input type="text" name="title" value="${dto.title }" required></p>
		<p><input type="text" name="writer" value="${dto.writer }" required></p>
		<p><textarea cols="22" rows="5" name="content" required>${dto.content }</textarea></p>
		<p><input type="submit" value="작성"></p>
	</form>
</c:if>

</body>
</html>