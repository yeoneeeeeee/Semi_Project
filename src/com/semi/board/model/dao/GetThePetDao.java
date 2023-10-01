package com.semi.board.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Favorite;
import com.semi.board.model.vo.FileCategory;
import com.semi.board.model.vo.GetThePet;
import com.semi.common.model.vo.PageInfo;
import com.semi.pet.model.vo.Pet;

public class GetThePetDao {

	private Properties prop = new Properties();
	
	public GetThePetDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(GetThePetDao.class.getResource("/sql/getThePet/getThePet-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
				
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectSearchListCount(Connection conn, String keyword) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	public ArrayList<GetThePet> selectGetThePetList(Connection conn, PageInfo pi) {
		
		ArrayList<GetThePet> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGetThePetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				GetThePet g = new GetThePet();
				g.setGetNo(rset.getString("GET_NO"));
				g.setGetContent(rset.getString("GET_CONTENT"));
				g.setThumbnail(rset.getString("THUMBNAIL"));
				
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pet> selectGetThePetInfoList(Connection conn, PageInfo pi){
		
		ArrayList<Pet> list = new ArrayList<Pet>();
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectGetThePetList");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Pet p = new Pet();
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetKind(rset.getString("PET_KIND"));
				p.setPetAge(rset.getInt("PET_AGE"));
				p.setPetGender(rset.getString("PET_GENDER"));
				p.setPetRescue(rset.getDate("PET_RESCUE"));
				p.setPetPrice(rset.getInt("PET_PRICE"));
				
				
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
	
	public ArrayList<GetThePet> searchGetThePetList(Connection conn, PageInfo pi, String keyword) {
		
		ArrayList<GetThePet> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchGetThePetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				GetThePet g = new GetThePet();
				g.setGetNo(rset.getString("GET_NO"));
				g.setGetContent(rset.getString("GET_CONTENT"));
				g.setThumbnail(rset.getString("THUMBNAIL"));
				
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pet> searchGetThePetInfoList(Connection conn, PageInfo pi, String keyword){
		
		ArrayList<Pet> list = new ArrayList<Pet>();
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("searchGetThePetList");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Pet p = new Pet();
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetKind(rset.getString("PET_KIND"));
				p.setPetAge(rset.getInt("PET_AGE"));
				p.setPetGender(rset.getString("PET_GENDER"));
				p.setPetRescue(rset.getDate("PET_RESCUE"));
				p.setPetPrice(rset.getInt("PET_PRICE"));
				
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
	
	public GetThePet selectGetThePet(Connection conn, String boardNo) {
		
		GetThePet g = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGetThePet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new GetThePet();
				
				g.setPetNo(rset.getString("PET_NO"));
				g.setGetNo(rset.getString("GET_NO"));
				g.setGetContent(rset.getString("GET_CONTENT"));
				g.setThumbnail(rset.getString("THUMBNAIL"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return g;
	}
	
	public Pet selectGetThePetInfo(Connection conn, String boardNo) {
		
		Pet p = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGetThePetInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Pet();
				
				p.setPetNo(rset.getString("PET_NO"));
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetKind(rset.getString("PET_KIND"));
				p.setPetAge(rset.getInt("PET_AGE"));
				p.setPetGender(rset.getString("PET_GENDER"));
				p.setPetRescue(rset.getDate("PET_RESCUE"));
				p.setPetPrice(rset.getInt("PET_PRICE"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	
	public ArrayList<Attachment> selectAttachmentList(Connection conn, String boardNo){
		
		ArrayList<Attachment> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getString("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
								
				
				list.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
	public ArrayList<FileCategory> selectCategoryList(Connection conn){
		
		ArrayList<FileCategory> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFileCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FileCategory f = new FileCategory();
				f.setCategoryNo(rset.getString("CATEGORY_NO"));
				f.setCategoryName(rset.getString("CATEGORY_NAME"));
				
				list.add(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	
	public int insertGetThePet(Connection conn, GetThePet g) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertGetThePet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getGetContent());
			pstmt.setString(2, g.getPetNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			
			for(Attachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getCategoryNo());
				
				result *= pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateGetThePet(Connection conn, GetThePet g) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateGetThePet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getGetContent());
			pstmt.setString(2, g.getPetNo());
			pstmt.setString(3, g.getGetNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int updateAttachment(Connection conn, ArrayList<Attachment> reUpList) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		try {
			
			for(Attachment at : reUpList) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getCategoryNo());
				pstmt.setString(5, at.getBoardNo());
				
				
				result *= pstmt.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteGetThePet(Connection conn, GetThePet g) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteGetThePet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getGetNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteAttachment(Connection conn, ArrayList<Attachment> at) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			
			for(Attachment a : at) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, a.getFileNo());
				
				result *= pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int checkPetNo(Connection conn, String petNo) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("checkPetNo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, petNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public Pet getPetInfo(Connection conn, String petNo) {
		
		Pet p = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("getPetInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, petNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				p = new Pet();
				p.setPetAge(rset.getInt("PET_AGE"));
				p.setPetGender(rset.getString("PET_GENDER"));
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetKind(rset.getString("PET_KIND"));
				p.setPetNo(rset.getString("PET_NO"));
				p.setPetPrice(rset.getInt("PET_PRICE"));
				p.setPetRescue(rset.getDate("PET_RESCUE"));
				p.setStatus(rset.getString("STATUS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return p;
		
	}
	
	
	public ArrayList<GetThePet> searchGet(Connection conn, String keyword) {
		
		ArrayList<GetThePet> list = new ArrayList<GetThePet>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchGet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				GetThePet g = new GetThePet();

				g.setGetNo(rset.getString("GET_NO"));
				
				list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
		
	}
	
	public int insertFavorite(Connection conn, Favorite f) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getUserNo());
			pstmt.setString(2, f.getGetNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteFavorite(Connection conn, Favorite f) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getUserNo());
			pstmt.setString(2, f.getGetNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Pet> selectFavoritePet(Connection conn, String userNo, PageInfo pi) {
		
		ArrayList<Pet> list = new ArrayList<Pet>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Pet p = new Pet();
				
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetKind(rset.getString("PET_KIND"));
				p.setPetGender(rset.getString("PET_GENDER"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<String> selectFavoriteGet(Connection conn, String userNo, PageInfo pi) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				String getNo = rset.getString("GET_NO");
				
				list.add(getNo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public Favorite checkFavorite(Connection conn, String userNo, String boardNo) {
		
		Favorite f = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userNo);
			pstmt.setString(2, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Favorite(rset.getString("USER_NO"), rset.getString("GET_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}
	
	public int selectListCountFavorite(Connection conn, String userNo) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("COUNT(*)");
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
