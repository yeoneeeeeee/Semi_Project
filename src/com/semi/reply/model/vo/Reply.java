package com.semi.reply.model.vo;

import java.sql.Date;

public class Reply {
	
	private String postNO;
	private String postName;
	private String postContent;
	private Date createDate;
	private String receiverNo;
	private String callerNo;
	private String status;
	private int total;
	
	public Reply() {
		
	}

	public Reply(String postNO, String postName, String postContent, Date createDate, String receiverNo,
			String callerNo, String status, int total) {
		super();
		this.postNO = postNO;
		this.postName = postName;
		this.postContent = postContent;
		this.createDate = createDate;
		this.receiverNo = receiverNo;
		this.callerNo = callerNo;
		this.status = status;
		this.total = total;
	}

	public Reply(String postNO, String postName, String postContent, Date createDate, String receiverNo,
			String callerNo, String status) {
		super();
		this.postNO = postNO;
		this.postName = postName;
		this.postContent = postContent;
		this.createDate = createDate;
		this.receiverNo = receiverNo;
		this.callerNo = callerNo;
		this.status = status;
	}

	public String getPostNO() {
		return postNO;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Reply [postNO=" + postNO + ", postName=" + postName + ", postContent=" + postContent + ", createDate="
				+ createDate + ", receiverNo=" + receiverNo + ", callerNo=" + callerNo + ", status=" + status
				+ ", total=" + total + "]";
	}
	
	
	

}
