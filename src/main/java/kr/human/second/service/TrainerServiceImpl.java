package kr.human.second.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.TrainerDAO;
import kr.human.second.dao.TrainerDAOImpl;
import kr.human.second.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrainerServiceImpl implements TrainerService{
	private static TrainerService instance = new TrainerServiceImpl();
	private TrainerServiceImpl() {}
	public static TrainerService getInstance(){
		return instance;
	}
	//-------------------------------------------------------------------------
	// 전체 회원 목록 보기
	@Override
	public List<MemberVO> SelectByAllUserList() {
		log.info("TrainerServiceImpl의 SelectByAllUserList호출 ");
		
		SqlSession sqlSession = null;
		List<MemberVO> memberVO = null;
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			memberVO = trainerDAO.SelectByAllUserList(sqlSession);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 SelectByAllUserList 리턴 : " + memberVO);
		return memberVO;
	}
	
	// 전체 회원 중 한명 정보 보기
	@Override
	public MemberVO SelectByAllUserInfo(String id) {
		log.info("TrainerServiceImpl의 SelectByUserInfo호출 : {}", id);
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		MemberVO memberVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			memberVO = trainerDAO.SelectByUserInfo(sqlSession, id);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 SelectByUserInfo 리턴 : " + memberVO);
		return memberVO;
	}
	
	// 나의 회원 목록 보기
	@Override
	public List<MemberVO> SelectByUserList(String trainerid) {
		log.info("TrainerServiceImpl의 SelectByUserList호출 ");
		
		SqlSession sqlSession = null;
		List<MemberVO> memberVO = null;
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			memberVO = trainerDAO.SelectByUserList(sqlSession, trainerid);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 SelectByUserList 리턴 : " + memberVO);
		return memberVO;
	}
	
	// 나의 회원 정보 보기
	@Override
	public MemberVO SelectByUserInfo(String id) {
		log.info("TrainerServiceImpl의 SelectByUserInfo호출 : {}", id);
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		MemberVO memberVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			memberVO = trainerDAO.SelectByUserInfo(sqlSession, id);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 SelectByUserInfo 리턴 : " + memberVO);
		return memberVO;
	}
	// 회원 pt이용권 등록, 스타트, 엔드데이 등록
	@Override
	public void MemberUpdate(MemberVO memberVO, int newPT, String myTrainer) {
		log.info("TrainerServiceImpl의 MemberUpdate호출 : {}", memberVO);
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(memberVO!=null) {
				// DB에서 해당 회원 정보를 가져온다.
				MemberVO dbVO = trainerDAO.SelectByAllUserInfo(sqlSession, memberVO.getId());
				memberVO.setPt(newPT);
				memberVO.setMyTrainer(myTrainer);
//				memberVO.setStartDay(newStartDay);
//				memberVO.setEndDay(newEndDay);
				trainerDAO.MemberUpdate(sqlSession, memberVO);
//				sqlSession.commit();
				// 세션의 값을 변경된 값으로 바꿔준다.
				// httpSession.setAttribute("memberVO", memberVO);
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}	
		// TODO Auto-generated method stub
		
	}

}
