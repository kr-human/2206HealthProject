<%@page import="kr.human.second.service.UsersServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String u_id = request.getParameter("u_id");
int count = UsersServiceImpl.getInstance().u_idCheck(u_id);
out.println(count);
%>