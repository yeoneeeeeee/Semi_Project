package com.semi.board.model.vo;

import java.sql.Date;

public class Attachment {

	private String fileNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date createDate;
	private String categoryNo;
	private String boardNo;
	private String status;
	
	public Attachment() {
		
	}
	
	public Attachment(String fileNo, String originName, String changeName, String filePath, Date createDate,
			String categoryNo, String boardNo, String status) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.createDate = createDate;
		this.categoryNo = categoryNo;
		this.boardNo = boardNo;
		this.status = status;
	}

	public Attachment(String originName, String changeName, String filePath, String categoryNo) {
		super();
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.categoryNo = categoryNo;
	}

	public String getFileNo() {
		return fileNo;
	}


	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}


	public String getOriginName() {
		return originName;
	}


	public void setOriginName(String originName) {
		this.originName = originName;
	}


	public String getChangeName() {
		return changeName;
	}


	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
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
		return "Attachment [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", createDate=" + createDate + ", categoryNo=" + categoryNo + ", boardNo="
				+ boardNo + ", status=" + status + "]";
	}
	
	
}
