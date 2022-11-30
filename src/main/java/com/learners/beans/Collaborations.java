package com.learners.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Collaborations implements Comparable<Collaborations>{
 
	public Collaborations(Subject subject, Teacher teacher, Class classL) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.classL = classL;
	}
	public Subject getSubject() {
		return subject;
	}
	public Collaborations() {
		super();
		//TODO Auto-generated constructor stub
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Class getClassL() {
		return classL;
	}
	public void setClassL(Class classL) {
		this.classL = classL;
	}
	
    @Id
    @GeneratedValue
    private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade={CascadeType.ALL})
	private Subject subject;
	@ManyToOne(cascade={CascadeType.ALL})
	private Teacher teacher;
	@ManyToOne(cascade={CascadeType.ALL})
	private Class classL;
	@Override
	public int compareTo(Collaborations o) {
		// TODO Auto-generated method stub
		if(o.getTeacher()!=null)
		return (this.getTeacher().getTeacherId()-o.getTeacher().getTeacherId());
		else
			return 0;
			
	}
}
