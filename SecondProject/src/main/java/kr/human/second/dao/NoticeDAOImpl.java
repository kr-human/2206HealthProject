package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
	private static NoticeDAO instance = new NoticeDAOImpl();
	private NoticeDAOImpl() {}
	public static NoticeDAO getInstance(){
		return instance;
	}
	@Override
	public void insert(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
		
	}
	@Override
	public void update(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
		
	}
	@Override
	public void delete(SqlSession sqlSession, int idx) throws SQLException {
		
	}
	@Override
	public int clickCount(SqlSession sqlSession) throws SQLException {
		return 0;
	}
	@Override
	public List<NoticeVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		return null;
	}
	@Override
	public int selectCount(SqlSession sqlSession) throws SQLException {
		return 0;
	}
	@Override
	public NoticeVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
		return null;
	}

}
