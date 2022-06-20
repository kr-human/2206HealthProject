package kr.human.second.service;

import javax.servlet.http.HttpSession;

import kr.human.second.vo.UsersVO;

public interface UsersService {
	//아이디 중복 확인
	int u_idCheck(String u_id);	
	//닉네임 중복 확인
	int u_nicnameCheck(String u_nicname);
	//유저 로그인
	boolean u_login(String u_id, String u_password, HttpSession httpSession);
	//회원 가입 (저장)
	void u_insert(UsersVO usersVO,String urlAddress);
}
