<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<<<<<<< HEAD
<%-- 	${sessionScope.memberVO } --%>
=======
	<%--session에 들어오는 memberVO 확인하는 것 --%>
	<%-- ${sessionScope.memberVO }--%>
	
	
>>>>>>> hwan91
	<c:if test="${empty sessionScope.memberVO }">
		<a href="insertForm.jsp">회원가입</a>
		<a href="login.jsp">로그인</a>
	<hr />
		<p>본문 내용</p>
	</c:if>

	<c:if test="${not empty sessionScope.memberVO && sessionScope.memberVO.lev == 1}">
		${sessionScope.memberVO.id }(${sessionScope.memberVO.name })님 반갑습니다 <br>
		<h1>유저</h1>
		<a href="c.jsp">나의 정보 수정</a>
		<a href="logout.jsp">로그아웃</a>
	<hr />
		<a href="a.jsp">예약 하기</a> 
		<a href="b.jsp">나의 강사보기</a> 
	</c:if>
<<<<<<< HEAD
	
	<c:if test="${not empty sessionScope.memberVO && sessionScope.memberVO.lev == 3}">
      ${sessionScope.memberVO.id }(${sessionScope.memberVO.name })님 반갑습니다 <br>
      <h1>강사</h1>
	  <a href="updateForm.jsp">정보수정</a>
      <a href="logout.jsp">로그아웃</a>
	<hr />
      <a href="UserList.jsp">회원관리</a>
	  <a href="${pageContext.request.contextPath }/TrainerPTMain.jsp">PT관리</a>
	  <a href="Notice.jsp">공지사항</a>
   </c:if>

=======
	 --%>
		
		<c:if test="${not empty sessionScope.memberVO && sessionScope.memberVO.lev == 1}">
			회원 ${sessionScope.memberVO.name }님 반갑습니다 <br>
			
			<a href="a.jsp">예약 하기</a> 
			<a href="b.jsp">나의 강사보기</a> 
			<a href="updateForm.jsp">나의 정보 수정</a>
			<a href="logout.jsp">로그아웃</a>
			<a href="deleteForm.jsp">회원탈퇴</a>
		</c:if>
		<c:if test="${not empty sessionScope.memberVO && sessionScope.memberVO.lev == 3}">
	      강사 ${sessionScope.memberVO.name }님 반갑습니다 <br>
	      
	      <a href="d.jsp">회원목록보기</a> 
	      <a href="e.jsp">예약 등록</a> 
	      <a href="f.jsp">게시판(공지사항)</a>
	      <a href="logout.jsp">로그아웃</a>
	   </c:if>
 		 	
>>>>>>> hwan91
</body>
</html>