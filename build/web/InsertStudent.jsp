<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert New Student</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("AdminLogin.jsp");
	}
%>
<br><h1>Insert New Student</h1><br>
<img src= "abes.jpg"></img><br><br>
<form action= "InsertStudent" method= "post">
Username:<input type= "text" name= "username" required><br><br>
Password: <input type= "password" name= "password" required><br>
<br><input type= "submit" value= "SUBMIT">
</form>
<form action= "Logout" method= "post">
<br><input type= "submit" value= "Logout">
</form>
</body>
</html>