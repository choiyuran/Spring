<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h1>home.jsp</h1>

<ul>
	<li><a href="${cpath }/test">test</a></li>
	<li><a href="${cpath }/list">camping</a></li>
</ul>


<c:forEach var="row" items="${list }">
	<div>
		<a href="${cpath }/view/${row.name}">${row.name }</a>
		${row.addr }
		<a class="link" href="${cpath }/camping_around/${row.mapX}/${row.mapY}">캠핑장 근처</a>
	</div>
</c:forEach>




</body>
</html>