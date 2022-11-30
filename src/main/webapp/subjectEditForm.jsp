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
<style type="text/css">
      label {
  display: inline-block;
width: 110px
      }
    </style>
</head>
<body>
<%

session.setAttribute("subjectId", request.getParameter("id"));
Set<Subject> list=(HashSet<Subject>)session.getAttribute("subjectListAttribute");
Subject s=null;
for(Subject subject:list)
{
	if(subject.getSubjectId()==(Integer.parseInt(request.getParameter("id"))))
	{
		s=subject;
	}
		
}
%>
<fieldset>
<legend><h2>Subject Edit Form</h2></legend>
<form action="SubjectController" method="post">
<label for="SubjectID">Subject Id:</label>
<input type="text" name="id" value="<%=s.getSubjectId()%>" readonly="readonly"><br/><br/>
<label for="SubjectName">Subject Name:</label>
<input type="name" name="name" value="<%=s.getSubjectName()%>" title="Enter the Name" required><br/><br/>
<label for="SubjectshortCut">Subject ShortForm:</label>
<input type="text" name="shortCut" value="<%=s.getSubjectShortcut()%>" title="Enter the shortcut" required><br/><br/>
<label for="UpdateButton"></label>
<input type="submit" name="button" value="Update" title="click to update">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
