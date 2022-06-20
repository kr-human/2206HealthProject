<%@page import="kr.human.second.service.AdminServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String t_id = request.getParameter("t_id");
int count = AdminServiceImpl.getInstance().t_idCheck(t_id);
out.println(count);
%>