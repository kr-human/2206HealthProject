<%@page import="kr.human.second.service.TrainerServiceImpl"%>
<%@page import="kr.human.second.service.TrainerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
		/*if(request.getMethod().equals("GET")){
			response.sendRedirect(request.getContextPath());
			return;
		}*/
		String t_id = request.getParameter("userid");
		String t_password = request.getParameter("password");
	
		if(t_id!=null && t_password!=null){
			// 서비스를 호출하여 로그인 처리를 한다.
			//여기서 유저 서비스에서 호출하는 ID 
			boolean isLogin = TrainerServiceImpl.getInstance().t_login(t_id, t_password, session);
			if(isLogin){
				response.sendRedirect(request.getContextPath());
				return;
			}else{
				request.setAttribute("error", "잘못된 정보입니다.");
				pageContext.forward("t_login.jsp");
			}
		}else{
			request.setAttribute("error", "잘못된 정보입니다.");
			pageContext.forward("t_login.jsp");
			return;
		}
		
		
		
		
	%>
</body>
</html>