package com.learners.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Student implements Serializable,Comparable<Student>{
	private static final long serialVersionUID = 1L;
	@Id
	private int studentId;
	private String studentName;
	private int studentAge;
	private String studentEmail;
	private String studentAddress;
	private Long studentPhone;
	
	@OneToOne(targetEntity = Class.class,cascade = {CascadeType.PERSIST})
	private Class learnerClass;

	public Student(int studentId, String studentName, int studentAge, String studentEmail, String studentAddress,
			Long studentPhone, Class learnerClass) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentPhone = studentPhone;
		this.learnerClass = learnerClass;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentEmail=" + studentEmail + ", studentAddress=" + studentAddress + ", studentPhone="
				+ studentPhone + ", learnerClass=" + learnerClass + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(Long studentPhone) {;
		this.studentPhone = studentPhone;
	}

	public Class getLearnerClass() {
		return learnerClass;
	}

	public void setLearnerClass(Class learnerClass) {
		this.learnerClass = learnerClass;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (this.getStudentId()-o.getStudentId());
	}

	
	

}
