package com.semi.pet.model.vo;

import java.sql.Date;

public class Pet {

   private String petNo;
   private String petName;
   private String petKind;
   private int petAge;
   private String petGender;
   private int petPrice;
   private Date petRescue;
   private String status;
   
   public Pet() {
      
   }
   
   public Pet(String petNo, String petName, String petKind, int petAge, String petGender, int petPrice, Date petRescue,
         String status) {
      super();
      this.petNo = petNo;
      this.petName = petName;
      this.petKind = petKind;
      this.petAge = petAge;
      this.petGender = petGender;
      this.petPrice = petPrice;
      this.petRescue = petRescue;
      this.status = status;
   }
   
   

   public Pet(String petName, String petKind, int petAge, String petGender, int petPrice, Date petRescue) {
	super();
	this.petName = petName;
	this.petKind = petKind;
	this.petAge = petAge;
	this.petGender = petGender;
	this.petPrice = petPrice;
	this.petRescue = petRescue;
   }

   public Pet(String petNo, String petName, int petAge, String petGender) {
		super();
		this.petNo = petNo;
		this.petName = petName;
		this.petAge = petAge;
		this.petGender = petGender;
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

   public String getPetGender() {
      return petGender;
   }

   public void setPetGender(String petGender) {
      this.petGender = petGender;
   }

   public int getPetPrice() {
      return petPrice;
   }

   public void setPetPrice(int petPrice) {
      this.petPrice = petPrice;
   }

   public Date getPetRescue() {
      return petRescue;
   }

   public void setPetRescue(Date petRescue) {
      this.petRescue = petRescue;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Pet [petNo=" + petNo + ", petName=" + petName + ", petKind=" + petKind + ", petAge=" + petAge
            + ", petGender=" + petGender + ", petPrice=" + petPrice + ", petRescue=" + petRescue + ", status="
            + status + "]";
   }
   
   
}