<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainerlayout</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}

li {
	list-style-type: none;
}

.hbody {
	background-color: black;
	width: 100%;
	height: 110px;
}

.nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px;
	color: white;
}

.mashtitle {
	font-size: 2em;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 20px;
	color: white;
}

.mashtitle>a {
	color: white;
	text-decoration: none;
}
/*웹 브라우저 가로의 최소 너비가 625px일 때(625px 이상일 때)*/
@media screen and (min-width: 625px) {
	#menu {
		display: flex;
	}
	#menu>li {
		padding: 20px 30px;
		font-size: 20px;
	}
	li>a {
		color: white;
		text-decoration: none;
	}
}
/*웹 브라우저 가로의 최대 너비가 625px일 때(625px 이하일 때)*/
@media screen and (max-width: 625px) {
	.nav {
		padding: 30px 40px;
	}
	#menu {
		display: none;
	}
}

.is {
	font-size: 20px;
	margin-right: 20px;
}

/* footer 하단 고정 */
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
}

#body-wrapper {
	min-height: 100%;
	position: relative;
}

#body-content {
	padding-bottom: 200px;
}

footer {
	width: 100%;
	height: 200px; /* footer의 높이 */
	position: absolute;
	bottom: 0;
	left: 0;
	background-color: black;
	align-content: center;
	text-align: center;
	font-size: 16px;

}

.footer>* {
	color: white;
}
/* footer 하단 고정 */
</style>
<sitemesh:write property='head'/>
</head>
<body>
	<header>
		<section class="hbody">
			<article class="nav">
				<div class="mashtitle">
					<a href="./index.html">로고</a>
				</div>
				<ul id="menu">
					<c:if test="${not empty sessionScope.memberVO }">
						<c:if test="${sessionScope.memberVO.lev == 3}">
							<li><a href="${pageContext.request.contextPath }/Member/ReservationCalendar.jsp">PT 등록</a> </li>
							<li><a href="${pageContext.request.contextPath }/UserList.jsp">회원관리</a></li>
							
							<li><a href="${pageContext.request.contextPath }/Notice/index.jsp">공지사항</a></li>
							<li><a href="${pageContext.request.contextPath }/updateForm.jsp">정보수정</a></li>
							<li><a href="${pageContext.request.contextPath }/logout.jsp">로그아웃</a></li>
						</c:if>
						<c:if test="${sessionScope.memberVO.lev == 1}">
							<li><a href="${pageContext.request.contextPath }/b.jsp">나의 강사보기</a> </li>
							<li><a href="${pageContext.request.contextPath }/Member/ReservationCalendar.jsp">예약 하기</a>  </li>
													
							<li><a href="${pageContext.request.contextPath }/Notice/index.jsp">공지사항</a></li>
							<li><a href="${pageContext.request.contextPath }/updateForm.jsp">정보수정</a></li>
							<li><a href="${pageContext.request.contextPath }/logout.jsp">로그아웃</a></li>
							<li><a href="${pageContext.request.contextPath }/deleteForm.jsp">회원탈퇴</a></li>	
						</c:if>
					</c:if>

				</ul>
				<c:if test="${empty sessionScope.memberVO }">
					<div class="mashtitle">
						<a class="is" href="login.jsp">로그인</a> <a class="is"
							href="insertForm.jsp">회원가입</a>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.memberVO }">
					<c:if test="${sessionScope.memberVO.lev == 1}">
						${sessionScope.memberVO.name } 님 반갑습니다.
						<br />
						나의 PT이용권 : ${sessionScope.memberVO.pt }
						<br />
						등록일 : <fmt:formatDate value="${sessionScope.memberVO.startDay }" pattern="yyyy-MM-dd"/>
						<br />
						만기일 : <fmt:formatDate value="${sessionScope.memberVO.endDay }" pattern="yyyy-MM-dd"/>
					</c:if>
					<c:if test="${sessionScope.memberVO.lev == 3}">
						(${sessionScope.memberVO.name })님 반갑습니다.
					</c:if>
				</c:if>
			</article>
		</section>
	</header>
	<div id="body-wrapper">
		<div id="body-content">
			<%-- 이자리에 내가 쓴 본문의 내용이 나타나라 --%>
			<sitemesh:write property='body' />
		</div>
		<footer class="footer">
				<br/><br/><b>humanfitness Inc.&nbsp;&nbsp;경기 수원시 팔달구</b>
				<br><br><p>대표 : 휴먼&nbsp;&nbsp;&nbsp;&nbsp;사업자등록번호:001-01-00002</p>
				<p>대표번호: +82)123-4567&nbsp;&nbsp;&nbsp;팩스번호 : +82)323-8567&nbsp;&nbsp;&nbsp;홈페이지 : humanfitness.com </p>
		</footer>
	</div>
</body>
</html>