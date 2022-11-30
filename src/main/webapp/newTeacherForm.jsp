<%@page import="com.learners.services.AcademyServices"%>
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
<%!String  tid="";String tname="";String tage="";String temail="";String taddress="";String tphone="";%>
<%
if(request.getAttribute("flag")!=null && request.getAttribute("flag").equals("true")){
tid=request.getParameter("id");
tname=request.getParameter("name");
tage=request.getParameter("age");
temail=request.getParameter("email");
taddress=request.getParameter("address");
tphone=request.getParameter("phone");
}
else{
tid="";tname="";tage="";temail="";taddress="";tphone="";	
}
%>
<fieldset>
<legend><h2>Teacher Add Form</h2></legend>
<form action="TeacherController" method="post">
<label for="TeacherID">Teacher Id:</label>
<input type="text" name="id"  value="<%=tid %>" title="Enter the Name" required><br/><br/>
<label for="TeacherName">Teacher Name:</label>
<input type="name" name="name" value="<%=tname %>" title="Enter the Name" required><br/><br/>
<label for="TeacherAge">Teacher Age:</label>
<input type="text" name="age" value="<%=tage %>" title="Enter the Age" required><br/><br/>
<label for="TeacherEmail">Teacher Email:</label>
<input type="text" name="email" value="<%=temail %>" title="Enter the Email" required><br/><br/>
<label for="TeacherAddress">Teacher Address:</label>
<input type="text" name="address" value="<%=taddress %>" title="Enter the Address" required><br/><br/>
<label for="TeacherPhone">Teacher Phone:</label>
<input type="text" name="phone" value="<%=tphone %>" title="Enter the Phone" required><br/><br/>
<label for="AddButton"></label>
<input type="submit" name="button" value="Add" title="click to add">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
