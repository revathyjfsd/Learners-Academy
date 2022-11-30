<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
<%@page import="com.learners.beans.Class"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.learners.beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
session.setAttribute("studentId", request.getParameter("id"));
Set<Student> list=(HashSet<Student>)session.getAttribute("StudentList");
Student s=null;
for(Student student:list)
{
	if(student.getStudentId()==(Integer.parseInt(request.getParameter("id"))))
	{
		s=student;
	}
		
}
%>
<fieldset>
<legend><h2>Student Edit Form</h2></legend>
<form action="StudentController" method="post">
<label for="StudentID">Student Id:</label>
<input type="text" name="id" value="<%=s.getStudentId()%>" readonly="readonly"><br/><br/>
<label for="StudentName">Student Name:</label>
<input type="name" name="name" value="<%=s.getStudentName()%>" title="Enter the Name" required><br/><br/>
<label for="StudentAge">Student Age:</label>
<input type="text" name="age" value="<%=s.getStudentAge()%>" title="Enter the Age" required><br/><br/>
<label for="StudentEmail">Student Email:</label>
<input type="text" name="email" value="<%=s.getStudentEmail()%>" title="Enter the Email" required><br/><br/>
<label for="StudentAddress">Student Address:</label>
<input type="text" name="address" value="<%=s.getStudentAddress()%>" title="Enter the Address" required><br/><br/>
<label for="StudentPhone">Student Phone:</label>
<input type="text" name="phone" value="<%=s.getStudentPhone()%>" title="Enter the Phone" required><br/><br/>
  <label for="classId">Select Class:</label>
			<select name = "classId" value="<%=request.getParameter("classId")%>">
			<%for(Class c:classList)
				out.print("<option>"+c.getClassId()+"-"+c.getName()+"</option>");%>
			</select><br/><br/>
<label for="UpdateButton"></label>
<input type="submit" name="button" value="Update" title="click to update">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
