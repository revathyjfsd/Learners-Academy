<%@page import="java.util.Collections"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
<%@page import="com.learners.beans.Student"%>
<%@page import="java.util.ArrayList"%>
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
Set<Student> list= service.getStudentDetails();
session.setAttribute("StudentList", list);
if(list!=null && list.size()>0)
{
	ArrayList<Student> arrayList= new ArrayList<Student>(list);
	Collections.sort(arrayList);
%>
	<table>
	<tr>
	<th>Student Id</th>
	<th>Student Name</th>
	<th>Student Age</th>
	<th>Student Email</th>
	<th>Student Address</th>
	<th>Student Phone</th>
	<th>Student Class No</th>
	<th>Edit Student</th>
	<th>Delete Student</th>
	</tr>
<%	for(Student student :arrayList)
	{
%>
	<td><%=student.getStudentId()%></td>
	<td><%=student.getStudentName()%></td>
	<td><%=student.getStudentAge()%></td>
	<td><%=student.getStudentEmail()%></td>
	<td><%=student.getStudentAddress()%></td>
	<td><%=student.getStudentPhone()%></td>
	<td><%if(student.getLearnerClass()!=null)
	{ out.print(student.getLearnerClass().getClassId());
	}%></td>
	<td><a href="studentEditForm.jsp?id=<%=student.getStudentId()%>">Edit</a></td>
	<td><a href="deleteStudent.jsp?id=<%=student.getStudentId()%>" onclick="return confirm('Are you sure \n Do you want to delete ?')">Delete</a></td>
	</tr><%
	}%>
	</table>

	<%}
	else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Students</SPAN>");
	}
				%>
				
					<br><br>
	Click here to add new Student details: 
	<button width ="140%" onclick="location.href ='newStudentForm.jsp'" >Add</button>
</body>
</html>