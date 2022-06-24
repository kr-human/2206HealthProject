<%@page import="java.util.List"%>
<%@page import="kr.human.second.service.TrainerServiceImpl"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	// 수정할 글을 가져온다.
	String id = request.getParameter("id");
	MemberVO VO = TrainerServiceImpl.getInstance().SelectByAllUserInfo(id);
	if(VO==null){ // 글이 없다.
		response.sendRedirect("UserList.jsp");
		return;
	}
	session.setAttribute("VO", VO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PT이용권 수정</title>
<link href="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/jquery/3.6.0/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript">

</script>
<style type="text/css">
	table { width: 900px; margin: auto; border: none;}
	th{ padding: 5px; text-align: center; background-color: silver; border: 1px solid gray;}
	td{ padding: 5px; text-align: center;  border: 1px solid gray;}
</style>
</head>
<body>
	<form action="PTupdateOk.jsp" method="post">
	<table>
		<tr>
			<td class="title" colspan="4">회원정보 수정하기</td>
		</tr>
		<tr>
			<td>이름</td>
			<td style="text-align: left;"> 
				<input type="hidden" name="id" value="${VO.id }" />
				<input type="text" name="name" value="${VO.name }" readonly="readonly"/>
			</td>
			<td>이메일</td>
			<td style="text-align: left;">
				<input type="email" name="email" value="${VO.email }" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>pt이용권</td>
			<td style="text-align: left;"> 
				<input type="number" name="pt" id="pt" value="${VO.pt }" required="required"/>
			</td>
			<td>트레이너아이디</td>
			<td style="text-align: left;">
				<input type="text" name="myTrainer" id="myTrainer" value="${VO.myTrainer }" required="required"/>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td style="text-align: left;"> 
				<input type="date" name="startDay1" value="${VO.startDay }" required="required"/>
			</td>
			<td>만기일</td>
			<td style="text-align: left;">
				<input type="date" name="endDay1" value="${VO.endDay }" required="required"/>
			</td>
		<tr>
			<td colspan="4" style="text-align: right;border: none;">
				<input type="submit" value=" 등록 및 수정 " />
				<c:url var="url" value="UserList.jsp"></c:url>
				<input type="button" onclick="location.href='${url}'" value=" 돌아가기 "/>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>