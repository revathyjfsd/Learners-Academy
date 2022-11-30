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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
 <style>
 label {
  display: inline-block;
width: 110px
      }
      </style>
</head>
<body>
<%
AcademyServices service = new AcademyServicesImpl();
Set<Class> classList= service.getClassDetails();
session.setAttribute("classList",classList);
ArrayList<Class> arrayListClass=null;
if(classList!=null)
{
arrayListClass= new ArrayList<Class>(classList);
Collections.sort(arrayListClass);
}
%>
<fieldset>
<legend><h2>Get Class Details</h2></legend>
<form action="ClassController" method="post">
						
<label for="classId">Select Class:</label>
			<select name = "classId">
			<%for(Class c:arrayListClass)
				out.print("<option>"+c.getClassId()+"-"+c.getName()+"</option>");%>
			</select><br/><br/>
			
<label for="GetButton"></label>
<input type="submit" name="button" value="Get Data" title="click to get details"><br/><br/>
</form>
</fieldset>
<br>
<%
if(request.getAttribute("selectedClass")!=null) 
{
Class classL=(Class) request.getAttribute("selectedClass");
Set<Collaborations> list=service.getAllDetailsByClassId(classL.getClassId());
Set<Student> studentList=service.getStudentDetailsByClassId(classL.getClassId());
if(list!=null)
{
out.print("The Class details of selected Class Id "+classL.getClassId()+" is");
%>
<br>
	<table>
	<tr>
	<th>S.No</th>
	<th>Teacher Id</th>
	<th>Teacher Name</th>
	<th>Subject Id</th>
	<th>Subject Name</th>
	</tr>
<% int i=1;
	 for(Collaborations c:list)
	 {
		 if(c.getTeacher()!=null && c.getSubject()!=null)
		 {
		 %>
		 <td><%=i++%></td>
		<td><%=c.getTeacher().getTeacherId()%></td>
		<td><%=c.getTeacher().getTeacherName()%></td>
		<td><%=c.getSubject().getSubjectId()%></td>
		<td><%=c.getSubject().getSubjectName()%></td>
		</tr><%
		 }
	}
	%></table> <%

}
else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Teachers</SPAN>");
	}
if(studentList!=null && studentList.size()>0)
{
	ArrayList<Student> arrayList= new ArrayList<Student>(studentList);
	Collections.sort(arrayList);
	%>
	<table>
	<tr>
	<th>Student Id</th>
	<th>Student Name</th>
	<th>Student Age</th>
	</tr><br>
	<br>
	
<%	for(Student student :arrayList)
	{ 
%>
	<td><%=student.getStudentId()%></td>
	<td><%=student.getStudentName()%></td>
	<td><%=student.getStudentAge()%></td>
	</tr><%
	}%>
	</table>
	<%}
	else
	{
		response.setContentType("text/html; charset=utf-8");
		out.print("<SPAN style= 'color:red'>"+"No records found for Students</SPAN>");
	}
}	%>
</body>
</html>