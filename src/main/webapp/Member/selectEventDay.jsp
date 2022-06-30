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
	System.out.println(vo);
	
	String pttime = request.getParameter("pttime");
	String myTrainer = request.getParameter("myTrainer");
	String id = request.getParameter("id");
	
	System.out.println("pttime : "+pttime+", myTrainer : "+myTrainer);
	//myTrainer = "hyun95";
	
	HashMap<String, String> map1 = new HashMap<>();
	map1.put("pttime",pttime);
	map1.put("id",myTrainer);
	
	
	List<PTClassVO> list = MemberServiceImpl.getInstance().selectPtOneDay(map1);
	ReservationVO reservationVO = new ReservationVO();
	System.out.println("list : "+list);
	
	for(PTClassVO ptClass : list){
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("id",id);
		map2.put("idx", ptClass.getIdx());
		
		ptClass.setCount(MemberServiceImpl.getInstance().CheckMyReservation(map2));
	}
	
	
	Gson gson = new Gson();
	out.println(gson.toJson(list));
	
%>


