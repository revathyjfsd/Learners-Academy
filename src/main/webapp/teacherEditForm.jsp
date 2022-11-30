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

Set<Teacher> list=(HashSet<Teacher>)session.getAttribute("teacherListAttribute");
Teacher t=null;
for(Teacher teacher:list)
{
	if(teacher.getTeacherId()==(Integer.parseInt(request.getParameter("id"))))
	{
		t=teacher;
	}
		
}
%>
<fieldset>
<legend><h2>Teacher Edit Form</h2></legend>
<form action="TeacherController" method="post">
<label for="TeacherID">Teacher Id:</label>
<input type="text" name="id" value="<%=t.getTeacherId()%>" readonly="readonly"><br/><br/>
<label for="TeacherName">Teacher Name:</label>
<input type="name" name="name" value="<%=t.getTeacherName()%>" title="Enter the Name" required><br/><br/>
<label for="TeacherAge">Teacher Age:</label>
<input type="text" name="age" value="<%=t.getTeacherAge()%>" title="Enter the Age" required><br/><br/>
<label for="TeacherEmail">Teacher Email:</label>
<input type="text" name="email" value="<%=t.getTeacherEmail()%>" title="Enter the Email" required><br/><br/>
<label for="TeacherAddress">Teacher Address:</label>
<input type="text" name="address" value="<%=t.getTeacherAddress()%>" title="Enter the Address" required><br/><br/>
<label for="TeacherPhone">Teacher Phone:</label>
<input type="text" name="phone" value="<%=t.getTeacherPhone()%>" title="Enter the Phone" required><br/><br/>
<label for="UpdateButton"></label>
<input type="submit" name="button" value="Update" title="click to update">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
