package kr.human.second.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.AdminDAO;
import kr.human.second.dao.TrainerDAO;
import kr.human.second.dao.TrainerDAOImpl;
import kr.human.second.vo.TrainerVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TrainerServiceImpl implements TrainerService {
	private static TrainerService instance = new TrainerServiceImpl();
	private TrainerServiceImpl() {}
	public static TrainerService getInstance() {
		return instance;
	}
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
}
