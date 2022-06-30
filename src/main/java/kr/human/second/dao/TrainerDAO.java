package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public interface TrainerDAO {
	// 전체 회원 목록 보기
	List<MemberVO>SelectByAllUserList(SqlSession sqlSession) throws SQLException;
	// 전체 회원 중 한명 정보 보기
	MemberVO SelectByAllUserInfo(SqlSession sqlSession, String id) throws SQLException;
	// 나의 회원 목록 보기
	List<MemberVO> SelectByUserList(SqlSession sqlSession,String trainerid) throws SQLException;
	// 나의 회원 정보 보기
	MemberVO SelectByUserInfo(SqlSession sqlSession, String id) throws SQLException;
	// 회원 pt이용권 등록, 스타트, 엔드데이 등록
	void MemberUpdate(SqlSession sqlSession, MemberVO memberVO) throws SQLException;
}
