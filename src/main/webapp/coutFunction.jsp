<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="a" value="${10}"></c:set>
<c:out value="${a}"></c:out>

<br>
<br>
<c:set var="a" value="${100}"></c:set>
<p>before value is </p>
<c:out value="${a+10}"></c:out>
<c:remove var="a"/>
<p>after value is </p>
<c:out value="${a+10}"></c:out>

<br>
<br>
<%--if ->iff the condition is true --%>
<c:set var="a" value="${100}"></c:set>
<c:set var="b" value="${10}"></c:set>
<c:if test="${a>b}">
<p> value of a is > </p>
</c:if>

<%--choose when otherwise --%>
<c:set var="a" value="${-2}"></c:set>
<c:choose>
<c:when test="${a>=100}">
the value of a is greater
</c:when>
<c:when test="${a>=0 &&a<100}">
the value is between 0 and 99
</c:when>
<c:otherwise>
check the input value
</c:otherwise>
</c:choose>


</body>
</html>