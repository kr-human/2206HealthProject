package kr.human.second.service;

import java.util.List;
import kr.human.second.vo.PTClassVO;

public interface PTClassService {
	// PT일정표 등록하기
	void insert(PTClassVO ptclassVO);
	// PT일정표 삭제하기
	void delete(PTClassVO ptclassVO);
	// PT일정표 확인하기 - 1일 얻기
	List<PTClassVO> selectByPTOneDayCheck();
	// PT일정표 확인하기 - 1개 얻기
	PTClassVO selectByPTCheck(int idx);
	
}
