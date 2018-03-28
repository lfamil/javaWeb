package com.nuesoft.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory sqlsessionfactory = null;
	static {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlsessionfactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ªÒ»°SqlSessionFactory
	 * */
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlsessionfactory;
	}
	/**
	 * πÿ±’SqlSession
	 * */
	public static void close(SqlSession sqlsession) {
		sqlsession.close();
	}
}
