package kr.human.second.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.NoticeDAO;
import kr.human.second.dao.NoticeDAOImpl;
import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoticeServiceImpl  implements NoticeService{
	private static NoticeService instance = new NoticeServiceImpl();
	private NoticeServiceImpl() {}
	public static NoticeService getInstance() {
		return instance;
	}
	@Override 
	public PagingVO<NoticeVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.info("NoticeServiceImpl selectList 호출 : " + currentPage + ", " + pageSize + ", " + blockSize);
		PagingVO<NoticeVO> pagingVO = null;
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 전체 개수를 구한다.
			int totalCount = NoticeDAO.selectCount(sqlSession);
			// 2. 페이지를 계산한다.
			pagingVO = new PagingVO<NoticeVO>(totalCount, currentPage, pageSize, blockSize);
			// 3. 글목록을 가져온다.
			HashMap<String, Integer> map = new HashMap<>();
			map.put("startNo", pagingVO.getStartNo());
			map.put("endNo", pagingVO.getEndNo());
			List<NoticeVO> list = NoticeDAO.selectList(sqlSession, map);
			// 4. 글의 목록을 pageingVO에 넣어준다.
			pagingVO.setList(list);
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		log.info("NoticeServiceImpl selectList 리턴 : " + pagingVO);
		return pagingVO;
	}
	@Override
	public NoticeVO selectByIdx(int idx) {
		log.info("NoticeServiceImpl selectByIdx 호출 : " + idx);
		NoticeVO NoticeVO= null;
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 해당 글번호의 글을 가져온다.
			NoticeVO = NoticeDAO.selectByIdx(sqlSession, idx);
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------
		log.info("NoticeServiceImpl selectByIdx 리턴 : " + NoticeVO);
		return NoticeVO;
	}
	
	@Override
	public void insert(NoticeVO NoticeVO) {
		log.info("NoticeServiceImpl insert 호출 : " + NoticeVO);
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;

		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(NoticeVO!=null) {
				// 2. 원본글을 저장한다.
				NoticeDAO.N_insert(sqlSession, NoticeVO);
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------
	}

	@Override
	public void update(NoticeVO NoticeVO) {
		log.info("NoticeServiceImpl update 호출 : " + NoticeVO);
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(NoticeVO!=null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				NoticeVO dbVO = NoticeDAO.selectByIdx(sqlSession, NoticeVO.getIdx());
				// 3. DB에 글이 있으면
				if(dbVO!=null){
					// 원본글 수정
					NoticeDAO.N_update(sqlSession, NoticeVO);
				}
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------			
	}

	@Override
	public void delete(NoticeVO NoticeVO) {
		log.info("FileBoardServiceImpl delete 호출 : " + NoticeVO);
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(NoticeVO!=null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				NoticeVO dbVO = NoticeDAO.selectByIdx(sqlSession, NoticeVO.getIdx());
				// 3. DB에 글이 있으면
				if(dbVO!=null){
					// 원본글 삭제
					NoticeDAO.N_delete(sqlSession, NoticeVO.getIdx());
				}
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------		
	}
}
