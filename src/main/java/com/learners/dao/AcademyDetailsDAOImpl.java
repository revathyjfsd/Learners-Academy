package com.learners.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learners.beans.Class;
import com.learners.beans.Collaborations;
import com.learners.beans.Student;
import com.learners.beans.Subject;
import com.learners.beans.Teacher;
import com.learners.exceptions.EntityExistsException;

public class AcademyDetailsDAOImpl extends AcademyDetailsDAO {
	
	
	public void assignTeacherToClass(Class classL,Subject subject,Teacher teacher) throws Exception
	{
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		try {
		Class learnerClass =(Class)session.get(Class.class, classL.getClassId());
		if(learnerClass.getSubjectClass()!=null)
        {
    		  learnerClass.getSubjectClass().add(subject);
        }else
        {
        	 Set<Subject> s= new HashSet<Subject>();
        	 s.add(subject);
        	 learnerClass.setSubjectClass(s);
        }
        if(learnerClass.getTeacherClass()!=null)
        {
      		  learnerClass.getTeacherClass().add(teacher);
        }
        else
        {
        	Set<Teacher> t= new HashSet<Teacher>();
            t.add(teacher);
            learnerClass.setTeacherClass(t);
        }
        session.save(learnerClass);
        Collaborations c= new Collaborations();
        c.setClassL(learnerClass);
        c.setSubject(subject);
        c.setTeacher(teacher);
        session.save(c);

		}catch(Exception e)
		{
			throw e;
		}finally {
			tran.commit();
			session.close();
		}
		
	}
	public void updateStudentDetails(Student s) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
        Student student = 
                (Student)session.get(Student.class, s.getStudentId()); 
        student.setStudentAge(s.getStudentAge());
        student.setStudentEmail(s.getStudentEmail());
        student.setStudentAddress(s.getStudentAddress());
        student.setStudentName(s.getStudentName());
        student.setStudentPhone(s.getStudentPhone());
        Class learnerClass =(Class)session.get(Class.class, s.getLearnerClass().getClassId());
        student.setLearnerClass(learnerClass);
		session.save(student);
		tran.commit();
		session.close();
	}
	
	public void updateTeacherDetails(Teacher t) throws Exception{
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Teacher teacher = 
                (Teacher)session.get(Teacher.class, t.getTeacherId()); 
		teacher.setTeacherAge(t.getTeacherAge());
		teacher.setTeacherEmail(t.getTeacherEmail());
		teacher.setTeacherAddress(t.getTeacherAddress());
		teacher.setTeacherName(t.getTeacherName());
		teacher.setTeacherPhone(t.getTeacherPhone());
		session.save(teacher);
		tran.commit();
		session.close();
	}
	
	public void updateSubjectDetails(Subject s) throws Exception{
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Subject subject = 
                (Subject)session.get(Subject.class, s.getSubjectId()); 
		subject.setSubjectId(s.getSubjectId());
		subject.setSubjectName(s.getSubjectName());
		subject.setSubjectShortcut(s.getSubjectShortcut());
		session.save(subject);
		tran.commit();
		session.close();
	}
	
	public void updateClassDetails(Class c) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Class classL = 
                (Class)session.get(Class.class, c.getClassId()); 
		classL.setClassId(c.getClassId());
		classL.setName(c.getName());
		classL.setSection(c.getSection());
		session.save(classL);
		tran.commit();
		session.close();
	}
	
	public void deleteStudent(int id)throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Student student = 
	                (Student)session.get(Student.class, id); 
		session.delete(student);
		tran.commit();
		session.close();
	}
	public void deleteCollaboration(int id,String entity) throws Exception
	{
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		if(entity.equals("C"))
		{
			Query q=session.createQuery("Delete Collaborations c where c.classL.classId=:id");
			q.setParameter("id",id);
			q.executeUpdate();
		}
		if(entity.equals("T"))
		{
			Query q=session.createQuery("Delete Collaborations c where c.teacher.teacherId=:id");
			q.setParameter("id",id);
			q.executeUpdate();
		}
		if(entity.equals("S"))
		{
			Query q=session.createQuery("Delete Collaborations c where c.subject.subjectId=:id");
			q.setParameter("id",id);
			q.executeUpdate();
		}
		tran.commit();
		session.close();
	}
	
	public void deleteClass(int id) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Class classLearner = 
	                (Class)session.get(Class.class, id); 

		Query sql=session.createQuery("update Student stud set stud.learnerClass=NULL where stud.learnerClass.classId=:id");
		sql.setParameter("id",id);
		sql.executeUpdate();
		Set<Subject> subjectList = classLearner.getSubjectClass();
		ArrayList<Subject> list=new ArrayList<Subject>(subjectList);
		if(list!=null)
		{
			for(Subject subject: list)
			{
				classLearner.removeSubjects(subject);
			}
		}
		Set<Teacher> teacherList =classLearner.getTeacherClass();
		ArrayList<Teacher> list1=new ArrayList<Teacher>(teacherList);
		if(list1!=null)
		{
		 for(Teacher teacher: list1)
			{
				classLearner.removeTeacher(teacher);
			}
		}
		session.remove(classLearner);
		tran.commit();
		session.close();
	}
	
	public void deleteTeacher(int id) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Teacher teacher = 
	                (Teacher)session.get(Teacher.class, id); 
		Set<Class> classList = teacher.getClassList();
		ArrayList<Class> list1=new ArrayList<Class>(classList);
		if(list1!=null)
		{
			for(Class learnerClass: list1)
			{
				teacher.removeClass(learnerClass);
			}
		}
		session.remove(teacher);
		tran.commit();
		session.close();
	}
	
	public void deleteSubject(int id) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Subject subject = 
	                (Subject)session.get(Subject.class, id); 
		Set<Class> classList =subject.getClassList();
		ArrayList<Class> list1=new ArrayList<Class>(classList);
		if(list1!=null)
		{
			for(Class learnerClass: list1)
			{
				subject.removeClass(learnerClass);
			}
		}
		session.remove(subject);
		tran.commit();
		session.close();
	}
	public void insertStudentDetails(Student s) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(s);
		tran.commit();
		session.close();
	}
	
	public void insertTeacherDetails(Teacher t) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(t);
		tran.commit();
		session.close();
	}
	
	public void insertSubjectDetails(Subject s) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(s);
		tran.commit();
		session.close();
	}
	
	public void insertClassDetails(Class c) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(c);
		tran.commit();
		session.close();
	}
	
	public Set<Student> getStudentDetailsByClassId(int id) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Query sql=session.createQuery("from Student stud where stud.learnerClass.classId=:id");
		sql.setParameter("id",id);
		ArrayList<Student> arraylist= (ArrayList<Student>)sql.list();
		Set<Student> list= new HashSet<Student>(arraylist);
			for(Student st:list)
			{
				System.out.println(st.toString());
				System.out.println(st.getLearnerClass().getClassId());
			}
		tran.commit();
		session.close();
		return list;
	}
	
	public Set<Student> getStudentDetails() throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Query sql = session.createQuery("FROM Student order by studentId asc");
		ArrayList<Student> arraylist= (ArrayList<Student>)sql.list();
		Set<Student> list= new HashSet<Student>(arraylist);
		tran.commit();
		session.close();
		return list;
	}
	public Set<Class> getClassDetails() throws Exception{
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Query sql = session.createQuery("FROM Class order by classId asc");
		 ArrayList<Class> arraylist= (ArrayList<Class>)sql.list();
		 Set<Class> classList= new HashSet<Class>(arraylist);
		 tran.commit();
			session.close();
			return classList;
	}
	
	public Set<Subject> getSubjectDetails()throws Exception {
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Query sql = session.createQuery("FROM Subject order by subjectId asc");
		 ArrayList<Subject> arraylist= (ArrayList<Subject>)sql.list();
		 Set<Subject> subjectList= new HashSet<Subject>(arraylist);
		 tran.commit();
			session.close();
			return subjectList;
	}
	
	public Set<Teacher> getTeacherDetails() throws Exception{
		// TODO Auto-generated method stub
		
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Query sql = session.createQuery("FROM Teacher  order by teacherId asc");
		 ArrayList<Teacher> arraylist= (ArrayList<Teacher>)sql.list();
		 Set<Teacher> teacherList= new HashSet<Teacher>(arraylist);
		 tran.commit();
			session.close();
			return teacherList;
	}
	
	public Set<Collaborations> getAllDetailsByClassId(int id) throws Exception{
		// TODO Auto-generated method stub
		
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Query sql=session.createQuery("FROM Collaborations c where c.classL.classId=:id");
		sql.setParameter("id",id);
		ArrayList<Collaborations> arraylist= (ArrayList<Collaborations>)sql.list();
		Set<Collaborations> collaborationsList= new HashSet<Collaborations>(arraylist);
		tran.commit();
		session.close();
		return collaborationsList;
	}
	
	public Class getClassDetailsById(int id) throws Exception{
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		Class learnerClass = 
                (Class)session.get(Class.class, id); 
		 tran.commit();
			session.close();
			return learnerClass;
	}
	
	public Set<Subject> getSubjectDetailsById() throws Exception{
		// TODO Auto-generated method stub
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Query sql = session.createQuery("FROM Subject order by subjectId");
		 ArrayList<Subject> arraylist= (ArrayList<Subject>)sql.list();
		 Set<Subject> subjectList= new HashSet<Subject>(arraylist);
		 tran.commit();
			session.close();
			return subjectList;
	}
	
	public Set<Teacher> getTeacherDetailsById() throws Exception {
		// TODO Auto-generated method stub
		
		SessionFactory factory = LearnersSessionFactory.getDBConnection();
		Session session = factory.openSession();
		Transaction tran= session.beginTransaction();
		 Query sql = session.createQuery("FROM Teacher order by teacherId");
		 ArrayList<Teacher> arraylist= (ArrayList<Teacher>)sql.list();
		 Set<Teacher> teacherList= new HashSet<Teacher>(arraylist);
		 tran.commit();
			session.close();
			return teacherList;
	}
}
