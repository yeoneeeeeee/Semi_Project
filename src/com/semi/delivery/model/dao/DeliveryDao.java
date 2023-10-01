package com.semi.delivery.model.dao;

import static com.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.common.model.vo.PageInfo;
import com.semi.delivery.model.vo.Delivery;
import com.semi.pet.model.dao.PetDao;
import com.semi.pet.model.vo.Pet;

public class DeliveryDao {
	private Properties prop = new Properties();

	public DeliveryDao() {

		String fileName = PetDao.class.getResource("/sql/delivery/delivery-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Delivery> selectDeliveryList(Connection conn, PageInfo pi) {

		ArrayList<Delivery> list = new ArrayList<Delivery>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectDeliveryList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() +1;
	        int endRow = startRow + pi.getBoardLimit() -1;
	         
	        pstmt.setInt(1, startRow);
	        pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Delivery d = new Delivery(rset.getString("DEL_NO"), 
						rset.getString("DEL_STATUS"), 
						rset.getString("CUR_SPOT"),
						rset.getString("PET_NO"), 
						rset.getString("PET_NAME"), 
						rset.getString("PET_KIND"), 
						rset.getInt("PET_AGE"), 
						rset.getString("USER_NO"),
						rset.getString("USER_NAME"),
						rset.getDate("DELIVERY_DATE")
						);
			list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public Delivery selectDelivery(Connection conn, String delNo) {

		Delivery d = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectDelivery");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				d = new Delivery(rset.getString("DEL_NO"), 
						rset.getString("DEL_STATUS"), 
						rset.getString("CUR_SPOT"),
						rset.getString("PET_NO"), 
						rset.getString("PET_NAME"), 
						rset.getString("PET_KIND"), 
						rset.getInt("PET_AGE"), 
						rset.getString("USER_NO"),
						rset.getString("USER_NAME"),
						rset.getDate("DELIVERY_DATE")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return d;
	}
	
	public int insertDelivery(Connection conn, Delivery d) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertDelivery");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, d.getCurSpot());
			pstmt.setString(2, d.getPetNo());
			pstmt.setString(3, d.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int updateDelivery(Connection conn, Delivery d) {

		int result = 0;
		
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateDelivery");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, d.getDelNo());
			pstmt.setString(2, d.getDelStatus());
			pstmt.setString(3, d.getCurSpot());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int DeliveryCompletedUpdate(Connection conn, Delivery d) {

		int result = 0;
		
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("DeliveryCompletedUpdate");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, d.getDelNo());
			pstmt.setString(2, d.getDelStatus());
			pstmt.setString(3, d.getCurSpot());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteDelivery(Connection conn, String delNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteDelivery");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, delNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}


	public int updateDelivery(Connection conn, String delNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateCurDelivery");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, delNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public int completedDelivery(Connection conn, String delNo) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("completedDelivery");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, delNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public ArrayList<Delivery> selectAdoptDeliveryList(Connection conn){
		ArrayList<Delivery> list = new ArrayList<Delivery>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectAdoptDeliveryList");

		try {
			pstmt = conn.prepareStatement(sql);
			
		    rset = pstmt.executeQuery();

			while(rset.next()) {
				Delivery d = new Delivery(rset.getString("DEL_NO"), 
						rset.getString("DEL_STATUS"), 
						rset.getString("CUR_SPOT"),
						rset.getString("PET_NO"), 
						rset.getString("PET_NAME"), 
						rset.getString("PET_KIND"), 
						rset.getInt("PET_AGE"), 
						rset.getString("USER_NO"),
						rset.getString("USER_NAME"),
						rset.getDate("DELIVERY_DATE")
						);
				list.add(d);
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
	      
	      String sql = prop.getProperty("selectListCount");
	   
	      try {
	         pstmt = conn.prepareStatement(sql);

	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            listCount = rset.getInt(1); //명칭을 안정해줘서 그냥 숫자만 사용(예외방식 한 번 사용해봄)
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return listCount;
	}
	
	public int selectListCount(Connection conn, String userNo) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountUserNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1); //명칭을 안정해줘서 그냥 숫자만 사용(예외방식 한 번 사용해봄)
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
