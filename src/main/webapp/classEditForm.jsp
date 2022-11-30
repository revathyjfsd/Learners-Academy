<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
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
session.setAttribute("classId", request.getParameter("id"));
Set<Class> list=(HashSet<Class>)session.getAttribute("classDetails");
Class c=null;
for(Class classLearner:list)
{
	if(classLearner.getClassId()==(Integer.parseInt(request.getParameter("id"))))
	{
		c=classLearner;
	}
		
}
%>
<fieldset>
<legend><h2>Class Edit Form</h2></legend>
<form action="ClassDetailsController" method="post">
<label for="ClassID">Class Id:</label>
<input type="text" name="id" value="<%=c.getClassId()%>" readonly="readonly"><br/><br/>
<label for="ClassName">Class Name:</label>
<input type="name" name="name" value="<%=c.getName()%>" title="Enter the Name" required><br/><br/>
<label for="ClassSection">Class Section:</label>
<input type="text" name="section" value="<%=c.getSection()%>" title="Enter the Section" required><br/><br/>
<label for="UpdateButton"></label>
<input type="submit" name="button" value="Update" title="click to update">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
