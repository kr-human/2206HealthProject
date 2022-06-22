package kr.human.second.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.MemberDAO;
import kr.human.second.dao.MemberDAOImpl;
import kr.human.second.dao.ReservationDAO;
import kr.human.second.dao.ReservationDAOImpl;
import kr.human.second.vo.MemberVO;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationVO;

public class MemberServiceImpl implements MemberService{
	//----------------------------------------------------------
	// 싱글톤으로 만들즈아!
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberService getInstance() {
		return instance;
	}
	//----------------------------------------------------------
	
	@Override
	public MemberVO selectMyInfo(String u_id) {
		SqlSession sqlSession = null;
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		MemberVO memberVO = new MemberVO();
		try {
			
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			
			if(sqlSession!=null) {
			memberVO = memberDAO.selectMyInfo(sqlSession, u_id);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			sqlSession.close(); 
		}

		return memberVO;
	}
	
	@Override
	public MemberVO selectMyTrainerInfo(String myTrainer) {
		SqlSession sqlSession = null;
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		MemberVO memberVO = new MemberVO();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			
			if(sqlSession!=null) {
			memberVO = memberDAO.selectMyTrainerInfo(sqlSession, myTrainer);
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
		return memberVO;
	}
	
	@Override
	public void updateMember(MemberVO memberVO) {
		SqlSession sqlSession = null;
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		HashMap<String, String> map = new HashMap<>();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				map.put("name", memberVO.getName());
				map.put("password", memberVO.getPassword());
				map.put("addr1", memberVO.getAddr1());
				map.put("addr2", memberVO.getAddr2());
				map.put("postcode", memberVO.getPostcode());
				memberDAO.updateMember(sqlSession, map);
			}
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public void insertReservation(ReservationVO reservationVO) {
		SqlSession sqlSession = null;
		ReservationDAO reservationDAO = ReservationDAOImpl.getInstance();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				reservationDAO.insertReservation(sqlSession, reservationVO);
			}
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public void deleteReservation(ReservationVO reservationVO) {
		SqlSession sqlSession = null;
		ReservationDAO reservationDAO = ReservationDAOImpl.getInstance();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				reservationDAO.deleteReservation(sqlSession, reservationVO);
			}
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<ReservationVO> selectMyReservation(String u_id) {
		SqlSession sqlSession = null;
		ReservationDAO reservationDAO = ReservationDAOImpl.getInstance();
		List<ReservationVO> list = new ArrayList<>();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				list = reservationDAO.selectMyReservation(sqlSession, u_id);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}		
		return list;
	}
	
	@Override
	public List<PTClassVO> selectPtOneDay(HashMap<String, String> map) {
		SqlSession sqlSession = null;
		ReservationDAO reservationDAO = ReservationDAOImpl.getInstance();
		List<PTClassVO> list = new ArrayList<>();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				list = reservationDAO.selectPtOneDay(sqlSession, map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	
}