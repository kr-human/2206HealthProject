package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
<<<<<<< HEAD
	private static NoticeDAO instance = new NoticeDAOImpl();
	private NoticeDAOImpl() {}
	public static NoticeDAO getInstance(){
		return instance;
=======
	   private static NoticeDAO instance = new NoticeDAOImpl();
	   private NoticeDAOImpl() {}
	   public static NoticeDAO getInstance(){
	      return instance;
	   }
	   @Override
	   public void N_insert(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
	      sqlSession.insert("notice.insert",noticeVO);
	   }
	   @Override
	   public void N_update(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
	      sqlSession.update("notice.update", noticeVO);
	   }
	   @Override
	   public void N_delete(SqlSession sqlSession, int idx) throws SQLException {
	      sqlSession.delete("notice.delete", idx);
	   }
	   @Override
	   public int clickCount(SqlSession sqlSession) throws SQLException {
	      return sqlSession.selectOne("notice.clickCount");
	   }
	   @Override
	   public List<NoticeVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
	      return sqlSession.selectList("notice.selectList",map);
	   }
	   @Override
	   public int selectCount(SqlSession sqlSession) throws SQLException {
	      return sqlSession.selectOne("notice.selectCount");
	   }
	   @Override
	   public NoticeVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
	      return sqlSession.selectOne("notice.selectByIdx", idx);
	   }
	   @Override
	   public int selectMaxIdx(SqlSession sqlSession) throws SQLException {
		   return sqlSession.selectOne("fileBoard.selectMaxIdx");
	   }
>>>>>>> origin/subMain
	}
    @Override
    public void N_insert(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
       sqlSession.insert("notice.insert",noticeVO);
    }
    @Override
    public void N_update(SqlSession sqlSession, NoticeVO noticeVO) throws SQLException {
       sqlSession.update("notice.update", noticeVO);
    }
    @Override
    public void N_delete(SqlSession sqlSession, int idx) throws SQLException {
       sqlSession.delete("notice.delete", idx);
    }
    @Override
    public int clickCount(SqlSession sqlSession) throws SQLException {
       return sqlSession.selectOne("notice.clickCount");
    }
    @Override
    public List<NoticeVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
       return sqlSession.selectList("notice.selectList",map);
    }
    @Override
    public int selectCount(SqlSession sqlSession) throws SQLException {
       return sqlSession.selectOne("notice.selectCount");
    }
    @Override
    public NoticeVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
       return sqlSession.selectOne("notice.selectByIdx", idx);
    }

}
