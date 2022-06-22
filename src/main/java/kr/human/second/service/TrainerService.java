package kr.human.second.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.human.second.vo.MemberVO;

public interface TrainerService {
	// 나의 회원 목록 보기
	List<MemberVO> SelectByUserList();
	// 나의 회원 정보 보기
	MemberVO SelectByUserInfo(String myTrainer);
	// 회원 pt이용권 등록, 스타트, 엔드데이 등록
	void MemberUpdate(MemberVO memberVO, int newPt, Date newStartDay, Date newEndDay, HttpSession httpSession);
}
