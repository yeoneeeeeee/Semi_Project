package com.semi.donation.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.semi.common.JDBCTemplate.*;

import com.semi.common.model.vo.PageInfo;
import com.semi.donation.model.dao.DonationDao;
import com.semi.donation.model.vo.Donation;
import com.semi.member.model.vo.Grade;
import com.semi.postAll.model.dao.PostAllDao;
import com.semi.postAll.model.vo.PostAll;
import com.semi.member.model.vo.*;

public class DonationService {

	public int insertDonation(Donation d) {

		Connection conn = getConnection();

		int result = new DonationDao().insertDonation(conn, d);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ArrayList<Donation> donaCount() {

		Connection conn = getConnection();

		ArrayList<Donation> list = new DonationDao().donaCount(conn);

		if (!(list == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list;
	}

	public Donation selectDonation(String userId) {

		Connection conn = getConnection();

		Donation d = new DonationDao().selectDonation(conn, userId);

		close(conn);

		return d;
	}

	public Donation memberDonation(String userId) {

		Connection conn = getConnection();

		Donation d = new DonationDao().memberDonation(conn, userId);

		close(conn);

		return d;
	}
	
	public ArrayList<Donation> nSelectDonation(PageInfo pi ,String userNo) {

		Connection conn = getConnection();

		ArrayList<Donation> list = new DonationDao().nSelectDonation(conn, pi, userNo);

		if (!(list == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list;
	}
	
	public ArrayList<Donation> ASelectDonation(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Donation> list = new DonationDao().ASelectDonation(conn, pi);

		if (!(list == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list;
	}
	public  ArrayList<Grade> searchGrade(String userNo1) {

		Connection conn = getConnection();

		ArrayList<Grade> list1 = new DonationDao().searchGrade(conn, userNo1);

		if (!(list1 == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list1;
	}

}
