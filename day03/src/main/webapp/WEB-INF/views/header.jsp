<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day03 - password board</title>
<style>
	table {
		border-collapse: collapse;
		border: 1px solid black;
	}
	th, td {
		border: 1px solid grey;
		padding: 10px;
	}
	th {
		background-color: #eee;
	}
	a {
		text-decoration: none;
		color: inherit; 
	}
	a:hover {
		text-decoration: underline;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day03</a></h1>
	
	<nav>
		<ul>
			<li><a href="${cpath }/list">게시판</a></li>
			<li><a href="${cpath }/add">글쓰기</a></li>
		</ul>
	</nav>
</header>
