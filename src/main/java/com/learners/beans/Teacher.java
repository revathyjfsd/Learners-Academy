package com.learners.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Teacher implements Serializable,Comparable<Teacher>{
	private static final long serialVersionUID = 1L;
	@Id
	private int teacherId;
	private String teacherName;
	private int teacherAge;
	private String teacherEmail;
	private String teacherAddress;
	private Long teacherPhone;
	
    @ManyToMany(mappedBy="teacherClass",fetch=FetchType.EAGER)
    private Set<Class> classList = new HashSet<Class>();
  
    
	public Set<Class> getClassList() {
		return classList;
	}
	public void setClassList(Set<Class> classList) {
		this.classList = classList;
	}
	
	 public void removeClass(Class learnerClass) {
	        this.classList.remove(learnerClass);
	        learnerClass.getSubjectClass().remove(this);
	    }
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacherId, String teacherName, int teacherAge, String teacherEmail, String teacherAddress,
			Long teacherPhone) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAge = teacherAge;
		this.teacherEmail = teacherEmail;
		this.teacherAddress = teacherAddress;
		this.teacherPhone = teacherPhone;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(int teacherAge) {
		this.teacherAge = teacherAge;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	public Long getTeacherPhone() {
		return teacherPhone;
	}
	public void setTeacherPhone(Long teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAge=" + teacherAge
				+ ", teacherEmail=" + teacherEmail + ", teacherAddress=" + teacherAddress + ", teacherPhone="
				+ teacherPhone + "]";
	}
	@Override
	public int compareTo(Teacher o) {
		// TODO Auto-generated method stub
		return (this.getTeacherId()-o.getTeacherId());
	}
	/*
	 * public boolean equals(Object obj) { if(!(obj instanceof Teacher)) { return
	 * false; } Teacher teacher = (Teacher)obj; return this.teacherId ==
	 * teacher.getTeacherId(); }
	 */
	
}
