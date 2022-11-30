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
<%!String  cid="";String cname="";String csection="";%>
<%
if(request.getAttribute("flag")!=null && request.getAttribute("flag").equals("true")){
cid=request.getParameter("id");
cname=request.getParameter("name");
csection=request.getParameter("section");
}
else
{
cid="";cname="";csection="";	
}
%>
<fieldset>
<legend><h2>Class Add Form</h2></legend>
<form action="ClassDetailsController" method="post">
<label for="ClassID">Class Id:</label>
<input type="text" name="id" value="<%=cid %>" title="Enter the Id"><br/><br/>
<label for="ClassName">Class Name:</label>
<input type="name" name="name" value="<%=cname %>" title="Enter the Name" required><br/><br/>
<label for="ClassSection">Class Section:</label>
<input type="text" name="section" value="<%=csection %>" title="Enter the Section" required><br/><br/>
<label for="AddButton"></label>
<input type="submit" name="button" value="Add" title="click to add">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
