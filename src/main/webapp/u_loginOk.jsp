<%@page import="kr.human.second.service.UsersServiceImpl"%>
<%@page import="kr.human.second.service.UsersService"%>
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
		String u_id = request.getParameter("userid");
		String u_password = request.getParameter("password");
	
		if(u_id!=null && u_password!=null){
			// 서비스를 호출하여 로그인 처리를 한다.
			//여기서 유저 서비스에서 호출하는 ID 
			boolean isLogin = UsersServiceImpl.getInstance().u_login(session, u_id, u_password);
			if(isLogin){
				response.sendRedirect(request.getContextPath());
				return;
			}else{
				request.setAttribute("error", "잘못된 정보입니다.");
				pageContext.forward("u_login.jsp");
			}
		}else{
			request.setAttribute("error", "잘못된 정보입니다.");
			pageContext.forward("u_login.jsp");
			return;
		}
		
		
		
		
	%>
</body>
</html>