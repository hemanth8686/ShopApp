package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.RegistrationBean;
import com.example.model.EmployeeRegistrationModel;
import com.example.model.FeeMasterModel;
import com.example.model.RegisterModel;
import com.example.model.SectionMaster;
import com.example.service.ShopService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ShopContoller {
	@Autowired
	private RegistrationBean registrationBean;
	@Autowired
	private ShopService shopService;
	@Autowired
	private com.example.entities.EmployeeRegister employeeRegister;

	private List<SectionMaster> sectionByClass;

	public List<SectionMaster> getSectionByClass() {
		return sectionByClass;
	}

	public void setSectionByClass(List<SectionMaster> sectionByClass) {
		this.sectionByClass = sectionByClass;
	}

	@RequestMapping(value = "/GotoLogin")
	public ModelAndView gotoLogin() {
		ModelAndView view = new ModelAndView();
		view.setViewName("NewFile");
		return view;
	}

	@RequestMapping(value = "validate")

	public ModelAndView validate(@RequestParam(value = "userName") int userName,
			@RequestParam(value = "password") String password, HttpSession httpSession) {
		httpSession.setAttribute("userName", userName);
		ModelAndView view = new ModelAndView();
		String userPassword = shopService.validate(userName);
		if (password.equalsIgnoreCase(userPassword)) {
			view.setViewName("menu");

		} else {
			view.setViewName("fail");

		}
		System.out.println(userPassword);

		return view;
	}

	@RequestMapping(value = "gotoregister")
	public ModelAndView gotoregister() {
		ModelAndView view = new ModelAndView();
		view.setViewName("register");
		return view;
	}

	@RequestMapping(value = "register")
	public ModelAndView register(@ModelAttribute(value = "RegistrationBean") RegistrationBean registrationBean,@RequestParam(value = "studentPhoto") MultipartFile studentPhoto) {
		ModelAndView view = new ModelAndView();
		String firstName = registrationBean.getFirstName();
		String lastName = registrationBean.getLastName();
		int age = registrationBean.getAge();
		String email = registrationBean.getEmail();
		String gender = registrationBean.getGender();
		String mobile = registrationBean.getMobile();
		String password = registrationBean.getPassword();
		java.sql.Date dateOfBirth = registrationBean.getDateOfBirth();
		String userName = registrationBean.getUserName();
		String bloodGroup = registrationBean.getBloodGroup();
		String address = registrationBean.getAddress();
		String motherName = registrationBean.getMotherName();
		String fatherName = registrationBean.getFatherName();
	

		
		
		
		int studentId = shopService.register(firstName, lastName, age, email, gender, mobile, password, dateOfBirth,
				userName, bloodGroup, address, motherName, fatherName,studentPhoto);
		view.addObject("studentId", studentId);
		view.setViewName("RegisterSucess");
		
	
		return view;
	}

	@RequestMapping(value = "gotoFeeMaster")
	public ModelAndView gotoFeeMaster() {
		ModelAndView view = new ModelAndView();
		view.setViewName("FeeMaster");

		return view;
	}

	@RequestMapping(value = "FeeMasterSave")
	public ModelAndView FeeMasterSave(@RequestParam(name = "studentClass") int studentClass,
			@RequestParam(value = "studentFee") int studentFee, HttpSession session) {
		int userName = (int) session.getAttribute("userName");
		ModelAndView view = new ModelAndView();
		shopService.saveFee(studentClass, studentFee, userName);
		view.setViewName("FeeMaster");
		return view;

	}

	@RequestMapping(value = "gotoEmployeeRegister")
	public ModelAndView gotoEmployeeRegister() {

		ModelAndView view = new ModelAndView();
		view.setViewName("EmployeeRegistration");

		return view;

	}

	@RequestMapping(value = "EmployeeRegister")
	public ModelAndView EmployeeRegister(
			@ModelAttribute(value = "employeeRegister") EmployeeRegistrationModel registrationModel,
			HttpSession session) {
		String userName = (String) session.getAttribute("userName");
		String employeeFirstName = registrationModel.getEmployeeFirstName();
		String employeelastName = registrationModel.getEmployeelastName();
		int employeeAge = registrationModel.getEmployeeAge();
		Date employeeDateOfBirth = registrationModel.getEmployeeDateOfBirth();
		String employeePassword = registrationModel.getEmployeePassword();
		String employeeEmail = registrationModel.getEmployeeEmail();
		String employeeRole = registrationModel.getEmployeeRole();
		int employeeUserID = shopService.saveEmployeeDetails(employeeFirstName, employeelastName, employeeAge,
				employeeDateOfBirth, employeePassword, employeeEmail, employeeRole, userName);
		ModelAndView view = new ModelAndView();
		view.addObject("employeeUserID", employeeUserID);
		return view;

	}

	@RequestMapping(value = "gotoStudentAdmission")
	public ModelAndView gotoStudentAdmission() {
		ModelAndView view = new ModelAndView();
		view.setViewName("Admission");
		return view;
	}

	@RequestMapping(value = "makeStudentAdmission")
	public ModelAndView makeStudentAdmission(@RequestParam(value = "studentId") int studentId) {
		ModelAndView view = new ModelAndView();
		List<RegisterModel> studentDetailsById = shopService.getStudentDetailsById(studentId);
		view.addObject("studentDetailsById", studentDetailsById);
		view.setViewName("MakeAdmission");
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "ajax", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public int ajax(@PathParam(value = "name") int name) {

		int feeByClass = shopService.getFeeByClass(name);
		return feeByClass;

	}

	@RequestMapping(value = "makeAdmissionWithFee")
	public ModelAndView makeAdmissionWithFee(@RequestParam(value = "studentId", required = false) int studentId,
			@RequestParam(value = "studentClass", required = false) int studentClass,
			@RequestParam(value = "classfee", required = false) int classfee,
			@RequestParam(value = "finalAmount", required = false) int finalAmount,
			@RequestParam(value = "discount", required = false) int discount, @RequestParam(value = "studentSection", required = false) String studentSection,HttpSession session) {
		int userName = (int) session.getAttribute("userName");
		String upperCase = studentSection.toUpperCase();
		shopService.saveAdmissionWithFee(studentId, studentClass, classfee, finalAmount, discount, userName,upperCase);
		ModelAndView view = new ModelAndView();
		view.setViewName("MakeAdmission");
		return view;

	}

	@RequestMapping(value = "gotoAddSection")
	public String gotoAddSection() {

		return "SectionMaster";

	}

	@RequestMapping(value = "addSection")
	public ModelAndView addSection(@RequestParam(value = "studentClass", required = false) int studentClass,
			@RequestParam(value = "section", required = false) String studentSection, HttpSession session) {
		int userName = (int) session.getAttribute("userName");
		shopService.addSection(studentClass, studentSection, userName);
		return null;

	}

	@ResponseBody
	@RequestMapping(value = "getSectionByClass", method = RequestMethod.GET)

	public ResponseEntity<List<JSONObject>> getSectionByClass(@RequestParam(value = "studentClass") String name,
			HttpSession session, ModelAndView view, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(name + "in class");
		int className = Integer.parseInt(name);
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";

		this.sectionByClass = shopService.getSectionByClass(className);
		for (SectionMaster sectionMaster : sectionByClass) {
			System.out.println(sectionMaster.getSection());
		}
		JSONObject obj = new JSONObject();
		obj.put("sectionByClass", sectionByClass);

		response.setContentType("application/json");
		List<JSONObject> entities = new ArrayList<JSONObject>();
		for (SectionMaster n : sectionByClass) {
			JSONObject entity = new JSONObject();
			entity.put("section", n.getSection());
			entities.add(entity);
		}
		try {
			resp = mapper.writeValueAsString(sectionByClass);
		} catch (JsonProcessingException e) {
		}
		System.out.println(entities.size() + "this is size");
		obj.put("entities", entities);
		JSONObject obj1=new JSONObject();
		obj.put("issuedQtyList",sectionByClass);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setStatus(HttpServletResponse.SC_OK);
		
		return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);

	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "getSectionByClassTest", method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)

	public  ResponseEntity<String> getSectionByClassTest(@RequestParam(value = "studentClass") String name,
			HttpSession session, ModelAndView view, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(name + "in class");
		int className = Integer.parseInt(name);
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";
		
		
		List<String> sectionList=new ArrayList<String>();


		this.sectionByClass = shopService.getSectionByClass(className);
		for (SectionMaster sectionMaster : sectionByClass) {
			String section = sectionMaster.getSection();
		sectionList.add(section);
		}
		try {
			resp = mapper.writeValueAsString(sectionList);
			System.out.println(resp.length()+"......................................"+resp.toString());
		} catch (JsonProcessingException e) {
		}
		

		return new ResponseEntity<String>(resp, HttpStatus.OK);

	}
	@ResponseBody
	@RequestMapping(value = "getSection", method = RequestMethod.GET)

	public List<SectionMaster> getSection(@RequestParam(value = "studentClass") String name,
			HttpSession session, ModelAndView view, HttpServletRequest request, HttpServletResponse response) {
		int className = Integer.parseInt(name);
		ModelAndView view2=new ModelAndView();
		
		this.sectionByClass = shopService.getSectionByClass(className);
		view2.addObject("sectionByClass", sectionByClass);

		return sectionByClass ;

	}



}
