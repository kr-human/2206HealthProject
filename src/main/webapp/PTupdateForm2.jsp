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
	String trainerid = ((MemberVO)session.getAttribute("memberVO")).getId();
	MemberVO MVO = TrainerServiceImpl.getInstance().SelectByUserInfo(trainerid);
	if(MVO==null){ // 글이 없다.
		response.sendRedirect("UserList.jsp");
		return;
	}
	// EL로 출력하기 위하여 영역에 저장한다.
	request.setAttribute("Mvo", MVO);
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
// 	function formCheck(){
// 		var value = $("#myTrainer").val();
// 		if(value==null || value.trim().length==0){
// 			alert('트레이너아이디는 반드시 등록해야 합니다.');
// 			$("#myTrainer").val("");
// 			$("#myTrainer").focus();
// 			return false;
// 		}
// 	}
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
				<input type="text" name="name" value="${Mvo.name }" readonly="readonly"/>
			</td>
			<td>이메일</td>
			<td style="text-align: left;">
				<input type="email" name="email" value="${Mvo.email }" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>pt이용권</td>
			<td style="text-align: left;"> 
				<input type="number" name="pt" id="pt" value="${Mvo.pt }" required="required"/>
			</td>
			<td>트레이너아이디</td>
			<td style="text-align: left;">
				<input type="text" name="myTrainer" id="myTrainer" value="${Mvo.myTrainer }" required="required"/>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td style="text-align: left;"> 
				<input type="date" name="startDay" value="${Mvo.startDay }" required="required"/>
			</td>
			<td>만기일</td>
			<td style="text-align: left;">
				<input type="date" name="endDay" value="${Mvo.endDay }" required="required"/>
			</td>
		<tr>
			<td colspan="4" style="text-align: right;border: none;">
				<input type="submit" value=" 수정하기 " />
				<c:url var="url" value="UserList.jsp"></c:url>
				<input type="button" onclick="location.href='${url}'" value=" 돌아가기 "/>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>