<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day04</title>
<style>
	table {
		border-collapse: collapse;
		border: 1px solid black;
	}
	th, td {
		border: 1px solid grey;
		padding: 10px 15px;
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
	<h1><a href="${cpath }/board">day04</a></h1>
	<hr>
</header>

