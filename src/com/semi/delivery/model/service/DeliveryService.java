package com.semi.delivery.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.common.model.vo.PageInfo;
import com.semi.delivery.model.dao.DeliveryDao;
import com.semi.delivery.model.vo.Delivery;
import com.semi.pet.model.dao.PetDao;


public class DeliveryService {

	public ArrayList<Delivery> selectDeliveryList(PageInfo pi){
		
		Connection conn = getConnection();

		ArrayList<Delivery> list = new DeliveryDao().selectDeliveryList(conn, pi);

		close(conn);

		return list;
	}
	
	/** 상세조회
	 * @param delNo
	 * @return d
	 */
	public Delivery selectDelivery(String delNo) {
		Connection conn = getConnection();

		Delivery d = new DeliveryDao().selectDelivery(conn, delNo);

		close(conn);

		return d;
	}

	public int insertDelivery(Delivery d) {
		
		Connection conn = getConnection();
		
		int result = new DeliveryDao().insertDelivery(conn, d);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int updateDelivery(Delivery d) {
		
		Connection conn = getConnection();
		
		int result = new DeliveryDao().updateDelivery(conn,d);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int DeliveryCompletedUpdate(Delivery d) {
		
		Connection conn = getConnection();
		
		int result = new DeliveryDao().updateDelivery(conn,d);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteDelivery(String delNo) {
		
		Connection conn = getConnection();
		
		int result = new DeliveryDao().deleteDelivery(conn, delNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateDelivery(String delNo) {

		Connection conn = getConnection();
		
		int result = new DeliveryDao().updateDelivery(conn,delNo);
		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int completedDelivery(String delNo) {
		
		Connection conn = getConnection();
		
		int result = new DeliveryDao().completedDelivery(conn,delNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Delivery> selectAdoptDeliveryList(){
		Connection conn = getConnection();

		ArrayList<Delivery> list = new DeliveryDao().selectAdoptDeliveryList(conn);

		close(conn);

		return list;
	}

	public int selectListCount() {
		Connection conn = getConnection();
	      
	    int listCount = new DeliveryDao().selectListCount(conn);  
	      
	    close(conn);
	      
	    return listCount;
	}
	
	public int selectListCount(String userNo) {
		Connection conn = getConnection();
		
		int listCount = new DeliveryDao().selectListCount(conn,userNo);  
		
		close(conn);
		
		return listCount;
	}
	
}
