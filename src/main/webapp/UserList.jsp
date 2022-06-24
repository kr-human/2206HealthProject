<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.second.service.TrainerServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	List<MemberVO> ALLlist = TrainerServiceImpl.getInstance().SelectByAllUserList();
	request.setAttribute("Alllist", ALLlist);
%>
<%
	String trainerid = ((MemberVO)session.getAttribute("memberVO")).getId();
	List<MemberVO> list = TrainerServiceImpl.getInstance().SelectByUserList(trainerid);
	request.setAttribute("myUserList", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link href="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/jquery/3.6.0/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript">

</script>
<style type="text/css">
	table { margin: auto; border: none;}
	th{ padding: 5px; text-align: center; background-color: silver; border: 1px solid gray;}
	td{ padding: 5px; text-align: center;  border: 1px solid gray;}
	.title{ padding: 5px; text-align: left; border: none; font-size: 18pt;}
</style>
</head>
<body>
	<table>
		<tr>
			<td class="title" colspan="8">전체 회원 목록</td>
		</tr>
		<tr>
			<th>이름</th>
			<th>이메일</th>
			<th>성별</th>
			<th>pt이용권</th>
			<th>등록일</th>
			<th>만기일</th>
			<th>트레이너</th>
			<th></th>
		</tr>
		<c:if test="${empty Alllist }">
			<tr>
				<td align="center" colspan="8">등록된 글이 없습니다.</td>
			</tr>		
		</c:if>
		<c:if test="${not empty Alllist }">
			<c:forEach var="vo" items="${Alllist }">
				<tr>
					<td>${vo.name }</td>
					<td>${vo.email }</td>
					<td>${vo.gender }</td>
					<td>${vo.pt }</td>
					<td><fmt:formatDate value="${vo.startDay }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${vo.endDay }" pattern="yyyy-MM-dd"/></td>
					<td>${vo.myTrainer }</td>
					<td>
					<c:url var="url" value="PTupdateForm.jsp">
						<c:param name="id" value="${vo.id }"/>
					</c:url>
					<button onclick="location.href='${url}'">등록 및 수정</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<table>
		<tr>
			<td class="title" colspan="8">나의 회원 목록</td>
		</tr>
		<tr>
			<th>이름</th>
			<th>이메일</th>
			<th>성별</th>
			<th>pt이용권</th>
			<th>등록일</th>
			<th>만기일</th>
			<th>트레이너</th>
			<th></th>
		</tr>
		<c:if test="${empty myUserList }">
			<tr>
				<td align="center" colspan="8">등록된 글이 없습니다.</td>
			</tr>		
		</c:if>
		<c:if test="${not empty myUserList }">
			<c:forEach var="myUserList" items="${myUserList }">
				<tr>
					<td>${myUserList.name }</td>
					<td>${myUserList.email }</td>
					<td>${myUserList.gender }</td>
					<td>${myUserList.pt }</td>
					<td><fmt:formatDate value="${myUserList.startDay }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${myUserList.endDay }" pattern="yyyy-MM-dd"/></td>
					<td>${myUserList.myTrainer }</td>
					<td>
					<c:url var="url" value="PTupdateForm2.jsp">
						<c:param name="id" value="${myUserList.id }"/>
					</c:url>
					<button onclick="location.href='${url}'">등록 및 수정</button>
					</td>
				</tr>			
			</c:forEach>
		</c:if>
	</table>
</body>
</html>