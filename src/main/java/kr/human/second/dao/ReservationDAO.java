package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.ibatis.sqlmap.client.SqlMapException;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationInfoVO;
import kr.human.second.vo.ReservationVO;

public interface ReservationDAO {
	// 일별 pt수강 목록 가져오기
	List<PTClassVO> selectPtOneDay(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
	// 예약 하기
	void insertReservation(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException;
	// 예약 취소하기
	void deleteReservation(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException;
	// 나의 예약목록 확인하기
	List<ReservationVO> selectMyReservation(SqlSession sqlSession, String u_id) throws SQLException;
	// 예약/예약취소시 ptClass의 check값 변경
	void checkUpdate(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException;
	// 나의 예약체크하기
	int CheckMyReservation(SqlSession sqlSession, HashMap<String, Object> map) throws SQLException;
	// 특정 트레이너 PT수업에 예약된 회원 이름가져오기
	List<ReservationInfoVO> SelectByReservationInfo(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
	// ptclass를 삭제하자
	void deletePT(SqlSession sqlSession, int idx) throws SQLException;
	// ptclass를 삭제하기 위해서 reservation에 있는 놈을 삭제하자
	void deleteRe(SqlSession sqlSession, int idx) throws SQLException;
	
	// 예약을 하면 pt권 하나를 감소
	void MinusPT(SqlSession sqlSession, String id) throws SQLException;
	// 예약을 취소 하면 pt권 하나를 증가
	void PlusPT(SqlSession sqlSession, String id) throws SQLException;
	// 예약하기전에 pt권이 있는지 확인을하자
	int CheckPT(SqlSession sqlSession, String id) throws SQLException;
	
}
