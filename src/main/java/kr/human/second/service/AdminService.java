package kr.human.second.service;

import javax.servlet.http.HttpSession;

import kr.human.second.vo.TrainerVO;

public interface AdminService {
	//아이디 중복 확인
	int t_idCheck(String t_id);
	//닉네임 중복 확인
	int t_nicnameCheck(String t_id);
	//관리자 로그인
	boolean a_login(String a_id, String a_password, HttpSession httpSession);
	//강사 등록
	void t_insert(TrainerVO trainerVO,String urlAddress);
}
