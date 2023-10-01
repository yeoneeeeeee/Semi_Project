package com.semi.board.model.vo;

public class Favorite {
	
	private String userNo;
	private String getNo;
	
	public Favorite() {
		
	}
	public Favorite(String userNo, String getNo) {
		super();
		this.userNo = userNo;
		this.getNo = getNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getGetNo() {
		return getNo;
	}
	public void setGetNo(String getNo) {
		this.getNo = getNo;
	}
	@Override
	public String toString() {
		return "Favorite [userNo=" + userNo + ", getNo=" + getNo + "]";
	}
	
	

}
