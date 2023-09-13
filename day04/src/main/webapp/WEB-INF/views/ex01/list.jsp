<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>list.jsp - 아티스트 목록</h1>
<hr>

<c:forEach var="dto" items="${list }">
	<p>
		${dto.id } | 
		<a href="${cpath }/ex01/view?id=${dto.id }">${dto.name }</a> | 				<!-- pathVariable 방식은 보통 계층형 구조에서 사용 -->

	</p>
</c:forEach>

</body>
</html>