<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.service.MemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>

<%@page import="kr.human.second.vo.ReservationVO"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 스트링으로 받기 
	int idx1 = Integer.parseInt(request.getParameter("idx"));
	
	System.out.println("idx : " + idx1);
	
	
	
	MemberServiceImpl.getInstance().deletePT(idx1);
	

%>
