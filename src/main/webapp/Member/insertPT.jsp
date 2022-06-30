<%@page import="kr.human.second.service.PTClassServiceImpl"%>
<%@page import="kr.human.second.vo.ReservationInfoVO"%>
<%@page import="kr.human.second.vo.ReservationVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<jsp:useBean id="vo" class="kr.human.second.vo.PTClassVO"></jsp:useBean>
<jsp:setProperty name="vo" property="*"/>
<%

	String pttime = request.getParameter("pttime");
	String info = request.getParameter("info");
	String id = request.getParameter("id");
	
	info += " " + pttime;
	
	System.out.println("info : "+info + ", T_ID : " + id);
	
	PTClassVO ptClassVO = new PTClassVO();
	ptClassVO.setId(id);
	ptClassVO.setPtTime(info);
	ptClassVO.setR_check("T");

	System.out.println("ptClassVO : " + ptClassVO.toString());
	
	PTClassServiceImpl.getInstance().insert(ptClassVO);
	

	Gson gson = new Gson();
	out.println(gson.toJson(ptClassVO));
	
%>
