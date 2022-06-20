package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.AdminVO;
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
		sqlSession.update("admin.Pt_update", map);
	}
	
	@Override
	public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException {
		return sqlSession.selectOne("admin.SelectByUserInfo", u_id);
	}
	@Override
	public TrainerVO SelectByTraninerInfo(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectOne("admin.SelectByTraninerInfo", t_id);
	}
	@Override
	public void T_insert(SqlSession sqlSession, TrainerVO trainerVO) throws SQLException {
		sqlSession.insert("admin.T_insert", trainerVO);	
	}
	@Override
	public List<UsersVO> SelectByAllUserList(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectList("admin.SelectByAllUserList", map);
	}
	@Override
	public List<TrainerVO> SelectByAllTraninerList(SqlSession sqlSession, HashMap<String, String> map)throws SQLException {
		return sqlSession.selectList("admin.SelectByAllTraninerList", map);
	}
	@Override
	public int SelectByTrainerId(SqlSession sqlSession, String t_id) throws SQLException {
		return sqlSession.selectOne("admin.SelectByTrainerId",t_id);
	}
	@Override
	public int SelectByTrainerNickname(SqlSession sqlSession, String t_nicname) throws SQLException {
		return sqlSession.selectOne("admin.SelectByTrainerNickname",t_nicname);
	}
	@Override
	public AdminVO SelectByAdminInfo(SqlSession sqlSession, String t_id) throws SQLException {		
		return sqlSession.selectOne("admin.SelectByAdminInfo",t_id);
	}
}
