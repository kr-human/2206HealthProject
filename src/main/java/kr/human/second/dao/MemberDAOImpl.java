package kr.human.second.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.human.second.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	//---------------------------------------------------------------
	//싱글톤으로 만들어보즈아!!!
	private static MemberDAO instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	//---------------------------------------------------------------
	
	@Override
	public MemberVO selectMyInfo(SqlSession sqlSession, String id) throws SQLException {
		return sqlSession.selectOne("member.selectMyInfo", id);
	}
	@Override
	public MemberVO selectMyTrainerInfo(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		System.out.println("id : "+map.get("id"));
		return sqlSession.selectOne("member.selectMyTrainerInfo", map);
	}
	@Override
	public void updateMember(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		sqlSession.update("member.updateMember", map);
	}
	
	
}
