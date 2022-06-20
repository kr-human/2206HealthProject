<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.usersVO }">
		<a href = "u_insertForm.jsp">회원가입</a>
		<a href = "login.jsp">로그인</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.usersVO }">
		${sessionScope.UserVO.u_id }(${sessionScope.usersVO.u_name }) 회원님 반갑습니다.<br>		
			<a href = "updateForm.jsp">회원 정보 수정</a>
			<a href = "deleteForm.jsp">회원 탈퇴</a>
			<a href = "logout.jsp">로그 아웃</a>		
	</c:if>
	
	<c:if test="${not empty sessionScope.trainerVO }">
		${sessionScope.trainerVO.t_id }(${sessionScope.trainerVO.t_name }) 선생님 반갑습니다.<br>		

			<a href = "logout.jsp">로그 아웃</a>		
	</c:if>
	
	<c:if test="${not empty sessionScope.adminVO }">
		${sessionScope.adminVO.a_id } 관리자님 반갑습니다.<br>		
			<a href = "t_insertForm.jsp">강사 관리</a>
			<a href = "logout.jsp">로그 아웃</a>		
	</c:if>



</body>
</html>