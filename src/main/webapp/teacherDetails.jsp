<%@page import="java.util.Collections"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
<%@page import="com.learners.beans.Teacher"%>
<%@page import="com.learners.beans.Teacher"%>
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
Set<Teacher> list= service.getTeacherDetails();
session.setAttribute("teacherListAttribute", list);
if(list!=null && list.size()>0)
{
	ArrayList<Teacher> arrayList= new ArrayList<Teacher>(list);
	Collections.sort(arrayList);
%>
	<table>
	<tr>
	<th>Teacher Id</th>
	<th>Teacher Name</th>
	<th>Teacher Age</th>
	<th>Teacher Email</th>
	<th>Teacher Address</th>
	<th>Teacher Phone</th>
	<th>Edit Teacher</th>
	<th>Delete Teacher</th>
	</tr>
<%	for(Teacher teacher :arrayList)
	{ %>
	<td><%=teacher.getTeacherId()%></td>
	<td><%=teacher.getTeacherName()%></td>
	<td><%=teacher.getTeacherAge()%></td>
	<td><%=teacher.getTeacherEmail()%></td>
	<td><%=teacher.getTeacherAddress()%></td>
	<td><%=teacher.getTeacherPhone()%></td>
	<td><a href="teacherEditForm.jsp?id=<%=teacher.getTeacherId()%>">Edit</a></td>
	<td><a href="deleteTeacher.jsp?id=<%=teacher.getTeacherId()%>" onclick="return confirm('Are you sure?')">Delete</a></td>
	</tr><%
	}%>
	</table>
	
	<%}
	else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Teachers</SPAN>");
	}
				%>
				
				<br><br>
	Click here to add new Teacher details: 
	<button width ="140%" onclick="location.href ='newTeacherForm.jsp'" >Add New</button>
</body>
</html>