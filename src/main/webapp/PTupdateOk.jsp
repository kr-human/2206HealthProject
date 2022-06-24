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
	<%
		String PT = request.getParameter("pt");
		int newPt = Integer.parseInt(PT);
		
		String myTrainer = request.getParameter("myTrainer");
		
		// String 을 날짜 형식으로 변경하여 넣는다.
		String newStartDay = request.getParameter("startDay1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// 		Date startDay = sdf.parse(newStartDay);
		vo.setStartDay(sdf.parse(newStartDay));
		
		// String 을 날짜 형식으로 변경하여 넣는다.
		String newEndDay = request.getParameter("endDay1");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		vo.setEndDay(sdf2.parse(newEndDay));
	%>
<%-- 	<%=vo %> --%>
	<%
		// 서비스를 호출하여 수정을 하고
		TrainerServiceImpl.getInstance().MemberUpdate(vo, newPt, myTrainer);

		// 어디론가 간다.
		response.sendRedirect(request.getContextPath()+"/UserList.jsp"); // 홈으로
	%>
</body>
</html>