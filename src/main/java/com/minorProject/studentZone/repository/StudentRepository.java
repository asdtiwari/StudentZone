package com.minorProject.studentZone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minorProject.studentZone.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
