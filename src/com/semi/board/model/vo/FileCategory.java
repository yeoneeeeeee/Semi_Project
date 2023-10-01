package com.semi.board.model.vo;

public class FileCategory {
	
	private String categoryNo;
	private String categoryName;
	
	public FileCategory() {
		
	}
	
	
	public FileCategory(String categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}


	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "FileCategory [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
}
