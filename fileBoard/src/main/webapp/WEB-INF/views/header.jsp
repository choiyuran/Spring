<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 게시판</title>
</head>
<body>

<h1><a href="${cpath }">fileBoard</a></h1>

<c:if test="${not empty login }">
	<p align="right">${login.username }</p>
</c:if>
<hr>
