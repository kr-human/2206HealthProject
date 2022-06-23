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
	// 트레이너는 자신의 수업시간과 그시간에 맞는 회원이름을 가져와야한다
	System.out.println(vo);
	
	String pttime = request.getParameter("pttime");
	String id = request.getParameter("id");
	
	System.out.println("pttime : "+pttime+", T_ID : " + id);
	
	HashMap<String, String> map = new HashMap<>();
	map.put("pttime",pttime);
	map.put("id",id);
	
	
	List<ReservationInfoVO> list = MemberServiceImpl.getInstance().SelectByReservationInfo(map);
	ReservationVO reservationVO = new ReservationVO();
	System.out.println("list : " + list);
	

	Gson gson = new Gson();
	out.println(gson.toJson(list));
	
%>


