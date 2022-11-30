<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
<%@page import="com.learners.beans.Class"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
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
Set<Class> list= service.getClassDetails();
session.setAttribute("classDetails", list);

if(list!=null && list.size()>0)
{
	ArrayList<Class> arrayList= new ArrayList<Class>(list);
	Collections.sort(arrayList);
%>
	<table>
	<tr>
	<th>Class Id</th>
	<th>Class Name</th>
	<th>Class Section</th>
	<th>Edit Class</th>
	<th>Delete Class</th>
	</tr>
<%	for(Class classL :arrayList)
	{ %>
	<tr>
	<td><%=classL.getClassId()%></td>
	<td><%=classL.getName()%></td>
	<td><%=classL.getSection()%></td>
	<td><a href="classEditForm.jsp?id=<%=classL.getClassId()%>">Edit</a></td>
	<td><a href="deleteClass.jsp?id=<%=classL.getClassId()%>" onclick="return confirm('Are you sure?')">Delete</a></td>
	</tr><%
	}%>
	</table>
	
	<%}
	else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Class</SPAN>");
	}
				%>
				<br><br>
	Click here to add new Subject details: 
	<button width ="140%" onclick="location.href ='newClassForm.jsp'">Add New</button>
</body>
</html>