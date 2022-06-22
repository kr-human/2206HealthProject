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
	
	System.out.println("pttime : "+pttime+", myTrainer : "+myTrainer);
	//myTrainer = "hyun95";
	
	HashMap<String, String> map = new HashMap<>();
	map.put("pttime",pttime);
	map.put("id",myTrainer);
			
	List<PTClassVO> list = MemberServiceImpl.getInstance().selectPtOneDay(map);
	
	System.out.println("list : "+list);
	
	Gson gson = new Gson();
	out.println(gson.toJson(list));
	
%>


