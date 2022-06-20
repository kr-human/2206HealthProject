package kr.human.second.dao;

import java.sql.SQLException;
import java.util.Date;
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
		sqlSession.delete("trainer.T_delete", u_id);
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectList("trainer.SelectByAllUserList", t_id);
	}
	@Override
	public UsersVO selectByUserInfo(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectOne("trainer.selectByUserInfo", t_id);
	}
	@Override
	public void P_insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		sqlSession.insert("pt.P_insert", ptclassVO);
	}
	@Override
	public void P_update(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		sqlSession.update("pt.P_update", ptclassVO);
	}
	@Override
	public void P_delete(SqlSession sqlSession, String pt_Code) throws SQLException {
		sqlSession.delete("pt.P_delete", pt_Code);
	}
	@Override
	public PTClassVO P_check(SqlSession sqlSession, String pt_Code) throws SQLException {
		return sqlSession.selectOne("pt.P_check", pt_Code);
	}
	@Override
	public List<PTClassVO> PList_Check(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectList("pt.PList_check");
	}
	
}