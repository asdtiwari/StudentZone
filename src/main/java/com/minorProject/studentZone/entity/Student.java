package com.minorProject.studentZone.entity;

import org.springframework.lang.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	private String id;
	private String name;
	@Nullable
	private String father;
	@Nullable
	private String mother;
	private String dob;
	private String sex;
	private String category;
	private String phone;
	@Nullable
	private String email;
	private String course;
	private String branch;
	private String semester;
	@Nullable
	private String address;
	@Nullable
	private String pin;
	
	public Student() {
		super();
	}

	public Student(String id, String name, String father, String mother, String dob, String sex, String category,
			String phone, String email, String course, String branch, String semester, String address, String pin) {
		super();
		this.id = id;
		this.name = name;
		this.father = father;
		this.mother = mother;
		this.dob = dob;
		this.sex = sex;
		this.category = category;
		this.phone = phone;
		this.email = email;
		this.course = course;
		this.branch = branch;
		this.semester = semester;
		this.address = address;
		this.pin = pin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", father=" + father + ", mother=" + mother + ", dob=" + dob
				+ ", sex=" + sex + ", category=" + category + ", phone=" + phone + ", email=" + email + ", course="
				+ course + ", branch=" + branch + ", semester=" + semester + ", address=" + address + ", pin=" + pin
				+ "]";
	}
}
