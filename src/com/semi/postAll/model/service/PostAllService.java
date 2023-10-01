package com.semi.postAll.model.service;

import com.semi.common.model.vo.PageInfo;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.donation.model.dao.DonationDao;
import com.semi.donation.model.vo.Donation;
import com.semi.postAll.model.dao.PostAllDao;
import com.semi.postAll.model.vo.PostAll;
import com.semi.common.model.vo.PageInfo;

public class PostAllService {

	public int insertPostAll(PostAll p) {

		Connection conn = getConnection();

		int result = new PostAllDao().insertPostAll(conn, p);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int deletePost(String postNo) {

		Connection conn = getConnection();

		int result = new PostAllDao().deletePost(conn, postNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ArrayList<PostAll> PostSelect() {

		Connection conn = getConnection();

		ArrayList<PostAll> list = new PostAllDao().PostSelect(conn);

		if (!(list == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list;
	}

	public ArrayList<PostAll> PostRSelect(PageInfo pi, String callerNo) {

		Connection conn = getConnection();

		ArrayList<PostAll> list = new PostAllDao().PostRSelect(conn, pi, callerNo);

		if (!(list == null)) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return list;
	}

	public int PselectListCount() {

		Connection conn = getConnection();

		int listCount = new PostAllDao().PselectListCount(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<PostAll> PselectList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<PostAll> list = new PostAllDao().PselectList(conn, pi);

		close(conn);

		return list;
	}

	public String searchReceiverNo(String receiverName) {

		Connection conn = getConnection();

		String receiverNo = new PostAllDao().searchReceiverNo(conn, receiverName);

		close(conn);

		return receiverNo;
	}

}
