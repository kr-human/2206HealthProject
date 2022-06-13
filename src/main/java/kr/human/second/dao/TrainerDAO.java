package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.UsersVO;

public interface TrainerDAO {
	//탈퇴
	void delete(SqlSession sqlSession, String t_id) throws SQLException;
	//나의 회원 목록 보기
	List<UsersVO> SelectByAllUserList(SqlSession sqlSession,String u_id) throws SQLException;
	//나의 회원 정보 보기
	int selectCount(SqlSession sqlSession) throws SQLException;
	//pt일정표 등록하기 
	void insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
	//pt일정표 변경하기
	void update(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
	//pt일정표 삭제하기
	void delete(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
}
