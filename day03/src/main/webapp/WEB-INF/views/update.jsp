<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="hidden" name="idx" value="${dto.idx }"></p>
	<p><input type="text" name="title" value="${dto.title }"></p>
	<p><textarea name="content">${dto.content }</textarea></p>
	<p><input type="text" name="password" placeholder="패스워드 입력"></p>
	<P><input type="submit" value="수정"></P>
</form>
</body>
</html>