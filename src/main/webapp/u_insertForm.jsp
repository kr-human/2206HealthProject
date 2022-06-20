<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
<%-- 다음 우편번호 API --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){
	$("#u_birth").datepicker({
		format : "yyyy-mm-dd", // 달력에서 클릭시 표시할 값 형식
		language : "kr", // 언어(js 추가가 필요하다.)
		startDate : "-30y",
	});
	// 아이디 입력시 Ajax를 호출하여 아이디 중복확인하기	
	$("#u_id").keyup(function() {
		var value = $(this).val();
		if(value!=null && value.length>=4){
			// alert(value);
			$.ajax("u_idCheck.jsp", {
				type : "GET",
				data : {"u_id":value},
				success : function(data){
					//alert(typeof(data) + "\n" + data )
					if(data*1==0){
						$("#msg").html("사용가능").css('color','blue');
					}else{
						$("#msg").html("사용불가능").css('color','red');
					}
				},
				error : function(){
					alert('에러다!!!!')
				}
			});
		}else{
			$("#msg").html("").css('color','black');
		}
	});
	//닉네임 중복확인
	$("#u_nicname").keyup(function() {
		var value = $(this).val();
		if(value!=null && value.length>=4){
			// alert(value);
			$.ajax("u_nicnameCheck.jsp", {
				type : "GET",
				data : {"u_nicname":value},
				success : function(data){
					//alert(typeof(data) + "\n" + data )
					if(data*1==0){
						$("#msg").html("사용가능").css('color','blue');
					}else{
						$("#msg").html("사용불가능").css('color','red');
					}
				},
				error : function(){
					alert('에러다!!!!')
				}
			});
		}else{
			$("#msg").html("").css('color','black');
		}
	});
});

function daumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('u_postcode').value = data.zonecode;
            document.getElementById("u_addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("u_addr2").focus();
        }
    }).open();
}

// 폼검증하는 자바스크립트 함수
function formCheck(){
	var value = $("#u_id").val();
	if(value==null || value.trim().length==0){
		alert('아이디는 반드시 입력해야 합니다.');
		$("#u_id").val("");
		$("#u_id").focus();
		return false;
	}
	if($("#msg").html()!="사용가능"){
		alert('사용 불가능한 아이디입니다.');
		$("#u_id").val("");
		$("#msg").text("");
		$("#u_id").focus();
		return false;
	}
	var value = $("#u_password").val();
	if(value==null || value.trim().length==0){
		alert('사용자 비빌번호는 반드시 입력해야 합니다.');
		$("#u_password").val("");
		$("#u_password").focus();
		return false;
	}
	var value = $("#u_nicname").val();
	if(value==null || value.trim().length==0){
		alert('사용자 닉네임은 반드시 입력해야 합니다.');
		$("#u_nicname").val("");
		$("#u_nicname").focus();
		return false;
	}
	var value = $("#u_name").val();
	if(value==null || value.trim().length==0){
		alert('사용자 이름은 반드시 입력해야 합니다.');
		$("#u_name").val("");
		$("#u_name").focus();
		return false;
	}
	var value = $("#u_birth").val();
	if(value==null || value.trim().length==0){
		alert('생년월일은 반드시 입력해야 합니다.');
		$("#u_birth").val("");
		$("#u_birth").focus();
		return false;
	}
	var value = $("#u_postcode").val();
	if(value==null || value.trim().length==0){
		alert('우편번호는 반드시 입력해야 합니다.');
		$("#u_postcode").val("");
		$("#u_postcode").focus();
		return false;
	}
	var value = $("#u_addr1").val();
	if(value==null || value.trim().length==0){
		alert('주소는 반드시 입력해야 합니다.');
		$("#u_addr1").val("");
		$("#u_addr1").focus();
		return false;
	}
	var value = $("#u_addr2").val();
	if(value==null || value.trim().length==0){
		alert('상세주소는 반드시 입력해야 합니다.');
		$("#u_addr2").val("");
		$("#u_addr2").focus();
		return false;
	}
	var value = $("#u_email").val();
	if(value==null || value.trim().length==0){
		alert('이메일 주소는 반드시 입력해야 합니다.');
		$("#u_email").val("");
		$("#u_email").focus();
		return false;
	}
	var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    if (!regEmail.test(value)) {
    	alert('이메일 주소 형식이 잘못되었습니다.');
		$("#u_email").val("");
		$("#u_email").focus();
		return false;
    }
}
</script>

