<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<h3>version : ${version }</h3>
<h3>sysdate : ${sysdate }</h3>
<h3>tableList : ${tableList }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 파라미터 전달</a></li>
	<li><a href="${cpath }/ex02">ex02 - 파라미터 전달(경로 변수)</a></li>
	<li><a href="${cpath }/ex03">ex03 - 마이바티스 파라미터 전달</a></li>
	<li><a href="${cpath }/board">게시판</a></li>
</ul>

</body>
</html>