package com.semi.client.model.vo;

import java.sql.Date;

public class Faq {
	
	private String FaqNo;
	private String FaqTitle;
	private String FaqContent;
	private Date createDate;
	private String userNo;
	private String status;
	private int total;
	
	public Faq() {
		
	}

	public Faq(String FaqNo, String FaqTitle, String FaqContent, Date createDate, String userNo, String status,
			int total) {
		super();
		this.FaqNo = FaqNo;
		this.FaqTitle = FaqTitle;
		this.FaqContent = FaqContent;
		this.createDate = createDate;
		this.userNo = userNo;
		this.status = status;
		this.total = total;
	}

	public Faq(String FaqNo, String FaqTitle, String FaqContent, Date createDate, String userNo, String status) {
		super();
		this.FaqNo = FaqNo;
		this.FaqTitle = FaqTitle;
		this.FaqContent = FaqContent;
		this.createDate = createDate;
		this.userNo = userNo;
		this.status = status;
	}

	public String getFaqNo() {
		return FaqNo;
	}

	public void setFaqNo(String FaqNo) {
		this.FaqNo = FaqNo;
	}

	public String getFaqTitle() {
		return FaqTitle;
	}

	public void setFaqTitle(String FaqTitle) {
		this.FaqTitle = FaqTitle;
	}

	public String getFaqContent() {
		return FaqContent;
	}

	public void setFaqContent(String FaqContent) {
		this.FaqContent = FaqContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
		return "Faq [FaqNo=" + FaqNo + ", FaqTitle=" + FaqTitle + ", FaqContent=" + FaqContent + ", createDate="
				+ createDate + ", userNo=" + userNo + ", status=" + status + ", total=" + total + "]";
	}
	
	
	
	
}
