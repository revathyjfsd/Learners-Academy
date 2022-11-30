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
out.println("inside delete teacher "+request.getParameter("id"));
int id = Integer.parseInt(request.getParameter("id"));
AcademyServices services = new AcademyServicesImpl();
services.deleteTeacher(id);
%>
<h3>Teacher <i><Strong style="color:Tomato;"><%=id%></Strong></i> has been deleted successfully</h3>
<%@ include file="teacherDetails.jsp" %>
</body>
</html>