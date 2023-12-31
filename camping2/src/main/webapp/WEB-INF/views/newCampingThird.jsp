<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-3">
  <h2>캠핑장 상세등록</h2>
  <form method="POST" action="${cpath }/newCampingThird">
	    <div class="mb-3 mt-3">
	      <label>부대시설:</label>
	      <input type="text" name="sbrsCl">
	    </div>
	    <div class="mb-3">
	      <label>부대시설 기타:</label>
	      <input type="text" name="sbrsEtc">
	    </div>
	    <div class="mb-3">
	      <label>화장실 개수:</label>
	     	<input type="number" name="toiletCo" required>
	    </div>
	    <div class="mb-3">
	      <label>샤워실 개수:</label>
	     	<input type="number" name="swrmCo" required>
	    </div>
	     <div class="mb-3">	
	      <label>글램핑 내부시설</label>
	      	<input type="text" name="glamplnnerFclty">
	    </div>
	     <div class="mb-3">	
	      <label>카라반 내부시설</label>
	      	<input type="text" name="caravlnnerFclty">
	    </div>
	  	<!-- camping_safety_device -->
	    <div class="mb-3">
	      <label>소화기 개수:</label>
	      	<input type="number" name="extshrCo" required>
	    </div>
	    <div class="mb-3">
	      <label>방화수 개수:</label>
	      	<input type="number" name="frprvtWrppCo" required>
	    </div>
	    <div class="mb-3">
	      <label>방화사 개수:</label>
	      	<input type="number" name="frprvtSandCo" required>
	    </div>
	    <div class="mb-3">
	      <label>화재감지기 개수:</label>
	      	<input type="number" name="fireSensorCo" required>
	    </div>
	    <!-- camping_site -->
	    <div class="mb-3">
	      <label>사이트A 개수:</label>
	      	<input type="number" name="siteMg1Co" required>
	    </div>
	    <div class="mb-3">
	      <label>사이트B 개수:</label>
	      	<input type="number" name="siteMg2Co">
	    </div>
	    <div class="mb-3">
	      <label>사이트C 개수:</label>
	      	<input type="number" name="siteMg3Co">
	    </div>
	    <div class="mb-3">
	      <label>사이트A 가격:</label>
	      	<input type="number" name="siteMg1_price" required>
	    </div>
	    <div class="mb-3">
	      <label>사이트B 가격:</label>
	      	<input type="number" name="siteMg2_price">
	    </div>
	    <div class="mb-3">
	      <label>사이트C 가격:</label>
	      	<input type="number" name="siteMg3_price" required>
	    </div>
	      <button id="prevtwo" class="btn btn-primary">이전</button>
	    <input type="submit" class="btn btn-primary" value="등록">
  </form>
</div>

<script>
	const prev = document.getElementById('prevtwo')
	prev.addEventListener('click', function() {
		window.location.href='${cpath}/prevPageTwo'
	})
</script>
</body>
</html>