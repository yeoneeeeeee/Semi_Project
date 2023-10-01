package com.semi.delivery.model.vo;

import java.sql.Date;

public class Delivery {

	private String delNo;				//	DEL_NO
	private String delStatus;		//	DEL_STATUS
	private String curSpot;			//	CUR_SPOT
	private String petNo;				//	PET_NO
	private String petName;
	private String petKind;
	private int    petAge;
	private String userNo;				//	USER_NO
	private String userName;
	private Date deliveryDate;
	
	public Delivery() {
		
	}
	
	/**
	 * @author 전체 목록
	 * @ return list
	 */
	public Delivery(String delNo, String delStatus, String curSpot, String petNo, String petName, String petKind, int petAge, String userNo, String userName, Date deliveryDate) {
		super();
		this.delNo = delNo;
		this.delStatus = delStatus;
		this.curSpot = curSpot;
		this.petNo = petNo;
		this.petName = petName;
		this.petKind = petKind;
		this.petAge = petAge;
		this.userNo = userNo;
		this.userName = userName;
		this.deliveryDate =deliveryDate;
	}

	
	/**
	 * @param 배송고유번호별 배송현황 조회
	 */
	public Delivery(String petName, String delNo, String delStatus, String curSpot, String userNo) {
		super();
		this.petName = petName;
		this.delNo = delNo;
		this.delStatus = delStatus;
		this.curSpot = curSpot;
		this.userNo = userNo;
	}

	
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDelNo() {
		return delNo;
	}
	
	public void setDelNo(String delNo) {
		this.delNo = delNo;
	}
	
	public String getDelStatus() {
		return delStatus;
	}
	
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	
	public String getCurSpot() {
		return curSpot;
	}
	
	public void setCurSpot(String curSpot) {
		this.curSpot = curSpot;
	}
	
	public String getPetNo() {
		return petNo;
	}
	
	public void setPetNo(String petNo) {
		this.petNo = petNo;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetKind() {
		return petKind;
	}
	
	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}
	
	public int getPetAge() {
		return petAge;
	}
	
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	public String getUserNo() {
		return userNo;
	}
	
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Delivery [delNo=" + delNo + ", delStatus=" + delStatus + ", curSpot=" + curSpot + ", petNo=" + petNo
				+ ", petName=" + petName + ", petAge=" + petAge + ", userNo=" + userNo + ", userName=" + userName + ", deliveryDate=" + deliveryDate + "]";
	}
		
}
