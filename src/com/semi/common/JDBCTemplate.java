package com.semi.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	// 공통부분 뽑아내기
	// 1. DB와 접속된 Connection 객체 생성 후 반환 메서드
	public static Connection getConnection() {
		
		// 동적 코딩방식을 적용하기 위해서 Properties 객체를 생성함
		Properties prop = new Properties();
		
		// Connection 객체를 담을 그릇 생성
		Connection conn = null;
		
		try {
			// prop로부터 load메서드를 이용해서 driver.properties에 있는 정보를 읽어들임
			String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
//			prop.load(new FileInputStream("resources/driver.properties"));
			
			prop.load(new FileInputStream(fileName));
			
			// prop로부터 getProperty함수를 이용해서 각 키값에 해당하는 벨류값을 뽑아서 배치
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
									  		   prop.getProperty("username"),
											   prop.getProperty("password"));
									
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Connection 객체 반환
		return conn;
	}
	
	// 2. 전달받은 JDBC용 객체를 반납시켜주는 메서드(객체별로)
	// 2-1) Connection객체를 전달받아서 반납시켜주는 메서드
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 2-2) Statement 객체를 전달받아서 반납시켜주는 메서드(오버로딩 적용)
	// 	    => 다형성으로 인해 PreparedStatement 객체 또한 매개변수로 전달이 가능(UpCasting)
	public static void close(Statement pstmt) {
		
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 2-3) ResultSet 객체를 전달받아서 반납시켜주는 메서드(오버로딩 적용)
	public static void close(ResultSet rset) {
		
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 3. 전달받은 Connection 객체를 가지고 트랜잭션 처리를 해주는 메서드
	// 3-1) Commit메서드
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 3-2) Rollback메서드
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && conn.isClosed()) conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
