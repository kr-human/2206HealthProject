package kr.human.second.service;


import java.util.HashMap;
import java.util.List;
import kr.human.second.vo.MemberVO;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationVO;

public interface MemberService {
	// 마이페이지의 정보를 출력해주자
	MemberVO selectMyInfo(String u_id);
	// 나의 트레이너 정보를 보여주자
	MemberVO selectMyTrainerInfo(String myTrainer);
	// 나의 정보를 수정하자
	void updateMember(MemberVO memberVO);
	// pt예약을 하자
	void insertReservation(ReservationVO reservationVO);
	// pt예약을 취소하자
	void deleteReservation(ReservationVO reservationVO);
	// 나의 예약목록을 보자
	List<ReservationVO> selectMyReservation(String u_id);
	// 일별 pt수강 목록을 가져오자
	List<PTClassVO> selectPtOneDay(HashMap<String, String> map);
}
