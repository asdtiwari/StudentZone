package com.minorProject.studentZone.services;

import java.util.List;

import org.springframework.ui.Model;

import com.minorProject.studentZone.entity.Student;

public interface StudentServices {

	String addStudent(Student s);
	Student getStudent(String id, Model model);
	List<Student> getAllStudent(Model model);
	String updateStudent(Student s);
	String deleteStudent(String id);
}
