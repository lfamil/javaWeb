package com.nuesoft.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Utils { 
	private static Properties ps=new Properties();
	
	static {
		//���������ļ�·��
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
	//һ����������
		try {
			ps.load(is);
			Class.forName(ps.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//����׼��������url
	public static Connection getConnection() throws SQLException {
		Connection conn=null;
		conn=DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));
		return conn;	
	}
	//�ߡ��ر�����
	//���¹رշ���
	public static void close(Connection conn,Statement st) throws SQLException {
		conn.close();
		st.close();
	}
	public static void close(Connection conn,Statement st,ResultSet rs) throws SQLException {
		conn.close();
		st.close();
		rs.close();
	}
	public static void close(Connection conn,PreparedStatement  pst,ResultSet rs) throws SQLException {
		conn.close();
		pst.close();
		rs.close();
	}
}



