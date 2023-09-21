<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<h3>로그인</h3>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" autofocus required></p>
		<p><input type="text" name="userpw" placeholder="PW" required></p>
		<p><input type="submit" value="로그인"></p>
	</form>
	<p><a href="${cpath }/member/join">회원가입</a></p> 
</div>
</body>
</html>