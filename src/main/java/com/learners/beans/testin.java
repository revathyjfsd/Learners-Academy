package com.learners.beans;

import java.util.HashSet;
import java.util.Set;

import com.learners.exceptions.EntityExistsException;



public class testin {

	public static void main(String[] args)  throws EntityExistsException{
		Set<Subject> list = new HashSet<Subject>();
		Subject s= new Subject(201, "biology", "bio");
		list.add(s);
		Subject s1= new Subject(201, "fgfgdf", "bio");
		Subject s2= new Subject(202, "biodfgdflogy", "bio");
		if(list.contains(s1)) {
			System.out.println("yes it has");
		}
		else
			System.out.println("no");
		Set<Teacher> list1=new HashSet<Teacher>();
		Teacher t = new Teacher(12,"sdfs",23,"sdfsd","sfsd",56768878L);
		list1.add(t);
		Teacher t1 = new Teacher(12,"sdfsdffs",23,"sdfsd","sfsdfsdfsd",56768878L);
		if(list1.contains(t1)) {
			System.out.println("yes it has");
		}
		else
			System.out.println("no");
		
		EntityExistsException exception= new EntityExistsException("Already this Teacher "+t.getTeacherId()+" has been assigned to this class "+s.getSubjectId());
		System.out.println(exception);
	}

}
