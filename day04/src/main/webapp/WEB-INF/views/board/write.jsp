<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<h1>새 글 등록</h1>

<form method="POST">
	<p><input type="text" name="title" placeholder="title" autofocus required></p>
	<p><input type="text" name="writer" placeholder="writer" required></p>
	<p><input type="password" name="password" placeholder="password" required></p>
	<p><textarea name="content" placeholder="내용을 입력해주세요" required></textarea></p>
	<p><input type="submit" value="등록"></p>
</form>
</body>
</html>