<style type="text/css">
	.title { font-size: 18pt;text-align: center; padding: 10px; font-weight: bold;}
</style>
</head>
<body>
	<div class="container" style="border: 1px solid gray;padding: 15px;margin-top: 30px;border-radius: 30px;">
		<form action="insertOk.jsp" method="post" onsubmit="return formCheck();">
			<div class="title" >회원가입하기</div>
			<div class="mb-3 row">
			  	<label for="u_id" class="col-sm-2 col-form-label">사용자 아이디</label>
			  	<div class="col-sm-2">
				<input type="text" class="form-control" id="u_id" name="u_id" placeholder="아이디입력" required>
				</div>
				<div class="col-sm-1 col-form-label" id="msg"></div>
				<div class="col-sm-2"></div>
			  	<label for="u_password" class="col-sm-2 col-form-label">사용자 비밀번호</label>
			  	<div class="col-sm-3">
				<input type="password" class="form-control" id="u_password" name="u_password" placeholder="비밀번호입력"  required>
				</div>
			</div>
			<div class="mb-3 row">
			  	<label for="u_name" class="col-sm-2 col-form-label">사용자 이름</label>
			  	<div class="col-sm-3">
				<input type="text" class="form-control" id="u_name" name="u_name" placeholder="사용자 이름 입력" required>
				</div>
				<div class="col-sm-2"></div>
			  	<label for="u_birth" class="col-sm-2 col-form-label">생년월일</label>
			  	<div class="col-sm-3">
				<input type="text" class="form-control" id="u_birth" name="u_birth" placeholder="사용자 생년월일 입력" required>
				</div>
			</div>
			<div class="mb-3 row">
			  	<label for="u_email" class="col-sm-2 col-form-label">사용자 이메일</label>
			  	<div class="col-sm-3">
				<input type="email" class="form-control" id="u_email" name="u_email" placeholder="사용자 이메일 입력" required>
				</div>
				<div class="col-sm-2"></div>
			  	<label for="u_nicname" class="col-sm-2 col-form-label">사용자 닉네임</label>
			  	<div class="col-sm-3">
				<input type="text" class="form-control" id="u_nicname" name="u_nicname" placeholder="사용자 닉네임 입력" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-2">
			  	  <label for="gender1" class="col-sm-2 col-form-label">남자</label>
				  <input class="form-check-input" type="radio" name="gender" id="gender1" value="M" checked>
				</div>
				<div class="col-sm-2">
			  	  <label for="gender2" class="col-sm-2 col-form-label">여자</label>
				  <input class="form-check-input" type="radio" name="gender" id="gender2" value="F">
				 </div> 
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="u_postCode">우편번호</label>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="u_postCode" id="u_postCode" readonly  required onclick="daumPostcode();">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-2">
				  <input type="button" class="btn-check" id="zipCodebtn" onclick="daumPostcode();">
				  <label class="btn btn-outline-primary" for="zipCodebtn">우편번호찾기</label>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="u_addr1">주소</label>
				<div class="col-sm-10">
				  <input class="form-control" type="text" name="u_addr1" id="u_addr1" readonly  required onclick="daumPostcode();">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="u_addr2">상세주소</label>
				<div class="col-sm-10">
				  <input class="form-control" type="text" name="u_addr2" id="u_addr2"  required>
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-12" style="text-align: right;">
					  <input type="submit" class="btn-check" id="submitBtn" >
					  <label class="btn btn-outline-success" for="submitBtn">회원가입</label>
					  <input type="reset" class="btn-check" id="resetBtn" >
					  <label class="btn btn-outline-success" for="resetBtn">다시쓰기</label>
					  <input type="button" class="btn-check" id="cancelBtn" onclick="location.href='${pageContext.request.contextPath}'">
					  <label class="btn btn-outline-success" for="cancelBtn">돌아가기</label>
				</div>
			</div>
		</form>
	</div>
</body>
</html>