<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainerlayout</title>
</head>

<body>
	<nav>
	<c:if test="${empty sessionScope.memberVO }">
		<a href="insertForm.jsp">회원가입</a>  
		<a href="login.jsp">로그인</a>
	</c:if>
	<c:if test="${not empty sessionScope.memberVO }">
		${sessionScope.memberVO.userid }(${sessionScope.memberVO.name })님 반갑습니다 <br>
		
		<a href="updateForm.jsp">정보수정</a>
		<a href="logout.jsp">로그아웃</a>
	</c:if>
	</nav>
	
	<hr />
	<%-- 이자리에 내가 쓴 본문의 내용이 나타나라 --%>
	<sitemesh:write property='body'/>
	
	<hr />
	
	
	<h1>회사명, 주소 등 기입할 하단</h1>
</body>
</html>