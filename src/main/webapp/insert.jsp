<%@page import="kr.human.second.vo.ReservationVO"%>
<%@page import="kr.human.second.service.UsersServiceImpl"%>
<%@page import="kr.human.second.service.UsersService"%>
<%@page import="kr.human.second.vo.PTClassVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 스트링으로 받기 
	String t_id = request.getParameter("t_id");
	String pt_code = request.getParameter("pt_code");
	String u_id = request.getParameter("u_id");
	
	System.out.println("t_id : " + t_id);
	System.out.println("pt_code : " + pt_code);
	System.out.println("u_id : " + u_id);
	
	// 받은 데이터를 VO에 넣자
	ReservationVO vo = new ReservationVO();
	vo.setPt_code(pt_code);
	vo.setT_id(t_id);
	vo.setU_id(u_id);
	
	// 서비스를 호출하여 저장을 수행하면 된다.
	UsersServiceImpl.getInstance().InsertReservation(vo);
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
<style type="text/css">

</style>
</head>
<body>
	
</body>
</html>