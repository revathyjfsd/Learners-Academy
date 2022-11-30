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
<%!String  sid="";String sname="";String sshortCut="";%>
<%
if(request.getAttribute("flag")!=null && request.getAttribute("flag").equals("true")){
sid=request.getParameter("id");
sname=request.getParameter("name");
sshortCut=request.getParameter("shortCut");
}else
{
sid="";sname="";sshortCut="";
}
%>
<fieldset>
<legend><h2>Subject Add Form</h2></legend>
<form action="SubjectController" method="post">
<label for="SubjectID">Subject Id:</label>
<input type="text" name="id" value="<%=sid %>" title="Enter the Id"><br/><br/>
<label for="SubjectName">Subject Name:</label>
<input type="name" name="name"  value="<%=sname%>"title="Enter the Name" required><br/><br/>
<label for="SubjectshortCut">Subject ShortForm:</label>
<input type="text" name="shortCut"  value="<%=sshortCut %>" title="Enter the shortcut" required><br/><br/>
<label for="AddButton"></label>
<input type="submit" name="button" value="Add" title="click to add">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
