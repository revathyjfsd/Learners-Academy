<%@page import="java.util.Collections"%>
<%@page import="com.learners.services.AcademyServices"%>
<%@page import="java.util.Set"%>
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
<%!String  sid="";String sname="";String sage="";String semail="";String saddress="";String sphone="";%>
<%
AcademyServices service = new AcademyServicesImpl();
Set<Class> classList= service.getClassDetails();
ArrayList<Class> arrayList = null;
if(classList!=null && classList.size()>0)
{
arrayList= new ArrayList<Class>(classList);
Collections.sort(arrayList);
}
if(request.getAttribute("flag")!=null && request.getAttribute("flag").equals("true")){
sid=request.getParameter("id");
sname=request.getParameter("name");
sage=request.getParameter("age");
semail=request.getParameter("email");
saddress=request.getParameter("address");
sphone=request.getParameter("phone");
}
else
{
sid="";sname="";sage="";semail="";saddress="";sphone="";
}
%>
<fieldset>
<legend><h2>Student Add Form</h2></legend>
<form action="StudentController" method="post">
<label for="StudentID">Student Id:</label>
<input type="text" name="id" value="<%=sid %>" title="Enter the Id" required><br/><br/>
<label for="StudentName">Student Name:</label>
<input type="name" name="name" value="<%=sname%>"title="Enter the Name" required><br/><br/>
<label for="StudentAge">Student Age:</label>
<input type="text" name="age" value="<%=sage%>" title="Enter the Age" required><br/><br/>
<label for="StudentEmail">Student Email:</label>
<input type="text" name="email" value="<%=semail%>" title="Enter the Email" required><br/><br/>
<label for="StudentAddress">Student Address:</label>
<input type="text" name="address" value="<%=saddress%>" title="Enter the Address" required><br/><br/>
<label for="StudentPhone">Student Phone:</label>
<input type="text" name="phone" value="<%=sphone%>" title="Enter the Phone" required><br/><br/>
  <label for="classId">Select Class:</label>
			<select name = "classId">
			<%for(Class c:arrayList)
				out.print("<option>"+c.getClassId()+"-"+c.getName()+"</option>");%>
			</select><br/><br/>
<label for="AddButton"></label>
<input type="submit" name="button" value="Add" title="click to add">&nbsp;&nbsp;
<input type="submit" name="button" value="Cancel" title="click to cancel" formnovalidate><br/><br/>
</form>
</fieldset>
</body>
</html>