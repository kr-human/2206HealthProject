package kr.human.second.service;

import javax.servlet.http.HttpSession;

public interface TrainerService {
	//강사 로그인
	boolean t_login(String t_id, String t_password, HttpSession httpSession);
}
