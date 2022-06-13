package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.ReservationVO;
import kr.human.second.vo.TrainerVO;
import kr.human.second.vo.UsersVO;

public interface UsersDAO {
	//회원가입
	void U_insert(SqlSession sqlSession, UsersVO usersVO) throws SQLException;  
	//회원 탈퇴
	void U_delete(SqlSession sqlSession, String u_id) throws SQLException;
	//회원 정보 수정
	void U_update(SqlSession sqlSession, UsersVO usersVO) throws SQLException;
	//동일한 아이디 갯수 얻기 (중복확인)
	int SelectByUserId(SqlSession sqlSession, String u_id) throws SQLException;
	//동일한 닉네임 갯수 얻기 (중복확인)
	int SelectByUserNickname(SqlSession sqlSession, String u_nicname) throws SQLException;	
	//1개 얻기 (user_id)로 얻기
	UsersVO SelectByUserInfo(SqlSession sqlSession, String u_id) throws SQLException; 	
	// 자신의 강사목록 가져오기 ----------------------- 
	// 자신의 강사 목록 ? 1:1 가정인데 자신의 강사만 불러올지
	// 트레이너 전체를 불러올지 확실히 해야할듯
	// 1. 자신의 강사만 불러온다. 2. 자신의 강사도 불러오고 전체 강사목록도 불러온다.
	List<TrainerVO> SelectByTrainerList(SqlSession sqlSession, String t_id) throws SQLException; 
	// 비밀번호 변경
	void ChangePassword(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException; 
	// 아이디 찾기 (name으로 가져오기)
	List<UsersVO> FindUserId(SqlSession sqlSession, String u_name) throws SQLException; 
	//pt예약하기 
	void R_insert(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException;
	//pt예약 변경하기
	void R_update(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException;
	//pt예약 취소하기
	void R_delete(SqlSession sqlSession, ReservationVO reservationVO) throws SQLException;
	
}
