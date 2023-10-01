package com.semi.reply.model.dao;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.member.model.dao.MemberDao;

public class ReplyDao {
	
	private Properties prop = new Properties();
	
	public ReplyDao() {
		
		String fileName = ReplyDao.class.getResource("/sql/reply/reply-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int replyAd(Connection conn, String userNo, String receiver, String post) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("replyAd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post);
			pstmt.setString(2, receiver);
			pstmt.setString(3, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	

}
