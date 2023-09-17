<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table border="1" cellpadding="10" cellspacing="0">
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>
				<a href="${cpath }/member/view/${dto.idx}">${dto.userid }</a>
			</td>
			<td>${dto.username }</td>
			<td>${dto.email }</td>
			<td>${dto.originalFileName }</td>
			
			<c:if test="${dto.originalFileName eq 'default.jpg' }">
				<td style="background-image: url('${cpath}/upload/${dto.originalFileName}');
							background-position: center;
							background-repeat: no-repeat;
							background-size: auto 100%;
							width: 130px;
							height: 130px;">	
				</td>
			</c:if>
			<c:if test="${dto.originalFileName ne 'default.jpg' }">
				<td style="background-image: url('${cpath}/upload/${dto.storedFileName}');
							background-position: center;
							background-repeat: no-repeat;
							background-size: auto 100%;
							width: 130px;
							height: 130px;">	
				</td>
			</c:if>
			
			<c:if test="${dto.originalFileName eq 'default.jpg' }">
				<td>
					<a href="${cpath }/upload/${dto.originalFileName}" download="${dto.originalFileName }"><button>다운로드</button></a>
				</td>
			</c:if>
			<c:if test="${dto.originalFileName ne 'default.jpg' }">
				<td>
					<a href="${cpath }/upload/${dto.storedFileName}" download="${dto.originalFileName }"><button>다운로드</button></a>
				</td>
			</c:if>
		</tr>
	</c:forEach>

</table>

<p>
	<a href="${cpath }/member/join"><button>회원가입</button></a>
	<a href="${cpath }/member/login"><button>로그인</button></a>
	<a href="${cpath }/member/logout"><button>로그아웃</button></a>
</p>
</body>
</html>