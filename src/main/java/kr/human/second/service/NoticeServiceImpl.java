package kr.human.second.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import kr.human.second.dao.UpFileDAO;
import kr.human.second.dao.UpFileDAOImpl;

import kr.human.second.vo.UpFileVO;
import kr.human.mybatis.MybatisApp;
import kr.human.second.dao.NoticeDAO;
import kr.human.second.dao.NoticeDAOImpl;
import kr.human.second.service.NoticeServiceImpl;
import kr.human.second.vo.NoticeVO;
import kr.human.second.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoticeServiceImpl implements NoticeService {
	private static NoticeService instance = new NoticeServiceImpl();

	private NoticeServiceImpl() {
	}

	public static NoticeService getInstance() {
		return instance;
	}

	@Override
	public PagingVO<NoticeVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.info("NoticeServiceImpl selectList 호출 : " + currentPage + ", " + pageSize + ", " + blockSize);
		PagingVO<NoticeVO> pagingVO = null;
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		UpFileDAO upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			// --------------------------------------------------------------------
			// 1. 전체 개수를 구한다.
			int totalCount = NoticeDAO.selectCount(sqlSession);
			// 2. 페이지를 계산한다.
			pagingVO = new PagingVO<NoticeVO>(totalCount, currentPage, pageSize, blockSize);
			// 3. 글목록을 가져온다.
			HashMap<String, Integer> map = new HashMap<>();
			map.put("startNo", pagingVO.getStartNo());
			map.put("endNo", pagingVO.getEndNo());
			List<NoticeVO> list = NoticeDAO.selectList(sqlSession, map);
			// 4. 각각의 글에 대하여 첨부파일 정보를 얻어서 넣자!!!
			if (list != null) {
				for (NoticeVO vo : list) {
					List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, vo.getIdx());
					vo.setFileList(fileList);
				}
			}
			// 5. 글의 목록을 pageingVO에 넣어준다.
			pagingVO.setList(list);
			// --------------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		log.info("NoticeServiceImpl selectList 리턴 : " + pagingVO);
		return pagingVO;
	}

	@Override
	public NoticeVO selectByIdx(int idx) {
		log.info("NoticeServiceImpl selectByIdx 호출 : " + idx);
		NoticeVO NoticeVO = null;
		// ------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		UpFileDAO upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			// --------------------------------------------------------------------
			// 1. 해당 글번호의 글을 가져온다.
			NoticeVO = NoticeDAO.selectByIdx(sqlSession, idx);
			// 2. 해당글이 존재하면 첨부파일의 정보를 가져온다.
			if (NoticeVO != null) {
				List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, idx);
				NoticeVO.setFileList(fileList);
			}
			// --------------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// ----------------------------------------------------------------------------------
		log.info("NoticeServiceImpl selectByIdx 리턴 : " + NoticeVO);
		return NoticeVO;
	}

	@Override
	public void insert(NoticeVO NoticeVO) {
		log.info("NoticeServiceImpl insert 호출 : " + NoticeVO);
		// ------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		UpFileDAO upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			// --------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if (NoticeVO != null) {
				// 2. 원본글을 저장한다.
				NoticeDAO.N_insert(sqlSession, NoticeVO);

				// 3. 첨부파일을 저장한다.
				if (NoticeVO.getFileList() != null) { // 첨부파일이 있다면
					int ref = NoticeDAO.selectMaxIdx(sqlSession); // 지금 저장한 글의 idx를 읽는다.
					for (UpFileVO vo : NoticeVO.getFileList()) {
						vo.setRef(ref); // 원본글의 글번호를 넣는다.
						upFileDAO.insert(sqlSession, vo);
					}
				}
			}
			// --------------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// ----------------------------------------------------------------------------------
	}

	@Override
	public void update(NoticeVO NoticeVO, String path, String[] delfile) {
		log.info("NoticeServiceImpl update 호출 : " + NoticeVO + ", " + path + ", " + Arrays.toString(delfile));
		// ------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO NoticeDAO = null;
		UpFileDAO upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			NoticeDAO = NoticeDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			// --------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if (NoticeVO != null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				NoticeVO dbVO = NoticeDAO.selectByIdx(sqlSession, NoticeVO.getIdx());
				// 3. DB에 글이 있으면 수정한다
				if (dbVO != null) {
					// 원본글 수정
					NoticeDAO.N_update(sqlSession, NoticeVO);
					// 원본글에 추가로 파일이 첨부가 되었다면 파일을 저장한다.
					if (NoticeVO.getFileList() != null) { // 첨부파일이 있다면
						int ref = NoticeVO.getIdx();
						for (UpFileVO vo : NoticeVO.getFileList()) {
							vo.setRef(ref); // 원본글의 글번호를 넣는다.
							upFileDAO.insert(sqlSession, vo);
						}
					}
					// 4. 기존파일에 삭제를 선택했다면 기존에 업로드된 파일을 DB와 저장된 파일 자체를 지워준다.
					if (delfile != null) {
						for (String idx : delfile) {
							try {
								// DB에서 1개를 가져온다.
								UpFileVO dbFileVO = upFileDAO.selectByIdx(sqlSession, Integer.parseInt(idx));
								if (dbFileVO != null) {
									// DB에서 첨부파일 삭제
									upFileDAO.delete(sqlSession, Integer.parseInt(idx));
									// 서버에서 파일을 삭제
									File file = new File(path + File.separator + dbFileVO.getSfile());
									file.delete();
								}

							} catch (Exception e) {
								;
							}
						}
					}

				}
			}
			// --------------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// ----------------------------------------------------------------------------------

	}

	@Override
	public void delete(NoticeVO NoticeVO, String path) {
		log.info("NoticeServiceImpl delete 호출 : " + NoticeVO + ", " + path);
		// ------------------------------------------------------------
		SqlSession sqlSession = null;
		NoticeDAO fileBoardDAO = null;
		UpFileDAO upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = NoticeDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			// --------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if (NoticeVO != null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				NoticeVO dbVO = fileBoardDAO.selectByIdx(sqlSession, NoticeVO.getIdx());
				// 3. DB에 글이 있으면 삭제
				if (dbVO != null) {

					// 원본글 삭제
					fileBoardDAO.N_delete(sqlSession, NoticeVO.getIdx());

					// 원본글의 첨부파일 목록을 가져온다.
					List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, NoticeVO.getIdx());
					// 첨부파일도 삭제해야 한다.
					if (fileList != null) {
						for (UpFileVO upFileVO : fileList) {
							// DB의 첨부 삭제
							upFileDAO.delete(sqlSession, upFileVO.getIdx());
							// 서버에 저장된 파일 삭제
							File file = new File(path + File.separator + upFileVO.getSfile());
							file.delete();
						}
					}
				}
			}
			// --------------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// ----------------------------------------------------------------------------------
	}
}
