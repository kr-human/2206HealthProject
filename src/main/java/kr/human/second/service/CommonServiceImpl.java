package kr.human.second.service;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;


import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.CommonDAO;
import kr.human.second.dao.CommonDAOImpl;
import kr.human.second.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonServiceImpl implements CommonService {

	private static CommonService instance = new CommonServiceImpl();

	private CommonServiceImpl() {
	};

	public static CommonService getInstance() {
		return instance;
	}

	@Override
	// 유저 아이디 중복확인
	public int idCheck(String id) {
		log.info("CommonServiceImpl의 idCheck호출 : {}", id);
		int count = 0;

		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;

		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			count = commonDAO.SelectByUserId(sqlSession, id);
			sqlSession.commit();

		} catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		log.info("CommonServiceImpl의 idCheck리턴 : {}", count);
		return count;
	}

	@Override
	// 로그인
	public boolean login(HttpSession httpSession, String id, String password) {
		log.debug("CommonServiceImpl의 login호출 : {}, {}", id, password);
		boolean isLogin = false;

		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			// ------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO memberVO = commonDAO.SelectByUserInfo(sqlSession, id);
			if (memberVO != null) {
				if (memberVO.getPassword().equals(password) && memberVO.getLev() == 1) { // 회원 일때 1
					// 여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("memberVO", memberVO);
					isLogin = true;
				}
				if (memberVO.getPassword().equals(password) && memberVO.getLev() == 3) {// 관리자 일떄 3
					// 여기서 섹션 추가 (카테고리 보여주는거)
					httpSession.setAttribute("memberVO", memberVO);
					isLogin = true;
				}
			}
			// ------------------------------------------------------------------
			sqlSession.commit();
		} catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		log.debug("CommonServiceImpl의 login리턴 : {}", isLogin);
		return isLogin;
	}
	// 유저 회원가입

	@Override
	public void insert(MemberVO memberVO, String urlAddress) {
		log.info("CommonServiceImpl의 insert호출 : {}, {}", memberVO, urlAddress);

		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			// ------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			if (memberVO != null) {
				commonDAO.insert(sqlSession, memberVO); // DB에 저장
				// 환영 이메일 발송
				EmailService.sendMail(memberVO.getEmail(), memberVO.getName() + "님 회원가입을 환영합니다.",
						"다음 링크를 클릭하여 인증을 하셔야만 회원 가입이 완료됩니다.<br>" 
						+ "<a href='" + urlAddress + "&id=" + memberVO.getId()
						+ "'>인증하기</a>");
			}
			// ------------------------------------------------------------------
			sqlSession.commit();
		} catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	@Override
	public boolean emailConfirm(String id) {
		log.debug("CommonServiceImpl의 emailConfirm호출 : {}", id);
		boolean isConfirm = false;

		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			// ------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO memberVO = commonDAO.SelectByUserInfo(sqlSession, id);
			if (memberVO != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				//인증하면 level 1 로 향상
				map.put("lev", "1");
				map.put("id", id);
				commonDAO.updateLevel(sqlSession, map);
				isConfirm = true;
			
			}
			// ------------------------------------------------------------------
			sqlSession.commit();
		} catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		log.debug("CommonServiceImpl의 emailConfirm리턴 : {}", isConfirm);
		return isConfirm;
	}

	@Override
	public void update(MemberVO memberVO, String newPassword, HttpSession httpSession) {
		log.info("MemberServiceImpl의 update호출 : {}, {}", memberVO, newPassword);
		
		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(memberVO!=null) {
				// DB에서 해당 idx을 회원 정보를 가져온다.
				MemberVO dbVO = commonDAO.SelectByUserInfo(sqlSession, memberVO.getId());
				// 비번이 같으면
				if(dbVO!=null && dbVO.getPassword().equals(memberVO.getPassword())) {
					// 변경을 수행한다.
					memberVO.setPassword(newPassword); // 새로운 비번으로 바꿔서
					commonDAO.update(sqlSession, memberVO); // sql문으로 바꿔주고
					sqlSession.commit(); //바뀐거 저장
					memberVO = commonDAO.SelectByUserInfo(sqlSession, memberVO.getId()); //바뀐걸 다시 불러오고
					// 세션의 값을 변경된 값으로 바꿔준다.
					httpSession.setAttribute("memberVO", memberVO);
					
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

	@Override
	public void delete(MemberVO memberVO, HttpSession httpSession) {
		log.debug("CommonServiceImpl의 delete호출 : {}", memberVO);
		

		SqlSession sqlSession = null;
		CommonDAO commonDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			commonDAO = CommonDAOImpl.getInstance();
			// ------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO dbVO = commonDAO.SelectByUserInfo(sqlSession, memberVO.getId());
			if (memberVO != null) {
				if(dbVO!=null && dbVO.getPassword().equals(memberVO.getPassword())){
					//삭제 수행
					//DB에서 바로 지우면 안됨
					HashMap<String, String> map = new HashMap<String,String>();
					map.put("lev", "9"); // lev9인 회원은 휴먼계정
					map.put("id", memberVO.getId());
					commonDAO.updateLevel(sqlSession, map);
					sqlSession.commit();
					memberVO = commonDAO.SelectByUserInfo(sqlSession, memberVO.getId());
					httpSession.removeAttribute("memberVO");
				}
			}
			// ------------------------------------------------------------------
			sqlSession.commit();
		} catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		log.debug("CommonServiceImpl의 delete리턴 : {}", memberVO);
		
	}

}
