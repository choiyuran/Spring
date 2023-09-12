<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>삭제 패스워드 확인</h3>
<form method="POST">
	<p><input type="hidden" name="idx" value="${dto.idx }"></p>
	<p><input type="text" name="password" placeholder="패스워드 확인"></p>
	<p><input type="submit" value="삭제"></p>
</form>

</body>
</html>