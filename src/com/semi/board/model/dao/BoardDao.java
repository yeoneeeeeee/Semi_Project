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
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.FAQ;
import com.semi.board.model.vo.Reply;
import com.semi.board.model.vo.Report;
import com.semi.common.model.vo.PageInfo;

public class BoardDao {

	private Properties prop = new Properties();

	public BoardDao() {

		String fileName = BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Board selectBoard(Connection conn, String userId) {

		Board b = new Board();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				b = new Board(
								rset.getString("BOARD_NO"), 
								rset.getString("BOARD_TITLE"), 
								rset.getString("BOARD_CATEGORY"), 
								rset.getString("BOARD_CONTENT"), 
								rset.getDate("CREATE_DATE"), 
								rset.getInt("COUNT"), 
								rset.getString("WRITER_NO"), 
								rset.getString("STATUS")
							);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public Board memberBoard(Connection conn, String userId) {

		Board b = new Board();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("memberBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				b = new Board(rset.getInt("TOTAL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}
	
	public Board selectCountBoard(Connection conn, String userId) {
		Board listCount = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCountBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = new Board(rset.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountReport(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCountReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountBoard(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountNone(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountNone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountShare(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountShare");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountAdopt(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountAdopt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountFaqPet(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountFaqPet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountFaqEtc(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountFaqEtc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public int selectListCountFaqDona(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountFaqDona");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountTitle(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountNum(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountWriter(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCountWriter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListFaqCountTitle(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqCountTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListFaqCountNum(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqCountNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListFaqCountWriter(Connection conn,String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqCountWriter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Report> reportList(Connection conn, PageInfo pi){
		ArrayList<Report> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getString("REPORT_NO"),rset.getString("REPORT_CONTENT"),rset.getDate("CREATE_DATE"),rset.getString("BOARD_NO"),rset.getString("STATUS")));
				
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
	
	
	
	public ArrayList<Board> selectListBoard(Connection conn, PageInfo pi){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	
	public ArrayList<Board> selectListShare(Connection conn, PageInfo pi){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListShare");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	public ArrayList<Board> selectListNone(Connection conn, PageInfo pi){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListNone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	public ArrayList<Board> selectListAdopt(Connection conn, PageInfo pi){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListAdopt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	
	public ArrayList<FAQ> selectListFaqPet(Connection conn, PageInfo pi){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqPet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
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
	public ArrayList<FAQ> selectListFaqEtc(Connection conn, PageInfo pi){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqEtc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
				
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
	public ArrayList<FAQ> selectListFaqDona(Connection conn, PageInfo pi){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListFaqDona");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
				
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
	
	public Board selectBoard2(Connection conn, String boardNo) {
		Board b = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board(
						rset.getString("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"),
						rset.getDate("CREATE_DATE"),
						rset.getInt("COUNT"),
						rset.getString("USER_NAME"),
						rset.getString("WRITER_NO"),
						rset.getString("BOARD_CATEGORY")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public FAQ selectFaq(Connection conn, String faqNo) {
		FAQ b = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, faqNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getString("FAQ_CONTENT"),rset.getString("USER_NO"),rset.getString("FAQ_CATEGORY"),rset.getString("USER_NAME"),rset.getDate("CREATE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	
	public ArrayList<Board> selectWriter(Connection conn, PageInfo pi,String search){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWriter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	
	
	public ArrayList<Board> selectTitle(Connection conn, PageInfo pi,String search){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	
	
	public ArrayList<Board> selectNum(Connection conn, PageInfo pi,String search){
		ArrayList<Board> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	
	public ArrayList<FAQ> selectFaqWriter(Connection conn, PageInfo pi,String search){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqWriter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+search+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
				
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
	
	
	public ArrayList<FAQ> selectFaqTitle(Connection conn, PageInfo pi,String search){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
				
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
	
	
	public ArrayList<FAQ> selectFaqNum(Connection conn, PageInfo pi,String search){
		ArrayList<FAQ> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
				
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
	
	public int increaseCount(Connection conn, String boardNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int increaseCountFaq(Connection conn, String faqNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCountFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,faqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardCategory());
			pstmt.setString(3, b.getWriteNo());
			pstmt.setString(4, b.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertFaq(Connection conn, FAQ f) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getCategory());
			pstmt.setString(3, f.getUserNo());
			pstmt.setString(4, f.getFaqContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteBoard(Connection conn, String boardNo) {
		int result = 0;
		
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		String sql = prop.getProperty("deleteBoard");
		String sql2 = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setString(1, "N");
			pstmt.setString(2, boardNo);
			
			pstmt2.setString(1, boardNo);
			
			result = pstmt2.executeUpdate();
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteFaq(Connection conn, String faqNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "N");
			pstmt.setString(2, faqNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardCategory());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateFaq(Connection conn, FAQ b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getCategory());
			pstmt.setString(2, b.getFaqTitle());
			pstmt.setString(3, b.getFaqContent());
			pstmt.setString(4, b.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertReply(Connection conn, Reply r) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReplyContent());
			pstmt.setString(2, r.getBoardNo());
			pstmt.setString(3, r.getUserName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, String boardNo){
		ArrayList<Reply> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setUserName(rset.getString("USER_NAME"));
				r.setCreateDate(rset.getDate("CREATE_DATE"));
				
				list.add(r);
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
	
	public ArrayList<Attachment> selectAttachmentBoardList(Connection conn, String boardNo){
		ArrayList<Attachment> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachmentBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(at);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertAttachmentBoardList(Connection conn,ArrayList<Attachment> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachmentBoardList");
		
		try {
			for(Attachment at : list) {
				//반복문이 돌때마다 미완성된 sql문을 담은 pstmt객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getCategoryNo());
				result *= pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateAttachmentBoardList(Connection conn,Board b,ArrayList<Attachment> list) {
		int result = 1;
		int result2 = 0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = prop.getProperty("updateAttachmentBoardList");
		String sql2 = prop.getProperty("deleteAttachment");
		try {
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, b.getBoardNo());
			result2 = pstmt2.executeUpdate();
			for(Attachment at : list) {
				//반복문이 돌때마다 미완성된 sql문을 담은 pstmt객체 생성
				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, at.getFileNo());
				pstmt.setString(1, at.getBoardNo());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				pstmt.setString(4, at.getFilePath());
				pstmt.setString(5, at.getCategoryNo());
				
				result *= pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Board> searchBoardList(Connection conn, String search){
		ArrayList<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchBoardCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, "%"+search+"%");
			
			rset = pstmt.executeQuery();
						
			while(rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
				
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
	public ArrayList<Board> selectBoardUser(Connection conn, String userId, PageInfo pi) {

		ArrayList<Board> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBoardUser");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);	
			pstmt.setString(3, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> selectBoardMember(Connection conn, String userId) {

		ArrayList<Board> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBoardMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Board(rset.getString("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getDate("CREATE_DATE"), rset.getInt("COUNT"),
						rset.getString("USER_NAME"),rset.getString("BOARD_CATEGORY"),rset.getInt("RNUM")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int selectCountUser(Connection conn, String userId) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCountUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<FAQ> selectBoardFaqMember(Connection conn, String userId) {

		ArrayList<FAQ> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBoardFaqMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public FAQ selectCountFaqUser(Connection conn, String userId) {
		FAQ listCount = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCountFaqUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = new FAQ(rset.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	public ArrayList<FAQ> selectBoardFaqMember(Connection conn, String userId, PageInfo pi) {

		ArrayList<FAQ> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBoardFaqMemberM");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);	
			pstmt.setString(3, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new FAQ(rset.getString("FAQ_NO"),rset.getString("FAQ_TITLE"),rset.getDate("CREATE_DATE"),rset.getInt("COUNT"),rset.getString("FAQ_CATEGORY")
						,rset.getInt("RNUM"),rset.getString("USER_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteMyBoard(Connection conn, String boardNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMyBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,boardNo );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMyFaqBoard(Connection conn, String boardNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMyFaqBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,boardNo );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertReport(Connection conn, Report r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReportContent());
			pstmt.setString(2, r.getBoardNo());
			
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
