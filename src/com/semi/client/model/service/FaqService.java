package com.semi.client.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.client.model.dao.FaqDao;
import com.semi.client.model.vo.Faq;
import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;
import com.semi.pet.model.dao.PetDao;

public class FaqService {
	
	public ArrayList<Faq> faqList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().faqList(conn, pi);
		close(conn);
		
		return list;
	}
	
	/**
	 * 페이징 : 조건 검색 
	 * @param m
	 * @return ArrayList<Member>
	 */
	public ArrayList<Faq> selectFaqList(PageInfo pi, String keyword, String category) {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn, pi, keyword, category);
		
		close(conn);
		
		return list;
	}

	
   public int selectListCount() {
      
      Connection conn = getConnection();
      
      int listCount = new FaqDao().selectListCount(conn);  
      
      close(conn);
      
      return listCount;
   }
   
   /**
	 * 페이징 : 조건 검색 
	 * @param keyword
	 * @param category
	 * @return
	 */
	public int selectFaqCount(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new FaqDao().selectFaqCount(conn,keyword);
		
		close(conn);
		
		return listCount;
	}
	
	
   public int deleteFaq(String faqNo) {
	   
	   Connection conn = getConnection();
	   
	   int result = new FaqDao().deleteFaq(conn, faqNo);
	   
	   if(result > 0) {
		   commit(conn);
	   } else {
		   rollback(conn);
	   }
	   close(conn);
	   
	   return result;
   }
}
