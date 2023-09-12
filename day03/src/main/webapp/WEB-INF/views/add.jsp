<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>글 작성</h3>
<form method="POST">
	<p><input type="text" name="title" placeholder="title" required autofocus></p>
	<p><input type="text" name="writer" placeholder="writer" required></p>
	<p><input type="password" name="password" placeholder="password" required></p>
	<p><textarea name="content" placeholder="내용을 입력해주세요" required></textarea></p>
	<p><input type="submit" value="새 글 등록"></p>
</form>

</body>
</html>