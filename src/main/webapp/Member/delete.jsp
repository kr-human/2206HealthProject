<%@page import="kr.human.second.vo.MemberVO"%>
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
	MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
	// 스트링으로 받기 
	String id = request.getParameter("id");
	int ptcode = Integer.parseInt(request.getParameter("idx"));
	
	System.out.println("id : " + id);
	System.out.println("idx : " + ptcode);
	
	// 내가 예약취소한 PTClass의 check값을 'T'로 변경하자
	PTClassVO ptClassVO = new PTClassVO();
	ptClassVO.setR_check("T");
	ptClassVO.setId(id);
	ptClassVO.setIdx(ptcode);
	//구분자를 통해 예약 삭제 type
	ptClassVO.setType("delete");
	
	MemberService memberService = MemberServiceImpl.getInstance();
	System.out.println(ptClassVO);
	memberService.checkUpdate(ptClassVO);
	
	int ptcoupon = MemberServiceImpl.getInstance().CheckPT(id);
	memberVO.setPt(ptcoupon);
	session.setAttribute("memberVO", memberVO);

%>
