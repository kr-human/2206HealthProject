package kr.human.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;



public class MybatisAppTest {
	
	static SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void beforeClass() {
		sqlSessionFactory = MybatisApp.getSqlSessionFactory();
	}
	
	@Test
	public void getSession() {
		assertNotNull(MybatisApp.getSqlSessionFactory());
	}


	
}
