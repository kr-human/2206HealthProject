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
	public void updatePt(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		sqlSession.update("member.update", map);
		
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectList("admin.SelectByAllUserList",u_id);
	}
	@Override
	public List<TrainerVO> SelectByAllTraninerList(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectList("admin.SelectByAllTraninerList",t_id);
	}
	@Override
	public List<NoticeVO> SelectByNoteice(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectList("admin.SelectByNoteice",idx);
	}
}
