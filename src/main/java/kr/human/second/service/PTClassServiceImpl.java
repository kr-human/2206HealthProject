package kr.human.second.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.PTClassDAO;
import kr.human.second.dao.PTClassDAOImpl;
import kr.human.second.vo.PTClassVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PTClassServiceImpl implements PTClassService{

	private static PTClassService instance = new PTClassServiceImpl();
	private PTClassServiceImpl() {}
	public static PTClassService getInstance() { return instance; }
	//---------------------------------------------------------------------------
	// PT일정표 등록하기
	@Override
	public void insert(PTClassVO ptclassVO) {
		log.info("TrainerServiceImpl의 insert호출 : {}", ptclassVO);
		
		SqlSession sqlSession = null;
		PTClassDAO ptcDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			ptcDAO = PTClassDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(ptclassVO!=null) {
				ptcDAO.P_insert(sqlSession, ptclassVO);
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	// PT일정표 삭제하기
	@Override
	public void delete(PTClassVO ptclassVO) {
		log.info("TrainerServiceImpl의 delete호출 : {}", ptclassVO);
		
		SqlSession sqlSession = null;
		PTClassDAO ptcDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			ptcDAO = PTClassDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(ptclassVO!=null) {
				// DB에서 해당 정보를 가져온다.
				PTClassVO ptcVO = ptcDAO.P_check(sqlSession, ptclassVO.getIdx());
				// 트레이너 아이디가 같으면
				if(ptcVO!=null && ptcVO.getT_id().equals(ptclassVO.getT_id())) {
					// 삭제를 수행한다.
					ptcDAO.P_delete(sqlSession, ptclassVO.getIdx());
				}
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	// PT일정표 확인하기 - 1일 얻기
	@Override
	public List<PTClassVO> selectByPTOneDayCheck() {
		log.info("TrainerServiceImpl의 selectByPTOneDayCheck호출 ");
		
		SqlSession sqlSession = null;
		List<PTClassVO> ptclVO = null;
		PTClassDAO ptcDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			ptcDAO = PTClassDAOImpl.getInstance();
			//------------------------------------------------------------------
			ptclVO = ptcDAO.PList_Check(sqlSession);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 selectByPTOneDayCheck 리턴 : " + ptclVO);
		return ptclVO;
	}
	// PT일정표 확인하기 - 1개 얻기
	@Override
	public PTClassVO selectByPTCheck(int idx) {
		log.info("TrainerServiceImpl의 selectByPTCheck호출 : {}", idx);
		
		SqlSession sqlSession = null;
		PTClassDAO ptcDAO = null;
		PTClassVO ptcVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			ptcDAO = PTClassDAOImpl.getInstance();
			//------------------------------------------------------------------
			ptcVO = ptcDAO.P_check(sqlSession, idx);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 selectByPTCheck 리턴 : " + ptcVO);
		return ptcVO;
	}


}
