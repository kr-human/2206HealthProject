<%@ page import="kr.human.second.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String id = request.getParameter("id");
int count = MemberServiceImpl.getInstance().idCheck(id);
out.println(count);
%>