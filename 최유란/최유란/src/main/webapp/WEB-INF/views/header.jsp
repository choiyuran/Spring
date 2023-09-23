<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 리뷰 사이트</title>
<style>
	h1 {
		text-align: center;
	}
	ul {
		list-style: none;
		display: flex;
		justify-content: space-around;
		margin: 5px 100px;
	}
	ul > li {
		margin: 0 10px;
	}
	details {
		margin-left: 30px;
	}
	div#main {
		width: 400px;
		margin: auto;
	}
	div.btn {
		display: flex;
		justify-content: space-between;
	}
	button {
		margin: 10px 0;
	}
	table {
		border: 1px solid black;
		border-collapse: collapse;
		width: 400px;
		margin-top: 20px;
	}	
	th {
		background-color: #eee;
	}
	th, td {
		border: 1px solid grey;
		padding: 10px 15px;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
		font-weight: bold;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">회원제 리뷰 사이트</a></h1>
	
	<nav>
		<ul>
			<li><a href="${cpath }/account/${empty login ? 'login' : 'logout'}">
				${empty login ? '로그인' : '로그아웃' }</a></li>
			<li><a href="${cpath }/review/list">리뷰</a></li>
		</ul>
	</nav>
	
	<p align="right">
		<c:if test="${not empty login }">
			${login.userid } (${login.username })
		</c:if>
	</p>
</header>

<hr>