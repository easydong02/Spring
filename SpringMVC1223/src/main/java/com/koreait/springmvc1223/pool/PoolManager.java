package com.koreait.springmvc1223.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PoolManager {
	private static PoolManager instance;
	InitialContext context;
	DataSource ds;
	
	private PoolManager() {
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static PoolManager getInstance() {
		if(instance == null) {
			instance = new PoolManager();
			
		}
		
		return instance;
	}
	
	public void freeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con , PreparedStatement pstmt) {
		
		try {
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
