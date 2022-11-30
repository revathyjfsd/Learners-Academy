<%@page import="java.util.Collections"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
<%@page import="com.learners.beans.Subject"%>
<%@page import="com.learners.beans.Teacher"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
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

</style>
</head>
<body>
<%
AcademyServices service = new AcademyServicesImpl();
Set<Subject> list= service.getSubjectDetails();
session.setAttribute("subjectListAttribute", list);
if(list!=null && list.size()>0)
{
	ArrayList<Subject> arrayList= new ArrayList<Subject>(list);
	Collections.sort(arrayList);
%>
	<table>
	<tr>
	<th>Subject Id</th>
	<th>Subject Name</th>
	<th>Subject shortcut</th>
	<th>Edit Subject</th>
	<th>Delete Subject</th>
	</tr>
<%	for(Subject subject :arrayList)
	{ %>
	<tr>
	<td><%=subject.getSubjectId()%></td>
	<td><%=subject.getSubjectName()%></td>
	<td><%=subject.getSubjectShortcut()%></td>
	<td><a href="subjectEditForm.jsp?id=<%=subject.getSubjectId()%>">Edit</a></td>
	<td><a href="deleteSubject.jsp?id=<%=subject.getSubjectId()%>" onclick="return confirm('Are you sure?')">Delete</a></td>
	</tr><%
	}%>
	</table>
	
	<%}
	else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Subjects</SPAN>");
	}
				%>
				<br><br>
	Click here to add new Subject details: 
	<button width ="140%" onclick="location.href ='newSubjectForm.jsp'">Add New</button>
</body>
</html>