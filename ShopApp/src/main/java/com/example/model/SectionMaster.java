package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class SectionMaster {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private int studentcClass;
	private String section;
	private int createdId;
	private String createdBy;
	private Timestamp createdTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getStudentcClass() {
		return studentcClass;
	}
	public void setStudentcClass(int studentcClass) {
		this.studentcClass = studentcClass;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
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
	
	
	
	

}
