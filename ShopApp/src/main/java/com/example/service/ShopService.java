package com.example.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.ShopDao;
import com.example.model.FeeMasterModel;
import com.example.model.RegisterModel;
import com.example.model.SectionMaster;
@Service
public class ShopService {
	@Autowired
	private ShopDao shopDao;
	public int register(String firstName,String lastName,int age,String email,String gender,String mobile,String password,Date dateOfBirth,String userName,String bloodGroup,String address,String motherName,String fatherName,MultipartFile studentPhoto ) {
		return shopDao.save(firstName,lastName,age,email,gender,mobile,password,dateOfBirth,userName,bloodGroup,address,motherName,fatherName,studentPhoto);
		
	}
	
	public 	String validate(int userName) {
		return shopDao.validate(userName);
	}
	
	
	public void saveFee(int studentClass,int studentFee,int userName ) {
		shopDao.saveFee(studentClass,studentFee,userName);
		
	}
	
	public int saveEmployeeDetails(String employeeFirstName,String  employeelastName,int employeeAge,java.util.Date employeeDateOfBirth,String employeePassword,String employeeEmail,String employeeRole,String userName) {
	 return shopDao.saveEmployeeDetails(employeeFirstName,employeelastName,employeeAge,employeeDateOfBirth,employeePassword,employeeEmail,employeeRole,userName);
	}
	
	/*
	 * public void studentAdmission() { shopDao.saveAdmission(); }
	 */
	
	
	public List<RegisterModel> getStudentDetailsById(int studentId){
		
		return shopDao.getStudentDetailsById( studentId);
	}
	
	public int  getFeeByClass(int name) {
		return shopDao.getFeebyClass(name);
		
	}
	public List<SectionMaster>  getSectionByClass(int name) {
		return shopDao.getSectionByClass(name);
		
	}
	
	
	public void saveAdmissionWithFee(int studentId,int studentClass,int classfee,int finalAmount,int discount,int userName,String studentSection) {
	
		 shopDao.saveAdmissionWithFee(studentId,studentClass,classfee,finalAmount,discount,userName,studentSection);
	
}
	
	
	public void addSection(int studentClass,String studentSection,int userName) {
		shopDao.addSection(studentClass, studentSection,userName);
	}
	
	
	public List<String> getTestClass(int studentClass){
		return shopDao.getTestClass(studentClass);
		
		
	}
}