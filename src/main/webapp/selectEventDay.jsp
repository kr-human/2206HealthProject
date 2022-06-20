<%@page import="kr.human.second.service.UsersServiceImpl"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<jsp:useBean id="vo" class="kr.human.second.vo.PTClassVO"></jsp:useBean>
<jsp:setProperty name="vo" property="*"/>
<%
	System.out.println(vo);
	/*
	String ptTime = request.getParameter("ptTime");
	String t_id = request.getParameter("t_id");
	
	System.out.println("ptTime2 : "+ptTime+", t_id2 : "+t_id);
	t_id = "t1";
	
	PTClassVO vo = new PTClassVO();
	vo.setPtTime(ptTime);
	vo.setT_id(t_id);
			
	List<PTClassVO> list = UsersServiceImpl.getInstance().selectPtOneDay(vo);
	
	System.out.println("list222 : "+list);
	
	Gson gson = new Gson();
	out.println(gson.toJson(list));
	*/
%>


