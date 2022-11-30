package com.learners.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table
public class Class implements Serializable,Comparable<Class>{
	private static final long serialVersionUID = 1L;
	@Id
	private int classId;
	private String name;
	private String section;
	
	@OneToMany(mappedBy = "learnerClass",cascade = {CascadeType.ALL})
	private Set<Student> students= new HashSet<Student>();
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@ManyToMany(targetEntity = Subject.class,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinTable(name = "Class_Subjects", 
				joinColumns = { @JoinColumn(name = "classId") }, 
				inverseJoinColumns = { @JoinColumn(name = "subjectId") })
	private Set<Subject> subjectClass=new HashSet<Subject>();
	
	@ManyToMany(targetEntity = Teacher.class,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH} )
	@JoinTable(name = "Class_Teachers", 
				joinColumns = { @JoinColumn(name = "classId") }, 
				inverseJoinColumns = { @JoinColumn(name = "teacherId") })
	private Set<Teacher> teacherClass=new HashSet<Teacher>();

	public void removeSubjects(Subject subject) {
	        this.subjectClass.remove(subject);
	        subject.getClassList().remove(this);
	    }

	public void removeTeacher(Teacher teacher) {
	        this.teacherClass.remove(teacher);
	        teacher.getClassList().remove(this);
	    }
	public Set<Teacher> getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(Set<Teacher> teacherClass) {
		this.teacherClass = teacherClass;
	}
	public Set<Subject> getSubjectClass() {
		return subjectClass;
	}
	public void setSubjectClass(Set<Subject> subjectClass) {
		this.subjectClass = subjectClass;
	}
	public Class(int classId, String name, String section) {
		super();
		this.classId = classId;
		this.name = name;
		this.section = section;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", name=" + name + ", section=" + section + "]";
	}

	@Override
	public int compareTo(Class o) {
		// TODO Auto-generated method stub
		return (this.getClassId()-o.getClassId());
	}

	
}
