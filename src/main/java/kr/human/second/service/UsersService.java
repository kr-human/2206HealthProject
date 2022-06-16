package kr.human.second.service;



import java.util.List;

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
	
	
}
