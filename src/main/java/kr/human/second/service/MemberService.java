package kr.human.second.service;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationInfoVO;
import kr.human.second.vo.ReservationVO;

public interface MemberService {
	// 마이페이지의 정보를 출력해주자
	MemberVO selectMyInfo(String u_id);
	// 나의 트레이너 정보를 보여주자
	MemberVO selectMyTrainerInfo(String myTrainer);
	// 나의 정보를 수정하자
	void updateMember(MemberVO memberVO);
	// 나의 예약목록을 보자
	List<ReservationVO> selectMyReservation(String u_id);
	// 일별 pt수강 목록을 가져오자
	List<PTClassVO> selectPtOneDay(HashMap<String, String> map);
	// 예약/예약취소시 ptClass의 check값 변경 및 예약 저장/삭제
	void checkUpdate(PTClassVO ptClassVO);
	// 나의 예약체크하기
	int CheckMyReservation(HashMap<String, Object> map);
	
	// 트레이너의 pt수업에 예약된 회원의 이름과 수업시간을 가져오자
	List<ReservationInfoVO> SelectByReservationInfo(HashMap<String, String> map);
}
