<%@page import="com.learners.services.AcademyServices"%>
<%@page import="com.learners.services.AcademyServicesImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int id = Integer.parseInt(request.getParameter("id"));
AcademyServices services = new AcademyServicesImpl();
services.deleteStudent(id);
%>
<h3>Student <i><Strong style="color:Tomato;"><%=id%></Strong></i> has been deleted successfully</h3>
<%@ include file="studentDetails.jsp" %>
</body>
</html>