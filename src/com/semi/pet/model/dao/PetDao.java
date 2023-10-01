package com.semi.pet.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.common.model.vo.PageInfo;
import com.semi.pet.model.vo.Pet;

public class PetDao {

   private Properties prop = new Properties();

   public PetDao() {

      String fileName = PetDao.class.getResource("/sql/pet/pet-mapper.xml").getPath();

      try {
         prop.loadFromXML(new FileInputStream(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   
   /** 페이징처리
    * @param conn
    * @param pif
    * @return list
    */
   public ArrayList<Pet> selectList(Connection conn, PageInfo pi){
      
      ArrayList<Pet> list = new ArrayList();
      
      PreparedStatement pstmt = null;
      
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectList");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() +1;
         int endRow = startRow + pi.getBoardLimit() -1;
         
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            list.add(new Pet(
                        rset.getString("PET_NO"), 
                        rset.getString("PET_NAME"), 
                        rset.getString("PET_KIND"),
                        rset.getInt("PET_AGE"), 
                        rset.getString("PET_GENDER"), 
                        rset.getInt("PET_PRICE"),
                        rset.getDate("PET_RESCUE"), 
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
   
   
   /** 총 게시글 갯수 
    * @param conn
    * @return listCount
    */
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
   
  
   

   /**
    * 펫조회
    * @param conn
    * @param petNo
    * @return p
    */
   public Pet selectPet(Connection conn, String petNo) {

      Pet p = null;

      PreparedStatement pstmt = null;

      String sql = prop.getProperty("selectPet");

      ResultSet rset = null;

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, p.getPetNo());

         rset = pstmt.executeQuery();

         if(rset.next()) {
            p = new Pet(rset.getString("PET_NO"), 
                     rset.getString("PET_NAME"), 
                     rset.getString("PET_KIND"),
                     rset.getInt("PET_AGE"), 
                     rset.getString("PET_GENDER"), 
                     rset.getInt("PET_PRICE"),
                     rset.getDate("PET_RESCUE"), 
                     rset.getString("STATUS")
                     );
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return p;
   }

   public int insertPet(Connection conn, Pet p) {

      int result = 0;

      PreparedStatement pstmt = null;

      String sql = prop.getProperty("insertPet");

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, p.getPetName());
         pstmt.setString(2, p.getPetKind());
         pstmt.setInt(3, p.getPetAge());
         pstmt.setString(4, p.getPetGender());
         pstmt.setInt(5, p.getPetPrice());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int updatePet(Connection conn, Pet p) {

      int result = 0;

      PreparedStatement pstmt = null;

      String sql = prop.getProperty("updatePet");

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, p.getPetNo());
         pstmt.setString(2, p.getPetName());
         pstmt.setString(3, p.getPetKind());
         pstmt.setInt(4, p.getPetAge());
         pstmt.setString(5, p.getPetGender());
         pstmt.setInt(6, p.getPetPrice());
         pstmt.setDate(7, p.getPetRescue());
         pstmt.setString(8, p.getStatus());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int deletePet(Connection conn, String petNo) {
      
      int result = 0;

      PreparedStatement pstmt = null;

      String sql = prop.getProperty("deletePet");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, petNo);

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result;
   }


   public ArrayList<Pet> selectPetList(Connection conn) {
	  
	   ArrayList<Pet> list = new ArrayList();
	      
	   PreparedStatement pstmt = null;
	      
	   ResultSet rset = null;
	      
	   String sql = prop.getProperty("selectPetList");
	      
	   try {
	      pstmt = conn.prepareStatement(sql);
	      
	      rset = pstmt.executeQuery();

	      while(rset.next()) {
	    	  Pet p = new Pet(rset.getString("PET_NO"),
	    			  rset.getString("PET_NAME"),
	    			  rset.getString("PET_KIND"),
	    			  rset.getInt("PET_AGE"),
	    			  rset.getString("PET_GENDER"),
	    			  rset.getInt("PET_PRICE"),
	    			  rset.getDate("PET_RESCUE"),
	    			  rset.getString("STATUS"));
                list.add(p);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return list;
	   }
}