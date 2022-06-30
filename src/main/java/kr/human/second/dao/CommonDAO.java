package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public interface CommonDAO {
	//회원가입
	void insert(SqlSession sqlSession, MemberVO memberVO) throws SQLException;  
	//회원 탈퇴
	void delete(SqlSession sqlSession, String id) throws SQLException;
	//회원 정보 수정
	void update(SqlSession sqlSession, MemberVO memberVO) throws SQLException;
	//동일한 아이디 갯수 얻기 (중복확인)
	int SelectByUserId(SqlSession sqlSession, String id) throws SQLException;
	//1개 얻기 (user_id)로 얻기
	MemberVO SelectByUserInfo(SqlSession sqlSession, String id) throws SQLException; 	
	// 비밀번호 변경
	void ChangePassword(SqlSession sqlSession, HashMap<String, String> map) throws SQLException; 
	// 아이디 찾기 (name으로 가져오기)
	List<MemberVO> FindUserId(SqlSession sqlSession, String email) throws SQLException;
	//레벨변경
	void updateLevel(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
	
	
}
