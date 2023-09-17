<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>정보 수정</h3>
<form method="POST" enctype="multipart/form-data">
	<p><input type="password" name="currentPw" placeholder="현재 비밀번호"></p>
	<p><input type="password" name="newPw" placeholder="변경할 비밀번호"></p>
	<p>
		현재 파일 : ${dto.originalFileName }
		<a href="${cpath }/member/removeFile/${dto.storedFileName}/${dto.idx}"><input type="button" value="파일 삭제"></a>
	</p>
	<p><input type="file" name="upload"></p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>