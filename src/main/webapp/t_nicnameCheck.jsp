<%@page import="kr.human.second.service.AdminServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String t_nicname = request.getParameter("t_nicname");
int count = AdminServiceImpl.getInstance().t_nicnameCheck(t_nicname);
out.println(count);
%>