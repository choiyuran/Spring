<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="number" name="idx" placeholder="idx"></p>
	<p><input type="text" name="title" placeholder="title"></p>
	<p><input type="text" name="channel" placeholder="channel"></p>
	<p><input type="text" name="thumbnail" placeholder="thumbnail"></p>
	<p><textarea name="movieTag" placeholder="movieTag"></textarea></p>
	<p><input type="submit" value="추가"></p>
</form>
</body>
</html>