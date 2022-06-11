package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public class UsersDAOImpl implements UsersDAO{
	private static UsersDAO instance = new UsersDAOImpl();
	private UsersDAOImpl() {}
	public static UsersDAO getInstance(){
		return instance;
	}
	@Override
	public void insert(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
		sqlSession.insert("users.insert", usersVO);
		
	}
	@Override
	public void delete(SqlSession sqlSession, String u_id) throws SQLException {
		sqlSession.delete("users.delete", u_id);
		
	}
	@Override
	public void update(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
		sqlSession.update("users.update", usersVO);
		
	}
	@Override
	public int SelectByUserId(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectOne("users.SelectByUserId", u_id);
	}
	@Override
	public int SelectByUserNickname(SqlSession sqlSession, String u_nicname) throws SQLException {
		
		return sqlSession.selectOne("users.SelectByUserNickname", u_nicname);
	}
	@Override
	public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectOne("users.SelectByUserInfo", u_id);
		
	}
	@Override
	public List<TrainerVO> SelectByTrainerList(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectList("users.SelectByTrainerList",t_id);
	}
	@Override
	public void ChangePassword(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		sqlSession.update("users.ChangePassword", map);
		
	}
	@Override
	public List<UsersVO> FindUserId(SqlSession sqlSession, String name) throws SQLException {
		return sqlSession.selectList("users.FindUserId", name);
	}
	
}
