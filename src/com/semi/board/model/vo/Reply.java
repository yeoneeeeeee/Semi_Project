package com.semi.board.model.vo;

import java.sql.Date;

public class Reply {
	private String replyNo;
	private String replyContent;
	private Date createDate;
	private String boardNo;
	private String status;
	private String userName;
	
	public Reply() {
		super();
	}

	
	


	public Reply(String replyContent, Date createDate, String boardNo, String userName) {
		super();
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.userName = userName;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", boardNo=" + boardNo + ", status=" + status + "]";
	}
	
	
}
