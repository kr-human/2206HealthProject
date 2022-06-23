<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@page import="kr.human.second.service.TrainerServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="vo" class="kr.human.second.vo.MemberVO"></jsp:useBean>
	<jsp:setProperty property="*" name="vo"/>

	<%//=memberVO %>
	<%
		// 서비스를 호출하여 수정을 하고
		TrainerServiceImpl.getInstance().MemberUpdate(vo, session);

		// 어디론가 간다.
		response.sendRedirect(request.getContextPath()); // 홈으로
	%>
</body>
</html>