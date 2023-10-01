package com.semi.board.model.vo;

import java.sql.Date;

public class FAQ {
	private String faqNo;
	private String faqTitle;
	private String faqContent;
	private Date createDate;
	private int count;
	private String userNo;
	private String category;
	private int rnum;
	private String writer;
	
	public FAQ() {
		super();
	}
	
	
	public FAQ(String faqNo, String faqTitle, Date createDate, int count, String category,int rnum,String writer) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.createDate = createDate;
		this.count = count;
		this.category = category;
		this.rnum = rnum;
		this.writer = writer;
	}
	


	public FAQ(String faqNo, String faqTitle, String faqContent, String userNo, String category,String writer,Date createDate) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.userNo = userNo;
		this.category = category;
		this.writer = writer;
		this.createDate = createDate;
	}

	

	public FAQ(int count) {
		super();
		this.count = count;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getRnum() {
		return rnum;
	}


	public void setRnum(int rnum) {
		this.rnum = rnum;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
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

	@Override
	public String toString() {
		return "FAQ [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", createDate="
				+ createDate + ", userNo=" + userNo + "]";
	}
	
	
}
