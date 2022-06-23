package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationVO;

public class ReservationDAOImpl implements ReservationDAO{
	//------------------------------------------------------
	// 싱글톤을 만들자
	private static ReservationDAO instance = new ReservationDAOImpl();
	private ReservationDAOImpl() {};
	public static ReservationDAO getInstance() {
		return instance;
	}
	//------------------------------------------------------
	@Override
	public List<PTClassVO> selectPtOneDay(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectList("reservation.selectPtOneDay", map);
	}
	@Override
	public void insertReservation(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException {
		sqlSession.selectOne("reservation.insertReservation", ptClassVO);
	}
	@Override
	public void deleteReservation(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException {
		sqlSession.selectOne("reservation.deleteReservation", ptClassVO);
	}
	@Override
	public List<ReservationVO> selectMyReservation(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectList("reservation.selectMyReservation", u_id);
	}
	@Override
	public void checkUpdate(SqlSession sqlSession, PTClassVO ptClassVO) throws SQLException {
		sqlSession.update("reservation.checkUpdate", ptClassVO);
	}
	@Override
	public int CheckMyReservation(SqlSession sqlSession, HashMap<String, Object> map) throws SQLException {
		return sqlSession.selectOne("reservation.CheckMyReservation", map);
	}
}
