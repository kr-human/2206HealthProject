package kr.human.second.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import jdk.internal.org.jline.utils.Log;
import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.AdminDAO;
import kr.human.second.dao.AdminDAOImpl;
import kr.human.second.dao.TrainerDAO;
import kr.human.second.dao.TrainerDAOImpl;
import kr.human.second.dao.UsersDAO;
import kr.human.second.dao.UsersDAOImpl;
import kr.human.second.vo.AdminVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AdminServiceImpl implements AdminService {
	private static AdminService instance = new AdminServiceImpl();
	private AdminServiceImpl() {}
	public static AdminService getInstance() {
		return instance;
	}
	@Override
	//등록해주기 위해서
	//강사 아이디 중복확인
	public int t_idCheck(String t_id) {
		Log.info("Adminservice의 t_idCheck호출 : {}", t_id);
		int count = 0;
		
		SqlSession sqlSession = null;
		AdminDAO adminDAO = null;
		
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			adminDAO =AdminDAOImpl.getInstance();
			count = adminDAO.SelectByTrainerId(sqlSession, t_id);
			sqlSession.commit();
			
		}catch (SQLException e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		Log.info("Adminservice의 t_idCheck리턴 : {}",count);
		return count;
	}
	@Override
	//강사 닉네임 중복 확인
	public int t_nicnameCheck(String t_nicname) {
		Log.info("Adminservice의 t_nicnameCheck호출 : {}", t_nicname);
		int count = 0;
		
		SqlSession sqlSession = null;
		AdminDAO adminDAO = null;
		
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			adminDAO =AdminDAOImpl.getInstance();
			count = adminDAO.SelectByTrainerNickname(sqlSession, t_nicname);
			sqlSession.commit();
			
		}catch (SQLException e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		Log.info("Adminservice의 t_nicnameCheck리턴 : {}",count);
		return count;
	}
	@Override
	//관리자 로그인
	public boolean a_login(String a_id, String a_password, HttpSession httpSession) {
		log.info("AdminDAOImpl의 a_login호출 : {}, {}", a_id, a_password);
		boolean isLogin = false;
		
		SqlSession sqlSession = null;
		AdminDAO adminDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			adminDAO = AdminDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 관리자 정보를 읽어온다
			AdminVO adminVO = adminDAO.SelectByAdminInfo(sqlSession, a_id);
			if(adminVO != null) {
				if(adminVO.getA_password().equals(a_password) && adminVO.getLev()==5) { //관리자일때 5
					//여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("adminVO", adminVO);
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
		
		log.info("AdminDAOImpl의 a_login리턴 : {}", isLogin);
		return isLogin;
	}
	//강사 가입
		@Override
		public void t_insert(TrainerVO trainerVO, String urlAddress) {
			log.info("UsersserviceImpl의 u_insert호출 : {}, {}", trainerVO, urlAddress);
			
			SqlSession sqlSession = null;
			TrainerDAO trainerDAO = null;
			AdminDAO adminDAO = null;
			try {
				sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
				adminDAO = AdminDAOImpl.getInstance();
				//------------------------------------------------------------------
				// 해당 아이디의 회원 정보를 읽어온다
				if(trainerVO !=null) {
					adminDAO.T_insert(sqlSession, trainerVO); //DB에 저장
					//환영 이메일 발송
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
	
	
}
