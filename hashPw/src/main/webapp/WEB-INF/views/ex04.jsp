<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>비밀번호 변경</h3>
<form method="POST">
	<p><input type="password" name="currentPw" placeholder="현재 비밀번호" autofocus required></p>
	<p><input type="password" name="newPw" placeholder="변경할 비밀번호" required></p>
	<p><input type="submit" value="변경"></p>
</form>
</body>
</html>