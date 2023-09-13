<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script>
	const row = '${row}' 
	if(row != 0) {
		alert('정상적으로 처리하였습니다')
		location.href='${cpath}/board'
	}
	else {
		alert('패스워드를 다시 확인해주세요')
		history.go(-1)
	}
		
</script>

</body>
</html>