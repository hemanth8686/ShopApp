package com.example.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.jpa.Admission;
import com.example.jpa.EmployeeRegistrationJpa;
import com.example.jpa.FeeMasterJpa;
import com.example.jpa.SectionJpa;
import com.example.jpa.ShopJpa;
import com.example.model.EmployeeRegistrationModel;
import com.example.model.FeeMasterModel;
import com.example.model.RegisterModel;
import com.example.model.SectionMaster;
import com.example.model.StudentAdmission;
import com.example.service.ShopService;

@Repository
public class ShopDao {
	@Autowired
	private ShopJpa shopjpa;

	@Autowired
	private EmployeeRegistrationJpa registrationJpa;

	@Autowired
	private FeeMasterJpa feeMasterjpa;

	@Autowired
	private Admission admission;

	@Autowired
	private SectionJpa sectionJpa;

	static String format = "";

	public static String getCurrentDate() {

		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		format = sdf.format(cal);
		System.out.println(format);
		return format;

	}

	public static String getDatelog() {
		String dat = "";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = new Date();
		dat = dateFormat.format(date);

		return dat;
	}

	public int save(String firstName, String lastName, int age, String email, String gender, String mobile,
			String password, Date dateOfBirth, String userName, String bloodGroup, String motherName, String fatherName,
			String address, MultipartFile studentPhoto) {
		RegisterModel registerModel = new RegisterModel();
		registerModel.setFirstName(firstName);
		registerModel.setLastName(lastName);
		registerModel.setAge(age);
		registerModel.setEmail(email);
		registerModel.setGender(gender);
		registerModel.setMobile(mobile);
		registerModel.setPassword(password);
		registerModel.setDateOfBirth(dateOfBirth);
		registerModel.setMotherName(motherName);
		registerModel.setFatherName(fatherName);
		registerModel.setAddress(address);
		registerModel.setBloodGroup(bloodGroup);
		registerModel.setStatus(1);
		System.out.println(new Timestamp(new Date().getTime()));
		registerModel.setCreatedDate(new Timestamp(new Date().getTime()));

		System.out.println(getDatelog());

		int keyValue = 1000;

		int maxId = shopjpa.getMaxId();
		int adduniqueId = adduniqueId(maxId, keyValue);
		System.out.println(adduniqueId + "adduniqueIdadduniqueIdadduniqueIdadduniqueId");

		System.out.println(maxId + keyValue + "max id");
		registerModel.setUserName(maxId + keyValue);
		registerModel.setFullName(lastName + lastName);
		shopjpa.save(registerModel);

		if (!studentPhoto.isEmpty()) {
			try {
				byte[] bytes = studentPhoto.getBytes();

				File convertMultiPartToFile = convertMultiPartToFile(studentPhoto);

				File saveFile = new File("D:\\School\\StudentPhotos\\" + adduniqueId + File.separator + adduniqueId
						+ studentPhoto.getOriginalFilename());
				FileUtils.copyFile(convertMultiPartToFile, saveFile);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return maxId + keyValue;
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private int adduniqueId(int maxId, int value) {
		int test = maxId + value;
		return test;
	}

	public String validate(int userName) {

		String password = shopjpa.getPassword(userName);
		System.out.println(password);

		return password;

	}

	public void saveFee(int studentClass, int studentFee, int userName) {

		FeeMasterModel feeMaster = new FeeMasterModel();
		feeMaster.setStudentClass(studentClass);
		feeMaster.setFee(studentFee);
		feeMaster.setCreatedBy(userName);
		feeMasterjpa.save(feeMaster);

	}

	public int saveEmployeeDetails(String employeeFirstName, String employeelastName, int employeeAge,
			Date employeeDateOfBirth, String employeePassword, String employeeEmail, String employeeRole,
			String userName) {

		EmployeeRegistrationModel registrationModel = new EmployeeRegistrationModel();
		registrationModel.setEmployeeFirstName(employeeFirstName);
		registrationModel.setEmployeelastName(employeelastName);
		registrationModel.setEmployeeEmail(employeeEmail);
		registrationModel.setEmployeeAge(employeeAge);
		registrationModel.setEmployeePassword(employeePassword);
		registrationModel.setCreatedDate(new Timestamp(new Date().getTime()));
		registrationModel.setCreatedBy(userName);
		int maxId = registrationJpa.getMaxId();
		registrationModel.setEmployeeUserName(maxId + 500);
		registrationJpa.save(registrationModel);
		return maxId + 500;

	}

	/*
	 * public void saveAdmission() { StudentAdmission admission=new
	 * StudentAdmission();
	 * 
	 * }
	 */

	public List<RegisterModel> getStudentDetailsById(int studentId) {

		List<RegisterModel> studentDetailsById = shopjpa.getStudentDetailsById(studentId);

		return studentDetailsById;

	}

	public int getFeebyClass(int name) {
		return feeMasterjpa.getfee(name);

	}

	public void saveAdmissionWithFee(int studentId, int studentClass, int classfee, int finalAmount, int discount,
			int userName, String studentSection) {
		StudentAdmission studentAdmission = new StudentAdmission();
		studentAdmission.setStudentId(studentId);
		studentAdmission.setFee(classfee);
		studentAdmission.setFeeStatus(1);
		studentAdmission.setDiscount(discount);
		studentAdmission.setCreatedTime(new Timestamp(new Date().getTime()));
		;
		studentAdmission.setCreatedId(userName);
		studentAdmission.setStudentName(getStudentNameById(studentId));
		studentAdmission.setStudentSection(studentSection);

		studentAdmission.setFeeBalance(getFeebyClass(studentClass) - finalAmount - discount);
		admission.save(studentAdmission);

	}

	public String getStudentNameById(int studentId) {
		return shopjpa.getStudentNameById(studentId);

	}

	public void addSection(int studentClass, String studentSection, int userName) {
		SectionMaster sectionMaster = new SectionMaster();
		sectionMaster.setStudentcClass(studentClass);
		sectionMaster.setSection(studentSection);
		sectionMaster.setCreatedId(userName);
		sectionJpa.save(sectionMaster);

	}

	public List<SectionMaster> getSectionByClass(int studentClass) {
		return sectionJpa.getSectionByClass(studentClass);

	}

	public List<String> getTestClass(int studentClass) {
		return sectionJpa.search(studentClass);
	}

}
