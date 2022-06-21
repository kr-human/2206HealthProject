package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;

public class PTClassDAOImpl implements PTClassDAO{
	private static PTClassDAO instance = new PTClassDAOImpl();
	private PTClassDAOImpl() {}
	public static PTClassDAO getInstance(){
		return instance;
	}
	//-------------------------------------------------------------------------
	// PT일정표 등록하기
	@Override
	public void P_insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException {
		sqlSession.insert("pt.P_insert", ptclassVO);
	}
	// PT일정표 삭제하기
	@Override
	public void P_delete(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("pt.P_delete", idx);
	}
	// PT일정표 확인하기
	@Override
	public PTClassVO P_check(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectOne("pt.P_check", idx);
	}
	// PT일정표 목록보기
	@Override
	public List<PTClassVO> PList_Check(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectList("pt.PList_check");
	}

}
