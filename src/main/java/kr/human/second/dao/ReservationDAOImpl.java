package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationInfoVO;
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
	@Override
	public List<ReservationInfoVO> SelectByReservationInfo(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectList("reservation.SelectByReservationInfo", map);
	}
	@Override
	public void deletePT(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("pt.P_delete",idx);
	}
	@Override
	public void deleteRe(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("reservation.deletePT",idx);
		
	}
	@Override
	public void MinusPT(SqlSession sqlSession, String id) throws SQLException {
		sqlSession.update("reservation.MinusPt",id);
		
	}
	@Override
	public void PlusPT(SqlSession sqlSession, String id) throws SQLException {
		sqlSession.update("reservation.PulsPt",id);
		
	}
	@Override
	public int CheckPT(SqlSession sqlSession, String id) throws SQLException {
		return sqlSession.selectOne("reservation.seletByPtCoupon",id);
	}
}
