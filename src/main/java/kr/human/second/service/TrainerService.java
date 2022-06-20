package kr.human.second.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import kr.human.second.vo.PTClassVO;
import kr.human.second.vo.UsersVO;

public interface TrainerService {
	//강사 로그인
	boolean t_login(String t_id, String t_password, HttpSession httpSession);
	// PT일정표 등록하기
	void insert(PTClassVO ptclassVO);
	// PT일정표 삭제하기
	void delete(PTClassVO ptclassVO);
	// PT일정표 확인하기 - 1일 얻기
	List<PTClassVO> selectByPTOneDayCheck();
	// PT일정표 확인하기 - 1개 얻기
	PTClassVO selectByPTCheck(String pt_Code);
	// 자기 회원 정보 확인 -- 전체보기
	List<UsersVO> selectByUserList(String t_id);
	// 자기 회원 정보 상세 확인 -- 1명 보기
	UsersVO selectByUser(String u_id);
	
}
