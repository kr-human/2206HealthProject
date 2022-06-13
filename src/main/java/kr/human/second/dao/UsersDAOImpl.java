package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.ReservationVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public class UsersDAOImpl implements UsersDAO{
	private static UsersDAO instance = new UsersDAOImpl();
	private UsersDAOImpl() {}
	public static UsersDAO getInstance(){
		return instance;
	}
	@Override
	public void U_insert(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void U_delete(SqlSession sqlSession, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void U_update(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int SelectByUserId(SqlSession sqlSession, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int SelectByUserNickname(SqlSession sqlSession, String u_nicname) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TrainerVO> SelectByTrainerList(SqlSession sqlSession, String t_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ChangePassword(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<UsersVO> FindUserId(SqlSession sqlSession, String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void R_insert(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void R_update(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void R_delete(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
