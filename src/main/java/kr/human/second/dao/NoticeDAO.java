package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;

public interface NoticeDAO {
	// 공지 저장
	void N_insert(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException;
	// 공지 수정
	void N_update(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException;
	// 글 삭제
	void N_delete(SqlSession sqlSession, int idx) throws SQLException;
	// 조회수
	int clickCount(SqlSession sqlSession) throws SQLException;
	// 글 목록(1페이지 얻기)
	List<NoticeVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException;
	// 전체 개수 얻기
	int selectCount(SqlSession sqlSession) throws SQLException;
	// 1개 얻기
	NoticeVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException;
	// 최근 글 1개 얻기
	int selectMaxIdx(SqlSession sqlSession) throws SQLException;
}
