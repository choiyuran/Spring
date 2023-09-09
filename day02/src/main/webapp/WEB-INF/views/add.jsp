<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>유튜브 영상 추가하기</h3>
	<form method="POST">
		<p><input type="number" name="idx" placeholder="idx" required autofocus></p>
		<p><input type="text" name="title" placeholder="title" required></p>
		<p><input type="text" name="channel" placeholder="channel" required></p>
		<p><input type="number" name="viewCount" placeholder="viewCount" required></p>
		<p><input type="text" name="thumbnail" placeholder="thumbnail" required></p>
		<p><textarea name="movieTag" placeholder="movieTag" required></textarea></p>
		<p><input type="submit"></p>
	</form>
</div>
</body>
</html>