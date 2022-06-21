package kr.human.second.service;

import java.sql.SQLException;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.MemberDAO;
import kr.human.second.dao.MemberDAOImpl;

import kr.human.second.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class MemberServiceImpl implements MemberService{
	
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {};
	public static MemberService getInstance() {
		return instance;
	}
	
	
	@Override
	//유저 아이디 중복확인
	public int idCheck(String id) {
		log.info("MemberServiceImpl의 idCheck호출 : {}", id);
		int count = 0;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			count = memberDAO.SelectByUserId(sqlSession, id);
			sqlSession.commit();
			
		}catch (SQLException e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		log.info("MemberServiceImpl의 idCheck리턴 : {}",count);
		return count;
	}
	
	@Override
	//로그인
	public boolean login(HttpSession httpSession, String id, String password) {
		log.debug("MemberServiceImpl의 login호출 : {}, {}", id, password);
		boolean isLogin = false;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO memberVO = memberDAO.SelectByUserInfo(sqlSession, id);
			if(memberVO != null) {
				if(memberVO.getPassword().equals(password) && memberVO.getLev()==1) { //회원 일때 1
					//여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("memberVO", memberVO);
					isLogin = true;
				}
				if(memberVO.getPassword().equals(password) && memberVO.getLev()==3) {//관리자 일떄 3 
					//여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("memberVO", memberVO);
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
		
		log.debug("MemberServiceImpl의 login리턴 : {}", isLogin);
		return isLogin;
	}
	//유저 회원가입
	@Override
	public void insert(MemberVO memberVO, String urlAddress) {
		log.info("MemberServiceImpl의 insert호출 : {}, {}", memberVO, urlAddress);
		
		SqlSession sqlSession = null;
		MemberDAO memberDVO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDVO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			if(memberVO!=null) {
				memberDVO.insert(sqlSession, memberVO); //DB에 저장
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
