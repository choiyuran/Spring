<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01 - 단순 메일 보내기</h3>

<form method="POST">
	<p><input type="email" name="receiver" placeholder="받는 사람"></p>
	<p><textarea name="body" placeholder="내용"
					style="resize: none; width: 500px; height: 200px"></textarea></p>
	<p><input type="submit" value="보내기"></p>					
</form>

</body>
</html>