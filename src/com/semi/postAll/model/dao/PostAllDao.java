package com.semi.postAll.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.donation.model.dao.DonationDao;
import com.semi.donation.model.vo.Donation;
import com.semi.postAll.model.vo.PostAll;
import com.semi.common.model.vo.PageInfo;

import static com.semi.common.JDBCTemplate.*;

public class PostAllDao {

	private Properties prop = new Properties();

	public PostAllDao() {

		String fileName = PostAllDao.class.getResource("/sql/postAll/postAll-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertPostAll(Connection conn, PostAll p) {

		// Insert문 => 처리된 행의 갯수를 반환
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertPost");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, p.getPostTitle());
			pstmt.setString(2, p.getPostContent());
			pstmt.setString(3, p.getReceiverNo());
			pstmt.setString(4, p.getCallerNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deletePost(Connection conn, String postNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deletePost");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, postNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<PostAll> PostSelect(Connection conn) {

		ArrayList<PostAll> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectPost");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				PostAll p = new PostAll(rset.getString("POST_NO"), rset.getString("POST_TITLE"),
						rset.getString("POST_CONTENT"), rset.getDate("CREATE_DATE"), rset.getString("RECEIVER_NO"),
						rset.getString("CALLER_NO"), rset.getString("STATUS"));

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

	public ArrayList<PostAll> PostRSelect(Connection conn, PageInfo pi, String callerNo) {

		ArrayList<PostAll> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("RselectPost");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setString(1, callerNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				PostAll p = new PostAll(rset.getString("POST_NO"), rset.getString("POST_TITLE"),
						rset.getString("POST_CONTENT"), rset.getDate("CREATE_DATE"), rset.getString("RECEIVER_NO"),
						rset.getString("CALLER_NO"), rset.getString("STATUS"));
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

	public int PselectListCount(Connection conn) {

		// SELECT문 => ResultSet객체
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			if (rset.next()) {
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

	public ArrayList<PostAll> PselectList(Connection conn, PageInfo pi) {

		ArrayList<PostAll> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				list.add(new PostAll(rset.getString("POST_NO"), rset.getString("POST_TITLE"),
						rset.getString("POST_CONTENT"), rset.getDate("CREATE_DATE"), rset.getString("RECEIVER_NO"),
						rset.getString("CALLER_NO"), rset.getString("STATUS")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	public String searchReceiverNo(Connection conn, String receiverName) {

		String receiverNo = "";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("searchName");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, receiverName);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				receiverNo += rset.getString("USER_NO") + " ";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return receiverNo;
	}

}
