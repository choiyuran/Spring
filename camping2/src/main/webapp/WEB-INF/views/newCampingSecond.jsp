<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

${form }
<div class="container mt-3">
  <h2>캠핑장 상세등록</h2>
  <form action="${cpath }/newCampingThird?form=${form}" method="POST">
    <div class="mb-3 mt-3">
      <label>주변 이용 가능 시설:</label>
      <input type="text" name="posblfcltycl">
    </div>
    <div class="mb-3">
      <label>주변 이용 가능 시설 기타:</label>
      <input type="text" name="posblfcltyetc">
    </div>
    <div class="mb-3">
      <label>체험 프로그램:</label>
     	<input type="text" name="exprnprogrm">
    </div>
    <div class="mb-3">
      <label>오시는 길:</label>
     	<input type="text" name="direction">
    </div>
    <!-- camping_introduce -->
     <div class="mb-3">	
      <label>개인 카라반 동반 여부:</label>
      	<input type="checkbox" name="caravacmpnyat" value="yes">
      		<label>Y</label>
      	<input type="checkbox" name="caravacmpnyat" value="no">
      		<label>N</label>
    </div>
     <div class="mb-3">
      <label>개인 트레일러 동반 여부:</label>
      	<input type="checkbox" name="trleracmpnyat" value="yes">
      		<label>Y</label>
      	<input type="checkbox" name="trleracmpnyat" value="no">
      		<label>N</label>
    </div>
     <div class="mb-3">
      <label>운영 기간:</label>
     	<input type="checkbox" name="operpdcl" value="봄">
     		<label>봄</label>
     	<input type="checkbox" name="operpdcl" value="여름">
     		<label>여름</label>
     	<input type="checkbox" name="operpdcl" value="가을">
     		<label>가을</label>
     	<input type="checkbox" name="operpdcl" value="겨울">
     		<label>겨울</label>
    </div>
     <div class="mb-3">
      <label>운영일:</label>
     	<input type="checkbox" name="operdecl" value="평일">
     		<label>평일</label>
     	<input type="checkbox" name="operdecl" value="주말">
     		<label>주말</label>
    </div>
    <div class="mb-3">
      <label>테마환경:</label>
     	<input type="text" name="themaenvrncl">
    </div>
    <div class="mb-3">
      <label>기타 장비:</label>
     	<input type="text" name="eqpmnlendcl">
    </div>
    <div class="mb-3">
      <label>애견 동반 여부:</label>
      <select name="animalcmgcl">
      	<option value="가능(소형견)">가능(소형견)</option>
      	<option value="불가능">불가능</option>
      </select>
    </div>
    <div class="mb-3">
      <label>바닥재:</label>
     	잔디 : <input type="number" name="sitebottomcl1">
     	파쇄석 : <input type="number" name="sitebottomcl2">
     	테크 : <input type="number" name="sitebottomcl3">
     	자갈 : <input type="number" name="sitebottomcl4">
     	맨흙 : <input type="number" name="sitebottomcl5">
    </div>
    
	    <a href="${cpath }/prevPage"><button class="btn btn-primary">이전</button></a>
	    <input type="submit" class="btn btn-primary" value="다음">
  </form>
</div>
</body>
</html>