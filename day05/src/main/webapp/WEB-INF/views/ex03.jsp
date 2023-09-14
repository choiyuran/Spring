<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex03 - MultipartFile을 포함하는 DTO형식의 업로드 (컴포넌트 활용)</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="제목"></p>
	<p><input type="file" name="upload" accept="image/*"></p>
	<p><input type="submit"></p>
</form>

<div style="display: flex; flex-flow: wrap; width: 600px">
	<c:forEach var="dto" items="${list }">
		<div style="width: 150px; margin: 10px; border: 1px solid grey;">
			<div style="background-image: url('${cpath}/upload/${dto.fileName }');
						background-position: center;
						background-size: auto 100%;
						background-repeat: no-repeat;
						width: 150px;
						height: 150px;"></div>
		
			<div>
				<h4 style="text-align: center;">
					<a href="${cpath }/upload/${dto.fileName }" download="a.jpg">${dto.title }</a>	<!-- download 속성을 사용하면 바로 다운 (지정한 이름으로) -->
				</h4>
			</div>
		</div>
	
	</c:forEach>


</div>
</body>
</html>