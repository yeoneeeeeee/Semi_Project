package com.semi.client.model.vo;

import java.sql.Date;

public class Report {
	
	private String reportNo;
	private String reportContent;
	private Date createDate;
	private String boardNo;
	private String status;
	private int total;
	
	public Report() {
		
	}

	public Report(String reportNo, String reportContent, Date createDate, String boardNo, String status, int total) {
		super();
		this.reportNo = reportNo;
		this.reportContent = reportContent;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.status = status;
		this.total = total;
	}

	public Report(String reportNo, String reportContent, Date createDate, String boardNo, String status) {
		super();
		this.reportNo = reportNo;
		this.reportContent = reportContent;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.status = status;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportContent=" + reportContent + ", createDate=" + createDate
				+ ", boardNo=" + boardNo + ", status=" + status + ", total=" + total + "]";
	}
	
	

}
