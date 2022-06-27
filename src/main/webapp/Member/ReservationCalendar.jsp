<%@page import="java.io.PrintWriter"%>
<%@page import="kr.human.second.vo.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%

	String myTrainer = "";
	String id = "";
	int level = 0;
	System.out.println(session.getAttribute("memberVO"));
	if(session.getAttribute("memberVO")!=null){
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		myTrainer = memberVO.getMyTrainer();
		id = memberVO.getId();
		level = memberVO.getLev();
		System.out.println("memberVO : " + memberVO);
		System.out.println(myTrainer + " : " + id);
	}else{
		out.println("<script>alert('로그인후 이용해주세요'); location.href='../login.jsp';</script>");
		return;
	}
	
	request.setAttribute("myTrainer", myTrainer);
	request.setAttribute("id", id);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- fullcalendar 시작 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
	<!-- CSS only -->

<!-- fullcalendar 종료 -->
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
<%-- 날짜모양 이쁘게 출력하기 위한 자바스크립트 라이브러리 --%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<%-- 숫자를 이쁘게 출력하기 위한 자바스크립트 라이브러리 --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>

<script type="text/javascript">
	$(function() {
		var calendarEl = document.getElementById('calendar'); // id찾기
		console.log('calendar', calendarEl);
		// 지정 아이디를 넣어 객체 생성 : (표시할객체, 옵션)
		var calendar = new FullCalendar.Calendar(calendarEl, {
			locale : 'ko', // 로케일
			initialView : 'dayGridMonth',
			headerToolbar : {
				start : 'dayGridMonth,timeGridWeek,timeGridDay,listMonth', // will normally be on the left. if RTL, will be on the right
				center : 'title',
				end : 'prevYear,prev,today,next,nextYear' // will normally be on the right. if RTL, will be on the left
			},
			buttonText : {
				today : '오늘',
				month : '월',
				week : '주',
				day : '일',
				list : '목록'
			},
			height:850,
			editable: true, // 이벤트 수정 가능하게 한다.
			// 이벤트
			events : function(info, successCallback, failureCallback) {
				// ajax 처리로 데이터를 로딩 시킨다. 
				$.ajax({
					type : "get",
					url : "selectEvent.jsp",
					dataType : "json",
					data : {"pttime":info.dateStr, "mytrainer":'${myTrainer}'},
					success: function(data){
						
						//alert('성공\n' + data);
						// 받은 데이터를 가공한다. 입맞에 맞게....
						$.each(data, function(index, item){
							//alert(item.allday);
							if(item.allday){ // 하루 종일이면 시간이 필요 없으므로 시간을 지운다.
								//alert(item.start + "\n" + item.end);
								item.start = item.start.substr(0, 10);  
								item.end = item.end.substr(0, 10);
								//alert(item.start + "\n" + item.end);
							}else{ // 하루 중 일부라면 종료날짜를 지운거 
								//alert(item.start + "\n" + item.end);
								item.end='';
								//alert(item.start + "\n" + item.end);
							}
						});
						successCallback(data);
					},
					fail : function(){
						//('실패!!')
					}
				});
			}
		});
		calendar.render(); // 그려줘!!!
		
		
		// 날짜를 클릭했을때
		calendar.on('dateClick', function(info) {
			// 일정을 입력할 수 있는 창을 띄워 일정을 입력받아야 한다.
			/*
				title varchar2(50), 
				writer varchar2(50), 
				content varchar2(1000), 
				start1 date, 
				end1 date, 
				allDay number(1), 
				textColor varchar(50), 
				backgroundColor varchar2(50), 
			*/
			//날짜에 맞춰서 조회
			
			$("#reserveDiv").empty();
			$("#inputPTInfo").css('display','none');
			
	// 회원계정일때 
	<%if(level == 1) { %>
			$(".insertPT").css('display','none');
			$.ajax({
				type : "get",
				url : "selectEventDay.jsp",
				dataType : "json",
				data : {"pttime":info.dateStr, "myTrainer":'<%=myTrainer%>', "id" : '${id}'},
				success: function(data){
					console.log('dataClick',data, data.length);
					var date = new Date(+new Date() + 3240 * 10000).toISOString().replace("T", " ").replace(/\..*/, '');
					$("#reserveDiv").append("<thead><tr><th style='width:50%' scope='col'>PT시간</th><th>트레이너</th><th style='width:25%'>예약</th></tr></thead>");
					if(data.length > 0){
						
						//alert('성공\n' + data);
						// 받은 데이터를 가공한다. 입맞에 맞게....
					$("#reserveDiv").append("<tbody>");
					$.each(data, function(index, item){
							console.log('index', index, item);
						if(item.pttime > date){
							if(item.r_check=="T"){ // oracle에서 boolean타입이 없는데 어떻게 하지? 근데 가져온값이 false야... 머징? 이건 내일 트레이너가 ptclass만들때 True로 바꿔주도록하자!
										
								$("#reserveDiv").append("<tr><td>"+item.ptTime+"</td><td>"+item.id+"</td><td><button class='btn btn-success insertBtn' value='"+item.idx+"'>예약하기</button></td></tr>");
									
							}else{
								if(item.count){ // reservation테이블에서 현재 사용자 id로 예약이 되어있다면 예약취소 버튼을 출력하도록하자.
									$("#reserveDiv").append("<tr><td>"+item.ptTime+"</td><td>"+item.id+"</td><td><button class='btn btn-danger deleteBtn' value='"+item.idx+"'>예약취소</button></td></tr>");
								}else{
									$("#reserveDiv").append("<tr><td>"+item.ptTime+"</td><td>"+item.id+"</td><td>예약불가</td></tr>");
									}
								}
						} else {
								$("#reserveDiv").append("<tr><td>"+item.ptTime+"</td><td>"+item.id+"</td><td>시간초과</td></tr>");
						}
					});
						$("#reserveDiv").append("</tbody>");
					} else {
						$("#reserveDiv").append("<tr><td colspan='3'>수업이 없습니다.</td></tr>");
					}
				},
				fail : function(){
					//('실패!!')
				}
			});
	<% } else{ %>
//-----------------------------------------------------------------------------------------------------------------
//트레이너 계정일때
		

		$.ajax({
			type : "get",
			url : "MyPTClass.jsp",
			dataType : "json",
			data : {"pttime":info.dateStr, "id" : '${id}'},
			success: function(data){
				console.log('dataClick',data, data.length);
				var date = new Date(+new Date() + 3240 * 10000).toISOString().replace("T", " ").replace(/\..*/, '');
				console.log('date', date);
				
				$("#reserveDiv").append("<thead><tr><th style='width:50%' scope='col'>PT시간</th><th>예약된 회원</th><th style='width:25%'>예약현황</th></tr></thead>");
				if(data.length > 0){
					
					//alert('성공\n' + data);
					// 받은 데이터를 가공한다. 입맞에 맞게....
					$("#reserveDiv").append("<tbody>");
					$.each(data, function(index, item){
						console.log('index', index, item);
						if(item.pttime > date){ // pt수업시간이 지났다면 pt취소를 할수없도록한다.
							$("#reserveDiv").append("<tr><td>"+item.pttime+"</td><td>"+(item.name!=null?item.name:'예약인원없음')+"</td><td><button class='btn btn-success cancelPT' value='"+item.idx+"'>PT취소</button></td></tr>");
						}else{
								$("#reserveDiv").append("<tr><td>"+item.pttime+"</td><td>"+(item.name!=null?item.name:'예약인원없음')+"</td><td>시간초과</td></tr>");
						}
					});
					$("#reserveDiv").append("</tbody>");
				}
				else {
					$("#reserveDiv").append("<tr><td colspan='3'>수업이 없습니다.</td></tr>");
				}
			},
			fail : function(){
				//('실패!!')
			}
		});
		
		
		
		// pt수업 취소하기
		$(document).on('click', '.cancelPT', function(){
	            var cancelPT = $(this);
	            var tr = cancelPT.parent().parent();
	            var td = tr.children();
	 
	            var idx = cancelPT.val();
	            console.log('idx', idx);
			
			// 값이 모두 유효하면 Ajax를 호출하여 저장을 수행하면 된다.
			$.ajax({
				type : "get",
				url : "CancelPT.jsp",
				data : { 
					"idx" : idx				
					},
				success: function(data){
					alert('PT수업 취소 완료!\n');
					location.reload(); // 화면 다시 읽어라
				},
				fail : function(){
					alert('실패\n');
				}
			});
			
			$("#inputContent").css('display','none');
		});
		
		
		
		
		// pt수업 등록 팝업 띄우기
		$(document).on('click','.insertPT', function(){
			// pt등록하기 버튼을 누르면 현재 팝업창이 없어지고
			// 새로운 pt등록하는 팝업을 띄우자
			$("#reserveDiv").css('display','none');
			$(".second").css('display','none');
			$("#inputPTInfo").css('display','block');
	
		});
		
		// pt등록하기
		$(document).on('click','.insertPTClass', function(){
			var pttime = $('.selectPTtime').val();
			console.log(pttime);

			$.ajax({
				type : "post",
				url : "insertPT.jsp",
				dataType : "json", 
				data : {
					"pttime" : pttime,
					"info" : info.dateStr,
					"id" : '${id}'
				},
				success: function(){
					alert('pt등록이 되었습니다.');
				},
				fail: function(){
					alert('pt등록 실패하였습니다.');
				}
			})
			
		});
		
		
<% } %>

			// 위의 항목을 입력받을 수 있는 입력폼을 띄워야 한다.
			// alert(info.dateStr + "를 눌렀냐!!");
			$("#inputContent").css('display','block');
			//$("#start1").val(info.dateStr);
			//$("#end1").val(info.dateStr);
			
		});
		
		// 일정을 클릭했을때
		calendar.on('eventClick', function(info) {
			// 일정을 입력할 수 있는 창을 띄워 일정을 수정/삭제가 가능 하도록 해야 한다.
			//alert(JSON.stringify(info.event));
			//console.log(JSON.stringify(info));
			// alert(info.event.title +"\n" + info.event.start +"\n" + info.event.end +"\n" + info.event.extendedProps.content);
		});
		
		// 일정위에 마우스가 올라가면
		calendar.on('eventMouseEnter', function(info) {
			// 일정을 이쁘게 보이기
			// alert(info.jsEvent.pageX + ',' + info.jsEvent.pageY); // 이벤트가 발생한 위치
			$("#viewContent").css('display','block').css('top', info.jsEvent.pageY-210).css('left',info.jsEvent.pageX-150);
			var content = "제목 : " + info.event.title + "<br>";
			if(info.event.extendedProps.allday)
				content += "시작 : " +  moment(info.event.start).format('YYYY년 MM월 DD일') + "<br>";
			else
				content += "시작 : " +  moment(info.event.start).format('YYYY년 MM월 DD일 HH:mm') + "<br>";
				
			if(info.event.end!=null)
				if(info.event.extendedProps.allday)
					content += "종료 : " + moment(info.event.end).format('YYYY년 MM월 DD일') + "<br>";
				else
					content += "종료 : " + moment(info.event.end).format('YYYY년 MM월 DD일 HH:mm') + "<br>";
			content += "내용 : " + info.event.extendedProps.content + "<br>";
			$("#viewContent").html(content);
			// alert("하하하\n" + info.event.title +"\n" + info.event.start +"\n" + info.event.end +"\n" + info.event.extendedProps.content);
		});
		// 일정위에서 마우스가 떠나면
		calendar.on('eventMouseLeave', function(info) {
			// 일정을 숨기기
			$("#viewContent").css('display','none');
		});
		
		// 이벤트를 옮기면
		calendar.on('eventDrop', function(info) {
			// 일정을 수정해줘야 한다.
			//alert("이동!!!!\n" + JSON.stringify(info.event) ); // 이벤트 전체 출력
			// alert(info.event.start + "\n" + info.event.end ); // 시작과 종료만 변경하면 된다.
			var id = info.event.id;
			var start = info.event.start;
			var end = info.event.end;
			if(end==null){
				// allDay가 false로 end를 사용하지 않는다. DB에 not null이면 에러가 발생하므로 아무날짜나 넣자
				end = start;
			}else{
				// DB에 날짜를 1일 줄여서 넣어야 한다.
				end.setDate(end.getDate()-1);
			}
			// alert(start + "\n" + end  + "\n" + id); // 수정시 id, start, end가 필요하다.
			// 여기에서 Ajax를 호출하여 서버의 update을 수행하여야 한다.
			$.ajax({
				type : "get",
				url : "updateDrop.jsp",
				data : {"id":id, "start1" : start, "end1":end},
				success: function(data){
					alert('이동 성공\n');
				},
				fail : function(){
					alert('이동 실패\n');
				}
			});
			
			
			
		});

		// 취소 버튼을 누르면 입력창이 사라져야 한다.  
		$(".cancelBtn").click(function() {
			$("#inputContent").css('display','none');
			$("#reserveDiv").empty();
		});
		

		// 예약하기 버튼을 누르면 입력창이 사라져야 한다.  
		$(document).on('click', '.insertBtn', function(){
	            var insertBtn = $(this);
	            var tr = insertBtn.parent().parent();
	            var td = tr.children();
	            
	            var pttime = td.eq(0).text();
	            var id = td.eq(1).text();
	            var idx = insertBtn.val();
	            console.log('pttime', pttime, 'id', 'idx', idx);
			
			
			// 값이 모두 유효하면 Ajax를 호출하여 저장을 수행하면 된다.
			$.ajax({
				type : "get",
				url : "insert.jsp",
				data : { 
					"id" : '<%=id%>', 
					"idx" : idx				
					},
				success: function(data){
					alert('예약 완료!\n');
					location.reload(); // 화면 다시 읽어라
				},
				fail : function(){
					alert('예약 실패\n');
				}
			});
			
			$("#inputContent").css('display','none');
		});
		
		// 예약취소 버튼을 누르면 입력창이 사라져야 한다.  
		$(document).on('click', '.deleteBtn', function(){
	            var deleteBtn = $(this);
	            var tr = deleteBtn.parent().parent();
	            var td = tr.children();
	            
	            var pttime = td.eq(0).text();
	            var id = td.eq(1).text();
	            var idx = deleteBtn.val();
	            console.log('pttime', pttime, 'id', '<%=id%>','idx', idx);
			
			
			// 값이 모두 유효하면 Ajax를 호출하여 저장을 수행하면 된다.
			$.ajax({
				type : "get",
				url : "delete.jsp",
				data : { 
					"id" : '<%=id%>', 
					"idx" : idx				
					},
				success: function(data){
					alert('예약 취소 완료!\n');
					location.reload(); // 화면 다시 읽어라
				},
				fail : function(){
					alert('예약 취소 실패\n');
				}
			});
			
			$("#inputContent").css('display','none');
		});

});
</script>
<style type="text/css">
	#viewContent {
		width: 300px; height: 200px; border: 3px solid gray; background-color: rgba(255, 255, 128, 1.0);
		position: absolute; top: 100px; left: 200px; display: none; z-index: 10;
	}
	#inputContent {
		width: 500px; border: 1px solid silver; background-color: #FFFFFF; border-radius: 8px;
		position: absolute; top: 200px; left: 500px; display: none; z-index: 10;
	}
	
	table {
	    width: 100%;
	    border: 1px solid #444444;
	    text-align: center;
	  }
	  th, td {
	    border: 1px solid #444444;
	    border-collapse;
	    padding: 10px;
	  }
	  
	  
	  
