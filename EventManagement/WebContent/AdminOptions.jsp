<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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
<br><h1>Welcome ${username}</h1><br>
<img src= "abes.jpg"></img><br><br>
<form action= "Showall" method= "post"> 
<br><input type= "submit" value= "SHOW ALL UPCOMING EVENTS">
</form>
<form action= "Showspec" method= "post"> 
<input type= "text" name= "ser">
<input type= "submit" value= "Search">
</form>
<form action= "Showallitems" method= "post"> 
<br><input type= "submit" value= "SHOW ALL LOST OR FOUND ITEMS">
</form>
<form action= "Showspec" method= "post"> 
<input type= "text" name= "ser">
<input type= "submit" value= "Search">
</form>
<a href= "Insert.jsp"> 
<br><input type= "button" value= "ADD NEW STUDENT">
</a>
<a href= "DeleteStudent.jsp"> 
<input type= "button" value= "Delete Student"><br>
</a>
<form action="InsertEvent" method="get"> 
<br><input type= "button" value= "Insert new Events">
</form>
<a href= "UpdateEvent.jsp"> 
<input type= "button" value= "Update events"><br>
</a>
<a href= "InsertItem.jsp"> 
<br><input type= "button" value= "Insert Lost or Found Item">
</a>
<a href= "DeleteItem.jsp"> 
<input type= "button" value= "Delete items"><br>
</a>
<a href= "DeleteEve.jsp"> 
<br><input type= "button" value= "Delete events">
</a>

<form action= "DeletePast" method= "post">
<input type= "submit" value= "Delete past events"><br>
</form>

<a href= "ChngPass.jsp"> 
<br><input type= "button" value= "Change password"><br>
</a>
<form action= "Logout" method= "post">
<br><input type= "submit" value= "Logout"><br>
</form>
</body>
</html>