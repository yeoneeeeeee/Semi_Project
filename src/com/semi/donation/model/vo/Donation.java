package com.semi.donation.model.vo;

import java.sql.Date;

public class Donation {
	private String donationNo;
	private int donaPrice;
	private String donaKind;
	private Date donaDate;
	private String userNo;
	private int total;
	private int sum;

	public class donation {

	}

	public Donation() {

	}

	public Donation(String donationNo, int donaPrice, String donaKind, Date donaDate, String userNo, int total,
			int sum) {
		super();
		this.donationNo = donationNo;
		this.donaPrice = donaPrice;
		this.donaKind = donaKind;
		this.donaDate = donaDate;
		this.userNo = userNo;
		this.total = total;
		this.sum = sum;
	}

	public Donation(int total, int sum) {
		super();
		this.total = total;
		this.sum = sum;
	}

	public Donation(int donaPrice, String donaKind, String userNo) {
		super();
		this.donaPrice = donaPrice;
		this.donaKind = donaKind;
		this.userNo = userNo;
	}

	public Donation(int donaPrice, String donaKind) {
		super();
		this.donaPrice = donaPrice;
		this.donaKind = donaKind;
	}

	public Donation(String donationNo, int donaPrice, String donaKind, Date donaDate, String userNo) {
		super();
		this.donationNo = donationNo;
		this.donaPrice = donaPrice;
		this.donaKind = donaKind;
		this.donaDate = donaDate;
		this.userNo = userNo;
	}

	public String getDonationNo() {
		return donationNo;
	}

	public void setDonationNo(String donationNo) {
		this.donationNo = donationNo;
	}

	public int getDonaPrice() {
		return donaPrice;
	}

	public void setDonaPrice(int donaPrice) {
		this.donaPrice = donaPrice;
	}

	public String getDonaKind() {
		return donaKind;
	}

	public void setDonaKind(String donaKind) {
		this.donaKind = donaKind;
	}

	public Date getDonaDate() {
		return donaDate;
	}

	public void setDonaDate(Date donaDate) {
		this.donaDate = donaDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Donation [donationNo=" + donationNo + ", donaPrice=" + donaPrice + ", donaKind=" + donaKind
				+ ", donaDate=" + donaDate + ", userNo=" + userNo + "]";
	}

}
