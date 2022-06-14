package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.UsersVO;

public class TrainerDAOImpl implements TrainerDAO {
	private static TrainerDAO instance = new TrainerDAOImpl();
	private TrainerDAOImpl() {}
	public static TrainerDAO getInstance(){
		return instance;
	}
	@Override
	public void T_delete(SqlSession sqlSession, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession, String t_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UsersVO selectByUserInfo(SqlSession sqlSession, String t_id, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void P_insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void P_update(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void P_delete(SqlSession sqlSession, String pt_Code) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void P_check(SqlSession sqlSession, String pt_Code) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}