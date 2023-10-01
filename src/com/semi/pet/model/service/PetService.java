package com.semi.pet.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.vo.Member;
import com.semi.pet.model.dao.PetDao;
import com.semi.pet.model.vo.Pet;

public class PetService {

   
   /** 페이징처리
    * @param pif
    * @return list
    */
   public ArrayList<Pet> selectAllPet(PageInfo pi) {

      Connection conn = getConnection();

      ArrayList<Pet> list = new PetDao().selectList(conn,pi);

      close(conn);

      return list;
   }
   
   
   /** 총 게시글 갯수
    * @return listCount
    */
   public int selectListCount() {
      
      Connection conn = getConnection();
      
      int listCount = new PetDao().selectListCount(conn);  
      
      close(conn);
      
      return listCount;
   }
   
   
   /**
    * pet 상세조회
    * @param petNo
    * @return p
    */
   public Pet selectPet(String petNo) {

      Connection conn = getConnection();

      Pet p = new PetDao().selectPet(conn, petNo);

      close(conn);

      return p;
   }

   public int insertPet(Pet p) {

      Connection conn = getConnection();

      int result = new PetDao().insertPet(conn, p);

      if (result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }

      close(conn);

      return result;
   }

   public int updatePet(Pet p) {

      Connection conn = getConnection();

      int result = new PetDao().updatePet(conn, p);

      Pet updatePet = null;

      if (result > 0) {
         commit(conn);

         updatePet = new PetDao().selectPet(conn, p.getPetNo());
      } else {
         rollback(conn);
      }
      close(conn);

      return result;
   }

   public int deletePet(String petNo) {

      Connection conn = getConnection();

      int result = new PetDao().deletePet(conn, petNo);

      if (result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);

      return result;
   }


	public ArrayList<Pet> selectPetList() {
	
		Connection conn = getConnection();
	
		ArrayList<Pet> list = new PetDao().selectPetList(conn);
	
		close(conn);
	
		return list;
	}
   
}