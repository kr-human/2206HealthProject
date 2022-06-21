package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
   private static MemberDAO instance = new MemberDAOImpl();
   private MemberDAOImpl() {}
   public static MemberDAO getInstance(){
      return instance;
   }
   
   // 회원가입
   @Override
   public void insert(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
      sqlSession.insert("members.insert", memberVO);
   }
   
   // 회원 탈퇴
   @Override
   public void delete(SqlSession sqlSession, String id) throws SQLException {
      sqlSession.delete("members.delete", id);
   }
   
   // 회원 정보 수정
   @Override
   public void update(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
      sqlSession.update("members.update", memberVO);
   }
   
   // 동일한 아이디 갯수 얻기 (중복확인)
   @Override
   public int SelectByUserId(SqlSession sqlSession, String id) throws SQLException {
      return sqlSession.selectOne("members.SelectByUserId", id);
   }
   
  
   // 1개 얻기 (user_id)로 얻기
   @Override
   public MemberVO SelectByUserInfo(SqlSession sqlSession, String id) throws SQLException {
      return sqlSession.selectOne("members.SelectByUserInfo", id);
   }
   
   // 비밀번호 변경
   @Override
   public void ChangePassword(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
      sqlSession.update("members.ChangePassword", map);
   }
   
   // 아이디 찾기 (name으로 가져오기)
   @Override
   public List<MemberVO> FindUserId(SqlSession sqlSession, String email) throws SQLException {
      return sqlSession.selectList("members.FindUserId", email);
   }
   
   
   
}