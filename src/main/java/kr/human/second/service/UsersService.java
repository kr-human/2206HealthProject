package kr.human.second.service;

<<<<<<< HEAD
import javax.servlet.http.HttpSession;

import kr.human.second.vo.UsersVO;

public interface UsersService {
	//아이디 중복 확인
	int u_idCheck(String u_id);	
	//닉네임 중복 확인
	int u_nicnameCheck(String u_nicname);
	//유저 로그인
	boolean u_login(String u_id, String u_password, HttpSession httpSession);
	//회원 가입 (저장)
	void u_insert(UsersVO usersVO,String urlAddress);
=======


import java.util.List;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public interface UsersService {
	
	// 1. pt예약하기
	void InsertReservation(ReservationVO reservationVO);
	
	// 2. 강사 확인하기
	TrainerVO TrainerCheck(UsersVO usersVO);
	
	// 3. pt예약 취소하기 (UsersDAOImpl.R_delete메서드 파라메터타입 HashMap으로 해야함)
	void ChangeReservation(ReservationVO reservationVO);
	
	// 4. 예약 확인하기
	List<ReservationVO> getReservation(UsersVO usersVO);
	
	// 4. 지정된 pt수업 자동 예약
	void AutoReservation(ReservationVO reservationVO);
	
	// 4. 예약 확인하기
		List<PTClassVO> selectPtOneMonth(PTClassVO ptClassVO);
		List<PTClassVO> selectPtOneDay(PTClassVO ptClassVO);
	
	
>>>>>>> hyunwoong(ver.2)
}
