package kr.human.second.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.AdminDAO;
import kr.human.second.dao.TrainerDAO;
import kr.human.second.dao.TrainerDAOImpl;
import kr.human.second.vo.TrainerVO;
import lombok.extern.slf4j.Slf4j;
import kr.human.second.dao.UsersDAO;
import kr.human.second.dao.UsersDAOImpl;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.UsersVO;

@Slf4j
public class TrainerServiceImpl implements TrainerService {

	private static TrainerService instance = new TrainerServiceImpl();
	private TrainerServiceImpl() {}
	public static TrainerService getInstance() { return instance; }
	//---------------------------------------------------------------------------

	//강사 로그인
	@Override
	public boolean t_login(String t_id, String t_password, HttpSession httpSession) {
		log.info("TrainerServiceImpl의 t_login호출 : {}, {}", t_id, t_password);
		boolean isLogin = false;
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		AdminDAO adminDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 강사 정보를 읽어온다
			TrainerVO trainerVO = adminDAO.SelectByTraninerInfo(sqlSession, t_id);
			if(trainerVO != null) {
				if(trainerVO.getT_password().equals(t_password) && trainerVO.getLev() ==3 ) { //강사 일때 3
					//여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("trainerVO", trainerVO);
					isLogin = true;
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
		
		log.info("UsersserviceImpl의 u_login리턴 : {}", isLogin);
		return isLogin;
	}
	
	// PT일정표 등록하기
	@Override
	public void insert(PTClassVO ptclassVO) {
		log.info("TrainerServiceImpl의 insert호출 : {}", ptclassVO);
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(ptclassVO!=null) {
				trainerDAO.P_insert(sqlSession, ptclassVO);
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
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(ptclassVO!=null) {
				// DB에서 해당 정보를 가져온다.
				PTClassVO ptcVO = trainerDAO.P_check(sqlSession, ptclassVO.getPt_code());
				// 트레이너 아이디가 같으면
				if(ptcVO!=null && ptcVO.getT_id().equals(ptclassVO.getT_id())) {
					// 삭제를 수행한다.
					trainerDAO.P_delete(sqlSession, ptclassVO.getPt_code());
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
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			ptclVO = trainerDAO.PList_Check(sqlSession);
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
	public PTClassVO selectByPTCheck(String pt_Code) {
		log.info("TrainerServiceImpl의 selectByPTCheck호출 : {}", pt_Code);
		
		SqlSession sqlSession = null;
		TrainerDAO trainerDAO = null;
		PTClassVO ptcVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			ptcVO = trainerDAO.P_check(sqlSession, pt_Code);
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

	// 자기 회원 정보 확인 -- 전체보기
	@Override
	public List<UsersVO> selectByUserList(String t_id) {
		log.info("TrainerServiceImpl의 selectByUserList호출 : {}", t_id);
		
		SqlSession sqlSession = null;
		List<UsersVO> userlistVO = null;
		TrainerDAO trainerDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			trainerDAO = TrainerDAOImpl.getInstance();
			//------------------------------------------------------------------
			userlistVO = trainerDAO.SelectByAllUserList(sqlSession, t_id);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 selectByUserList 리턴 : " + userlistVO);
		return userlistVO;
	}

	// 자기 회원 정보 상세 확인 -- 1명 보기
	@Override
	public UsersVO selectByUser(String u_id) {
		log.info("TrainerServiceImpl의 selectByUser호출 : {}", u_id);
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = null;
		UsersVO usersVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			usersDAO = UsersDAOImpl.getInstance();
			//------------------------------------------------------------------
			usersVO = usersDAO.SelectByUserInfo(sqlSession, u_id);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		log.info("TrainerServiceImpl의 selectByUser 리턴 : " + usersVO);
		return usersVO;
	}
}
