package com.semi.postAll.model.vo;

import java.sql.Date;

public class PostAll {
	private String postNo;
	private String postTitle;
	private String postContent;
	private Date createDate;
	private String receiverNo;
	private String callerNo;
	private String status;

	public class postAll {

	}

	public PostAll(String postNo, String postTitle, String postContent, Date createDate, String receiverNo,
			String callerNo, String status) {
		super();
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.createDate = createDate;
		this.receiverNo = receiverNo;
		this.callerNo = callerNo;
		this.status = status;
	}

	public PostAll(String postTitle, String postContent, String receiverNo, String callerNo) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.receiverNo = receiverNo;
		this.callerNo = callerNo;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReceiverNo() {
		return receiverNo;
	}

	public void setReceiverNo(String receiverNo) {
		this.receiverNo = receiverNo;
	}

	public String getCallerNo() {
		return callerNo;
	}

	public void setCallerNo(String callerNo) {
		this.callerNo = callerNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PostAll [postNo=" + postNo + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", createDate=" + createDate + ", receiverNo=" + receiverNo + ", callerNo=" + callerNo + ", status="
				+ status + "]";
	}

}
