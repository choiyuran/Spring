<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

${form }
${param }
<div class="container mt-3">
  <h2>캠핑장 상세등록</h2>
  <form action="" method="POST" action="${cpath }/newCampingResult?form=${form}&param=${param}">
	    <div class="mb-3 mt-3">
	      <label>부대시설:</label>
	      <input type="text" name="sbrscl">
	    </div>
	    <div class="mb-3">
	      <label>부대시설 기타:</label>
	      <input type="text" name="sbrsetc">
	    </div>
	    <div class="mb-3">
	      <label>화장실 개수:</label>
	     	<input type="number" name="toiletco">
	    </div>
	    <div class="mb-3">
	      <label>샤워실 개수:</label>
	     	<input type="number" name="swrmco">
	    </div>
	     <div class="mb-3">	
	      <label>글램핑 내부시설</label>
	      	<input type="text" name="glampinnerfclty">
	    </div>
	     <div class="mb-3">	
	      <label>카라반 내부시설</label>
	      	<input type="text" name="caravinnerfclty">
	    </div>
	  	<!-- camping_safety_device -->
	    <div class="mb-3">
	      <label>소화기 개수:</label>
	      	<input type="number" name="extshrCo">
	    </div>
	    <div class="mb-3">
	      <label>방화수 개수:</label>
	      	<input type="number" name="frprvtwrppco">
	    </div>
	    <div class="mb-3">
	      <label>방화사 개수:</label>
	      	<input type="number" name="frprvtsandco">
	    </div>
	    <div class="mb-3">
	      <label>화재감지기 개수:</label>
	      	<input type="number" name="firesensorco">
	    </div>
	    <!-- camping_site -->
	    <div class="mb-3">
	      <label>사이트A 개수:</label>
	      	<input type="number" name="sitemg1co">
	    </div>
	    <div class="mb-3">
	      <label>사이트B 개수:</label>
	      	<input type="number" name="sitemg2co">
	    </div>
	    <div class="mb-3">
	      <label>사이트C 개수:</label>
	      	<input type="number" name="sitemg3co">
	    </div>
	    <div class="mb-3">
	      <label>사이트A 가격:</label>
	      	<input type="number" name="sitemg1_price">
	    </div>
	    <div class="mb-3">
	      <label>사이트B 가격:</label>
	      	<input type="number" name="sitemg2_price">
	    </div>
	    <div class="mb-3">
	      <label>사이트C 가격:</label>
	      	<input type="number" name="sitemg3_price">
	    </div>
	    <a href="${cpath }/prevPage"><button class="btn btn-primary">이전</button></a>
	    <input type="submit" class="btn btn-primary" value="등록">
  </form>
</div>
</body>
</html>