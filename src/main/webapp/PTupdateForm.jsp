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
<title>PT이용권 등록</title>
<link href="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/jquery/3.6.0/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.kr.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
<script type="text/javascript">

</script>
<style type="text/css">
/* 	table { width: 900px; margin: auto; border: none;} */
/* 	th{ padding: 5px; text-align: center; background-color: silver; border: 1px solid gray;} */
/* 	td{ padding: 5px; text-align: center;  border: 1px solid gray;} */
	.title { color:white; font-size: 18pt; text-align: center; padding: 10px; font-weight: bold;}
	#body-wrapper{ padding: 8px 16px; background: linear-gradient(to bottom, rgba(26, 111, 118, 1) 50%, rgba(40, 30, 101, 1) 100%, rgba(125, 185,232,1) 100%)}
	.container{ background-color: black; margin-top:70%;}
	.col-sm-2{ color: white;}
</style>
</head>
<body>
	<div class="clo-bg">
		<div class="container" style="border: 5px solid gray;padding: 15px;margin-top: 30px;border-radius: 30px;">
			<form action="PTupdateOk.jsp" method="post">
			<div class="title" >회원정보 등록하기</div>
				<div class="mb-3 row">
				  	<label for="userid" class="col-sm-2 col-form-label">이름</label>
				  	<div class="col-sm-2">
					<input type="hidden" name="id" value="${VO.id }" />
					<input type="text" class="form-control" id="id" name="id" value="${VO.name }" readonly="readonly">
					</div>
					<div class="col-sm-1 col-form-label" id="msg"></div>
					<div class="col-sm-2"></div>
				  	<label for="password" class="col-sm-2 col-form-label">이메일</label>
				  	<div class="col-sm-3">
					<input type="email" class="form-control" name="email" value="${VO.email }" readonly="readonly">
					</div>
				</div>
				<div class="mb-3 row">
				  	<label for="name" class="col-sm-2 col-form-label">pt이용권</label>
				  	<div class="col-sm-3">
					<input type="number" class="form-control" id="pt" name="pt" value="${VO.pt }" required="required">
					</div>
					<div class="col-sm-2"></div>
				  	<label for="email" class="col-sm-2 col-form-label">트레이너아이디</label>
				  	<div class="col-sm-3">
					<input type="text" class="form-control" id="myTrainer" name="myTrainer" value="${VO.myTrainer }" required="required">
					</div>
				</div>
				<div class="mb-3 row">
				  	<label for="name" class="col-sm-2 col-form-label">등록일</label>
				  	<div class="col-sm-3">
					<input type="date" class="form-control" name="startDay1" value="${VO.startDay }" required="required">
					</div>
					<div class="col-sm-2"></div>
				  	<label for="email" class="col-sm-2 col-form-label">만기일</label>
				  	<div class="col-sm-3">
					<input type="date" class="form-control" name="endDay1" value="${VO.endDay }" required="required">
					</div>
				</div>
				<div class="mb-3 row">
					<div class="col-sm-12" style="text-align: right;">
						  <input type="submit" class="btn-check" id="submitBtn" >
						  <label class="btn btn-outline-light" for="submitBtn">등록 및 수정 </label>
						  <c:url var="url" value="UserList.jsp"></c:url>
						  <input type="button" class="btn-check" id="cancelBtn" onclick="location.href='${url}'">
						  <label class="btn btn-outline-light" for="cancelBtn">돌아가기</label>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>