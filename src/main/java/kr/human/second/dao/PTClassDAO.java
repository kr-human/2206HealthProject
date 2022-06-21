package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;

public interface PTClassDAO {
		// pt일정표 등록하기 
		void P_insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
		// pt일정표 삭제하기
		void P_delete(SqlSession sqlSession, int idx) throws SQLException;
		// pt일정표 확인하기
		PTClassVO P_check(SqlSession sqlSession, int idx) throws SQLException;
		// pt일정표 목록보기
		List<PTClassVO> PList_Check(SqlSession sqlSession) throws SQLException;
}
