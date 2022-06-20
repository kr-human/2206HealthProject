<%@page import="kr.human.second.service.AdminServiceImpl"%>
<%@page import="kr.human.second.service.AdminService"%>
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
		String a_id = request.getParameter("userid");
		String a_password = request.getParameter("password");
	
		if(a_id!=null && a_password!=null){
			// 서비스를 호출하여 로그인 처리를 한다.
			//여기서 유저 서비스에서 호출하는 ID 
			boolean isLogin = AdminServiceImpl.getInstance().a_login(a_id, a_password, session);
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