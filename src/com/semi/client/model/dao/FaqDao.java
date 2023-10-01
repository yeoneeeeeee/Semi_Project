package com.semi.client.model.dao;

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

import com.semi.client.model.vo.Faq;
import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;

public class FaqDao {
	
private Properties prop = new Properties();
	
	public FaqDao() {
		
		String fileName =FaqDao.class.getResource("/sql/faq/faq-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Faq> faqList(Connection conn, PageInfo pi) {
		
		ArrayList<Faq> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("faqList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(
						rset.getString("FAQ_NO"),
						rset.getString("FAQ_TITLE"),
						rset.getString("FAQ_CONTENT"),
						rset.getDate("CREATE_DATE"),
						rset.getString("USER_NAME"),
						rset.getString("STATUS")
					));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	/**
	 * 페이징 : 조건 검색
	 * @param conn
	 * @return
	 */
	public ArrayList<Faq> selectFaqList(Connection conn, PageInfo pi, String keyword, String category) {
		
		ArrayList<Faq> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "";
		
		switch(category) {
		
		case "날짜순" :
			sql = prop.getProperty("selectEnrollDate");
			break;
		case "제목순" :
			sql = prop.getProperty("selectFaqTitle");
			break;
		default :
			sql = prop.getProperty("selectMemberNo");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
		
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(
						rset.getString("FAQ_NO"),
						rset.getString("FAQ_TITLE"),
						rset.getString("FAQ_CONTENT"),
						rset.getDate("CREATE_DATE"),
						rset.getString("USER_NAME"),
						rset.getString("STATUS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	
	public int selectListCount(Connection conn) {
	      
	      int listCount = 0;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectFaqListCount");
	   
	      try {
	         pstmt = conn.prepareStatement(sql);

	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	        	 listCount = rset.getInt(1);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return listCount;
	}
	
	/**
	 * 페이징 : 조건 검색
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public int selectFaqCount(Connection conn, String keyword) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeywordFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	public int deleteFaq(Connection conn, String faqNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, faqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	

}
