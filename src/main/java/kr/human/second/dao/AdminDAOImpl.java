package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public class AdminDAOImpl implements AdminDAO {
	private static AdminDAO instance = new AdminDAOImpl();
	private AdminDAOImpl() {}
	public static AdminDAO getInstance(){
		return instance;
	}
	@Override
	public void Pt_update(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TrainerVO> SelectByAllTraninerList(SqlSession sqlSession) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TrainerVO SelectByTraninerInfo(SqlSession sqlSession, String t_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void T_insert(SqlSession sqlSession, TrainerVO trainerVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
