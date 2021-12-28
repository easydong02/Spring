package com.koreait.springmvc.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//mybatis의 설정파일을 읽어들여 sqlsessionfactory로부터 sqlsession을 배급 및 반환하는 전담 객체
public class MybatisConfig {
	private static MybatisConfig instance= new MybatisConfig();
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig() {
		try {
			String resource = "com/koreait/springmvc/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession() {
		SqlSession sqlSession =null;
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	public static MybatisConfig getInstance() {
		return instance;
	}
}
