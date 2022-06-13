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
	public void delete(SqlSession sqlSession, String t_id) throws SQLException {
		
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession, String u_id) throws SQLException {
		return null;
	}
	@Override
	public int selectCount(SqlSession sqlSession) throws SQLException {
		return 0;
	}
	@Override
	public void insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		
	}
	@Override
	public void update(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		
	}
	@Override
	public void delete(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		
	}
}