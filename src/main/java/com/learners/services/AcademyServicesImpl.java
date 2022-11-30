package com.learners.services;

import java.util.Set;

import com.learners.beans.Class;
import com.learners.beans.Collaborations;
import com.learners.beans.Student;
import com.learners.beans.Subject;
import com.learners.beans.Teacher;
import com.learners.dao.AcademyDetailsDAO;
import com.learners.dao.AcademyDetailsDAOImpl;
import com.learners.exceptions.EntityExistsException;


public class AcademyServicesImpl extends AcademyServices{
	
	
	public void assignTeacherToClass(Class classL,Subject subject,Teacher teacher) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.assignTeacherToClass(classL,subject,teacher);
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void updateStudentDetails(Student s) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.updateStudentDetails(s);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void updateTeacherDetails(Teacher t) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.updateTeacherDetails(t);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void updateSubjectDetails(Subject s) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.updateSubjectDetails(s);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void updateClassDetails(Class c) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.updateClassDetails(c);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void deleteStudent(int id) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.deleteStudent(id);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void deleteClass(int id) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.deleteClass(id);
		dao.deleteCollaboration(id,"C");
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void deleteTeacher(int id) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.deleteTeacher(id);
		dao.deleteCollaboration(id,"T");
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void deleteSubject(int id) throws Exception
	{
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.deleteSubject(id);
		dao.deleteCollaboration(id,"S");
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void insertStudentDetails(Student s) throws Exception
	{ 
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.insertStudentDetails(s);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void insertTeacherDetails(Teacher t) throws Exception
	{ 
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.insertTeacherDetails(t);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void insertSubjectDetails(Subject s) throws Exception
	{ 
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.insertSubjectDetails(s);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public void insertClassDetails(Class c) throws Exception
	{ 
	try {
		AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
		dao.insertClassDetails(c);
		
	}
	catch(Exception e)
	{
		throw new Exception("Unexpected Error occurred: "+e);
	}
	}
	
	public Set<Student> getStudentDetails() throws Exception
	{
		Set<Student> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getStudentDetails();
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	
	public Set<Student> getStudentDetailsByClassId(int id) throws Exception
	{
		Set<Student> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getStudentDetailsByClassId(id);
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Set<Class> getClassDetails() throws Exception
	{
		Set<Class> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getClassDetails();
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Set<Subject> getSubjectDetails() throws Exception
	{
		Set<Subject> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getSubjectDetails();
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Set<Teacher> getTeacherDetails() throws Exception
	{
		Set<Teacher> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getTeacherDetails();
		}
		catch(Exception e)
		{
		throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Set<Collaborations> getAllDetailsByClassId(int id) throws Exception
	{
		Set<Collaborations> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getAllDetailsByClassId(id);
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Class getClassDetailsById(int id) throws Exception
	{
		Class learnerClass=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			learnerClass =dao.getClassDetailsById(id);
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return learnerClass;
	}
	public Set<Subject> getSubjectDetailsById(Subject s) throws Exception
	{
		Set<Subject> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getSubjectDetailsById();
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	public Set<Teacher> getTeacherDetailsById(Teacher t) throws Exception
	{
		Set<Teacher> list=null;
		
		try {
			AcademyDetailsDAO dao = new AcademyDetailsDAOImpl();
			list =dao.getTeacherDetailsById();
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return list;
	}
	
}
