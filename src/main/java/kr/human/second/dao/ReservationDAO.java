package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import kr.human.second.vo.PTClassVO;
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
}
