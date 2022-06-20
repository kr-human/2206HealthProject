package kr.human.second.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.UsersDAO;
import kr.human.second.dao.UsersDAOImpl;
import kr.human.second.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersServiceImpl implements UsersService {
	private static UsersService instance = new UsersServiceImpl();
	private UsersServiceImpl() {}
	public static UsersService getInstance() {
		return instance;
	}
	@Override
	//유저 아이디 중복확인
	public int u_idCheck(String u_id) {
		log.info("UsersserviceImpl의 idCheck호출 : {}", u_id);
		int count = 0;
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = null;
		
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			usersDAO = UsersDAOImpl.getInstance();
			count = usersDAO.SelectByUserId(sqlSession, u_id);
			sqlSession.commit();
			
		}catch (SQLException e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		log.info("UsersserviceImpl의 idCheck리턴 : {}",count);
		return count;
	}
	@Override
	//유저 닉네임 중복 확인
	public int u_nicnameCheck(String u_nicname) {
		log.info("UsersserviceImpl의 u_nicnameCheck호출 : {}", u_nicname);
		int count = 0;
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = null;
		
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			usersDAO = UsersDAOImpl.getInstance();
			count = usersDAO.SelectByUserNickname(sqlSession, u_nicname);
			sqlSession.commit();
			
		}catch (SQLException e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		log.info("UsersserviceImpl의 u_nicnameCheck리턴 : {}",count);
		return count;
	}
	@Override
	//유저 로그인
	public boolean u_login(String u_id, String u_password, HttpSession httpSession) {
		log.debug("UsersserviceImpl의 u_login호출 : {}, {}", u_id, u_password);
		boolean isLogin = false;
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			usersDAO = UsersDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			UsersVO usersVO = usersDAO.SelectByUserInfo(sqlSession, u_id);
			if(usersVO != null) {
				if(usersVO.getU_password().equals(u_password) && usersVO.getLev()>=1) { //회원 일때 1
					//여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("usersVO", usersVO);
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
		
		log.debug("UsersserviceImpl의 u_login리턴 : {}", isLogin);
		return isLogin;
	}
	//유저 회원가입
	@Override
	public void u_insert(UsersVO usersVO, String urlAddress) {
		log.info("UsersserviceImpl의 u_insert호출 : {}, {}", usersVO, urlAddress);
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			usersDAO = UsersDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			if(usersVO!=null) {
				usersDAO.U_insert(sqlSession, usersVO); //DB에 저장
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
