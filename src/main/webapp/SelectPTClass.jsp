<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="kr.human.second.service.TrainerServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<PTClassVO> list = TrainerServiceImpl.getInstance().selectByPTOneDayCheck();
	Gson gson = new Gson();
	out.println(gson.toJson(list));
%>