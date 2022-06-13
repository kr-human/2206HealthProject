package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.UsersVO;

public interface TrainerDAO {
	// 탈퇴(트레이너 본인 탈퇴-퇴사)
	void T_delete(SqlSession sqlSession, String t_id) throws SQLException;
	// 나의 회원 전체 목록 보기
	List<UsersVO> SelectByAllUserList(SqlSession sqlSession,String t_id) throws SQLException;
	// 나의 회원 정보 보기(회원한명의 정보)
	UsersVO selectByUserInfo(SqlSession sqlSession, String t_id, String u_id) throws SQLException;
	// pt일정표 등록하기 
	void P_insert(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
	// pt일정표 변경하기
	void P_update(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
	// pt일정표 삭제하기
	void P_delete(SqlSession sqlSession, String pt_Code) throws SQLException;
	// pt일정표 확인하기
	void P_check(SqlSession sqlSession, PTClassVO ptclassVO) throws SQLException;
}
