<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="title" required autofocus></p>
	<p><input type="file" name="upload"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>