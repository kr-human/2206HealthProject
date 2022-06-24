package kr.human.second.service;
import javax.servlet.http.HttpSession;

import kr.human.second.vo.MemberVO;




public interface CommonService {

	//아이디 중복 확인
		int idCheck(String id);	
	//유저 로그인
		boolean login(HttpSession httpSession, String id, String password);
	//회원 가입 (저장)
		void insert(MemberVO memberVO, String urlAddress);
		
    //회정정보 수정
		void update(MemberVO memberVO, String newPassword, HttpSession httpSession);
	//회원 탈퇴
		void delete(MemberVO memberVO, HttpSession httpSession);
	//인증하기(lev 향상)
		boolean emailConfirm(String id);
		
	//아이디 찾기
	//비번 찾기 

}
