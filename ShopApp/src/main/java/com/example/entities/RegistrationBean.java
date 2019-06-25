package com.example.entities;

import java.io.File;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class RegistrationBean {

	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private int age;
	private String gender;
	private java.sql.Date dateOfBirth;
	private String userName;
	private String address;
	private String motherName;
	private String fatherName;
	private String bloodGroup;
	
	/*
	 * private File studentPhoto;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public File getStudentPhoto() { return studentPhoto; } public void
	 * setStudentPhoto(File studentPhoto) { this.studentPhoto = studentPhoto; }
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
