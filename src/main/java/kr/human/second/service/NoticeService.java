package kr.human.second.service;


import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.PagingVO;

public interface NoticeService {
	// 1. 목록보기
	PagingVO<NoticeVO> selectList(int currentPage, int pageSize, int blockSize);
	// 2. 내용보기
	NoticeVO selectByIdx(int idx);
	// 3. 저장하기
	void insert(NoticeVO NoticeVO);
	// 4. 수정하기
	void update(NoticeVO NoticeVO, String path, String[] delfile);
	// 5. 삭제하기
	void delete(NoticeVO NoticeVO, String path);
}
