<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="title" value="${dto.title }"></p>
	<p><input type="text" name="channel" value="${dto.channel }"></p>
	<p><input type="text" name="thumbnail" value="${dto.thumbnail }"></p>
	<p><input type="submit" value="수정"></p>
</form>
</body>
</html>