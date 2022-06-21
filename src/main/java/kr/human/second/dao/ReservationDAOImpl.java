package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;
import kr.human.second.vo.ReservationVO;

public class ReservationDAOImpl implements ReservationDAO{
	//------------------------------------------------------
	// 싱글톤을 만들자
	private ReservationDAO instance = new ReservationDAOImpl();
	private ReservationDAOImpl() {};
	public ReservationDAO getInstance() {
		return instance;
	}
	//------------------------------------------------------
	@Override
	public List<MemberVO> selectPtOneDay(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectList("reservation.selectPtOneDay", map);
	}
	@Override
	public void insertReservation(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
		sqlSession.selectOne("reservation.insertReservation", reservationVO);
	}
	@Override
	public void deleteReservation(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
		sqlSession.selectOne("reservation.deleteReservation", reservationVO);
	}
	@Override
	public List<ReservationVO> selectMyReservation(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectList("reservation.selectMyReservation", u_id);
	}
}