</style>
</head>
<body>
	<%-- 일정표 --%>
	<div id='calendar'></div>
	<%-- 내용 보이기 --%>
	<div id="viewContent"></div>
	<%-- 내용 입력하기 --%>
	<div id="inputContent" style="padding:10px">
		<h2 class="second">PT 예약하기</h2>
		<table id="reserveDiv" class="table" ></table>
				
		<div style="float: right; padding: 10px" class="second">
			<button class="btn btn-success insertPT" >PT시간 등록하기</button>
			<button class="btn btn-success cancelBtn" >닫기</button>
		</div>
		<div id="inputPTInfo" style="padding:10px">
			<h2>PT수업 등록</h2>
			<table id="resultPtTime" class="table"></table>
			<div style=" padding: 10px;">
				<div style="float: left;">
					<select class="form-select selectPTtime" aria-label="Default select example" style="float: left;">
	  					<option selected>Select PT Time</option>
	 					<option value="8:00">8:00</option>
	  					<option value="9:00">9:00</option>
	  					<option value="10:00">10:00</option>
	  					<option value="11:00">11:00</option>
	  					<option value="13:00">13:00</option>
	  					<option value="14:00">14:00</option>
	  					<option value="15:00">15:00</option>
	  					<option value="16:00">16:00</option>
	  					<option value="17:00">17:00</option>
	  					<option value="18:00">18:00</option>
	  					<option value="19:00">19:00</option>
					</select>
				</div>
				<div style="float: right;">	
					<button class="btn btn-success insertPTClass">등록하기</button>
					<button class="btn btn-success cancelBtn">닫기</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>