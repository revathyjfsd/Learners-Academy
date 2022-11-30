<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Cookie[] cookies= request.getCookies();
String username="";
if (cookies != null) {
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("username")) {
            username = cookies[i].getValue();
        }
        cookies[i].setValue("");
        cookies[i].setMaxAge(0);
        
       }
}
session.invalidate();
%>
<jsp:include page="login.jsp"></jsp:include>
<h4>Administrator<Strong><i style="color:SlateBlue"> "<%=username %>" </i></Strong>has logged out successfully</h4>


</body>
</html>