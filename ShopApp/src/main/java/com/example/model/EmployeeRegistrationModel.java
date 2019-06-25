package com.example.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class EmployeeRegistrationModel {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String employeeFirstName;
	private String employeelastName;
	private int employeeAge;
	private String employeeEmail;
	private String employeePassword;
	private Date employeeDateOfBirth;
	private String employeeRole;
	private Timestamp createdDate;
	private String createdBy;
	private int  employeeUserName;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public int getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(int employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeelastName() {
		return employeelastName;
	}
	public void setEmployeelastName(String employeelastName) {
		this.employeelastName = employeelastName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}
	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	

}
