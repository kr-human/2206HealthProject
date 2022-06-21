package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;
import kr.human.second.vo.ReservationVO;

public interface ReservationDAO {
	// 일별 pt수강 목록 가져오기
	List<MemberVO> selectPtOneDay(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
	// 예약 하기
	void insertReservation(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException;
	// 예약 취소하기
	void deleteReservation(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException;
	// 나의 예약목록 확인하기
	List<ReservationVO> selectMyReservation(SqlSession sqlSession, String u_id) throws SQLException;
}
