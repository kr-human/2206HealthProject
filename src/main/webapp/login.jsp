<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: linear-gradient(to right, #b92b27, #1565c0)
}
#mainWrapper{
width: 100%;
text-align: center;
}
.login-container{
    margin-bottom:20px;
    border:none;
   
}


.box {
    width: 500px;
    padding: 80px;
    left: 37%;
    position: absolute;
    background: #191919;
    text-align: center;
    transition: 0.25s;
    margin-top: 100px;

}

.box input[type="text"],
.box input[type="password"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 10px 10px;
    width: 250px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s
}

.box h1 {
    color: white;
    text-transform: uppercase;
    font-weight: 500
}

.box input[type="text"]:focus,
.box input[type="password"]:focus {
    width: 300px;
    border-color: #2ecc71
}

.box input[type="submit"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #2ecc71;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer
}

.box input[type="submit"]:hover {
    background: #2ecc71
}

</style>

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
	<script src="https://kit.fontawesome.com/3c36eed32b.js" ></script>
		
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/css/app.css" />
</head>

<body>
	<div id="mainWrapper">
		<div class="login-container">
					<form action="${pageContext.request.contextPath }/loginOk.jsp" method="post" class="box">
						<%-- 로그인 실패시 에러메세지 출력 --%>
						<c:if test="${not empty error }">
							<div style="color: red;font-size: 15pt;">${error }</div>
						</c:if>
						<%-- 로그아웃시 메세지 출력 --%>
						<c:if test="${not empty msg }">
							<div style="color: green;font-size: 15pt;">${msg }</div>
						</c:if>
						<h1>Login</h1>
						<p class= "text-muted">Please enter your login and password!</p>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username">								
							</label>
							<input type="text" class="form-control" id="id" name="id" placeholder="Enter UserID" required>
						</div>
						
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password">								
							</label>
							 <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
						</div>
						
						
						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
						<div style="text-align: center;margin: 15px;">
							<!-- 여기서 아이디 찾기 패스워드찾기 기능 추가  -->
							[<a href="${pageContext.request.contextPath }">HOME</a>]
						</div>
					</form>
				
		</div>
	</div>

</body>
</html>


