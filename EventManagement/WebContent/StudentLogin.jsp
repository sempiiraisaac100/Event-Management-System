<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student login</title>
</head>
<body>
<br><h1>Student Login</h1><br>
<img src= "abes.jpg"></img><br><br>
<form action= "<%=request.getContextPath()%>/StudentLogin" method= "post"> 
<br>User name: <input type= "text" name= "username" required><br>
<br>Password: <input type= "password" name= "password" required><br>
<br><input type= "submit" value= "Login">
</form>
</body>
</html>