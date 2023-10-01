package com.semi.board.model.vo;

import java.sql.Date;

public class GetThePet {
	
	private String getNo;
	private String getContent;
	private Date createDate;
	private String petNo;
	private String status;
	private String thumbnail;
	
	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public GetThePet() {
		
	}


	public GetThePet(String getNo, String getContent, Date createDate, String petNo, String status) {
		super();
		this.getNo = getNo;
		this.getContent = getContent;
		this.createDate = createDate;
		this.petNo = petNo;
		this.status = status;
	}


	public String getGetNo() {
		return getNo;
	}


	public void setGetNo(String getNo) {
		this.getNo = getNo;
	}


	public String getGetContent() {
		return getContent;
	}


	public void setGetContent(String getContent) {
		this.getContent = getContent;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getPetNo() {
		return petNo;
	}


	public void setPetNo(String petNo) {
		this.petNo = petNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "GetThePet [getNo=" + getNo + ", getContent=" + getContent + ", createDate=" + createDate + ", petNo="
				+ petNo + ", status=" + status + ", thumbnail=" + thumbnail + "]";
	}

	
	
}
