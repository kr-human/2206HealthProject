package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public class CommonDAOImpl implements CommonDAO{
   private static CommonDAO instance = new CommonDAOImpl();
   private CommonDAOImpl() {}
   public static CommonDAO getInstance(){
      return instance;
   }
   
   // 회원가입
   @Override
   public void insert(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
      sqlSession.insert("common.insert", memberVO);
   }
   
   // 회원 탈퇴
   @Override
   public void delete(SqlSession sqlSession, String id) throws SQLException {
      sqlSession.delete("common.delete", id);
   }
   
   // 회원 정보 수정
   @Override
   public void update(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
      sqlSession.update("common.update", memberVO);
   }
   
   // 동일한 아이디 갯수 얻기 (중복확인)
   @Override
   public int SelectByUserId(SqlSession sqlSession, String id) throws SQLException {
      return sqlSession.selectOne("common.SelectByUserId", id);
   }
   
  
   // 1개 얻기 (user_id)로 얻기
   @Override
   public MemberVO SelectByUserInfo(SqlSession sqlSession, String id) throws SQLException {
      return sqlSession.selectOne("common.SelectByUserInfo", id);
   }
   
   // 비밀번호 변경
   @Override
   public void ChangePassword(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
      sqlSession.update("common.ChangePassword", map);
   }
   
   // 아이디 찾기 (name으로 가져오기)
   @Override
   public List<MemberVO> FindUserId(SqlSession sqlSession, String email) throws SQLException {
      return sqlSession.selectList("common.FindUserId", email);
   }
   
   
   
}