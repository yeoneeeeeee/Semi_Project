package com.semi.board.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.board.model.dao.BoardDao;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.FAQ;
import com.semi.common.model.vo.PageInfo;
import com.semi.board.model.vo.Reply;
import com.semi.board.model.vo.Report;

public class BoardService {

	public Board selectBoard(String userId) {

		Connection conn = getConnection();

		Board b = new BoardDao().selectBoard(conn, userId);

		close(conn);

		return b;
	}

	public Board memberBoard(String userId) {

		Connection conn = getConnection();

		Board b = new BoardDao().memberBoard(conn, userId);

		close(conn);

		return b;
	}

	public Board selectCountBoard(String userId) {
		Connection conn = getConnection();

		Board listCount = new BoardDao().selectCountBoard(conn, userId);

		close(conn);

		return listCount;

	}

	public int selectListCountBoard() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountBoard(conn);

		close(conn);

		return listCount;

	}
	
	public int selectListCountReport() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountReport(conn);

		close(conn);

		return listCount;

	}


	public int selectListCountNone() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountNone(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountAdopt() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountAdopt(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountShare() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountShare(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountFaqPet() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountFaqPet(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountFaqEtc() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountFaqEtc(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountFaqDona() {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountFaqDona(conn);

		close(conn);

		return listCount;

	}

	public int selectListCountTitle(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountTitle(conn, search);

		close(conn);

		return listCount;

	}

	public int selectListCountNum(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountNum(conn, search);

		close(conn);

		return listCount;

	}

	public int selectListCountWriter(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListCountWriter(conn, search);

		close(conn);

		return listCount;

	}

	public int selectListFaqCountTitle(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListFaqCountTitle(conn, search);

		close(conn);

		return listCount;

	}

	public int selectListFaqCountNum(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListFaqCountNum(conn, search);

		close(conn);

		return listCount;

	}

	public int selectListFaqCountWriter(String search) {
		Connection conn = getConnection();

		int listCount = new BoardDao().selectListFaqCountWriter(conn, search);

		close(conn);

		return listCount;

	}
	
	public ArrayList<Report> reportList(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Report> list = new BoardDao().reportList(conn, pi);

		close(conn);

		return list;
	}
	

	public ArrayList<Board> selectListBoard(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectListBoard(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<Board> selectListNone(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectListNone(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<Board> selectListAdopt(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectListAdopt(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<Board> selectListShare(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectListShare(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<FAQ> selectListFaqPet(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectListFaqPet(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<FAQ> selectListFaqEtc(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectListFaqEtc(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<FAQ> selectListFaqDona(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectListFaqDona(conn, pi);

		close(conn);

		return list;
	}

	public ArrayList<Board> searchTitle(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectTitle(conn, pi, search);

		close(conn);

		return list;
	}

	public ArrayList<Board> searchNum(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectNum(conn, pi, search);

		close(conn);

		return list;
	}

	public ArrayList<Board> searchWriter(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectWriter(conn, pi, search);

		close(conn);

		return list;
	}

	public int increaseCount(String boardNo) {
		Connection conn = getConnection();
		int result = new BoardDao().increaseCount(conn, boardNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<FAQ> searchFaqTitle(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectFaqTitle(conn, pi, search);

		close(conn);

		return list;
	}

	public ArrayList<FAQ> searchFaqNum(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectFaqNum(conn, pi, search);

		close(conn);

		return list;
	}

	public ArrayList<FAQ> searchFaqWriter(PageInfo pi, String search) {
		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectFaqWriter(conn, pi, search);

		close(conn);

		return list;
	}

	public int increaseCountFaq(String faqNo) {
		Connection conn = getConnection();
		int result = new BoardDao().increaseCountFaq(conn, faqNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Board selectBoard2(String boardNo) {
		Connection conn = getConnection();

		Board b = new BoardDao().selectBoard2(conn, boardNo);

		close(conn);
		return b;
	}

	public FAQ selectFaq(String faqNo) {
		Connection conn = getConnection();

		FAQ b = new BoardDao().selectFaq(conn, faqNo);

		close(conn);
		return b;
	}

	public int insertBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnection();

		int result1 = new BoardDao().insertBoard(conn, b);

		int result2 = new BoardDao().insertAttachmentBoardList(conn, list);

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;

	}

	public int insertFaq(FAQ f) {
		Connection conn = getConnection();

		int result1 = new BoardDao().insertFaq(conn, f);

		if (result1 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1;

	}

	public int deleteBoard(String boardNo) {
		Connection conn = getConnection();

		int result = new BoardDao().deleteBoard(conn, boardNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteFaq(String faqNo) {
		Connection conn = getConnection();

		int result = new BoardDao().deleteFaq(conn, faqNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnection();

		int result1 = new BoardDao().updateBoard(conn, b);
		int result2 = new BoardDao().updateAttachmentBoardList(conn, b, list);

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
	}

	public int updateFaq(FAQ b) {
		Connection conn = getConnection();

		int result1 = new BoardDao().updateFaq(conn, b);

		if (result1 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();

		int result = new BoardDao().insertReply(conn, r);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Reply> selectReplyList(String boardNo) {
		Connection conn = getConnection();

		ArrayList<Reply> list = new BoardDao().selectReplyList(conn, boardNo);

		close(conn);

		return list;
	}

	public ArrayList<Attachment> selectAttachmentBoardList(String boardNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectAttachmentBoardList(conn, boardNo);

		close(conn);
		return list;

	}

	public ArrayList<Board> searchBoardList(String search) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().searchBoardList(conn, search);

		close(conn);
		return list;
	}

	public ArrayList<Board> selectBoardMember(String userId) {

		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectBoardMember(conn, userId);

		close(conn);

		return list;
	}

	public ArrayList<Board> selectBoardUser(String userId, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectBoardUser(conn, userId, pi);

		close(conn);

		return list;
	}

	public int selectCountMemberBoard(String userId) {
		Connection conn = getConnection();
		int countList = new BoardDao().selectCountUser(conn, userId);
		return countList;
	}

	public ArrayList<FAQ> selectBoardFaqMember(String userId) {

		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectBoardFaqMember(conn, userId);

		close(conn);

		return list;
	}

	public FAQ selectCountFaqBoard(String userId) {
		Connection conn = getConnection();

		FAQ listCount = new BoardDao().selectCountFaqUser(conn, userId);

		close(conn);

		return listCount;

	}

	public ArrayList<FAQ> selectBoardFaqMember(String userId, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<FAQ> list = new BoardDao().selectBoardFaqMember(conn, userId, pi);

		close(conn);

		return list;
	}

	public int deleteMyBoard(String boardNo) {
		Connection conn = getConnection();
		int result = new BoardDao().deleteMyBoard(conn, boardNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteMyFaqBoard(String boardNo) {
		Connection conn = getConnection();
		int result = new BoardDao().deleteMyFaqBoard(conn, boardNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertReport(Report r) {
		Connection conn = getConnection();

		int result1 = new BoardDao().insertReport(conn, r);


		if (result1 > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1;

	}
}
