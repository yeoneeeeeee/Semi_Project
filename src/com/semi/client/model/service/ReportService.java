package com.semi.client.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.client.model.dao.FaqDao;
import com.semi.client.model.dao.ReportDao;
import com.semi.client.model.vo.Faq;
import com.semi.client.model.vo.Report;
import com.semi.common.model.vo.PageInfo;

public class ReportService {

public ArrayList<Report> reportList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().reportList(conn, pi);
		
		close(conn);
		
		return list;
	}


	/**
	 * 페이징 : 조건 검색 
	 * @param m
	 * @return ArrayList<Member>
	 */
	public ArrayList<Report> selectReportList(PageInfo pi, String keyword, String category) {
		
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().selectReportList(conn, pi, keyword, category);
		
		close(conn);
		
		return list;
	}


	public int deleteReport(String reportNo) {
		
		Connection conn = getConnection();
		
		int result = new ReportDao().deleteReport(conn, reportNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int selectListCount() {
	      
	      Connection conn = getConnection();
	      
	      int listCount = new ReportDao().selectListCount(conn);  
	      
	      close(conn);
	      
	      return listCount;
	   }
	
		
	 /**
	 * 페이징 : 조건 검색 
	 * @param keyword
	 * @param category
	 * @return
	 */
	public int selectReportCount(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new ReportDao().selectReportCount(conn,keyword);
		
		close(conn);
		
		return listCount;
	}
	
	
}
