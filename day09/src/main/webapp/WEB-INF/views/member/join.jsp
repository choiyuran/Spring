<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<h3>회원가입</h3>		
	<form method="POST" >
		<p><input type="text" name="userid" placeholder="ID" autofocus required></p>
		<p><input type="password" name="userpw" placeholder="PW" required></p>
		<p><input type="text" name="username" placeholder="이름" required></p>
		<p><input type="email" name="email" placeholder="이메일" required></p>
		<p><input type="submit" value="가입신청"></p>
	</form>
</div>

</body>
</html>