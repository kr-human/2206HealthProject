package kr.human.second.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.UsersDAO;
import kr.human.second.dao.UsersDAOImpl;
import kr.human.second.vo.ReservationVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public class UsersServiceImpl implements UsersService{
	
	private static UsersService instance = new UsersServiceImpl();
	private UsersServiceImpl() {};
	public static UsersService getInstance() {
		return instance;
	}
	
	@Override
	public void InsertReservation(ReservationVO reservationVO) {
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = UsersDAOImpl.getInstance();
		try{
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				usersDAO.R_insert(sqlSession, reservationVO);
			}
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	
	}
	
	@Override
	public TrainerVO TrainerCheck(UsersVO usersVO) {
		
		SqlSession sqlSession = null;
		UsersDAO usersDAO = UsersDAOImpl.getInstance();
		TrainerVO trainerVO = new TrainerVO();
		String t_id = usersVO.getT_id();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			trainerVO = usersDAO.SelectByTrainer(sqlSession, t_id);
		} catch (Exception e) {
			
		} finally {
			sqlSession.close();
		}
		return null;
		
	}
	
	@Override
	public void ChangeReservation(ReservationVO reservationVO) {
		SqlSession sqlSession = null;
		UsersDAO usersDAO = UsersDAOImpl.getInstance();
		HashMap<String, String> map = new HashMap<>();
		map.put(reservationVO.getPt_code(), reservationVO.getU_id());
		try{
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				usersDAO.R_delete(sqlSession, map);
			}
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void AutoReservation(ReservationVO reservationVO) {
		SqlSession sqlSession = null;
		UsersDAO usersDAO = UsersDAOImpl.getInstance();
		try{
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			if(sqlSession!=null) {
				usersDAO.R_insert(sqlSession, reservationVO);
			}
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	@Override
	public List<ReservationVO> getReservation(UsersVO usersVO) {
		ReservationVO reservationVO = new ReservationVO();
		SqlSession sqlSession = null;
		UsersDAO usersDAO = UsersDAOImpl.getInstance();
		List<ReservationVO> list = new ArrayList<>();
		String u_id = usersVO.getU_id();
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession();
			list = usersDAO.selectAllReservation(sqlSession, u_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			return list;
		}
	}
	
}
