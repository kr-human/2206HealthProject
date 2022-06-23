package kr.human.second.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.human.second.vo.MemberVO;

public interface TrainerService {
	// 전체 회원 목록 보기
	List<MemberVO> SelectByAllUserList();
	// 전체 회원 중 한명 정보 보기
	MemberVO SelectByAllUserInfo(String id);
	// 나의 회원 목록 보기
	List<MemberVO> SelectByUserList(String trainerid);
	// 나의 회원 정보 보기
	MemberVO SelectByUserInfo(String trainerid);
	// 회원 pt이용권 등록, 스타트, 엔드데이 등록
	void MemberUpdate(MemberVO memberVO, HttpSession httpSession);
}
