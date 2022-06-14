package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public interface AdminDAO {
	// admin에서 회원권 등록
	void Pt_update(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException;
	// 전체 회원 가져오기
	List<UsersVO> SelectByAllUserList(SqlSession sqlSession) throws SQLException;
	// 회원 한명 보기
	UsersVO SelectByUserInfo(SqlSession sqlSession,String u_id) throws SQLException;
	//전체 강사목록 보기
	List<TrainerVO> SelectByAllTraninerList(SqlSession sqlSession) throws SQLException;
	// 강사 한명 보기
	TrainerVO SelectByTraninerInfo(SqlSession sqlSession,String t_id) throws SQLException;
	// 트레이너 등록
	void T_insert(SqlSession sqlSession, TrainerVO trainerVO) throws SQLException;
}
