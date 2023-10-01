package com.semi.member.model.vo;

public class Grade {

	private String gradeNo;
	private String gradeName;
	private int minDona;
	private int maxDona;
	
	public Grade() {
		
	}

	public Grade(String gradeNo, String gradeName, int minDona, int maxDona) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
		this.minDona = minDona;
		this.maxDona = maxDona;
	}
	
	/**
	 * 등급 & 등급명
	 * @param gradeNo
	 * @param gradeName
	 */
	public Grade(String gradeNo, String gradeName) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
	}

	public String getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getMinDona() {
		return minDona;
	}

	public void setMinDona(int minDona) {
		this.minDona = minDona;
	}

	public int getMaxDona() {
		return maxDona;
	}

	public void setMaxDona(int maxDona) {
		this.maxDona = maxDona;
	}

	@Override
	public String toString() {
		return "Grade [gradeNo=" + gradeNo + ", gradeName=" + gradeName + ", minDona=" + minDona + ", maxDona="
				+ maxDona + "]";
	}
	
	
	
	
}
