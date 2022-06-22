package kr.human.second.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public class TrainerDAOImpl implements TrainerDAO{
	private static TrainerDAO instance = new TrainerDAOImpl();
	private TrainerDAOImpl() {}
	public static TrainerDAO getInstance(){
		return instance;
	}
	//-------------------------------------------------------------------------
	// 나의 회원 목록 보기
	@Override
	public List<MemberVO> SelectByUserList(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectList("trainer.SelectByUserList");
	}
	// 나의 회원 정보 보기
	@Override
	public MemberVO SelectByUserInfo(SqlSession sqlSession, String myTrainer) throws SQLException {
		return sqlSession.selectOne("trainer.SelectByUserInfo", myTrainer);
	}
	// 회원 pt이용권 등록, 스타트, 엔드데이 등록
	@Override
	public void MemberUpdate(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
		sqlSession.delete("trainer.MemberUpdate", memberVO);
	}

}
