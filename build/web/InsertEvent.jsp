<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert events</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Main.jsp");
	}
%>
<br><h1>Insert New Event</h1><br>
<img src= "abes.jpg"></img><br><br>
<h5>* fields are mandatory</h5>
<form action= "<%= request.getContextPath() %>/InsertEvent" method= "post" onsubmit= "return validaton()">
Event name* <input type= "text" name= "ename" required><br><br>
Date* <input type= "text" name="dt" required><br><br>
Venue* <input type= "text" name= "venue" required><br><br>
Fees <input type= "text" name= "fees"><br><br>
About*(not more than 50 characters) <input type= "text" name= "abt" required><br><br>
<input type= "submit" value= "Insert event"><br><br>
</form>
</body>
</html>