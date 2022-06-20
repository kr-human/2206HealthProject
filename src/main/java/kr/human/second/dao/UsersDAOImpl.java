package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.ReservationVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public class UsersDAOImpl implements UsersDAO{
   private static UsersDAO instance = new UsersDAOImpl();
   private UsersDAOImpl() {}
   public static UsersDAO getInstance(){
      return instance;
   }
   
   // 회원가입
   @Override
   public void U_insert(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
      sqlSession.insert("users.U_insert", usersVO);
   }
   
   // 회원 탈퇴
   @Override
   public void U_delete(SqlSession sqlSession, String u_id) throws SQLException {
      sqlSession.delete("users.U_delete", u_id);
   }
   
   // 회원 정보 수정
   @Override
   public void U_update(SqlSession sqlSession, UsersVO usersVO) throws SQLException {
      sqlSession.update("users.U_update", usersVO);
   }
   
   // 동일한 아이디 갯수 얻기 (중복확인)
   @Override
   public int SelectByUserId(SqlSession sqlSession, String u_id) throws SQLException {
      return sqlSession.selectOne("users.SelectByUserId", u_id);
   }
   
   // 동일한 닉네임 갯수 얻기 (중복확인)
   @Override
   public int SelectByUserNickname(SqlSession sqlSession, String u_nicname) throws SQLException {
      return sqlSession.selectOne("users.SelectByUserNickname", u_nicname);
   }
   
   // 1개 얻기 (user_id)로 얻기
   @Override
   public UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException {
      return sqlSession.selectOne("users.SelectByUserInfo", u_id);
   }

   // 자신의 강사 가져오기
   @Override
   public TrainerVO SelectByTrainer(SqlSession sqlSession, String t_id) throws SQLException {
      return sqlSession.selectOne("users.SelectByTrainer", t_id);
   }
   
   // 비밀번호 변경
   @Override
   public void ChangePassword(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
      sqlSession.update("users.ChangePassword", map);
   }
   
   // 아이디 찾기 (name으로 가져오기)
   @Override
   public List<UsersVO> FindUserId(SqlSession sqlSession, String u_email) throws SQLException {
      return sqlSession.selectList("users.FindUserId", u_email);
   }
   
   // 해당 수업을 예약하는 회원이 생겼을때 생성
   @Override
   public void R_insert(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException {
      sqlSession.insert("reservation.R_insert", reservationVO);
   }
   
   // 해당 pt수업을 예약을한 회원이 예약을 취소한경우
   @Override
   public void R_delete(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
      sqlSession.delete("reservation.R_delete", map);
   }
   
   // pt수업예약정보
   @Override
   public List<ReservationVO> selectByptCode(SqlSession sqlSession, String pt_Code) throws SQLException {
      return sqlSession.selectList("reservation.selectByptCode", pt_Code);
   }
   
   // 나의 전체 pt수업 예약 정보
   @Override
   public List<ReservationVO> selectAllReservation(SqlSession sqlSession, String u_id) {
	   return sqlSession.selectList("reservation.selectAllReservation", u_id);
   }
   
   @Override
   public List<PTClassVO> selectPtOneMonth(SqlSession sqlSession, PTClassVO ptClassVO) {
	   return sqlSession.selectList("users.selectPtOneMonth", ptClassVO);
   }
   
   @Override
   public List<PTClassVO> selectPtOneDay(SqlSession sqlSession, PTClassVO ptClassVO) {
	   return sqlSession.selectList("users.selectPtOneDay", ptClassVO);
   }
   
}