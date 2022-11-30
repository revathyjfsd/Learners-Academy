package com.learners.services;

import java.util.Set;

import com.learners.beans.Class;
import com.learners.beans.Collaborations;
import com.learners.beans.Student;
import com.learners.beans.Subject;
import com.learners.beans.Teacher;
import com.learners.dao.AcademyDetailsDAO;
import com.learners.dao.AcademyDetailsDAOImpl;

public abstract class AcademyServices {

	
	public abstract void assignTeacherToClass(Class classL,Subject subject,Teacher teacher) throws Exception;
	
	public abstract void updateStudentDetails(Student s) throws Exception;
	
	public abstract void updateTeacherDetails(Teacher t) throws Exception;
	
	public abstract void updateSubjectDetails(Subject s) throws Exception;
	
	public abstract void updateClassDetails(Class c) throws Exception;
	
	public abstract void deleteStudent(int id) throws Exception;
	
	public abstract void deleteClass(int id) throws Exception;
	
	public abstract void deleteTeacher(int id) throws Exception;
	
	public abstract void deleteSubject(int id) throws Exception;
	
	public abstract void insertStudentDetails(Student s) throws Exception;
	
	public abstract void insertTeacherDetails(Teacher t) throws Exception;
	public abstract void insertSubjectDetails(Subject s) throws Exception;
	
	public abstract void insertClassDetails(Class c) throws Exception;
	public abstract Set<Student> getStudentDetails() throws Exception;
	
	public abstract Set<Student> getStudentDetailsByClassId(int id) throws Exception;
	public abstract Set<Class> getClassDetails() throws Exception;
	public abstract Set<Subject> getSubjectDetails() throws Exception;
	public abstract Set<Teacher> getTeacherDetails() throws Exception;
	public abstract Set<Collaborations> getAllDetailsByClassId(int id) throws Exception;
	public abstract Class getClassDetailsById(int id) throws Exception;
	public abstract Set<Subject> getSubjectDetailsById(Subject s) throws Exception;
	public abstract Set<Teacher> getTeacherDetailsById(Teacher t) throws Exception;
	
}
