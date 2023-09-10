<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>
	<div class="wrap">
		<c:forEach var="row" items="${list }">
			<div class="item">
				<div class="thumbnail" style="background-image: url('${row.thumbnail}')" >
					<a href="${cpath }/view/${row.idx}"></a>		
				</div>
			
				<div class="top">
					<c:if test="${fn:length(row.title) > 20 }">
						${fn:substring(row.title, 0, 20) }...
					</c:if>
					<c:if test="${fn:length(row.title) <= 20 }">
						${row.title } 
					</c:if>
					| 
					${row.channel }
				</div>
				
				<div>
					조회수 : ${row.viewCount }
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>