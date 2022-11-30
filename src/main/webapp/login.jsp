<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <h2>Learner's Academy 
  </h2>
</header>
<form action="LoginController" method="post">
<fieldset height="400px">
<legend><h2>Login</h3></legend>
<label for="Username">Enter Username:</label>
<input type="text" name="username" title="Enter the username" required><br/><br/>
<label for="Password">Enter Password:</label>
<input type="password" name="password" title="Enter the password" required><br/><br/>
<label for="Login"></label>
<input type= "submit" name="login" value="Login" title="click to login"><br/><br/>
</fieldset>
</form>
</body>
</html>