<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<script>
		alert('회원만 작성할 수 있습니다')
		location.href='${cpath}/account/login'
	</script>
</c:if>

<div id="main">
	<h3>리뷰 작성</h3>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="text" name="title" placeholder="제목" autofocus required></p>
		<p><textarea name="content" placeholder="내용을 입력하세요" cols="80" rows="20"></textarea></p>
		<p><input type="file" name="upload" required></p>
		<p><input type="submit" value="등록" required></p>
	</form>
</div>

</body>
</html>