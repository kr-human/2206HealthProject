package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.UsersVO;

public interface UsersDAO {
	
	public void insert(SqlSession sqlSession, UsersVO usersVO) throws SQLException;  // 삽입
	public void delete(SqlSession sqlSession, String u_id) throws SQLException; // 삭제
	public void update(SqlSession sqlSession, UsersVO usersVO) throws SQLException; // 수정
	public int SelectByUserId(SqlSession sqlSession, String u_id) throws SQLException; // id유무확인
	public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException; // 1개얻기
	public void updatePt(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException; // pt회원권, 등록일~마감일 수정
	public int SelectByUserCount(SqlSession sqlSession) throws SQLException; // 전체수 얻기
	public List<UsersVO> SelectByUserList(SqlSession sqlSession, String t_id) throws SQLException; // 자신의 회원목록 가져오기
	public void ChangePassword(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException; // 비밀번호 변경
	public String FindUserId(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException; // 아이디 찾기
	
}
