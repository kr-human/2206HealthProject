<%@page import="java.util.UUID"%>
<%@page import="kr.human.second.service.CommonServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body{
text-align: center;
}
	h1{ 
		padding:15px;
	}
	a{
	font-size: 25px;
	}
	#log{
		border: 3px solid black;
		width: 850px;
		height:600px;
		border-radius: 20px;
		margin: auto;
		margin-top:100px;
	}
	
	#imagdiv{
	padding :10px;
	margin-left : 35%;
	}
	#img_btn{
	width: 50px;
	height: 50px;
	}
	img {
 max-width: 100%;
 max-height: 100%;
}

</style>
</head>
<body>
	<jsp:useBean id="memberVO" class="kr.human.second.vo.MemberVO"/>
	<jsp:setProperty property="*" name="memberVO"/>
	<%
	//=memberVO
	%>
	<%
	// 서비스를 호출하여 저장을 하고
			//String urlAddress = "http://"+request.getServerName()+":" +
		     //       	request.getServerPort()+ request.getContextPath() + "/confirm.jsp?fdagd=" + UUID.randomUUID();
	
			//System.out.println(memberVO + ":" + memberVO.getClass().getName());
			//System.out.println(urlAddress);
			//CommonServiceImpl.getInstance().insert(memberVO, urlAddress);
			
			
			//여기 부분 꾸며야함
			// 어디론가 간다.
			out.print("<div>");
			out.print("<div id='log'>");
			out.print("<h1>회원 가입 완료</h1>");
			out.print("<div id='imagdiv'>");
			out.print("<img src='./images/1.png' class='rounded float-start' >");
			out.print("</div>");
			out.print("<br><br><br><br><br><br><br><br><br>");
			out.print("<h2>"+memberVO.getEmail() + "<br>인증메일이 발송되었습니다.<br>인증을 진행하시고 로그인하시기 바랍니다.</h2>");
			out.print("<br><br><br><br>");
			out.println("<button type='button'class='btm_image'id='img_btn'><a href='" + request.getContextPath() + "'><img src='./images/2.png'></a></button>" );
			out.print("</div>");
			out.print("</div>");
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