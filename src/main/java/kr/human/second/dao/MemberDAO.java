package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public interface MemberDAO {
	
	// 나의 정보 가져오기
	MemberVO selectMyInfo(SqlSession sqlSession, String u_id) throws SQLException;
	
	// 나의 트레이너 정보 보기
	MemberVO selectMyTrainerInfo(SqlSession sqlSession, String t_id) throws SQLException;
	
	// 정보 수정하기
	void updateMember(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
}
