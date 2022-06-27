<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String myTrainer = "";
	String id = "";
	int level = 0;
	MemberVO MyTrainerVO = new MemberVO();
	
	if(session.getAttribute("memberVO")!=null){
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		myTrainer = memberVO.getMyTrainer();
		id = memberVO.getId();
		level = memberVO.getLev();
		
		System.out.println(memberVO);
		System.out.println(myTrainer + " : " + id);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("id", myTrainer);
		
		//----------------------------------------------------------------------------------
		//나의 트레이너 정보를 가져오자
		MyTrainerVO = MemberServiceImpl.getInstance().selectMyTrainerInfo(map);
		
	}else{
		out.println("<script>alert('로그인후 이용해주세요'); location.href='../login.jsp';</script>");
		return;
	}
	
	request.setAttribute("myTrainer", myTrainer);
	request.setAttribute("id", id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Trainer INFO</title>
<style type="text/css">
	#container{
		padding: 10px;
	}
	
	#TrainerName{
		text-align: center;
	}
	
	.sbox{
		width: 35%;
		height: 100%;		
		padding:10px;
		border: 3px solid navy;
		border-radius: 20px;
	}
</style>
<script type="text/javascript">

		

</script>
</head>
<body>
<div id="container" >
	<div class="sbox">
		<h1 id="TrainerName" >트레이너 소개</h1><hr />
		<br>
		<div>
			<h3><%=MyTrainerVO.getName()%> (<%=MyTrainerVO.getGender()!="M"?"남":"여" %>) 트레이너</h3>
			<br>
			<h4>생활체육지도자자격증2급(보디빌딩) </h4>
			<h4>생활체육지도자자격증2급(MMA)</h4>
			<h4>근막이완자격증 이수</h4>
			<h4>기능성재활트레이닝자격증 이수</h4>
			<h4>한국체육대학교 / 몬스터 크로스핏강사</h4>
		</div>
	</div>
	<div>
		<img alt="" src="">
	</div>
	
</div>
</body>
</html>