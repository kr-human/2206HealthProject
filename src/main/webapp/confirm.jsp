<%@page import="kr.human.second.service.CommonServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//사용자 아이디를 읽는다 
	String id = request.getParameter("id");
	//서비스를 호출하여 해당 아이디의 lev값을 변경해주고
	boolean isConfirm = false;
	if(id!=null){
		isConfirm = CommonServiceImpl.getInstance().emailConfirm(id);
	}

%>
<% if(isConfirm){ %>
	<h2>반갑습니다. <%=id %>님 인증에 성공하셨습니다.</h2>
	<h2>가입해주셔서 감사합니다.</h2>
	<a href="${pageContext.request.contextPath }">홈</a>
	<a href="${pageContext.request.contextPath }/login.jsp">로그인</a>
<%}else{ %>
	<h2>인증에 실패하였습니다.</h2>
	<a href="${pageContext.request.contextPath }">홈</a>
	<a href="${pageContext.request.contextPath }/insertForm.jsp">회원가입</a>
<%} %>
</body>
</html>