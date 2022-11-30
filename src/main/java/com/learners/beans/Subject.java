package com.learners.beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Subject implements Serializable,Comparable<Subject>{
	private static final long serialVersionUID = 1L;
	@Id
	private int subjectId;
	private String subjectName;
	private String subjectShortcut;

	@ManyToMany(mappedBy="subjectClass",fetch=FetchType.EAGER)
    private Set<Class> classList= new HashSet<Class>();
    
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
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectShortcut() {
		return subjectShortcut;
	}
	public void setSubjectShortcut(String subjectShortcut) {
		this.subjectShortcut = subjectShortcut;
	}

	public Subject(int subjectId, String subjectName, String subjectShortcut) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectShortcut = subjectShortcut;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectShortcut="
				+ subjectShortcut + "]";
	}
	@Override
	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		return (this.getSubjectId()-o.getSubjectId());
	}
	
	/*
	 * public boolean equals(Object obj) { if(!(obj instanceof Subject)) { return
	 * false; } Subject subject = (Subject)obj; return this.subjectId ==
	 * subject.getSubjectId(); }
	 */

	
}
