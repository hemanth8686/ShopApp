package com.example.entities;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRegister {
	
private String employeeFirstName;
private String employeelastName;
private int employeeAge;
private String employeeEmail;
private String employeePassword;
private Date employeeDateOfBirth;
private String employeeRole;
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



}
