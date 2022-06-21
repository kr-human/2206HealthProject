package kr.human.second.service;
import javax.servlet.http.HttpSession;
import kr.human.second.vo.MemberVO;
import java.util.List;



public interface MemberService {

	//아이디 중복 확인
		int idCheck(String id);	
	//유저 로그인
		boolean login(HttpSession httpSession, String id, String password);
	//회원 가입 (저장)
		void insert(MemberVO memberVO,String urlAddress);
		
    //회정정보 수정
	//회원 탈퇴
	//인증하기
	
		
	//아이디 찾기
	//비번 찾기 

}
