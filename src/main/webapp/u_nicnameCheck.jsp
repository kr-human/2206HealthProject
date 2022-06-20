<%@page import="kr.human.second.service.UsersServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String u_nicname = request.getParameter("u_nicname");
int count = UsersServiceImpl.getInstance().u_nicnameCheck(u_nicname);
out.println(count);
%>