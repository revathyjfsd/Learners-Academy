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
services.deleteClass(id);
%>
<h3>Class <i><Strong style="color:Tomato;"><%=id%></Strong></i> has been deleted successfully</h3>
<%@ include file="classDetails.jsp" %>
</body>
</html>