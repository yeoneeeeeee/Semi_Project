package com.semi.member.model.vo;

import java.sql.Date;

public class Member {

	private String userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String email;
	private String address;
	private Date enrollDate;
	private String gradeNo;
	private String status;
	
	public Member() {
		
		
	}

	/**
	 * 회원 정보 전체 조회
	 * @param userNo : 회원번호
	 * @param userName : 회원이름
	 * @param userId : 회원 아이디
	 * @param userPwd : 회원 비밀번호
	 * @param phone : 휴대전화
	 * @param email : 이메일
	 * @param address : 주소
	 * @param enrollDate : 등록일
	 * @param grade : 등급
	 * @param gradeNo : 등급번호
	 * @param status : 상태
	 */
	public Member(String userNo, String userId, String userPwd, String userName, String phone, String email,
			String address, Date enrollDate, String gradeNo, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.gradeNo = gradeNo;
		this.status = status;
	}

	/**
	 * 회원가입 양식
	 * @param userId
	 * @param userPwd
	 * @param userName
	 * @param phone
	 * @param email
	 * @param address
	 */
	public Member(String userId, String userPwd, String userName, String phone, String email, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	/**
	 * 회원 정보 수정
	 * @param userId
	 * @param userName
	 * @param phone
	 * @param email
	 * @param address
	 */
	public Member(String userId, String userName, String phone, String email, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", enrollDate=" + enrollDate
				+ ", gradeNo=" + gradeNo + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
	
}
