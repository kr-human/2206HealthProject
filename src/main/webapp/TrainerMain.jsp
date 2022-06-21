<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트레이너 로그인 후 메인 화면</title>
</head>
<body>
	<form action="">
		<h1>트레이너 로그인 후 메인 화면</h1>
		
		<a href="${pageContext.request.contextPath }/TrainerPTMain.jsp">PT관리</a> 
		<a href="UserList.jsp">회원관리</a> 
		<a href="Notice.jsp">공지사항</a>
	</form>
</body>
</html>