package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;

public interface NoticeDAO {
	int selectCount(SqlSession sqlSession) throws SQLException;
	NoticeVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException;
	List<NoticeVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException;
	void N_insert(SqlSession sqlSession, NoticeVO fileBoardVO) throws SQLException;
	void N_update(SqlSession sqlSession, NoticeVO fileBoardVO) throws SQLException;
	void N_delete(SqlSession sqlSession, int idx) throws SQLException;
	int increment(SqlSession sqlSession, int idx) throws SQLException;
	int selectMaxIdx(SqlSession sqlSession) throws SQLException;
}
