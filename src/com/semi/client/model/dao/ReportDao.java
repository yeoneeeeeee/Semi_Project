package com.semi.client.model.dao;

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
import com.semi.client.model.vo.Report;
import com.semi.common.model.vo.PageInfo;

public class ReportDao {
	
	private Properties prop = new Properties();
	
	public ReportDao() {
		
		String fileName = ReportDao.class.getResource("/sql/faq/faq-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Report> reportList(Connection conn, PageInfo pi) {
		
		ArrayList<Report> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("reportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(
						rset.getString("REPORT_NO"),
						rset.getString("REPORT_CONTENT"),
						rset.getDate("CREATE_DATE"),
						rset.getString("BOARD_NO"),
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
	public ArrayList<Report> selectReportList(Connection conn, PageInfo pi, String keyword, String category) {
		
		ArrayList<Report> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "";
		
		switch(category) {
		
		case "날짜순" :
			sql = prop.getProperty("selectReportEnrollDate");
			break;
		case "제목순" :
			sql = prop.getProperty("selectReportNo");
			break;
		default :
			sql = prop.getProperty("selectReportBoardNo");
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
				list.add(new Report(
						rset.getString("REPORT_NO"),
						rset.getString("REPORT_CONTENT"),
						rset.getDate("CREATE_DATE"),
						rset.getString("BOARD_NO"),
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
	
	
	
	public int deleteReport(Connection conn, String reportNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reportNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectListCount(Connection conn) {
	      
	      int listCount = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectReportListCount");
	   
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
	public int selectReportCount(Connection conn, String keyword) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeywordReport");
		
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

}
