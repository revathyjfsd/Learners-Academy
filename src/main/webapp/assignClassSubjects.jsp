<%@page import="java.util.Collections"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
<%@page import="com.learners.beans.Class"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.learners.beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page errorPage="fail.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
AcademyServices service = new AcademyServicesImpl();
Set<Class> classList= service.getClassDetails();
Set<Subject> subjectList= service.getSubjectDetails();
Set<Teacher> teacherList= service.getTeacherDetails();
session.setAttribute("classList",classList);
session.setAttribute("subjectList",subjectList);
session.setAttribute("teacherList",teacherList);
ArrayList<Subject> arrayListSubject=null;
ArrayList<Class> arrayListClass=null;
ArrayList<Teacher> arrayListTeacher=null;
if(subjectList!=null)
{
arrayListSubject= new ArrayList<Subject>(subjectList);
Collections.sort(arrayListSubject);
}
if(classList!=null)
{
arrayListClass= new ArrayList<Class>(classList);
Collections.sort(arrayListClass);
}
if(teacherList!=null)
{
arrayListTeacher= new ArrayList<Teacher>(teacherList);
Collections.sort(arrayListTeacher);
}
%>
<fieldset>
<legend><h2>Assign Teachers and Subjects</h2></legend>
<form action="ClassController" method="post">
<label for="classId">Select Class:</label>
			<select name = "classId">
			<%for(Class c:arrayListClass)
				out.print("<option>"+c.getClassId()+"-"+c.getName()+"</option>");%>
			</select><br/><br/>
			
			
<label for="teacherId">Select Teacher:</label>
			<select name = "teacherId">
			<%for(Teacher t:arrayListTeacher)
				out.print("<option>"+t.getTeacherId()+"-"+t.getTeacherName()+"</option>");%>
			</select><br/><br/>						


<label for="subjectId">Select Subject:</label>
			<select name = "subjectId">
			<%for(Subject s:arrayListSubject)
				out.print("<option>"+s.getSubjectId()+"-"+s.getSubjectName()+"</option>");%>
			</select><br/><br/>

<label for="UpdateButton"></label>
<input type="submit" name="button" value="Update" title="click to update details"><br/><br/>
</form>
</fieldset>
</body>
</html>