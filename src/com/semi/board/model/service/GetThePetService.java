package com.semi.board.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.board.model.dao.GetThePetDao;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Favorite;
import com.semi.board.model.vo.FileCategory;
import com.semi.board.model.vo.GetThePet;
import com.semi.common.model.vo.PageInfo;
import com.semi.pet.model.vo.Pet;

public class GetThePetService {
	
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new GetThePetDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int selectSearchListCount(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new GetThePetDao().selectSearchListCount(conn, keyword);
		
		close(conn);
		
		return listCount;
	}
	
	
	public ArrayList<GetThePet> selectGetThePetList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<GetThePet> list = new GetThePetDao().selectGetThePetList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<GetThePet> searchGetThePetList(PageInfo pi, String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<GetThePet> list = new GetThePetDao().searchGetThePetList(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<Pet> selectGetThePetInfoList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Pet> list = new GetThePetDao().selectGetThePetInfoList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<Pet> searchGetThePetInfoList(PageInfo pi, String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Pet> list = new GetThePetDao().searchGetThePetInfoList(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}
	

	
	public GetThePet selectGetThePet(String boardNo) {
		
		Connection conn = getConnection();
		
		GetThePet g = new GetThePetDao().selectGetThePet(conn, boardNo);
		
		close(conn);
		
		return g;
	}
	
	public Pet selectGetThePetInfo(String boardNo) {
		
		Connection conn = getConnection();
		
		Pet p = new GetThePetDao().selectGetThePetInfo(conn, boardNo);
		
		close(conn);
		
		return p;
	}
	
	
	public ArrayList<Attachment> selectAttachmentList(String boardNo){
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new GetThePetDao().selectAttachmentList(conn, boardNo);
		
		close(conn);
		
		return list;
	}
	
	
	public ArrayList<FileCategory> selectCategoryList(){
		Connection conn = getConnection();
		
		ArrayList<FileCategory> list = new GetThePetDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	
	public int insertGetThePet(GetThePet g, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		int result1 = new GetThePetDao().insertGetThePet(conn, g);
		
		int result2 = 1;
		
		if(list != null) {
				
			result2 = new GetThePetDao().insertAttachmentList(conn, list);
			
		}
		
		if(result1>0 && result2 >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return result1 * result2;
		
	}
	
	public int updateGetThePet(GetThePet g, ArrayList<Attachment> reUpList) {
		Connection conn = getConnection();
		
		int result1 = new GetThePetDao().updateGetThePet(conn, g);
		
		int result2 = 1;
		
		if(reUpList != null) {
				
				result2 = new GetThePetDao().updateAttachment(conn, reUpList);
				
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}
	

	public int deleteGetThePet(GetThePet g, ArrayList<Attachment> at) {
		Connection conn = getConnection();
		
		int result1 = new GetThePetDao().deleteGetThePet(conn, g);
		
		int result2 = 1;
		
		if(at != null) {
			
			result2 = new GetThePetDao().deleteAttachment(conn, at);
			
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}
	

	public int deleteAttachment(GetThePet g, ArrayList<Attachment> at) {
		Connection conn = getConnection();
		
		int result = 1;
		
		if(at != null) {
			
			result = new GetThePetDao().deleteAttachment(conn, at);
			
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int checkPetNo(String petNo) {
		
		Connection conn = getConnection();
		
		int result = new GetThePetDao().checkPetNo(conn, petNo);
		
		close(conn);
		
		return result;
	}
	
	
	public Pet getPetInfo(String petNo) {
		
		Connection conn = getConnection();
		
		Pet p = new GetThePetDao().getPetInfo(conn, petNo);
		
		close(conn);
		
		return p;
	}
	
	public ArrayList<GetThePet> searchGet(String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<GetThePet> list = new GetThePetDao().searchGet(conn, keyword);
		
		close(conn);
		
		return list;
	}
	
	public int insertFavorite(Favorite f) {
		
		Connection conn = getConnection();
		
		int result = new GetThePetDao().insertFavorite(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteFavorite(Favorite f) {
		
		Connection conn = getConnection();
		
		int result = new GetThePetDao().deleteFavorite(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Pet> selectFavoritePet(String userNo, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Pet> list = new GetThePetDao().selectFavoritePet(conn, userNo, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<String> selectFavoriteGet(String userNo, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<String> list = new GetThePetDao().selectFavoriteGet(conn, userNo, pi);
		
		close(conn);
		
		return list;
	}
	
	public Favorite checkFavorite(String userNo, String boardNo){
		
		Connection conn = getConnection();
		
		Favorite f = new GetThePetDao().checkFavorite(conn, userNo, boardNo);
		
		close(conn);
		
		return f;
	}
	
	public int selectListCountFavorite(String userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new GetThePetDao().selectListCountFavorite(conn, userNo);
		
		close(conn);
		
		return listCount;
	}
}
