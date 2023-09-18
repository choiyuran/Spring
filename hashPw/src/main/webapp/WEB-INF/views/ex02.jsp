<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>로그인</h3>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" autofocus required></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="submit" value="로그인"></p>
</form>
</body>
</html>