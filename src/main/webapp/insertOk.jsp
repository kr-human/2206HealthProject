<%@page import="java.util.UUID"%>
<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 완료</h1>
	<jsp:useBean id="memberVO" class="kr.human.second.vo.MemberVO"/>
	<jsp:setProperty property="*" name="memberVO"/>
	<%//=memberVO %>
	<%
		// 서비스를 호출하여 저장을 하고
		//String urlAddress = "http://"+request.getServerName()+":" +
	            	//request.getServerPort()+ request.getContextPath() + "/confirm.jsp?fdagd=" + UUID.randomUUID();
		//MemberServiceImpl.getInstance().insert(memberVO, urlAddress);
		// 어디론가 간다.
		//out.println(memberVO.getEmail() + "로 인증메일이 발송되었습니다. 인증을 진행하시고 로그인하시기 바랍니다.<br>");
		//out.println("<a href='" + request.getContextPath() + "'>홈으로</a><br>" );
		/*
		out.println(request.getRequestURI() + "<br>" );
		out.println(request.getRequestURL() + "<br>" );
		out.println(request.getContextPath() + "<br>" );
		out.println(request.getServerName() + "<br>" );
		out.println("http://"+request.getServerName()+":" + 
		            request.getServerPort()+ request.getContextPath() + "/confirm.jsp<br>" );
		*/
	%>
</body>
</html>