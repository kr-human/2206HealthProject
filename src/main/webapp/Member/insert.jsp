<%@page import="java.util.HashMap"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Member"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="kr.human.second.service.MemberServiceImpl"%>
<%@page import="kr.human.second.service.MemberService"%>
<%@ page contentType="text/plains; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%@page import="kr.human.second.vo.ReservationVO"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%
	MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
	request.setCharacterEncoding("UTF-8");
	// 스트링으로 받기 
	String id = request.getParameter("id");
	int ptcode = Integer.parseInt(request.getParameter("idx"));
	
	System.out.println("id : " + id);
	System.out.println("idx : " + ptcode);
	
	int ptcoupon = MemberServiceImpl.getInstance().CheckPT(id);
	if(ptcoupon>0){
		// 내가 예약한 PTClass의 check값을 'F'로 변경하자
		PTClassVO ptClassVO = new PTClassVO();
		ptClassVO.setR_check("F");
		ptClassVO.setId(id);
		ptClassVO.setIdx(ptcode);
		ptClassVO.setType("insert");
	
		MemberServiceImpl.getInstance().checkUpdate(ptClassVO);
		ptcoupon = MemberServiceImpl.getInstance().CheckPT(id);
		memberVO.setPt(ptcoupon);
		session.setAttribute("memberVO", memberVO);
		out.print("1");
	} else{
		out.print("0");
	}
%>
