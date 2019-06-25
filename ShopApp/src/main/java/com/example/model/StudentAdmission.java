package com.example.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class StudentAdmission {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private int studentClass;
	private int fee;
	private int feeStatus;
	private int discount;
	private int finalFee;
	private String createdBy;
	private Timestamp createdTime;
	private int studentId;
	private String studentName;
	private int createdId;
	private String studentSection;
	
	
	
	
	
	
	
	public String getStudentSection() {
		return studentSection;
	}
	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	private int FeeBalance;
	
	
	
	
	public int getFeeBalance() {
		return FeeBalance;
	}
	public void setFeeBalance(int feeBalance) {
		FeeBalance = feeBalance;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(int feeStatus) {
		this.feeStatus = feeStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getFinalFee() {
		return finalFee;
	}
	public void setFinalFee(int finalFee) {
		this.finalFee = finalFee;
	}

	
	
	
	
	

}
