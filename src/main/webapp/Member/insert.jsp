<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.service.MemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>

<%@page import="kr.human.second.vo.ReservationVO"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 스트링으로 받기 
	String id = request.getParameter("id");
	long ptcode = Integer.parseInt(request.getParameter("idx"));
	
	System.out.println("id : " + id);
	System.out.println("idx : " + ptcode);
	
	// 받은 데이터를 VO에 넣자
	ReservationVO reservationVO = new ReservationVO();
	reservationVO.setId(id);
	reservationVO.setIdx(ptcode);
	
	// 서비스를 호출하여 저장을 수행하면 된다.
	MemberService memberService = MemberServiceImpl.getInstance();
	memberService.insertReservation(reservationVO);
	

%>
