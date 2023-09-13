<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>글 수정</h3>

<form method="POST">
	<p><input type="text" name="title" value="${dto.title }"></p>
	<p><textarea name="content">${dto.content }</textarea></p>
	<p><input type="password" name="password" placeholder="비밀번호 확인"></p>
	<p><input type="submit" value="수정"></p>
</form>
</body>
</html>