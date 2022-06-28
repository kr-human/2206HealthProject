<%@page import="kr.human.second.service.CommonServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
	text-align: center;
	}
	h1{ 
		padding:15px;
	}
	#img_btn{
	width: 50px;
	height: 50px;
	}
	img {
 max-width: 100%;
 max-height: 100%;
}
#log{
		border: 3px solid black;
		width: 850px;
		height:600px;
		border-radius: 20px;
		margin: auto;
		margin-top:100px;
	}

</style>
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
<!-- 여기 부분 꾸며야 함 -->
	<%if(isConfirm){ %>
	<div>
		<div id='log'>
			<h2>반갑습니다. <%=id %>님 인증에 성공하셨습니다.</h2>
			<h2>가입해주셔서 감사합니다.</h2>	
			<button type='button'class='btm_image'id='img_btn'><a href="${pageContext.request.contextPath }"><img src='./images/2.png'></a></button>
			<button type='button'class='btm_image'id='img_btn'><a href="${pageContext.request.contextPath }/login.jsp"><img src='./images/4.png'></a></button>
		</div>
	</div>
	<%}else{ %>
	<div>
		<div id='log'>
			<h2>인증에 실패하였습니다.</h2>
			<button type='button'class='btm_image'id='img_btn'><a href="${pageContext.request.contextPath }"><img src='./images/2.png'></a></button>
			<button type='button'class='btm_image'id='img_btn'><a href="${pageContext.request.contextPath }/insertForm.jsp"><img src='./images/3.png'></a></button>
		</div>
	</div>
	<%} %>
</body>
</html>