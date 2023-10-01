package com.semi.board.model.vo;

import java.sql.Date;

public class Board {
	
	private String boardNo;
	private String boardTitle;
	private String boardCategory;
	private String boardContent;
	private Date createDate;
	private int count;
	private String writeNo;
	private String status;
	private String writer;
	private int rnum;
	private int total;
	
	public Board() {
		super();
	}
	
	public Board(String boardNo, String boardTitle, String boardCategory, String boardContent, Date createDate,
			int count, String wrtierNo, String status, int total) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCategory = boardCategory;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.writeNo = wrtierNo;
		this.status = status;
		this.total = total;
	}
	
	public Board(String boardNo, String boardTitle, String boardCategory, String boardContent, Date createDate,
			int count, String writerNo, String status) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCategory = boardCategory;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.writeNo = writerNo;
		this.status = status;
	}
	
	public Board(String boardNo, String boardTitle, Date createDate, int count, String writer, String boardCategory,int rnum) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.count = count;
		this.writer = writer;
		this.boardCategory = boardCategory;
		this.rnum = rnum;
	}
	


	public Board(String boardNo, String boardTitle, String boardContent, Date createDate, int count, String writer,String writeNo, String boardCategory) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.writer = writer;
		this.writeNo = writeNo;
		this.boardCategory = boardCategory;
	}

	

	public Board(int count) {
		super();
		this.count = count;
	}


	public int getRnum() {
		return rnum;
	}


	public void setRnum(int rnum) {
		this.rnum = rnum;
	}


	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardCategory=" + boardCategory
				+ ", boardContent=" + boardContent + ", createDate=" + createDate + ", count=" + count + ", writeNo="
				+ writeNo + ", status=" + status + "]";
	}

	
}
