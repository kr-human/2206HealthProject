<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
		if(request.getMethod().equals("GET")){
			response.sendRedirect(request.getContextPath());
			return;
		}
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		if(id!=null && password!=null){
			// 서비스를 호출하여 로그인 처리를 한다.
			//여기서 유저 서비스에서 호출하는 ID 
			boolean isLogin = MemberServiceImpl.getInstance().login(session, id, password);
			if(isLogin){
				response.sendRedirect(request.getContextPath());
				return;
			}else{
				request.setAttribute("error", "잘못된 정보입니다.");
				pageContext.forward("login.jsp");
			}
			
		}else{
			request.setAttribute("error", "잘못된 정보입니다.");
			pageContext.forward("login.jsp");
			return;
		}
		
		
		
		
	%>
</body>
</html>