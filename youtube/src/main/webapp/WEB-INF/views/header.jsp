<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>youtube</title>
<style>
	.thumbnail {
		width: 320px;
		height: 180px;
		background-size: 100%;
		background-repeat: no-repeat;
		background-position: center;
		margin-bottom: 10px;
	}
	.thumbnail > a {
		display: block;
		width: 100%;
		height: 100%; 
	}
	.wrap {
		width: 1100px;
		display: flex;
		margin: auto;
	}
	.item {
		width: 300px;
		margin-right: 40px;
	}
	.top {
		margin-bottom: 5px;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">Youtube</a></h1>
	
	<ul>
		<li><a href="${cpath }/list">목록</a></li>
		<li><a href="${cpath }/add">추가</a></li>
	</ul>
</header>

