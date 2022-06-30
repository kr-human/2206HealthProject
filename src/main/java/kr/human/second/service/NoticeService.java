package kr.human.second.service;

import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.PagingVO;

public interface NoticeService {
	// 1. 목록보기
		PagingVO<NoticeVO> selectList(int currentPage, int pageSize, int blockSize);
		// 2. 내용보기
		NoticeVO selectByIdx(int idx, boolean isClick); // isClick 조회수 때문에
		// 3. 저장하기
		void insert(NoticeVO NoticeVO);
		// 4. 수정하기
		void update(NoticeVO NoticeVO);
		// 5. 삭제하기
		void delete(NoticeVO NoticeVO);
}
