<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	h3 {
		width: 100%;
		word-break: break-all;
	}
</style>

<!-- 
	Hash란?/hash알고리즘
	1. 원본 데이터를 파편 내서 저장
	2. 단방향o 양방향x(한번 감으면 풀수 없음)
	3. 입력값이 일정하면 출력값이 일정
	4. 엄청 큰 두 수의 서로소를 구하는 방법과 비슷
	5. DB관리자가 패스워드를 쌩으로 볼수 없게 하기 위해서
	즉, 개인정보 보호를 위해서/해시 처리를 하지 않으면 법에 걸린다
 -->
<h3>home.jps</h3>

<p><a href="${cpath }/ex01"><button>ex01 - 회원가입 구현 (hash 적용)</button></a></p>
<p><a href="${cpath }/ex02"><button>ex02 - 로그인 구현 (hash 적용)</button></a></p>
<p><a href="${cpath }/ex03"><button>ex03 - 비밀번호 재발급 (hash 적용)</button></a></p>
<p><a href="${cpath }/ex04"><button>ex04 - 비밀번호 변경 (hash 적용)</button></a></p>

<fieldset>
	<legend>hash test</legend>
	<form method="POST">
		<p><input type="text" name="source" placeholder="source" autofocus></p>
		<p><input type="text" name="salt" placeholder="salt"></p>
		<p><input type="submit"></p>
	</form>
	<c:if test="${not empty hash }">
		<h3>source : ${param.source }</h3>
		<h3>salt : ${salt }</h3>
		<h3>hash : ${hash }</h3>
	</c:if>
</fieldset>
</body>
</html>