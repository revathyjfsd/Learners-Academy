package com.learners.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learners.beans.Class;
import com.learners.beans.Collaborations;
import com.learners.beans.Student;
import com.learners.beans.Subject;
import com.learners.beans.Teacher;

public abstract class AcademyDetailsDAO {
	
	public abstract void assignTeacherToClass(Class classL,Subject subject,Teacher teacher) throws Exception;
	
	public abstract void updateStudentDetails(Student s) throws Exception ;
	
	public abstract void updateTeacherDetails(Teacher t) throws Exception;
	
	public abstract void updateSubjectDetails(Subject s) throws Exception;
	public abstract void updateClassDetails(Class c) throws Exception ;
	
	public abstract void deleteStudent(int id) throws Exception;
	public abstract void deleteCollaboration(int id,String entity) throws Exception;
	
	public abstract void deleteClass(int id) throws Exception;
	
	public abstract void deleteTeacher(int id) throws Exception;
	
	public abstract void deleteSubject(int id) throws Exception;
	
	public abstract void insertStudentDetails(Student s) throws Exception;
	
	public abstract void insertTeacherDetails(Teacher t) throws Exception;
	public abstract void insertSubjectDetails(Subject s) throws Exception;
	public abstract void insertClassDetails(Class c) throws Exception;
	
	public abstract Set<Student> getStudentDetailsByClassId(int id) throws Exception;
	
	public abstract Set<Student> getStudentDetails() throws Exception;
	public abstract Set<Class> getClassDetails() throws Exception;
	public abstract Set<Subject> getSubjectDetails() throws Exception;
	
	public abstract Set<Teacher> getTeacherDetails() throws Exception;
	public abstract Set<Collaborations> getAllDetailsByClassId(int id) throws Exception;
	
	public abstract Class getClassDetailsById(int id) throws Exception;
	public abstract Set<Subject> getSubjectDetailsById() throws Exception;
	public abstract Set<Teacher> getTeacherDetailsById() throws Exception;
}
