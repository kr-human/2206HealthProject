<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트레이너 PT일정표</title>
<!-- fullcalendar 시작 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
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
		var calendarEl = document.getElementById('calendar');// 달력이 그려질 요소
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth', // 초기 보이는 모양
			locale : 'ko', // 언어 지정
			headerToolbar : { // 툴바 모양지정
				start : 'dayGridMonth,timeGridWeek,timeGridDay,listMonth', // 월, 주, 일, 일정목록
				center : 'title', // 중앙 년/월
				end : 'prevYear,prev,today,next,nextYear' // 이전년도, 이전월, 오늘, 다음월, 다음년도
			},
			buttonText : { // 버튼의 텍스트 변경시 사용
				today : '오늘',
				month : '월',
				week : '주',
				day : '일',
				list : '목록'
			},
			/*// title의 모양 변경시 사용
			views: {
			    dayGridMonth: { 
			      titleFormat: { year: 'numeric', month: '2-digit', day: '2-digit' }
			    }
			  },
			height: 500 // 높이 변경
			*/
			editable: true, // 이벤트 수정 가능하게 한다.
			// 테마 변경 : 
			themeSystem: 'bootstrap5',
			// 이벤트 등록하기 : Ajax로 DB값을 읽어온다.
			events: function(info, successCallBack, failureCallBack){
					$.ajax({
						type:"get",
						url:"SelectPTClass.jsp",
						datatype:"json",
// 						data : {"ptTime":"2022-06", "t_id":"t1"}, // 이건 뭘까 ? 현웅이파일에 있는거
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
						error : function(){
							alert('error!!!!');
						}
					});
			},
// 			// 이벤트 연결될때
// 			eventDidMount: function(info) {
// 				 // console.log(info.event.extendedProps);
// 			}
		});
		calendar.setOption('height', 700); // 실시간 높이 변경
		calendar.render();
		
		// 날짜를 클릭했을때
		calendar.on('dateClick', function(info) {
			console.log(JSON.stringify(info));
		});
		// 일정을 클릭했을때
		calendar.on('eventClick', function(info) {
			// 일정을 입력할 수 있는 창을 띄워 일정을 수정/삭제가 가능 하도록 해야 한다.
			console.log(JSON.stringify(info));
			console.log(JSON.stringify(info.event));
			console.log(JSON.stringify(info.event.extendedProps));
		});
	});
</script>
<style type="text/css">
	#calendar {
		width: 90%;
		margin: auto;
		border: 0px solid gray;
	}
</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>