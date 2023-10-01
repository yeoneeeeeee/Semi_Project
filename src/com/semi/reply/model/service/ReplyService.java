package com.semi.reply.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.semi.member.model.dao.MemberDao;
import com.semi.reply.model.dao.ReplyDao;

public class ReplyService {

public int replyAd(String userNo, String receiver, String post) {
		
		Connection conn = getConnection();
		
		receiver = new MemberDao().userNo(conn, receiver);
		
		int result = new ReplyDao().replyAd(conn, userNo, receiver, post);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}
