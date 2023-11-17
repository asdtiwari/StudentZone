package com.minorProject.studentZone.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minorProject.studentZone.entity.Student;
import com.minorProject.studentZone.services.StudentServices;

@Controller
@RequestMapping("/student")
public class ProjectController {

	StudentServices ss;
	Student s;
	
	public ProjectController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping(value="/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping(value="/register")
	public String register() {
		return "/register";
	}
	
	@GetMapping(value="/viewInfo")
	public String viewInfo() {
		return "/viewInfo";
	}
	
	@GetMapping(value="/update")
	public String update() {
		return "/update";
	}
	
	@GetMapping(value="/remove")
	public String remove() {
		return "/remove";
	}
	
	@GetMapping(value="/showAllInfo")
	public String showAllInfo(Model model) {
		ss.getAllStudent(model);
		return "/showAllInfo";
	}
	
	@PostMapping(value="/showInfo")
	public String showInfo(@RequestParam("id") String id, Model model) {
		try {
			ss.getStudent(id, model);
		}
		catch(Exception ex) {
			model.addAttribute("id", id);
			return "/invalid";
		}
		return "/showInfo";
	}
	
	@PostMapping(value="/removed")
	public String removed(@RequestParam("id") String id, Model model) {
		try {
			ss.getStudent(id, model);
			
			ss.deleteStudent(id);
			model.addAttribute("id", id);
		}
		catch(Exception ex) {

			model.addAttribute("id", id);
			return "invalid";
		}
		return "/removed";
	}
	
	@PostMapping("/registered")
	public String register(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("father") String father,
			@RequestParam("mother") String mother, @RequestParam("dob") @DateTimeFormat(pattern="dd-MM-yyyy") String dob, @RequestParam("sex") String sex,
			@RequestParam("category") String category, @RequestParam("phone") String phone, @RequestParam("email") String email,
			@RequestParam("course") String course, @RequestParam("branch") String branch, @RequestParam("semester") String semester,
			@RequestParam("address") String address, @RequestParam("pin") String pin) {
		
		return ss.addStudent(new Student(id.toUpperCase(), name.toUpperCase(), father.toUpperCase(), mother.toUpperCase(), dob, 
				sex.toUpperCase(), category.toUpperCase(), phone, email.toLowerCase(), course.toUpperCase(), branch.toUpperCase(), semester.toUpperCase(), address, pin));
	}
	
	@PostMapping("/updateDetails")
	public String updateDetails(@RequestParam("id") String id, Model model) {
		try {
			s = ss.getStudent(id, model);
		}
		catch(Exception ex) {

			model.addAttribute("id", id);
			return "invalid";
		}
		model.addAttribute("id", id);
		return "/updateDetails";
	}
	
	@PostMapping("/updated")
	public String updated(@RequestParam("name") String name, @RequestParam("father") String father,
			@RequestParam("mother") String mother, @RequestParam("dob") @DateTimeFormat(pattern="dd-MM-yyyy") String dob, @RequestParam("sex") String sex,
			@RequestParam("category") String category, @RequestParam("phone") String phone, @RequestParam("email") String email,
			@RequestParam("course") String course, @RequestParam("branch") String branch, @RequestParam("semester") String semester,
			@RequestParam("address") String address, @RequestParam("pin") String pin) {
		
		s.setName(name.toUpperCase());
		s.setFather(father.toUpperCase());
		s.setMother(mother.toUpperCase());
		s.setDob(dob);
		s.setSex(sex.toUpperCase());
		s.setCategory(category.toUpperCase());
		s.setPhone(phone);
		s.setEmail(email.toLowerCase());
		s.setCourse(course.toUpperCase());
		s.setBranch(branch.toUpperCase());
		s.setSemester(semester.toUpperCase());
		s.setAddress(address);
		s.setPin(pin);
		
		return ss.updateStudent(s);
	}
}
