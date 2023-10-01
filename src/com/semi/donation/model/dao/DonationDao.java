package com.semi.donation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.common.model.vo.PageInfo;
import com.semi.donation.model.dao.DonationDao;
import com.semi.donation.model.vo.Donation;
import com.semi.member.model.vo.Grade;
import com.semi.postAll.model.vo.PostAll;
import com.semi.member.model.vo.*;

import static com.semi.common.JDBCTemplate.*;

public class DonationDao {

	private Properties prop = new Properties();

	public DonationDao() {

		String fileName = DonationDao.class.getResource("/sql/donation/donation-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertDonation(Connection conn, Donation d) {

		// Insert문 => 처리된 행의 갯수를 반환
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertDonation");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, d.getDonaPrice());
			pstmt.setString(2, d.getDonaKind());
			pstmt.setString(3, d.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Donation> donaCount(Connection conn) {

		ArrayList<Donation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("donaP");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Donation d = new Donation(rset.getString("DONATION_NO"), rset.getInt("DONA_PRICE"),
						rset.getString("DONA_KIND"), rset.getDate("DONA_DATE"), rset.getString("USER_NO")

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

	public Donation selectDonation(Connection conn, String userId) {

		Donation d = new Donation();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectDonation");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				d = new Donation(rset.getString("DONATION_NO"), rset.getInt("DONA_PRICE"), rset.getString("DONA_KIND"),
						rset.getDate("DONA_DATE"), rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return d;
	}
   
	public ArrayList<Donation> nSelectDonation(Connection conn, PageInfo pi, String userNo) {

		ArrayList<Donation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("nSelectDonation");

		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setString(1, userNo);

			rset = pstmt.executeQuery();

			while(rset.next()) {
			Donation d = new Donation(rset.getString("DONATION_NO"), rset.getInt("DONA_PRICE"), rset.getString("DONA_KIND"),
						rset.getDate("DONA_DATE"), rset.getString("USER_NO"));
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
	
	public ArrayList<Donation> ASelectDonation(Connection conn, PageInfo pi) {

		ArrayList<Donation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("donaA");

		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			rset = pstmt.executeQuery();

			while(rset.next()) {
			Donation d = new Donation(rset.getString("DONATION_NO"), rset.getInt("DONA_PRICE"), rset.getString("DONA_KIND"),
						rset.getDate("DONA_DATE"), rset.getString("USER_NO"));
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
	
	
	
	public Donation memberDonation(Connection conn, String userId) {

		Donation d = new Donation();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("memberDonation");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				d = new Donation(rset.getInt("TOTAL"), rset.getInt("SUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return d;
	}
	public ArrayList<Grade> searchGrade(Connection conn, String userNo1) {

		ArrayList<Grade> list1 = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("DonationGrade");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userNo1);
			pstmt.setString(2, userNo1);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Grade g = new Grade(rset.getString("GRADE_NO"), rset.getString("GRADE_NAME"), rset.getInt("MIN_DONA"),
							rset.getInt("MAX_DONA"));
				   list1.add(g);
				   
				   System.out.println(list1);
				}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list1;
	}

	
}