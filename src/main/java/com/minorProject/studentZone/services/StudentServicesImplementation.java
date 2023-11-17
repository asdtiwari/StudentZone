package com.minorProject.studentZone.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.minorProject.studentZone.entity.Student;
import com.minorProject.studentZone.repository.StudentRepository;

@Service
public class StudentServicesImplementation implements StudentServices{

	StudentRepository repo;
	
	public StudentServicesImplementation(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addStudent(Student s) {
		repo.save(s);
		return "/registered";
	}

	@Override
	public Student getStudent(String id, Model model) {
		Student s = repo.findById(id).get();
		model.addAttribute("student", s);
		return s;
	}

	@Override
	public List<Student> getAllStudent(Model model) {
		List<Student> sList = repo.findAll();
		model.addAttribute("sList", sList);
		return sList;
	}

	@Override
	public String updateStudent(Student s) {
		repo.save(s);
		return "/updated";
	}

	@Override
	public String deleteStudent(String id) {
		repo.deleteById(id);
		return "/removed";
	}

}
